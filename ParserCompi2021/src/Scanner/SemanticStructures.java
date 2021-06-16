/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author carlo
 */
public class SemanticStructures {
    ArrayList<Object> stack = new ArrayList<Object>();
    HashMap<String,Object>s = new HashMap<String,Object>();
    SemanticStructures Struct;
    public SemanticStructures getInstante()
    {
        if(this.Struct==null )
        {
            this.Struct = new SemanticStructures();
        }
        return this.Struct;
    }
}
