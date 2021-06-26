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
import java.util.HashMap;

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
    public int forCount = 0;
    public int funcParamsCount = 0;
    public int switchCount = 0;
    
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
        RS_FU func= new RS_FU(nombre.valor, nombre.linea,tipo.columna,tipo.valor);
        func.params = params;
        
        System.out.println(func.valor);
        if(this.TablaSimbolos.containsKey(func.valor))
        {                     
            this.errores.add("La variable "+ func.valor +" no está declarada. Linea "+ nombre.linea +", columna " + tipo.columna);            
        }
        else
        {
            this.TablaSimbolos.put(func.valor,func);
        }
        //this.pushRS(func);
    }
    
    public void comoUstedQuiera(){
        if(this.stack.size()>2){
            evalBinary();
        }
        else{
            assing();
        }
    }
    
    public void evalBinary(){
        RS_DO RS_DO2 = (RS_DO) this.popRS();
        this.deleteTop();
        RS_Operador RS_OP = (RS_Operador) this.popRS();
        this.deleteTop();
        RS_DO RS_DO1 = (RS_DO) this.popRS();
        this.deleteTop();
        RS_DO RS_DO_;
        int calculo = 0;
        if(RS_DO2.banderita && RS_DO1.banderita ){
            if("+".equals(RS_OP.valor)) { calculo = Integer.parseInt(RS_DO2.valor)+Integer.parseInt(RS_DO1.valor);}
            else if("-".equals(RS_OP.valor)) { calculo = Integer.parseInt(RS_DO1.valor)-Integer.parseInt(RS_DO2.valor);}
            else if("/".equals(RS_OP.valor) && Integer.parseInt(RS_DO2.valor)!=0 ) {  calculo = Integer.parseInt(RS_DO1.valor)/Integer.parseInt(RS_DO2.valor);}
            else if("*".equals(RS_OP.valor)) { calculo = Integer.parseInt(RS_DO1.valor)*Integer.parseInt(RS_DO2.valor);}
            RS_DO_ = new RS_DO(Integer.toString(calculo), RS_DO1.linea, RS_DO1.columna, true);   
        }
        else{
            RS_DO_ = new RS_DO(RS_DO2.valor+"+"+RS_DO1.valor, RS_DO1.linea, RS_DO1.columna, true);  
        }
    }
    
    public void evalUnary(){
        RS_DO RS_DO = (RS_DO) this.popRS();
        this.deleteTop();
        RS_Operador RS_OP = (RS_Operador) this.popRS();
        this.deleteTop();
        RS_Operador RS_OP1 = (RS_Operador) this.popRS();
        this.deleteTop();
        int calculo = 0;
        if(RS_DO.banderita ){
            if("+".equals(RS_OP.valor) && "+".equals(RS_OP1.valor) ) { calculo = (Integer.parseInt(RS_DO.valor))+1;}
            else if("-".equals(RS_OP.valor) && "-".equals(RS_OP1.valor) ) { calculo = (Integer.parseInt(RS_DO.valor))-1;}
        }
        else{
            System.out.println("VELVET ES HERMOSOOOOOOOOO");
        }
    }
    
    private void assing() {
         System.out.println("VELVET ES HERMOSOOOOOOOOO!");
    }
    
    public void insertarTS(){
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
    
    
    
}

