/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TokenTypes;

/**
 *
 * @author carlo
 */
public class Reservadas extends Token{

    public Reservadas(int linea, String token) {
        super(linea, token);
        this.setTipo("Reservadas");
    }
}
