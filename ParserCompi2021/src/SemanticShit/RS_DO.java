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
public class RS_DO extends RS {
    public String valor;
    public Integer linea;
    public Integer columna;
    public boolean banderita;
    public boolean error = false;

    public RS_DO(String valor, Integer linea, Integer columna, boolean banderita) {
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
        this.banderita = banderita;
    }
    
}
