/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import Controller.Controlador;
import View.ventanaPrincipal;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Charly Ponce
 */
public class Principal {

    public static void main(String[] args) throws IOException, Exception { 
        ventanaPrincipal vista = new ventanaPrincipal();
        Controlador ctrl = new Controlador( vista);
        ctrl.iniciar();
        String ruta1 = "D:/Universidad/ScannerJAVACompi2021/CScannerCompi2021/ScannerCompile/src/Scanner/Lexer.flex";
        String ruta2 = "D:/Universidad/ScannerJAVACompi2021/CScannerCompi2021/ScannerCompile/src/Scanner/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax","D:/Universidad/ScannerJAVACompi2021/CScannerCompi2021/ScannerCompile/src/Scanner/Syntax.cup"};
        
        
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
       
        Path rutaSin = Paths.get("D:/Universidad/ScannerJAVACompi2021/CScannerCompi2021/ScannerCompile/src/Scanner/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }

    }
 }
