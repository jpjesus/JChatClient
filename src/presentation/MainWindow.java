
package presentation;
import controller.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ErickMan
 */
public class MainWindow extends javax.swing.JFrame {

    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        JLBTitle = new javax.swing.JLabel();
        JLBSpecialEdition = new javax.swing.JLabel();
        JLBImageMain = new javax.swing.JLabel();
        JLBNickName = new javax.swing.JLabel();
        JLBPassword = new javax.swing.JLabel();
        JTFNickName = new javax.swing.JTextField();
        JPFPassword = new javax.swing.JPasswordField();
        JBSignIn = new javax.swing.JButton();
        JLBRegister = new javax.swing.JLabel();
        JBRegister = new javax.swing.JButton();
        JLBGrey = new javax.swing.JLabel();
        JLBBurgundy = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMPreferences = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jButton1.setText("Preferences");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLBTitle.setBackground(new java.awt.Color(204, 204, 204));
        JLBTitle.setFont(new java.awt.Font("Tahoma", 1, 28));
        JLBTitle.setForeground(new java.awt.Color(204, 204, 204));
        JLBTitle.setText("JChat");
        getContentPane().add(JLBTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        JLBSpecialEdition.setFont(new java.awt.Font("Harlow Solid Italic", 0, 12));
        JLBSpecialEdition.setForeground(new java.awt.Color(204, 204, 204));
        JLBSpecialEdition.setText("Special Edition");
        getContentPane().add(JLBSpecialEdition, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        JLBImageMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Vinotinto P 1.jpg"))); // NOI18N
        getContentPane().add(JLBImageMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        JLBNickName.setBackground(new java.awt.Color(255, 255, 255));
        JLBNickName.setFont(new java.awt.Font("Tahoma", 1, 16));
        JLBNickName.setForeground(new java.awt.Color(153, 0, 0));
        JLBNickName.setText("Nickname :");
        getContentPane().add(JLBNickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        JLBPassword.setFont(new java.awt.Font("Tahoma", 1, 16));
        JLBPassword.setForeground(new java.awt.Color(153, 0, 0));
        JLBPassword.setText("Password :");
        getContentPane().add(JLBPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        JTFNickName.setFont(new java.awt.Font("Tahoma", 2, 12));
        JTFNickName.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(JTFNickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 280, 180, -1));

        JPFPassword.setFont(new java.awt.Font("Tahoma", 2, 11));
        JPFPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPFPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(JPFPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 180, -1));

        JBSignIn.setFont(new java.awt.Font("Tahoma", 1, 14));
        JBSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Balonn.png"))); // NOI18N
        JBSignIn.setText("Sign In");
        JBSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSignInActionPerformed(evt);
            }
        });
        getContentPane().add(JBSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));

        JLBRegister.setFont(new java.awt.Font("Tahoma", 0, 14));
        JLBRegister.setForeground(new java.awt.Color(204, 204, 204));
        JLBRegister.setText("Is your first Jchat? then...");
        getContentPane().add(JLBRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        JBRegister.setFont(new java.awt.Font("Tahoma", 1, 12));
        JBRegister.setText("Register Now");
        JBRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(JBRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, -1, -1));

        JLBGrey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/grisfondo.png"))); // NOI18N
        getContentPane().add(JLBGrey, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 270, 380));

        JLBBurgundy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/ole.png"))); // NOI18N
        getContentPane().add(JLBBurgundy, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 540));

        jMenu1.setText("File");

        jMPreferences.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/pelota.png"))); // NOI18N
        jMPreferences.setText("Preferences");
        jMPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPreferencesActionPerformed(evt);
            }
        });
        jMenu1.add(jMPreferences);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/X.png"))); // NOI18N
        jMenuItem2.setText("Exit");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSignInActionPerformed
       LogController.LogInSystem(this, this.JTFNickName, this.JPFPassword);
      
    }//GEN-LAST:event_JBSignInActionPerformed

    private void JBRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRegisterActionPerformed
        // TODO add your handling code here:
          UserRegistrationWindow SIWindow = new UserRegistrationWindow();
          this.dispose();
    }//GEN-LAST:event_JBRegisterActionPerformed

    private void JPFPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPFPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPFPasswordActionPerformed

    private void jMPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMPreferencesActionPerformed
        // TODO add your handling code here:
        Preferences SIWindow = new Preferences();
        SIWindow.setWindowFather(this, true);
        SIWindow.setVisible(true);
        
    }//GEN-LAST:event_jMPreferencesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBRegister;
    private javax.swing.JButton JBSignIn;
    private javax.swing.JLabel JLBBurgundy;
    private javax.swing.JLabel JLBGrey;
    private javax.swing.JLabel JLBImageMain;
    private javax.swing.JLabel JLBNickName;
    private javax.swing.JLabel JLBPassword;
    private javax.swing.JLabel JLBRegister;
    private javax.swing.JLabel JLBSpecialEdition;
    private javax.swing.JLabel JLBTitle;
    private javax.swing.JPasswordField JPFPassword;
    private javax.swing.JTextField JTFNickName;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMPreferences;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}