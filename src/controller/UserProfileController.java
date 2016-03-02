/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import logic.LogicUser;


/**
 *
 * @author PC
 */
public class UserProfileController {
    
    
    
    public static void printprofile (JTextField nickname, JTextField name, JTextField birthdate, JTextField mail, JLabel avatar, String nickuser){
        
        LogicUser user = LogController.getUser();
        nickname.setText(user.getUser().getNickname());
        String fullname = user.getUser().getName() + " " + user.getUser().getLastname() + " " + user.getUser().getSecondlastname();
        name.setText(fullname);
        DateFormat df = new SimpleDateFormat ("dd/MM/yy");
        birthdate.setText(df.format(user.getUser().getBirthdate()));
        mail.setText(user.getUser().getMail());
        ImageIcon image = new ImageIcon (user.getUser().getAvatar());
        avatar.setIcon(image);
        
        
    }
    
}
