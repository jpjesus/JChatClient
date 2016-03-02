/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Contacts.java
 *
 * Created on 06/08/2011, 03:07:25 PM
 */
package presentation;

import controller.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author ErickMan
 */
public class Contacts extends javax.swing.JFrame {

    /** Creates new form Contacts */
    public Contacts() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
      public void setWindowFather(JFrame windowFather)
    {
        this.windowFather = windowFather;
    }
    
    
       public void setWindowFather(JFrame windowFather, boolean blockWindowFather)
    {
        this.windowFather = windowFather;
        
        if (blockWindowFather)
            this.windowFather.setEnabled(false);
        
        this.setAlwaysOnTop(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPContacts = new javax.swing.JPanel();
        JPTitleContacts = new javax.swing.JPanel();
        JLBContacts = new javax.swing.JLabel();
        JLBChooseContacts = new javax.swing.JLabel();
        JBNickname = new javax.swing.JLabel();
        JTFNickname = new javax.swing.JTextField();
        JCBOptionContacts = new javax.swing.JComboBox();
        JBContacts = new javax.swing.JButton();
        JBCancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPContacts.setBackground(new java.awt.Color(255, 255, 255));
        JPContacts.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 0, 0)));

        JPTitleContacts.setBackground(new java.awt.Color(204, 204, 204));
        JPTitleContacts.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 0, 0)));

        JLBContacts.setFont(new java.awt.Font("Tahoma", 1, 14));
        JLBContacts.setForeground(new java.awt.Color(153, 0, 0));
        JLBContacts.setText("Contacts");

        javax.swing.GroupLayout JPTitleContactsLayout = new javax.swing.GroupLayout(JPTitleContacts);
        JPTitleContacts.setLayout(JPTitleContactsLayout);
        JPTitleContactsLayout.setHorizontalGroup(
            JPTitleContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTitleContactsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLBContacts)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPTitleContactsLayout.setVerticalGroup(
            JPTitleContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLBContacts)
        );

        JLBChooseContacts.setFont(new java.awt.Font("Tahoma", 0, 14));
        JLBChooseContacts.setForeground(new java.awt.Color(153, 0, 0));
        JLBChooseContacts.setText("Choose an option :");

        JBNickname.setFont(new java.awt.Font("Tahoma", 0, 14));
        JBNickname.setForeground(new java.awt.Color(153, 0, 0));
        JBNickname.setText("Nickname :");

        JTFNickname.setBackground(new java.awt.Color(230, 230, 230));
        JTFNickname.setFont(new java.awt.Font("Tahoma", 2, 11));

        JCBOptionContacts.setForeground(new java.awt.Color(153, 0, 0));
        JCBOptionContacts.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Add", "Remove", "Move" }));
        JCBOptionContacts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBOptionContactsActionPerformed(evt);
            }
        });

        JBContacts.setFont(new java.awt.Font("Tahoma", 1, 12));
        JBContacts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Camisa.png"))); // NOI18N
        JBContacts.setText("OK");
        JBContacts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBContactsActionPerformed(evt);
            }
        });

        JBCancelButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        JBCancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Camisa.png"))); // NOI18N
        JBCancelButton.setText("Cancel");
        JBCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPContactsLayout = new javax.swing.GroupLayout(JPContacts);
        JPContacts.setLayout(JPContactsLayout);
        JPContactsLayout.setHorizontalGroup(
            JPContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContactsLayout.createSequentialGroup()
                .addGroup(JPContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPContactsLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(JPContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPContactsLayout.createSequentialGroup()
                                .addComponent(JLBChooseContacts)
                                .addGap(18, 18, 18)
                                .addComponent(JCBOptionContacts, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPContactsLayout.createSequentialGroup()
                                .addGroup(JPContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JBContacts, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JBNickname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(JPContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(JPContactsLayout.createSequentialGroup()
                                        .addComponent(JTFNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addComponent(JBCancelButton)))))
                    .addGroup(JPContactsLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(JPTitleContacts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87))
        );
        JPContactsLayout.setVerticalGroup(
            JPContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContactsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPTitleContacts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(JPContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBChooseContacts)
                    .addComponent(JCBOptionContacts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBNickname)
                    .addComponent(JTFNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(JPContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBContacts)
                    .addComponent(JBCancelButton))
                .addContainerGap())
        );

        getContentPane().add(JPContacts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBContactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBContactsActionPerformed
        // TODO add your handling code here:
       if(FriendController.addFriend(LogController.getNickname(), JCBOptionContacts,JTFNickname.getText()))
         {  
           
        this.windowFather.setEnabled(true);
        this.dispose();
            try {
             JChatController.refresh();
            } catch (ParseException ex) {
                Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, ex);
            }
              
         }
       else
       {
           ErrorNickname2 SIWindow = new ErrorNickname2();
          SIWindow.setWindowFather(this, true);
          SIWindow.setVisible(true);
          this.setEnabled(false);
       }
        
    }//GEN-LAST:event_JBContactsActionPerformed

    private void JCBOptionContactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBOptionContactsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBOptionContactsActionPerformed

    private void JBCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelButtonActionPerformed
        // TODO add your handling code here:
         this.windowFather.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_JBCancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Contacts().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelButton;
    private javax.swing.JButton JBContacts;
    private javax.swing.JLabel JBNickname;
    private javax.swing.JComboBox JCBOptionContacts;
    private javax.swing.JLabel JLBChooseContacts;
    private javax.swing.JLabel JLBContacts;
    private javax.swing.JPanel JPContacts;
    private javax.swing.JPanel JPTitleContacts;
    private javax.swing.JTextField JTFNickname;
    // End of variables declaration//GEN-END:variables
private JFrame windowFather;
}
