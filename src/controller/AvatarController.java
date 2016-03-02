/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import presentation.ChooseAvatar;
import presentation.JChat;

/**
 *
 * @author PC
 */
public class AvatarController {
     private static File fileImagen;
    
      public static ImageIcon getAvatar(String nick){
        
        ImageIcon image = new ImageIcon (LogController.getUser().getUser().getAvatar());
        
        return image;
    } 
    
    public static void setAvatar(String rut){
        
        LogController.setAvatar(rut);
          
    }
     public static void changeavatar (String ruta, ChooseAvatar esta) throws ParseException{
        AvatarController.setAvatar(ruta);
        esta.windowFather.dispose();
        JChat chat= new JChat();
        chat.setVisible(true);
        esta.setWindowFather(chat);
        esta.dispose();        
}
    public static void browsed (JFileChooser JFCExam, ChooseAvatar  esta){
        
         int returnVal = JFCExam.showOpenDialog(esta);
		 if (returnVal == JFCExam.APPROVE_OPTION) 
                 {
                    fileImagen = JFCExam.getSelectedFile();
                    ImageIcon avatar2 = new ImageIcon (fileImagen.toString());
                     AvatarController.setAvatar(fileImagen.toString());
                    esta.windowFather.dispose();
                    JChat chat=null;
            try {
                chat = new JChat();
            } catch (ParseException ex) {
                Logger.getLogger(ChooseAvatar.class.getName()).log(Level.SEVERE, null, ex);
            }
                    chat.setVisible(true);
                    esta.setWindowFather(chat);
                    esta.dispose();
                 }
        
        
        
    }
}
