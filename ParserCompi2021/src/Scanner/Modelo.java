/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import TokenTypes.Token;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

/**
 *
 * @author Laptop
 */
public class Modelo {
    public static HashMap<Integer,HashMap<String,Token>> codeLines = new HashMap<Integer,HashMap<String,Token>>();
    public static HashMap<String,Token> allTokens = new HashMap<String,Token>();
    public static HashMap<String,Token> allErrors = new HashMap<String,Token>();  

    public Modelo() {
    }
    //Se encarga de iniciar el proceso de análisis léxico del documento ingresado
    public static void iniciar(String ruta) {
    try { 
        Reader lector = new BufferedReader(new FileReader(ruta));
        LexerViejo lexer = new LexerViejo(lector);
        //Se crea un subhashmap
        HashMap<String,Token> lineaHash = new HashMap<>();
        Integer currentLine = 0;
        while(true){

            Token token = lexer.yylex();
            //Si se llega al final se le agrega al Hashmap de Hashmaps el Hashmap de Tokens
            if(token == null)
            {
                codeLines.put(currentLine, lineaHash);
                break;
            }
            //Si cambia el número de linea, se agrega el hashmap de tokens al hashmap de lineas de tokens, y se crea uno nuevo para utilizar con la nueva línea
            if(token.getLinea() != currentLine)
            {
                codeLines.put(currentLine, lineaHash);
                lineaHash =  new HashMap<>();
            }        

            String currentKey = token.getToken();

            //En caso de existir la llave, se le suma 1 a las ocurrencias
            if(lineaHash.containsKey(currentKey))
            {
                Token tokenFound = lineaHash.get(token.getToken());
                Integer repeticiones = tokenFound.getOcurrencias() +1  ;
                tokenFound.setOcurrencias(repeticiones);
                lineaHash.put(currentKey, tokenFound);

            }
            //De no encontrarse la llave, se incluye en el hashMap
            else
            {
                lineaHash.put(token.getToken(), token);
            }
            currentLine = token.getLinea();
        }
        //Se revisa si hay Tokens iguales en diferentes lineas por medio de un método, si hay los agrupa

        revisarTipos();

       allTokens.forEach((k,v)->{
           String a = v.getOcurrenciasTotales();

       });

       allErrors.forEach((k,v)->{
           String a = v.getOcurrenciasTotales();

       });

    } catch (FileNotFoundException ex) {
        System.out.println("a");
    } catch (IOException ex) {
        System.out.println("a");
    }

}
    //A partir de los tokens obtenidos por la función principal se encarga de separarlos en Errores o en Tokens
    public static void revisarTipos(){
        
         codeLines.forEach((k,v)->{
                v.forEach((k2,v2)->{
                Token tokenFound = v2;
                if(!tokenFound.getTipo().equals("ErrorLexico"))
                {
                    if(allTokens.containsKey(k2))
                    {
                        allTokens.get(k2).setOcurrenciasTotales(tokenFound.getLinea(),tokenFound.getOcurrencias()); 
                    }
                
                    else
                    {
                        tokenFound.setOcurrenciasTotales(tokenFound.getLinea(), tokenFound.getOcurrencias());
                        allTokens.put(tokenFound.getToken(),tokenFound);
                    }
                }
                else
                {
                    
                    if(allErrors.containsKey(k2))
                    {
                        allErrors.get(k2).setOcurrenciasTotales(tokenFound.getLinea(),tokenFound.getOcurrencias()); 
                    }
                
                    else
                    {
                        tokenFound.setOcurrenciasTotales(tokenFound.getLinea(), tokenFound.getOcurrencias());
                        allErrors.put(tokenFound.getToken(),tokenFound);
                    }
                }
                
                
                });
            });
    }
    //Método de desarrollador utilizada solo si es necesario generar de nuevo la clase encargada de las expresiones regulares
//    public static void generarLexer( ){
//        String ruta = ".\\src\\Scanner\\Lexer.flex";
//        File archivo = new File(ruta);
//        JFlex.Main.generate(archivo);
//    }


}
