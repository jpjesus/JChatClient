/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.StandardObject;
import util.Util;
import javax.swing.JComboBox;
import jsockets.client.SocketClient;
import jsockets.util.UtilFunctions;
import logic.LogicUser;
import presentation.Main;

/**
 * 
 * @author Jesus Parada & Erick Medina
 */
public class FriendController {
  /**
 * Add a Friend in the Jchat , send the request to the server
 * @param String mynick
 * @param JComboBox jcombo
 * @param String friendnick
 * @return boolean
 */
    public static boolean addFriend (String mynick,JComboBox jcombo,String friendnick)
    {
        
     boolean conf = false;  
     byte[] resultado;
     SocketClient usersocket = new SocketClient();
    
     if (jcombo.getSelectedIndex()== 0)
     {
     String proto = "8:"+friendnick+":"+mynick;
     
     StandardObject generalObject = new StandardObject (proto,null);
     
    
     
     resultado = usersocket.executeRequest(generalObject, Util.SERVIDOR, Util.NUMERO_PUERTO_ENVIO);
     

     String res = UtilFunctions.byteArrayToString(resultado);
     System.out.print(res);
     if (res.compareTo("FALSE")!=0)
     {
         
       return conf = true;
         
     }
     else
     return conf;
    }
       if (jcombo.getSelectedIndex()== 1)
       {
           String proto = "12:"+mynick+":"+friendnick;
     
     StandardObject generalObject = new StandardObject (proto,null);
     
    
     
     resultado = usersocket.executeRequest(generalObject, Util.SERVIDOR, Util.NUMERO_PUERTO_ENVIO);
     

     String res = UtilFunctions.byteArrayToString(resultado);
     System.out.print(res);
     if (res.compareTo("FALSE")!=0)
     {
         
       return conf = true;
         
     }
     else
     return conf;
       }
    return conf ; 
    } 
   
    
   /* public static boolean deleteFriend (String my){
        
      
        boolean conf;  
        byte[] resultado;
    
     
        String proto = "12:"++":"+friendnick;
     
        StandardObject generalObject = new StandardObject (proto,null);
     
        SocketClient usersocket = new SocketClient();
        int port = Integer.parseInt(logInController.user.getUser().getPort());
     
        resultado = usersocket.executeRequest(generalObject, Main.SERVIDOR, Main.NUMERO_PUERTO);
     
        String res = UtilFunctions.byteArrayToString(resultado);
     
        if (res.compareTo("FALSE")==0){
         
            conf = false;
         
        }
        else {
            conf = true;
        }
     
     return conf;
     
    }*/
}
    
