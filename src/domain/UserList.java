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
 * The class Userlist is responsible for the creation of a Userlist and implements others methods
 * @author Jesus Parada & Erick Medina
 */
public class UserList implements Serializable {
    /** 
     * Attribute Declaration
     */
    private SortedSet <User> userlist;
    private Comparator       nicknamecomparator;
/**
     * Constructor of Userlist Class
     */
    
    
    public UserList(){
        
        this.nicknamecomparator = (Comparator) new NicknameComparator();
        this.userlist = new TreeSet(nicknamecomparator);
    }
  /**
     * Add a user in the list
     * @param User object
     * @return boolean
     */
    
    public boolean addUser(User user)
    {
        return this.userlist.add(user);
    }
    /**
     * Remove a user in the list
     * @param User object
     * @return boolean
     */
    public boolean removeUser(User user)
    {
        return this.userlist.remove(user);
    }
    /**
     * Print all the user in the list
     */
    public void printUserList()
    {
        Iterator iterator;
        
        
        
        iterator = this.userlist.iterator();
        
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
    /**
     * Return the size of the list
     */
    public int size()
    {
        return this.userlist.size();
    }
     /**
     * Return the position of the user in the list
     * @param int  pos
     * @return int
     */
    public User get(int pos)
    {
        ArrayList <User> list = new ArrayList(this.userlist);
        
        return list.get(pos);
    }

    
}
