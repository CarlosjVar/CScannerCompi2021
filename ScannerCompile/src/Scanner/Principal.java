/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import Controller.Controlador;
import View.ventanaPrincipal;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
/**
 *
 * @author Charly Ponce
 */
public class Principal {

    public static void main(String[] args) throws IOException, Exception { 
        ventanaPrincipal vista = new ventanaPrincipal();
        Controlador ctrl = new Controlador( vista);
        ctrl.iniciar();
        String ruta1 = "./src/Scanner/Lexer.flex";
        String ruta2 = "./src/Scanner/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax","./src/Scanner/Syntax.cup"};
             
        File archivo;
        //archivo = new File(ruta1);
       // JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
       JFlex.Main.generate(archivo);
        
        Reader reader = new FileReader("./src/Scanner/ejemplo.txt");     
        parser p = new parser(new LexerCup(reader));
        
        try{
        p.parse();
        System.out.println("puto quien lo lea");
        }catch(Exception e){
            Symbol simbol =  p.getS();
            System.out.println("Error de sintaxis. Linea: " + (simbol.right + 1) + " Columna: " + (simbol.left + 1) + ", Texto: \"" + simbol.value + "\"");
        }  
    }
 }
