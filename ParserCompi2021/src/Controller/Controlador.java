/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Scanner.LexerCup;
import Scanner.Modelo;
import Scanner.SemanticStructures;
import Scanner.parser;
import SemanticShit.RS;
import SemanticShit.RS_ID;
import SemanticShit.RS_Tipo;
import TokenTypes.Token;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laptop
 */
public class Controlador implements ActionListener{
    
    private TablaTokens ventana;
    
    public Controlador(){
    }

   
    public Controlador(TablaTokens vista) {
        this.ventana = vista;
    }
    
    public void iniciar(){
        this.ventana.setVisible(true);
        this.ventana.btn_Archivo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.ventana.btn_Archivo){
            JFileChooser buscador= new JFileChooser();
            buscador.showOpenDialog(null);
            File archivo =buscador.getSelectedFile();
            if (archivo != null){
                String path = archivo.getAbsolutePath();
                //String ruta1 = "./src/Scanner/Lexer.flex";
                //String ruta2 = "./src/Scanner/LexerCup.flex";
                //String[] rutaS = {"-parser", "Sintax","./src/Scanner/Syntax.cup"};
                //File archivo2;
                //archivo = new File(ruta1);
                // JFlex.Main.generate(archivo);
                //archivo2 = new File(ruta2);
                Modelo.iniciar(path);
                Reader reader; 
                try {
                    reader = new FileReader(path);
                    parser p = new parser(new LexerCup(reader));
                    try{
                        String texto =  new String(Files.readAllBytes(Paths.get(path)));
                        p.parse();
                        System.out.println("puto quien lo lea");
                        for(RS tipo: SemanticStructures.getInstance().stack)
                        {
                            try{
                                RS tipote =  tipo;
                                System.out.println("Token "+tipote.valor  + " Linea "+tipote.linea + " columna "+tipote.columna);
                            }
                            catch(Exception error)
                            {
                                RS Id =  tipo;
                                System.out.println("Token "+Id.valor+ " Linea "+Id.linea + " columna "+Id.columna);
                            }
                            
                        }
                        for (String error: SemanticStructures.getInstance().errores)
                        {
                            System.out.println(error);
                        }
                        llenarLista(p, texto);
                    }
                    catch(Exception A){
                       A.printStackTrace();
                    }  
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
        
        public void llenarLista(parser p, String t){
        
        JTable table = this.ventana.tabla_Tokens;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Map.Entry<String,Token> entry : Modelo.allTokens.entrySet()) {
            String a = entry.getValue().getOcurrenciasTotales();
            model.addRow(new Object[]{entry.getKey(),entry.getValue().getTipo(),a});
        }
        
        table = this.ventana.tabla_Errores;
        model = (DefaultTableModel) table.getModel();
        System.out.println("Errores");
        model.setRowCount(0);
        for (Map.Entry<String,Token> entry : Modelo.allErrors.entrySet()) {
            String a = entry.getValue().getOcurrenciasTotales();
            model.addRow(new Object[]{entry.getKey(), a});
        }
        System.out.println(p.errores);
        
        String[] parts = t.split("\n");
        JTextArea a = this.ventana.tabla_Tokens1;
        a.setText("");
        int i = 1;
        t="";
        for (String part : parts) {
                    t+=(i +".  "+ part + "\n");
                    i++;
        }
        a.setText(t);
        
        table = this.ventana.tabla_Errores1;
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        System.out.println("Errores");
        for ( String entry : p.errores) {
            model.addRow(new Object[]{entry});
        }
    }
    
    
  
    
}
