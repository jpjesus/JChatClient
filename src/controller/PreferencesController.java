/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import domain.PreferencesXmlFile;
import java.text.ParseException;
import logic.LogicUser;
import domain.User;
import javax.swing.JTextField;
import presentation.Main;
import domain.Utildomain;
import java.util.prefs.Preferences;
/**
 *
 * @author Satellite
 */
public class PreferencesController {
   
           
    public static void saveChanges ( JTextField serverport, JTextField serverip, JTextField clientport)
    {
        
       /* int port = Integer.parseInt(serverport.getText());
        Main.NUMERO_PUERTO_ENVIO = port;
        Main.SERVIDOR = serverip.getText();
        port = Integer.parseInt(clientport.getText());
        Main.NUMERO_PUERTO_ESCUCHA = port;*/
        PreferencesXmlFile.updatePreferencesInFile(Utildomain.USER_NICKNAME,serverip.getText(), serverport.getText() , clientport.getText());
   
    }
    }
    

