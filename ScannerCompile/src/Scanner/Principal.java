/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import Controller.Controlador;
import View.TablaTokens;
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
        TablaTokens vista = new TablaTokens();
        Controlador ctrl = new Controlador( vista);
        ctrl.iniciar();
        
    }
 }
