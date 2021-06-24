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
abstract public class RS {
    public Integer linea;
    public Integer columna;
    public String valor;
    
    RS(String valor,int linea, int columna){
        this.valor=valor;
        this.linea = linea;
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "Soy del tipo "+ this.getClass().getName() +", valor=" + valor +"\n";
    }
    
    
}
