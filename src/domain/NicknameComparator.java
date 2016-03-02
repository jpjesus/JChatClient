/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Jesus Parada & Erick Medina
 */
public class NicknameComparator implements Comparator, Serializable
{
  /**
 * Compare the nickname given to Objects this method implements the Comparator interface
 * @param Object object1
 * @param Object object2
 * @return integer
 * 
 */
    @Override
    public int compare(Object firstObject, Object secondObject)
    {
        int result = ((User)firstObject).getNickname().compareTo(((User)secondObject).getNickname());

        if (result == 0)
            return 0;
        
        if (result < 0)
            return -1;
        
        return 1;
    }
    
}
