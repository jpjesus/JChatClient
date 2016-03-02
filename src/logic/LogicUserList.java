/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.User;
import domain.UserList;

/**
 * LogicUserlist implements UserList and all of this attributes and methods
 * @author Jesus Parada & Erick Medina
 */
public class LogicUserList {
    
    private UserList userlist;
    
    public LogicUserList (){
         
        this.userlist = new UserList ();
    }

    public UserList getUserlist() {
        return userlist;
    }

    public void setUserlist(UserList userlist) {
        this.userlist = userlist;
    }
    
    public void addUser(LogicUser user)
    {
        this.userlist.addUser(user.getUser());
    }
    
    public void removeUser(LogicUser user)
    {
        this.userlist.removeUser(user.getUser());
    }
    
    public void printUserList()
    {
        this.userlist.printUserList();
    }
    
    public int size()
    {
        return this.userlist.size();
    }
    
    public LogicUser get(int pos)
    {
        LogicUser user = new LogicUser();
        user.setUser(this.userlist.get(pos));
        
        return user;
    }
    
}
