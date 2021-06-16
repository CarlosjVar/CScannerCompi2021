/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TokenTypes;

/**
 *
 * @author Laptop
 */
public class ErrorLexico extends Token {
    public ErrorLexico(int linea, String token) {
        super(linea, token);
        this.setTipo("ErrorLexico");
    }
}
