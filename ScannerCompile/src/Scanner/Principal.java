/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import Controller.Controlador;
import View.ventanaPrincipal;
import java.io.File;

/**
 *
 * @author Charly Ponce
 */
public class Principal {

    public static void main(String[] args) {
        ventanaPrincipal vista = new ventanaPrincipal();
        Controlador ctrl = new Controlador( vista);
        ctrl.iniciar();
        System.out.println("listooooo");
    }
    
 }
