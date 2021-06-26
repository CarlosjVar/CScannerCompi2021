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

/**
 *
 * @author carlo
 */
public class SemanticStructures {
    public ArrayList<RS> stack = new ArrayList<RS>();
    public HashMap<String,Object> TablaSimbolos = new HashMap<String,Object>();
    private static SemanticStructures Struct;
    public ArrayList<String> errores = new ArrayList<String>();
    int whileCount= 0 ;
    int forCount = 0;
    int funcParamsCount = 0;
    int switchCount = 0;
    
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
        //TODO agregar loop
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
        this.deleteTop();
    }
    
    public void evalFuncion(){
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
    
    public void insertarTS(){
        RS_Tipo tipo = (RS_Tipo)this.getBottom();
        System.out.println("inicioPila insertarTS"+this.stack);
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
}
