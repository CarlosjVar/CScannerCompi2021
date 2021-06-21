/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import SemanticShit.RS;
import SemanticShit.RS_ID;
import SemanticShit.RS_Tipo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author carlo
 */
public class SemanticStructures {
    ArrayList<RS> stack = new ArrayList<RS>();
    HashMap<String,Object> TablaSimbolos = new HashMap<String,Object>();
    SemanticStructures Struct;
    public SemanticStructures getInstante()
    {
        if(this.Struct==null )
        {
            this.Struct = new SemanticStructures();
        }
        return this.Struct;
    }
    public void recuerdaTipo(Object tipo)
    {
        RS_Tipo Rtipo = new RS_Tipo(tipo.value.toString());
        this.pushRS(Rtipo);
    }
    public void recuerdaId(Object id)
    {
        RS_ID RId = new RS_ID(id.value.toString());
        this.pushRS(RId);
    }
    public void insertarTS(){
        RS tipo = this.getInstante().getBottom();

        while(this.popRS() != tipo){
            RS stackpop = this.popRS();
            
        }
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
}
