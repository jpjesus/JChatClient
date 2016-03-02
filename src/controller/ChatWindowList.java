/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.NicknameComparator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import presentation.ChatWindow1;

/**
 *
 * @author Satellite
 */
public class ChatWindowList {
   
    /** 
     * Attribute Declaration
     */
    private SortedSet <ChatWindow1> chatlist;
    private Comparator       nicknamecomparator2;
/**
     * Constructor of ChatWindowList Class
     */
    
    
    public ChatWindowList(){
        
        this.nicknamecomparator2 = (Comparator) new NicknameComparator();
        this.chatlist = new TreeSet(nicknamecomparator2);
    }
  /**
     * Add a user in the list
     * @param User object
     * @return boolean
     */
    
    public boolean addChat(ChatWindow1 chat)
    {
        return this.chatlist.add(chat);
    }
    /**
     * Remove a user in the list
     * @param User object
     * @return boolean
     */
    public boolean removeChat(ChatWindow1 chat)
    {
        return this.chatlist.remove(chat);
    }
    
    /**
     * Return the size of the list
     */
    //<editor-fold defaultstate="collapsed" desc="comment">

    //</editor-fold>
/*    @Override
    public int size()
    {
        return this.chatlist.size();
    }*/
     /**
     * Return the position of the user in the list
     * @param int  pos
     * @return int
     */
    public ChatWindow1 get(int pos)
    {
        ArrayList <ChatWindow1> list = new ArrayList(this.chatlist);
        
        return list.get(pos);
    }

  public SortedSet<ChatWindow1> getChatWindow() {
        return chatlist;
    }

    public void setChatWindow(SortedSet<ChatWindow1> chat) {
        this.chatlist= chat;
    }
 
  public int size()
    {
        return this.chatlist.size();
    }
      public ChatWindow1 get(String friendnickname)
    {
        ArrayList <ChatWindow1> list = new ArrayList(this.chatlist);
        int i =0;
        ChatWindow1 aux = null;
        
        while (i<list.size()){
            
          if (list.get(i).getjLFriendNickname().getText().compareTo(friendnickname)==0)
              aux=list.get(i);
          else
              i++;
        }
        
        
        return aux;
    }
}
