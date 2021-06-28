/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author carlo
 */
public class CodeMonkey {
        private static CodeMonkey Struct;
        public String StringToWrite = "";
        public boolean codeStarted=false;
        public String CompareInstruction="";
            
    public static CodeMonkey getInstance()
    {
        if(Struct==null )
        {
            Struct = new CodeMonkey();
        }
        return Struct;
    }
    public void WriteAsmHeader(String fileName)
    {
      FileWriter myWriter = null;
            try {
                String fileNameWithOutExt = fileName.replaceFirst("[.][^.]+$", "");
                myWriter = new FileWriter(fileNameWithOutExt+".asm");
                myWriter.write(this.StringToWrite);
                myWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(CodeMonkey.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
    public void initializeString(){
        this.StringToWrite = ".DATA\n.UDATA\n";
    }
    public void initializeCode(){
        this.StringToWrite+=".CODE\n\n.STARTUP \n";
        this.codeStarted=false;
    }
    public void addToString(String newString){
        if(this.codeStarted)
        {
            this.initializeCode();
        }
        this.StringToWrite+= newString+ "\n";
    }
    public void setStringCompare(String cmpString)
    {
        this.CompareInstruction = cmpString;
    }


    
}
