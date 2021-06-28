/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Scanner.CodeMonkey;
import Scanner.LexerCup;
import Scanner.Modelo;
import Scanner.SemanticStructures;
import Scanner.parser;
import SemanticShit.RS;
import SemanticShit.RS_FU;
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
        this.ventana.getBtn_Archivo().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.ventana.getBtn_Archivo()){
            JFileChooser buscador= new JFileChooser();
            buscador.showOpenDialog(null);
            File archivo = buscador.getSelectedFile();
            if (archivo != null){
                String path = archivo.getAbsolutePath();
                SemanticStructures.getInstance().stack = new ArrayList();
                Modelo.iniciar(path);
                Reader reader; 
                SemanticStructures.getInstance().stack = new ArrayList();
                SemanticStructures.getInstance().TablaSimbolos = new HashMap();
                try {
                    reader = new FileReader(path);
                    parser p = new parser(new LexerCup(reader));
                    CodeMonkey.getInstance().initializeString();
  
                    try{
                        String texto =  new String(Files.readAllBytes(Paths.get(path)));
                        p.parse();
                        
                        for (String error: SemanticStructures.getInstance().errores)
                        {
                            System.out.println(error);
                        }
                        
                        ArrayList<String> errores = SemanticStructures.getInstance().errores;
                        llenarLista(p, texto, errores);
                        CodeMonkey.getInstance().WriteAsmHeader(path);
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
        
        public void llenarLista(parser p, String t, ArrayList<String> e){
        
        JTable table = this.ventana.getTabla_Tokens();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Map.Entry<String,Token> entry : Modelo.allTokens.entrySet()) {
            String a = entry.getValue().getOcurrenciasTotales();
            model.addRow(new Object[]{entry.getKey(),entry.getValue().getTipo(),a});
        }
        
        table = this.ventana.getTabla_Errores();
        model = (DefaultTableModel) table.getModel();
        System.out.println("Errores");
        model.setRowCount(0);
        for (Map.Entry<String,Token> entry : Modelo.allErrors.entrySet()) {
            String a = entry.getValue().getOcurrenciasTotales();
            model.addRow(new Object[]{entry.getKey(), a});
        }
        System.out.println(p.errores);
        
        String[] parts = t.split("\n");
        JTextArea a = this.ventana.getTabla_Tokens1();
        a.setText("");
        int i = 1;
        t="";
        for (String part : parts) {
                    t+=(i +".  "+ part + "\n");
                    i++;
        }
        a.setText(t);
        
        table = this.ventana.getTabla_Errores1();
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for ( String entry : p.errores) {
            model.addRow(new Object[]{entry});
        }
        
        table = this.ventana.getTabla_Errores2();
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for ( String entry : e) {
            model.addRow(new Object[]{entry});
        }
        
        a = this.ventana.getCodigo_e();
        a.setText("");
        String ubicacion = CodeMonkey.getInstance().StringToWrite;
        a.setText(ubicacion);
    }
    
    
  
    
}
