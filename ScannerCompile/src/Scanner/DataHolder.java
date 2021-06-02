/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

/**
 *
 * @author carlo
 */
public class DataHolder {
    int linea;
    String text;
    
    DataHolder(int linea,String text)
    {
        this.linea = linea ;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Linea "+ linea +" Texto "+ text; //To change body of generated methods, choose Tools | Templates.
    }
    
}
