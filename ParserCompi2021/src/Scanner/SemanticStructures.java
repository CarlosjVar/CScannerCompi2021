/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import SemanticShit.RS;
import SemanticShit.RS_DO;
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
    HashMap<String,Object> TablaSimbolos = new HashMap<String,Object>();
    private static SemanticStructures Struct;
    public ArrayList<String> errores = new ArrayList<String>();
    
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
    
    public void recuerdaVariable(String tipo, Integer linea, Integer columna){
        RS_DO RStipo = new RS_DO(tipo, linea, columna, false);
        this.pushRS(RStipo);
    }
    
    public void insertarTS(){
        RS_Tipo tipo = (RS_Tipo)this.getBottom();

        while(this.popRS() != tipo){
            try
            {
                RS_ID stackpop = (RS_ID)this.popRS(); 
                if(this.TablaSimbolos.containsKey(stackpop.token))
                {
                    this.errores.add("La variable "+ stackpop.token +" ya está definidida en la linea "+ stackpop.columna+ " , columna" + stackpop.linea);
                    this.deleteTop();
                    continue;
                }
                this.TablaSimbolos.put(stackpop.token,tipo.token );
                
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
        System.out.println(this.stack.toString());
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
    
}
