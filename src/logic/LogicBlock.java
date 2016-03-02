/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Block;
/**
 * LogicBlock implements Block and all of this attributes and methods
 * @author Jesus Parada & Erick Medina
 */
public class LogicBlock {
    
    private Block group;
    
    public LogicBlock (){
        
        this.group = new Block ();
       
    }
    
    public LogicBlock (String name){
        
        this.group = new Block (name);
    }
    
    public LogicBlock (boolean def){
        
        this.group = new Block (def);
    }

    public Block getBlockList() {
        return group;
    }

    public void setBlockList(Block group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "LogicGroup:" + "\n" +
                "group:" + group + "\n";
    }
       
}
