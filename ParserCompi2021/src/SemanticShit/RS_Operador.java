/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemanticShit;

/**
 *
 * @author Laptop
 */
public class RS_Operador extends RS {
    public String operador;
    public Integer linea;
    public Integer columna;

    public RS_Operador(String operador, Integer linea, Integer columna) {
        this.operador = operador;
        this.linea = linea;
        this.columna = columna;
    }
    
}
