/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import TokenTypes.Token;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Charly Ponce
 */
public class Principal {
    
    public static ArrayList<Token> tokensList = new ArrayList<Token>();
    public static HashMap<Integer,HashMap<String,Token>> codeLines = new HashMap<Integer,HashMap<String,Token>>();
    
    public static void main(String[] args) {
        String ruta = "D:\\Development\\ScannerCompi\\ScannerCompile\\src\\Scanner/Lexer.flex";
        generarLexer(ruta);

        try {
            Reader lector = new BufferedReader(new FileReader("D:/Development/ScannerCompi/ScannerCompile/src/Scanner/ejemplo.txt"));
            Lexer lexer = new Lexer(lector);
            int numerolinea = 0;
            //Se crea un subhashmap
            HashMap<String,Token> lineaHash = new HashMap<String,Token>();
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
                    lineaHash =  new HashMap<String,Token>();
 
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
            
            //Ejemplo de foreach
            codeLines.forEach((k,v)->{
                System.out.println("En la linea "+k+" estan los tokens "+v); 
                v.forEach((k2,v2)->{
                System.out.println("El token "+k2+" aparece "+v2.getOcurrencias()+" veces en la linea "+v2.getLinea());
                });
            });
        } catch (FileNotFoundException ex) {
            System.out.println("a");
        } catch (IOException ex) {
            System.out.println("a");
        }
        
    }
    
//    public static void revisarTipos(Token tok, int linea){
//        for(int k = 0; k<tokensList.size(); k++){
//            if (tokensList.get(k).getToken() == tok.getToken()){
//                tokensList.get(k).getAparece().add(linea);
//            }
//            else{
//                tokensList.add(tok);
//            }
//        }
//    }
  
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
