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
    private String tipo;
    private int linea;
    private String token;
    private Integer ocurrencias;
    
    
   
    Token(int linea,String token){
        this.linea = linea;
        this.token = token;
        this.ocurrencias = 1;
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

    public Integer getOcurrencias() {
        return ocurrencias;
    }

    public void setOcurrencias(Integer ocurrencias) {
        this.ocurrencias = ocurrencias;
    }
    
    
 
}
