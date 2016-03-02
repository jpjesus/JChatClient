/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
/* The class Block is responsible for the creation of a block
 * @author Jesus Parada & Erick Medina
 */
import java.io.Serializable;

public class Block implements Serializable {
   
    /** 
     * Atribute Declaration
     */
    
    private String blockname;
    private UserList userlist;
    
    /**
     * Constructor of Block Class
     */
    public Block () {
        
        this.blockname       = "";
        this.userlist    = new UserList();
        
    }
      /**
     * Overload constructor of Block class
     * @param boolean
     */
    
    public Block (boolean def){
        this.blockname       = "Other Friends";
        this.userlist    = new UserList();
    }
       /**
     * Overload constructor of Block class
     * @param String name 
     */
    public Block (String name) {
        
        this.blockname       = name;
        this.userlist    = new UserList ();
    }

    public UserList getUserList() {
        return userlist;
    }

    public void setUserList(UserList friends) {
        this.userlist = friends;
    }

    public String getBlockName() {
        return blockname;
    }

    public void setBlockName(String name) {
        this.blockname = name;
    }

    @Override
    public String toString() {
        
        System.out.println(blockname);
        System.out.println("Members: ");
        userlist.printUserList();
        return " ";
    }
    
     
    
            
    
}
