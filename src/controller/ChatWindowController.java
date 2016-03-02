/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.PreferencesXmlFile;
import domain.StandardObject;
import java.io.File;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import jsockets.client.SocketClient;
import jsockets.util.UtilFunctions;
import presentation.ChatWindow1;
import presentation.JChat;
import presentation.Main;

/**
 *
 * @author Satellite
 */
public class ChatWindowController {
 
    public static String message;
   private static File fileImagen;
    

public static boolean searchWindow (String friendnick)
{ 
  boolean found =false;
  

 
  if (JChat.getChat() == null)
  {
      return found;
  }
  else
  {
 int pos = JChat.getChat().size();
 int i = 0;
  while(i < pos )
  {
            if (JChat.getChat().get(i).getjLFriendNickname().getText().compareTo(friendnick)==0)
      {
          return found = true;
      }
   
      i++;
  }
  }
  return found;
}
public static boolean SendMessage(JTextArea mensaje,String friendNick, String mynick,boolean save)
{
   boolean conf ;
    byte[] resultado;
     
       String proto = "3:"+friendNick+":"+mynick+":"+mensaje.getText();
       
       if (save=true)
       {
           PreferencesXmlFile.saveChatToFile(mynick, mensaje.getText());
       }
        
       StandardObject generalObject = new StandardObject (proto,null);
     
       SocketClient usersocket = new SocketClient();
     
       resultado = usersocket.executeRequest(generalObject, Main.SERVIDOR, Main.NUMERO_PUERTO_ENVIO);
     String result = UtilFunctions.byteArrayToString(resultado);
       
    if (result.compareTo("TRUE")!=0){
         
        return conf = false;
       }
   return conf =true;
}
    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        ChatWindowController.message = message;
    }
public static void SendImage (JFileChooser JFCExam, ChatWindow1  esta,String friendnick,String usernick){
        
         int returnVal = JFCExam.showOpenDialog(esta);
         if (returnVal == JFCExam.APPROVE_OPTION) 
                 {
         fileImagen = JFCExam.getSelectedFile();
         byte[] resultado;  
         byte[] image;  
         String proto = "4:"+friendnick+":"+usernick;
         System.out.println(fileImagen.toString());
       image =UtilFunctions.imageToByteArray(fileImagen.toString())  ;
       StandardObject generalObject = new StandardObject (proto,image);
       SocketClient usersocket = new SocketClient();
       resultado = usersocket.executeRequest(generalObject, Main.SERVIDOR, Main.NUMERO_PUERTO_ENVIO);
             ChatWindow1 chat=null;
             chat = new ChatWindow1();
            
                    chat.setVisible(true);
                    esta.setWindowFather(chat);
                    esta.dispose();
                 }
        
        
        
    }
public static boolean SendMessageBroadcast(JTextArea mensaje, String mynick,boolean save)
{
   boolean conf ;
    byte[] resultado;
     
       String proto = "3:"+mynick+":"+mensaje.getText()+":2";
       
       if (save=true)
       {
           PreferencesXmlFile.saveChatToFile(mynick, mensaje.getText());
       }
        
       StandardObject generalObject = new StandardObject (proto,null);
     
       SocketClient usersocket = new SocketClient();
     
       resultado = usersocket.executeRequest(generalObject, Main.SERVIDOR, Main.NUMERO_PUERTO_ENVIO);
     String result = UtilFunctions.byteArrayToString(resultado);
       
    if (result.compareTo("TRUE")!=0){
         
        return conf = false;
       }
   return conf =true;
}

}
