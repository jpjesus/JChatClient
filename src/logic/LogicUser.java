/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.User;
import java.util.Date;

/**
 * LogicUser implements User and all of this attributes and methods
 * @author Jesus Parada & Erick Medina
 */
public class LogicUser {
    
    private User user;
    
    public LogicUser() {
        
        this.user= new User();
    }

    public LogicUser(String name,String lastname, String secondlastname,Date birthdate,String nickname,String mail,String password) {
        this.user = new User (name, lastname, secondlastname, birthdate, nickname, mail, password);
    }
    
   public LogicUser(String name,String lastname, String secondlastname,Date birthdate,String nickname,String mail,String password, String ip, String port, String active, String status) {
        this.user = new User (name, lastname, secondlastname, birthdate, nickname, mail, password,ip,port,active,status);
    } 
 public LogicUser(String nickname,String ip, String port, String port1) {
        this.user = new User (nickname,ip,port,port1);
    } 
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LogicUser: " + "\n" + 
                "user:" + user + "\n";
    }
    
    
    
    
}
