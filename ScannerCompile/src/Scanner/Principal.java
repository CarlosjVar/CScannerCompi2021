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
        String ruta1 = "E:/ArchivosTec/Quintosemestre/Compi/CScannerCompi2021/ScannerCompile/src/Scanner/Lexer.flex";
        String ruta2 = "E:/ArchivosTec/Quintosemestre/Compi/CScannerCompi2021/ScannerCompile/src/Scanner/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax","E:/ArchivosTec/Quintosemestre/Compi/CScannerCompi2021/ScannerCompile/src/Scanner/Syntax.cup"};
        
        
        
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("E:/ArchivosTec/Quintosemestre/Compi/CScannerCompi2021/ScannerCompile/src/Scanner//sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("E:/ArchivosTec/Quintosemestre/Compi/CScannerCompi2021/ScannerCompile/sym.java"), 
                Paths.get("E:/ArchivosTec/Quintosemestre/Compi/CScannerCompi2021/ScannerCompile/src/Scanner/sym.java")
        );
        
        Path rutaSin = Paths.get("E:/ArchivosTec/Quintosemestre/Compi/CScannerCompi2021/ScannerCompile/src/Scanner/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("E:/ArchivosTec/Quintosemestre/Compi/CScannerCompi2021/ScannerCompile/Sintax.java"), 
                Paths.get("E:/ArchivosTec/Quintosemestre/Compi/CScannerCompi2021/ScannerCompile/src/Scanner/Sintax.java")
        );
    }
 }
