/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TokenTypes;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Token {
    String tipo;
    int linea;
    String token;
    ArrayList<Integer> aparece;
    
    
   
        Token(int linea,String token){
        this.linea = linea;
        this.token = token;
    }
        
        
    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Integer> getAparece() {
        return aparece;
    }

    public void setAparece(ArrayList<Integer> aparece) {
        this.aparece = aparece;
    }
    
    
 
}
