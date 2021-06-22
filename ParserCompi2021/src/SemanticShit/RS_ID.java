/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemanticShit;

/**
 *
 * @author carlo
 */
public class RS_ID extends RS {
    public String token;
    public Integer linea;
    public Integer columna;
    public RS_ID(String token, Integer linea, Integer columna){
        this.token=token;
        this.linea = linea;
        this.columna = columna;

    }
}
