/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.BlockList;
import domain.StandardObject;
import domain.User;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import jsockets.client.SocketClient;
import jsockets.util.UtilFunctions;
import logic.LogicBlockList;
import logic.LogicUser;
import domain.User;
import domain.PreferencesXmlFile;
import presentation.Main;
import util.Util;
import domain.Utildomain;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import presentation.ErrorSignIn;
import presentation.JChat;
import presentation.MainWindow;

/**
 *
 * @author Jesus Parada & Erick Medina
 */
public class LogController {
    
    private static LogicUser user =null;
    
    
       private static JFrame chat;

    public static JFrame getChat() {
        return chat;
    }

    public static void setChat(JFrame chat) {
        LogController.chat = chat;
    }
  /**
 * Log a client in the system  , send a request to the server , and return a User
 * @param String nick
 * @param String password
 * @return boolean
 */
    
    public static boolean loginController (String mynick, String password)
    {
         boolean conf;  
     byte[] resultado;
     /*User user = new User();
     user = PreferencesXmlFile.readPreferencesFromFile(mynick);
    
   Main.SERVIDOR = user.getIp();
   Main.NUMERO_PUERTO_ENVIO=Integer.parseInt(user.getPort());*/
     String proto = "2:"+mynick+":"+password+":"+Main.MI_IP+":"+Main.NUMERO_PUERTO_ESCUCHA;
     
     StandardObject generalObject = new StandardObject (proto,null);
     
     SocketClient usersocket = new SocketClient();
     
     resultado = usersocket.executeRequest(generalObject, Main.SERVIDOR, Main.NUMERO_PUERTO_ENVIO);
     
     
     
     LogicUser user2 = new LogicUser();
     
     user2.setUser((User) UtilFunctions.byteArrayToObject(resultado));
     
     
     if (user2.getUser()==null){
         
         conf = false;
         
     }
     else {
         
         LogController.setUser(user2);
         
         conf = true;
         
     }
     
     System.out.println("Elservidor devuelve: "+conf);
     
     return conf;
    
    }
    public static void LogInSystem (JFrame window, JTextField user,JPasswordField password) 
    {
         boolean aux = false;
         
            aux = LogController.loginController(user.getText(), password.getText());   
           


  
            
        
            if (aux==true) 
            {
                
            Utildomain.USER_NICKNAME = user.getText();
            
            JChatController.setStatus(true);
            
            
            JChat chatwindow=null;
            try {
                chatwindow = new JChat();
            } catch (ParseException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            chatwindow.setWindowFather(window);
            chatwindow.setVisible(true);
            chatwindow.setLocationRelativeTo(null);
            window.dispose();
            LogController.setChat(chatwindow);
            JChatController.setStatus(true);
            }
            else {
                
            ErrorSignIn notmember = new ErrorSignIn();
            notmember.setWindowFather(window); 
            notmember.setLocationRelativeTo(null);
            notmember.setVisible(true);
            window.setEnabled(false);
                
            }
    }
    
    /**
 * Get the list of your friends  in the system  , send a request to the server , and return a User
 * @param String nick
 * @param String password
 * @return boolean
 */
    public static boolean getUserFriends (String nick) {
        
         String proto2 = "6:"+nick;
         boolean found = false;
     
         StandardObject generalObject2 = new StandardObject (proto2,null);
     
         SocketClient usersocket2 = new SocketClient();
         
         byte [] result;
         
         result = usersocket2.executeRequest(generalObject2, Main.SERVIDOR , Main.NUMERO_PUERTO_ENVIO);
         
         LogicBlockList blocklist = new LogicBlockList();
         blocklist.setBlockList((BlockList)UtilFunctions.byteArrayToObject(result));
     
         
  
         
       
           if (blocklist == null) {  
             System.out.println("Error leyendo amigos");
             
         }
         else
         {
           user.getUser().setBlockList(blocklist.getBlockList());
           System.out.println("amigos cargados exitosamente");
           found = true;
           
         }
           
           return found;
        
    }
    
     public static ImageIcon getAvatar(String nickname){
        
        ImageIcon image = new ImageIcon (user.getUser().getAvatar());
        
        return image;
    }
     
     public static void setAvatar(String rut){
        
        ImageIcon image = new ImageIcon (rut);
        
        user.getUser().setAvatar(rut);
        
    }

    public static LogicUser getUser() {
        return user;
    }

    public static void setUser(LogicUser user) {
        LogController.user = user;
    }
     
     public static String getNickname()
     {
       
             return user.getUser().getNickname();
    
     }


  
     
     
}