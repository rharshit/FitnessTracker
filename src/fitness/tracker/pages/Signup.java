/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness.tracker.pages;

import fitness.tracker.pages.Details;
import fitness.tracker.util.Connect;
import fitness.tracker.util.User;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author student
 */
public class Signup extends javax.swing.JFrame {

    /**
     * Creates new form Signup
     */
    static String uname;
    public Signup(String name) {
        uname = name;
        initComponents();
        tfSignupUname.setText(uname);
        addActionListeners();
    }

    private void addActionListeners() {
        tfSignupUname.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkUname();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkUname();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkUname();
            }
        });
        
        tfSignupPsw.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkPsw();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkPsw();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkPsw();
            }
        });
                
        tfSignupPsw2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkPsw();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkPsw();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkPsw();
            }
        });
    }
    
    private boolean checkUname(){
        tfSignupUname.setForeground(Color.black);
        String uname = tfSignupUname.getText();
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "SELECT * FROM user where user.username='"+uname+"'";
            System.out.println("Query: "+query);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                tfSignupUname.setForeground(Color.red);
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private void checkPsw(){
        tfSignupPsw.setForeground(Color.black);
        tfSignupPsw2.setForeground(Color.black);
        String psw = tfSignupPsw.getText();
        String psw2 = tfSignupPsw2.getText();
        if(psw.length()<3){
            tfSignupPsw.setForeground(Color.red);
            tfSignupPsw2.setForeground(Color.red);
        } else {
            if(!psw.equals(psw2)){
                tfSignupPsw2.setForeground(Color.red);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfSignupUname = new javax.swing.JTextField();
        tfSignupPsw = new javax.swing.JPasswordField();
        bSignup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfSignupPsw2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        tfSignupUname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSignupUnameActionPerformed(evt);
            }
        });

        tfSignupPsw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSignupPswActionPerformed(evt);
            }
        });

        bSignup.setText("Sign Up");
        bSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSignupActionPerformed(evt);
            }
        });

        jLabel4.setText("Re-type password:");

        tfSignupPsw2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSignupPsw2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfSignupUname)
                    .addComponent(tfSignupPsw, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(tfSignupPsw2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 172, Short.MAX_VALUE)
                .addComponent(bSignup)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfSignupUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfSignupPsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfSignupPsw2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(bSignup)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfSignupUnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSignupUnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSignupUnameActionPerformed

    private void tfSignupPswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSignupPswActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSignupPswActionPerformed

    private void bSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSignupActionPerformed
        // TODO add your handling code here:
        if(checkUname()){
            if(tfSignupUname.getText().equals("")){
                JOptionPane.showMessageDialog(null, "The username cannot be null");
            } else {
                if(tfSignupPsw.getText().length()<3){
                    JOptionPane.showMessageDialog(null, "The passwords must be at least 3 charecters long");
                }else {

                    if(tfSignupPsw.getText().equals(tfSignupPsw2.getText())){
                        new Details(tfSignupUname.getText(), tfSignupPsw.getText()).show();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "The passwords entered do not match");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username already taken");
        }
    }//GEN-LAST:event_bSignupActionPerformed

    private void tfSignupPsw2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSignupPsw2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSignupPsw2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup(uname).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField tfSignupPsw;
    private javax.swing.JPasswordField tfSignupPsw2;
    private javax.swing.JTextField tfSignupUname;
    // End of variables declaration//GEN-END:variables
}
