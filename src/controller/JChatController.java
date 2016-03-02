/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.StandardObject;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.text.ParseException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import jsockets.client.SocketClient;
import jsockets.util.UtilFunctions;
import logic.LogicBlockList;
import logic.LogicUser;
import logic.LogicUserList;
import presentation.Main;
import domain.Utildomain;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.tree.TreePath;
import presentation.ChooseAvatar;
import presentation.Contacts;
import presentation.JChat;
import presentation.MainWindow;

/**
 *
 * @author Jesus Parda @ Erick Medina
 */
public class JChatController {
    
  private static boolean status;
    
   /**
 * Load all the blocks given by the server in screen
 * @param JTree tree
 * @param JPanel panel
 */
    
   public static JTree loadtree (JTree blocks, JPanel JPpanel) throws ParseException {
        
        
        
     
        
        LogicBlockList grouplist = new  LogicBlockList() ;
     
        grouplist.setBlockList(LogController.getUser().getUser().getBlockList());
        if (grouplist.getBlockList() != null)
        {
        int i = 0;
       
        int t = grouplist.size();
        int j = 0;
       /// DefaultTreeModel def = (DefaultTreeModel)groups.getModel();
        DefaultMutableTreeNode block = new DefaultMutableTreeNode("Blocks");
        
        
       
        while(i < t){
            String name =grouplist.getBlockList().get(i).getBlockName();
            DefaultMutableTreeNode father = new DefaultMutableTreeNode(name);
            
            block.add(father);
            DefaultMutableTreeNode conectados = new DefaultMutableTreeNode("Conectados");
                 DefaultMutableTreeNode noconectados = new DefaultMutableTreeNode("No Conectados");
                     father.add(noconectados);
                     father.add(conectados);
           while(j < grouplist.getBlockList().get(i).getUserList().size())
             {
                
                 if(grouplist.getBlockList().get(i).getUserList().get(j).isOnline())
                 {
                
                     String nick= grouplist.getBlockList().get(i).getUserList().get(j).getNickname();
                     DefaultMutableTreeNode sons = new DefaultMutableTreeNode(nick);
                     conectados.add(sons);
                    
                 }
                 else
                 {
                 
                     String nick= grouplist.getBlockList().get(i).getUserList().get(j).getNickname();
                     DefaultMutableTreeNode sons = new DefaultMutableTreeNode(nick);
                    noconectados.add(sons);
                     
                 }
                     
                     
                   j ++;
                 
             }
            
            
            i++;
        }
       
        blocks = new JTree(block);
         
     
         Dimension dimension = new Dimension(586, 368);
        blocks.setMinimumSize(dimension);
        blocks.setMaximumSize(dimension);
        blocks.setSize(586, 368);
       JPpanel.setLayout(new BoxLayout(JPpanel, BoxLayout.PAGE_AXIS));
        
        
        JPpanel.setMinimumSize(dimension);
        JPpanel.setMaximumSize(dimension);
        
        JPpanel.setSize(586, 368);
        JPpanel.add(blocks, BorderLayout.CENTER);
          DefaultTreeCellRenderer render= (DefaultTreeCellRenderer)blocks.getCellRenderer();
        render.setOpenIcon(new ImageIcon("src/window.png"));
        render.setClosedIcon(new ImageIcon("src/comments.png"));
        render.setLeafIcon(new ImageIcon("src/pelota.png"));
     
     
   
                }
        return blocks;
   }
  /**
 * Close your session 
 * @param String mynick
 * @return boolean
 */
public static boolean isStatus() {
        return status;
    }
public static boolean LogOutFromSystem(){
        
        boolean found;  
        byte[] result;
    
     
        String proto = "5:"+LogController.getUser().getUser().getNickname();
     
        StandardObject generalObject = new StandardObject (proto,null);
        
        SocketClient usersocket = new SocketClient();
        
        result = usersocket.executeRequest(generalObject, Main.SERVIDOR, Main.NUMERO_PUERTO_ENVIO);
        
        String res = UtilFunctions.byteArrayToString(result);
        
        if (res.compareTo("TRUE")==0){
            found = true;
        }
        else {
            found = false;
        }
        
        return found;
    }
public static void ContactsControl (JFrame window){
        
      window.setEnabled(false);
       Contacts add = new Contacts();
      add.setWindowFather(window);
      add.setVisible(true);
    }
public static void refresh() throws ParseException{
        
        LogController.getChat().dispose();
        JChat chat=null;
        chat = new JChat();
        chat.setVisible(true);
        LogController.setChat(chat);
    }
public static void JChatConstructor(JFrame window, JLabel JLBavatar, JButton JBContacts, JButton JBblocks,  JLabel JLBnickname, boolean status) throws ParseException{
        
        window.setLocationRelativeTo(null);
        LogController.getUserFriends(Utildomain.USER_NICKNAME);
        JLBnickname.setText(LogController.getUser().getUser().getNickname());
        
        ImageIcon avatar = LogController.getAvatar(Utildomain.USER_NICKNAME);
        
        Image img = avatar.getImage();
        Image newimg = img.getScaledInstance(100, 100,java.awt.Image.SCALE_SMOOTH); 
        ImageIcon newIcon = new ImageIcon(newimg); 
        JLBavatar.setIcon(newIcon);
        
      
        
    }
public static void logOutcontrol (JFrame window){
        
        boolean logout = JChatController.LogOutFromSystem();
       
       if (logout==true){
           MainWindow login = new MainWindow();
           login.setVisible(true);
           window.dispose();
       }
       else {
           System.out.println ("error login out");
       }
    }
 public static void changeAvatar (JFrame esta,JLabel avatar){
      esta.setEnabled(false);
      ChooseAvatar ca = new ChooseAvatar (avatar);
      ca.setWindowFather(esta);
      ca.setVisible(true);
    }

    public static void setStatus(boolean status) {
        JChatController.status = status;
    }
    
}
