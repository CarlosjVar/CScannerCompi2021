/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import SemanticShit.RS;
import SemanticShit.RS_DO;
import SemanticShit.RS_FU;
import SemanticShit.RS_ID;
import SemanticShit.RS_Operador;
import SemanticShit.RS_Tipo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;

/**
 *
 * @author carlo
 */
public class SemanticStructures {
    public ArrayList<RS> stack = new ArrayList<RS>();
    public HashMap<String,Object> TablaSimbolos = new HashMap<String,Object>();
    private static SemanticStructures Struct;
    public ArrayList<String> errores = new ArrayList<String>();
    public int whileCount= 0 ;
    public int whileCountlabel= 0;
    public int ifCount = 0;
    public int forCount = 0;
    public int funcParamsCount = 0;
    public int switchCount = 0;
    public boolean AssignBinary=false;
    
    public static SemanticStructures getInstance()
    {
        if(Struct==null )
        {
            Struct = new SemanticStructures();
        }
        return Struct;
    }
    public void recuerdaTipo(String tipo, Integer linea, Integer columna)
    {
        RS_Tipo Rtipo = new RS_Tipo(tipo,linea,columna);
        this.pushRS(Rtipo);
    }
    
    public void recuerdaId(String id, Integer linea, Integer columna)
    {
        RS_ID RId = new RS_ID(id,linea,columna);
        this.pushRS(RId);
    }
    
    public void recuerdaConst(String tipo, Integer linea, Integer columna){
        RS_DO RStipo = new RS_DO(tipo, linea, columna, true);
        this.pushRS(RStipo);
    }
    
    public void recuerdaOperador(String tipo, Integer linea, Integer columna){
        RS_Operador RSoperador = new RS_Operador(tipo, linea, columna);
        this.pushRS(RSoperador);
    }

    public void recuerdaVariable(String valor, Integer linea, Integer columna){
        RS_DO RS_DO_ = new RS_DO(valor, linea, columna, false);
        if(!this.TablaSimbolos.containsKey(RS_DO_.valor)){
            RS_DO_.error=true;
            this.TablaSimbolos.put(RS_DO_.valor,RS_DO_);
            this.errores.add("La variable "+ RS_DO_.valor +" no está declarada. Linea "+ linea +", columna " + columna);
        }
        this.pushRS(RS_DO_);     
    }
    
    public void recuerdaFuncion(){
        CodeMonkey.getInstance().codeStarted=true;
        ArrayList <RS_Tipo> params = new ArrayList <RS_Tipo>();
        while(this.funcParamsCount>0)
        {
            RS_ID  Id = (RS_ID) this.popRS();
            this.deleteTop();
            RS_Tipo tipo  = (RS_Tipo ) this.popRS();
            this.deleteTop();
            
            this.funcParamsCount--;
            tipo.name = Id.valor;
            params.add(tipo);

        }
        RS nombre = this.popRS();
        this.deleteTop();
        RS tipo = this.popRS();
        this.deleteTop();
        RS_FU func= new RS_FU(nombre.valor, nombre.linea,tipo.columna,tipo.valor);
        Collections.reverse(Arrays.asList(params));
        func.params = params;
        

        if(this.TablaSimbolos.containsKey(func.valor))
        {                     
            this.errores.add("La funcion "+ func.valor +" ya esta declarada. Linea "+ nombre.linea +", columna " + tipo.columna);            
        }
        else
        {
            this.TablaSimbolos.put(func.valor,func);
            
        }
        //this.pushRS(func);
    
    }
    
    
    public void evalBinary(){
        System.out.println("Inicio Stack evBinary"+ this.stack);
        RS_DO RS_DO2 = (RS_DO) this.popRS();
        this.deleteTop();
        RS_Operador RS_OP = (RS_Operador) this.popRS();
        this.deleteTop();
        RS_DO RS_DO1 = (RS_DO) this.popRS();
        this.deleteTop();
        RS_DO RS_DO_;
        int calculo = 0;
        String regex = "[+*/-]";
        if(RS_DO2.banderita && RS_DO1.banderita && RS_OP.valor.matches(regex)){
            if("+".equals(RS_OP.valor)) { calculo = Integer.parseInt(RS_DO2.valor)+Integer.parseInt(RS_DO1.valor);}
            else if("-".equals(RS_OP.valor)) { calculo = Integer.parseInt(RS_DO1.valor)-Integer.parseInt(RS_DO2.valor);}
            else if("/".equals(RS_OP.valor) && Integer.parseInt(RS_DO2.valor)!=0 ) {  calculo = Integer.parseInt(RS_DO1.valor)/Integer.parseInt(RS_DO2.valor);}
            else if("*".equals(RS_OP.valor)) { calculo = Integer.parseInt(RS_DO1.valor)*Integer.parseInt(RS_DO2.valor);}
            
            
        CodeMonkey.getInstance().addToString("MOV EAX,"+calculo);
        this.AssignBinary=true;
            System.out.println("Final stack folding" + this.stack);
        }
        else{
            //System.out.println("Entre a no folding operador:" +RS_OP.valor );
            this.AssignBinary=true;
            if("+".equals(RS_OP.valor)) { 
     
                String regex2 = "[0-9]";
                CodeMonkey.getInstance().addToString( RS_DO1.valor.matches(regex2)? "MOV EAX,"+  RS_DO1.valor :"MOV EAX,"+"["+ RS_DO1.valor+"]" );
                CodeMonkey.getInstance().addToString( RS_DO2.valor.matches(regex2)? "ADD EAX,"+  RS_DO2.valor :"ADD EAX,"+"["+ RS_DO2.valor+"]");
            
            }
            else if("-".equals(RS_OP.valor)) { 
            
                String regex2 = "[0-9]";
                CodeMonkey.getInstance().addToString( RS_DO1.valor.matches(regex2)? "MOV EAX,"+  RS_DO1.valor :"MOV EAX,"+"["+ RS_DO1.valor+"]" );
                CodeMonkey.getInstance().addToString( RS_DO2.valor.matches(regex2)? "SUB EAX,"+  RS_DO2.valor :"SUB EAX,"+"["+ RS_DO2.valor+"]");
            }
            else if("/".equals(RS_OP.valor) && Integer.parseInt(RS_DO2.valor)!=0 ) { 
                String regex2 = "[0-9]";
                CodeMonkey.getInstance().addToString( RS_DO1.valor.matches(regex2)? "MOV EAX,"+  RS_DO1.valor :"MOV EAX,"+"["+ RS_DO1.valor+"]" );
                CodeMonkey.getInstance().addToString( RS_DO2.valor.matches(regex2)? "MOV EBX,"+  RS_DO2.valor :"MOV EAX,"+"["+ RS_DO2.valor+"]" );
                CodeMonkey.getInstance().addToString("DIV EBX");
            }
            else if("*".equals(RS_OP.valor)) {
                String regex2 = "[0-9]";
                CodeMonkey.getInstance().addToString( RS_DO1.valor.matches(regex2)? "MOV EAX,"+  RS_DO1.valor :"MOV EAX,"+"["+ RS_DO1.valor+"]" );
                CodeMonkey.getInstance().addToString( RS_DO2.valor.matches(regex2)? "MOV EBX,"+  RS_DO2.valor :"MOV EAX,"+"["+ RS_DO2.valor+"]" );
                CodeMonkey.getInstance().addToString("MUL EBX");
            }
            else if("<".equals(RS_OP.valor)){
                String regex2 = "[0-9]";
                CodeMonkey.getInstance().addToString( RS_DO1.valor.matches(regex2)? "MOV EAX,"+  RS_DO1.valor :"MOV EAX,"+"["+ RS_DO1.valor+"]" );
                CodeMonkey.getInstance().addToString( RS_DO2.valor.matches(regex2)? "MOV EBX,"+  RS_DO2.valor :"MOV EAX,"+"["+ RS_DO2.valor+"]" );
                CodeMonkey.getInstance().addToString("CMP EAX,EBX");
                CodeMonkey.getInstance().setStringCompare("JGE ");
            }
            else if(">".equals(RS_OP.valor)){
                String regex2 = "[0-9]";
                CodeMonkey.getInstance().addToString( RS_DO1.valor.matches(regex2)? "MOV EAX,"+  RS_DO1.valor :"MOV EAX,"+"["+ RS_DO1.valor+"]" );
                CodeMonkey.getInstance().addToString( RS_DO2.valor.matches(regex2)? "MOV EBX,"+  RS_DO2.valor :"MOV EAX,"+"["+ RS_DO2.valor+"]" );
                CodeMonkey.getInstance().addToString("CMP EAX,EBX");
                CodeMonkey.getInstance().setStringCompare("JLE ");
            }
            else if("==".equals(RS_OP.valor)){
                String regex2 = "[0-9]";
                CodeMonkey.getInstance().addToString( RS_DO1.valor.matches(regex2)? "MOV EAX,"+  RS_DO1.valor :"MOV EAX,"+"["+ RS_DO1.valor+"]" );
                CodeMonkey.getInstance().addToString( RS_DO2.valor.matches(regex2)? "MOV EBX,"+  RS_DO2.valor :"MOV EAX,"+"["+ RS_DO2.valor+"]" );
                CodeMonkey.getInstance().addToString("CMP EAX,EBX");
                CodeMonkey.getInstance().setStringCompare("JNE ");
            }
            else if(">=".equals(RS_OP.valor)){
                String regex2 = "[0-9]";
                CodeMonkey.getInstance().addToString( RS_DO1.valor.matches(regex2)? "MOV EAX,"+  RS_DO1.valor :"MOV EAX,"+"["+ RS_DO1.valor+"]" );
                CodeMonkey.getInstance().addToString( RS_DO2.valor.matches(regex2)? "MOV EBX,"+  RS_DO2.valor :"MOV EAX,"+"["+ RS_DO2.valor+"]" );
                CodeMonkey.getInstance().addToString("CMP EAX,EBX");
                CodeMonkey.getInstance().setStringCompare("JL ");
            }
            else if("<=".equals(RS_OP.valor)){
                String regex2 = "[0-9]";
                CodeMonkey.getInstance().addToString( RS_DO1.valor.matches(regex2)? "MOV EAX,"+  RS_DO1.valor :"MOV EAX,"+"["+ RS_DO1.valor+"]" );
                CodeMonkey.getInstance().addToString( RS_DO2.valor.matches(regex2)? "MOV EBX,"+  RS_DO2.valor :"MOV EAX,"+"["+ RS_DO2.valor+"]" );
                CodeMonkey.getInstance().addToString("CMP EAX,EBX");
                CodeMonkey.getInstance().setStringCompare("JG ");
            }
            else if("!=".equals(RS_OP.valor)){
                String regex2 = "[0-9]";
                CodeMonkey.getInstance().addToString( RS_DO1.valor.matches(regex2)? "MOV EAX,"+  RS_DO1.valor :"MOV EAX,"+"["+ RS_DO1.valor+"]" );
                CodeMonkey.getInstance().addToString( RS_DO2.valor.matches(regex2)? "MOV EBX,"+  RS_DO2.valor :"MOV EAX,"+"["+ RS_DO2.valor+"]" );
                CodeMonkey.getInstance().addToString("CMP EAX,EBX");
                CodeMonkey.getInstance().setStringCompare("JE ");
            }
        }

        //System.out.println("Final stack evBinary"+this.stack);

    }
    
    public void evalUnary(){
        RS_Operador RS_OP = (RS_Operador) this.popRS();
        this.deleteTop();
        RS_DO RS_DO = (RS_DO) this.popRS();
        this.deleteTop();

        int calculo = 0;
        if(RS_DO.banderita ){
            if("++".equals(RS_OP.valor) ) { calculo = (Integer.parseInt(RS_DO.valor))+1;}
            else if("--".equals(RS_OP.valor) ) { calculo = (Integer.parseInt(RS_DO.valor))-1;}
        }
        else{
             if("++".equals(RS_OP.valor) ) {CodeMonkey.getInstance().addToString("INC "+RS_DO.valor);}
            else if("--".equals(RS_OP.valor) ) {CodeMonkey.getInstance().addToString("DEC "+RS_DO.valor);}
           
        }
    }
    public void evalFuncion(){
        System.out.println("Inicio stack evFunc"+this.stack);
        RS llamado = this.stack.get(0);
        RS_FU func = (RS_FU)this.TablaSimbolos.get(llamado.valor);
        boolean error = true;
        if(func != null)
        { 
            ArrayList <RS_Tipo> paramsTS = func.params;
            
            if(paramsTS.size() == this.stack.size() - 1)
            {
                while(this.stack.size() > 1)
                {
                    RS_ID  Id = (RS_ID) this.popRS();
                    this.deleteTop();

                    if(!this.TablaSimbolos.containsKey(Id.valor))
                    {
                        RS_DO RS_DO_ = new RS_DO(Id.valor,Id.linea,Id.columna, false);
                        RS_DO_.error=true;
                        this.TablaSimbolos.put(RS_DO_.valor,RS_DO_);
                        this.errores.add("La variable "+ RS_DO_.valor +" no está declarada. Linea "+ Id.linea +", columna " + Id.columna);
                    }
                    else
                    {
                        RS_Tipo varLlamada = (RS_Tipo)this.TablaSimbolos.get(Id.valor);
                        RS_Tipo varFuncion = paramsTS.get(this.stack.size()-1);
                        if(!varLlamada.valor.equals(varFuncion.valor))
                        {
                            // System.out.println("evalFunc"+Id+" "+varFuncion);
                            RS_DO RS_DO_Tipo = new RS_DO(Id.valor,Id.linea,Id.columna, false);
                            RS_DO_Tipo.error=true;
                            this.errores.add("La variable "+ RS_DO_Tipo.valor +" no es del tipo correcto. Linea "+ Id.linea +", columna " + Id.columna);
                        }
                    }
                }
            }
            else
            { 
                this.errores.add("Cantidad de parametros erronea");
                this.stack = new ArrayList();
            }
                   
                    
        }
        else
        {
            RS_FU RS_FU_ = new RS_FU(llamado.valor,llamado.linea,llamado.columna,"error");
            RS_FU_.error=true;
            this.TablaSimbolos.put(RS_FU_.valor,RS_FU_);
            this.errores.add("puto La función "+ RS_FU_.valor +" no está declarada. Linea "+ RS_FU_.linea +", columna " + RS_FU_.columna);
        }
        //System.out.println(paramsFU);
    }
    
    public void assign() {
        System.out.println("Inicio stack asignación" + this.stack);
        if(this.AssignBinary && this.stack.size()==1){
            
            RS VARIABLE = this.popRS();
            this.deleteTop();
            CodeMonkey.getInstance().addToString("MOV [" +VARIABLE.valor+"],EAX" );
            this.AssignBinary=false;
            System.out.println("Inicio stack asignación" + this.stack);
        }
        else
        {
        RS VALUE = this.popRS();
        this.deleteTop();
        RS VAR = this.popRS();
        this.deleteTop();
        String regex = "[0-9]";
        CodeMonkey.getInstance().addToString(VALUE.valor.matches(regex)? "MOV EAX,"+ VALUE.valor :"MOV EAX,"+"["+VALUE.valor+"]" );
         CodeMonkey.getInstance().addToString("MOV [" +VAR.valor+"],EAX" );
         System.out.println("VELVET ES HERMOSOOOOOOOOO!");
        }

    }
    
    public void insertarTS(boolean isGlobal){
        RS_Tipo tipo = (RS_Tipo)this.getBottom();      
        while(this.popRS() != tipo){
            try
            {
                RS_ID stackpop = (RS_ID)this.popRS(); 
                if(this.TablaSimbolos.containsKey(stackpop.valor))
                {
                    this.errores.add("La variable "+ stackpop.valor  +" ya está definidida en la linea "+ stackpop.columna+ " , columna" + stackpop.linea);
                    this.deleteTop();
                    continue;
                }
                this.TablaSimbolos.put(stackpop.valor,tipo );
                if(isGlobal){CodeMonkey.getInstance().addToString(stackpop.valor+"\tresd 1");
                }

                this.deleteTop();
            }
            catch(Exception e)
            {
                break;
            }
        }
        this.deleteTop();
    }
    
    public void pushRS(RS rs){
        this.stack.add(rs);
      
    }
    
    public RS popRS(){
        return this.stack.get(this.stack.size()-1);
    }
    
    public RS getBottom(){
         return this.stack.get(0);
    }
    
    public void deleteTop(){
        this.stack.remove(this.stack.size()-1);
    }
    
    public void wipeStack()
    {
        stack = new ArrayList<RS>();
    }
    public void addCountParams(){
        this.funcParamsCount= this.funcParamsCount +1 ;
    }
    
    public void addWhileCount(){
        this.whileCount++;
    }
     public void reduceWhileCount(){
        this.whileCount--;
    }
    public void checkWhile( String token, Integer linea, Integer columna){
        if(!(this.whileCount>0)){
            this.errores.add("Error en linea "+ linea+ " ,columna "+columna+ "\nPalabra reservada "+ token +" fuera de los bloques válidos");
        }
        
    }   
    public void comoUstedQuiera(){
        System.out.println("Inicio Diferencia asignacion"+this.stack);
        if(this.stack.size()>2){
            evalBinary();
            assign();
        }
        else{
            assign();
            if(this.stack.size()>0)
            {
                this.deleteTop();
            }
        }
    }
    public void writeLabelIf(String string){
        if(string.equals("if"))
        {
            CodeMonkey.getInstance().addToString(CodeMonkey.getInstance().CompareInstruction + "if_Exit_"+this.ifCount);
        }
            
        else if(string.equals("else"))
        {
            
        }
        else if(string.equals("endIf"))
        {
            CodeMonkey.getInstance().addToString("if_Exit_"+this.ifCount+":");
            this.ifCount++;
        }
        else if(string.equals("while"))
        {
            CodeMonkey.getInstance().addToString("whileLabel"+this.whileCountlabel+":");
        }
        else if(string.equals("whileStart"))
        {
            CodeMonkey.getInstance().addToString(CodeMonkey.getInstance().CompareInstruction + "while_Exit_"+this.whileCountlabel+":");
        }
        else if(string.equals("whileEnd"))
        {
            CodeMonkey.getInstance().addToString("JMP "+ "whileLabel"+this.whileCountlabel);
            CodeMonkey.getInstance().addToString("while_Exit_"+this.whileCountlabel+":");
            this.whileCountlabel++;
            
        }
    
    }
    
}

