/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.StandardObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTextField;
import jsockets.client.SocketClient;
import jsockets.util.UtilFunctions;
import logic.LogicUser;
import presentation.ErrorNickname;
import presentation.IncompleteField;
import presentation.Main;
import presentation.ThanksForRegister;
import util.Util;


/**
 *
 * @author Jesus Parada & Erick Medina
 */
public class RegistrationController {
   /**
 * Check you dont miss any of the fields in the registration
 * @param String nick
 * @param String name
 * @param String lastname
 * @param String secondlastname
 * @param String email
 * @param Date birthdate
 * @param String password
 * @return boolean
 */
   
    public static boolean register (String name, String lastname, String secondlastname, String nickname, String password,Date birthdate,String mail){
       
        boolean conf;  
        byte[] resultado;
    
     
       String proto = "1:";
       
       LogicUser user= new LogicUser (name, lastname, secondlastname,birthdate,nickname,mail,password);
        
       StandardObject generalObject = new StandardObject (proto,user.getUser());
     
       SocketClient usersocket = new SocketClient();
     
       resultado = usersocket.executeRequest(generalObject, Main.SERVIDOR, Main.NUMERO_PUERTO_ENVIO);
     
       String result = UtilFunctions.byteArrayToString(resultado);
       
       if (result.compareTo("TRUE")==0){
         
         conf = true;
       }
        else {
         
         conf = false;
         
         
     }
     
     return conf;
    }
    
    /**
 * Register a User in the system , send the request to the server
 * @param String nick
 * @param String name
 * @param String lastname
 * @param String secondlastname
 * @param String email
 * @param Date birthdate
 * @param String password
 * @return boolean
 */
   
 public static void RegisterInSystem (JFrame window,String nickname, String name, String lastname, String secondlastname, String email ,Date birthdate,String password){
       
     if (name.compareTo("")                !=0 && 
            lastname.compareTo("")            !=0 &&
            secondlastname.compareTo("")      !=0 && 
            nickname.compareTo("")            !=0 &&
            password.compareTo("")            !=0 &&
            birthdate                            !=null &&
            email.compareTo("")                !=0)
        {
         boolean aux= RegistrationController.register(name, lastname, secondlastname, nickname, password,birthdate,email); 
         if (aux == true){
                window.dispose();
                ThanksForRegister reg = new ThanksForRegister();
                reg.setVisible(true);
            
            }
         else
         {
              window.setEnabled(false);
                ErrorNickname reg = new ErrorNickname();
                reg.setWindowFather(window);
                reg.setVisible(true);
         }
        }
        else
     {
         window.setEnabled(false);
            IncompleteField fm = new  IncompleteField();
            fm.setWindowFather(window);
            fm.setVisible(true);
     }
        
    }
    
}
