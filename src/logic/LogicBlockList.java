/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


import domain.BlockList;

/**
 * LogicBlockList implements Blocklist and all of this attributes and methods
 * @author Jesus Parada & Erick Medina
 */
public class LogicBlockList {
    
    private BlockList blocklist;
    
    public LogicBlockList (){
        
        this.blocklist = new BlockList();
    }

    public BlockList getBlockList() {
        return blocklist;
    }

    public void setBlockList(BlockList grouplist) {
        this.blocklist = grouplist;
    }
    
    public void addGroup(LogicBlock group)
    {
        this.blocklist.addGroup(group.getBlockList());
    }
    
    public void removeGroup(LogicBlock group)
    {
        this.blocklist.removeGroup(group.getBlockList());
    }
    
    public void printBlockList()
    {
        this.blocklist.printGroupList();
    }
    
    public int size()
    {
        return this.blocklist.size();
    }
    
    public LogicBlock get(int pos)
    {
        LogicBlock group = new LogicBlock();
        group.setBlockList(this.blocklist.get(pos));
        
        return group;
    }
    
    public LogicBlock get(String groupname)
    {
        LogicBlock group = new LogicBlock();
        
        group.setBlockList(this.blocklist.get(groupname));
        
        return group;
    }
    
    public boolean checkBlock(String groupname, LogicBlockList groups)
    {
        boolean aux = this.blocklist.checkGroup(groupname,groups.getBlockList());
        
        return aux;
    }
    
    
}
