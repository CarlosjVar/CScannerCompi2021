package SemanticShit;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Feterro
 */
public class RS_FU extends RS {
    
    public String tipo;
    public ArrayList <RS_Tipo> params;
    
    public RS_FU(String valor, int linea, int columna,String tipo){        
        super(valor, linea, columna);
        this.params = new ArrayList<RS_Tipo>();
        this.tipo = tipo;
    }
    
    public void AsignarParametros(RS_Tipo param){
        this.params.add(param);
    }
}
