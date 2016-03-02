/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.Serializable;
import java.util.Comparator;
import presentation.ChatWindow1;

/**
 *
 * @author Satellite
 */
public class NicknameComparator2 implements Comparator, Serializable{
    @Override
    public int compare(Object firstObject, Object secondObject)
    {
        int result = ((ChatWindow1)firstObject).getjLFriendNickname().getText().compareTo(((ChatWindow1)secondObject).getjLFriendNickname().getText());

        if (result == 0)
            return 0;
        
        if (result < 0)
            return -1;
        
        return 1;
    }
    
}
