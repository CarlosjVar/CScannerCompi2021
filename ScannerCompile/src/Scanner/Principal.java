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

/**
 *
 * @author Charly Ponce
 */
public class Principal {
    
    public static void main(String[] args) {
        String ruta = "D:\\Development\\ScannerCompi\\ScannerCompile\\src\\Scanner/Lexer.flex";
        generarLexer(ruta);
        ArrayList<ArrayList<Token>> listaToken = new ArrayList<ArrayList<Token>>();
        try {
            Reader lector = new BufferedReader(new FileReader("D:/Development/ScannerCompi/ScannerCompile/src/Scanner/ejemplo.txt"));
            Lexer lexer = new Lexer(lector);
            int numerolinea = 0;
            ArrayList<Token> linea = new ArrayList<Token>();
            while(true){

                Token token = lexer.yylex();
                if(token == null)
                {
                    listaToken.add(linea);
                    break;
                }
                if(token.getLinea() != numerolinea)
                {
                    listaToken.add(linea);
                    linea = new ArrayList<Token>();
                }
                numerolinea = token.getLinea();
                

                linea.add(token);
                System.out.println(token.getTipo());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("a");
        } catch (IOException ex) {
            System.out.println("a");
        }
        for (ArrayList<Token> var : listaToken) 
        { 
            System.out.println(var);
        }
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
