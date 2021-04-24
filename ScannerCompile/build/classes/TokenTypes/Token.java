/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TokenTypes;

import java.util.HashMap;

/**
 *
 * @author carlo
 */
public class Token {
    private String tipo;
    private int linea;
    private String token;
    private Integer ocurrencias;
    public HashMap<Integer,Integer> OcurrenciasTotales;
    
    
   
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
    public void setOcurrenciasTotales(Integer linea, Integer ocurrencias){
        if( this.OcurrenciasTotales == null)
        {
            this.OcurrenciasTotales = new HashMap<>();
        }
        this.OcurrenciasTotales.put(linea,ocurrencias);
    }
    public String getOcurrenciasTotales(){
        String resultado = "";
        
         for (Integer key : this.OcurrenciasTotales.keySet()) {
                Integer ocurrencias = this.OcurrenciasTotales.get(key);
                String concat = "";
                if(ocurrencias==1)
                {
                    concat = key+",";
                }
                else
                {
                    concat = key+"("+ocurrencias+") ,";

                }
                resultado = resultado.concat(concat);   
        }
        if (resultado != null && resultado.length() > 0 && resultado.charAt(resultado.length() - 1) == ',') {
                    resultado = resultado.substring(0, resultado.length() - 1);
                } 
        return resultado;
    }
    

    public void setOcurrencias(Integer ocurrencias) {
        this.ocurrencias = ocurrencias;
    }
    
    
 
}
