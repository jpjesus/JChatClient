/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * About.java
 *
 * Created on Aug 8, 2011, 11:34:43 AM
 */
package presentation;

import javax.swing.JFrame;

/**
 *

 */
public class About extends javax.swing.JFrame {

    /** Creates new form About */
    public About() {
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

        JBokchat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About JChat");
        setBackground(new java.awt.Color(204, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JBokchat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Vinotinto P 1.jpg"))); // NOI18N
        JBokchat.setBorderPainted(false);
        JBokchat.setContentAreaFilled(false);
        JBokchat.setFocusPainted(false);
        JBokchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBokchatActionPerformed(evt);
            }
        });
        getContentPane().add(JBokchat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 190));

        jLabel1.setFont(new java.awt.Font("Square721 BT", 1, 18));
        jLabel1.setText(" Jchat");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 140, -1));

        jLabel2.setText("Version : 0.0.0");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 240, -1));

        jLabel3.setText("By : Jesus Parada & Erick Medina");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/pelota.png"))); // NOI18N
        jButton1.setText(" Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 90, -1));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-486)/2, (screenSize.height-218)/2, 486, 218);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

                // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void JBokchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBokchatActionPerformed
 
        
    }//GEN-LAST:event_JBokchatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          this.windowFather.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new About().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBokchat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

 private JFrame windowFather;


}
