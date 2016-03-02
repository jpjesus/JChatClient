/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/** 
 * The class Blocklist is responsible for the creation of a Blocklist and implements others methods
 * @author Jesus Parada & Erick Medina
 */
public class BlockList implements Serializable {
    /** 
     * Attribute Declaration
     */
    private SortedSet <Block> groups;
    private Comparator namecomparator;
     /**
     * Constructor of Blocklist Class
     */
    
    public BlockList (){
        
        this.namecomparator = (Comparator) new NameComparator();
        
        this.groups = new TreeSet(namecomparator);
       
    }
    /**
     * Add a block in the list
     * @param Block
     * @return boolean
     */
    
     public boolean addGroup(Block group)
    {
        return this.groups.add(group);
    }
    /**
     * Remove a block in the list
     * @param Block
     * @return boolean
     */
    public boolean removeGroup(Block group)
    {
        return this.groups.remove(group);
    }
    
    /**
     * Print all the block in the list
     */
    public void printGroupList()
    {
        Iterator iterator;
        
        System.out.println("Groups: ");
        
        iterator = this.groups.iterator();
        
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
    /**
     * Check  if block is listed or not
     * @param String blockname
     * @param Blocklist object
     * @return boolean
     */
    public boolean checkGroup (String blockname, BlockList groups){
        
        boolean check = false;
        int i =0;
        
        
        if (groups==null) {
            check=false;
        }
        else {
            
        
        
        
        while (i<groups.size()){
            
          if (groups.get(i).getBlockName().compareTo(blockname)==0){
              check=true;
              i ++;
          }
          else
              i++;
        }
        }
        
        return check;
           
    }
        
   
            
    /**
     * Return the size of the list
     */
    public int size()
    {
        return this.groups.size();
    }
     /**
     * Return the position of the block in the list
     * @param int  pos
     * @return int
     */
    public Block get(int pos)
    {
        ArrayList <Block> list = new ArrayList(this.groups);
        
        return list.get(pos);
    }
    /**
     * Return the  block in the list
     * @param String blockname
     * @return Block object
     */
    public Block get(String blockname)
    {
        ArrayList <Block> list = new ArrayList(this.groups);
        int i =0;
        Block aux = null;
        
        while (i<list.size()){
            
          if (list.get(i).getBlockName().compareTo(blockname)==0)
              aux=list.get(i);
          else
              i++;
        }
        
        
        return aux;
    }
    
     /**
     * Return the  block in the list given the name of the block and the blocklist
     * @param String blockname
     * @param Blocklist object
     * @return Block object
     */
    public Block get(String blockname,BlockList groups)
    {
        int i = 0;
        Block aux = null;
        boolean found = false;
        while (found!=true && i<groups.size())
        { 
            if (groups.get(i).getBlockName().compareTo(blockname)== 0)
            {
                aux=groups.get(i);
                found = true;
            }
            else
                i ++;
        }
        return aux;
    }
  public SortedSet<Block> getGroups() {
        return groups;
    }

    public void setGroups(SortedSet<Block> groups) {
        this.groups = groups;
    }
    
    
}
