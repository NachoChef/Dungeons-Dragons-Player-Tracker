/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndpt;
import javax.swing.*;
import java.sql.*;
import java.security.MessageDigest;
//import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author Justin Jones
 */
public class Login extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        conn = JavaConn.ConnectDb("org.sqlite.JDBC", "jdbc:sqlite:dnd35.db");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_pword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmd_login = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        remoteButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(90, 90, 90));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        txt_pword.setText("toor");
        txt_pword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pwordActionPerformed(evt);
            }
        });

        jLabel1.setText("Username: ");

        txt_username.setText("root");

        jLabel2.setText("Password:");

        cmd_login.setText("Login");
        cmd_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_loginActionPerformed(evt);
            }
        });

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        remoteButton.setText("Remote");
        remoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remoteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_pword)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmd_login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(remoteButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_pword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd_login)
                    .addComponent(jButton1)
                    .addComponent(remoteButton)))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/dndlogo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pwordActionPerformed

    private void cmd_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_loginActionPerformed
        
        String sql ="select * from player where username=? and password=?";
        try{
            //prepares a statement looking for matching values in player
            pst = conn.prepareStatement(sql);
            //String pword = sha1Hex(txt_pword.getText());
            pst.setString(1, txt_username.getText());
            pst.setString(2, JavaConn.SHA(txt_pword.getText()));
            rs = pst.executeQuery();
            if(rs.next()){
                //if entry exists, we need pid and permissions to give to mainWindow
                //to set permissions
                sql = "select * from player where username =?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, txt_username.getText());
                rs = pst.executeQuery();
                int pid = rs.getInt("pid");
                boolean admin = (rs.getInt("isAdmin") == 1);
                this.setVisible(false);
                new MainWindow(txt_username.getText(), pid, admin, conn);
                JOptionPane.showMessageDialog(null, "Login Successful!");
                rs.close();
                pst.close();
            } else {
                JOptionPane.showMessageDialog(null, "Unable to login.");
            }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, e);
        } 
        finally {
            try{
                rs.close();
                pst.close();
            } catch(Exception e) {}
        }
            
    }//GEN-LAST:event_cmd_loginActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void remoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remoteButtonActionPerformed
        this.setVisible(false);
        new Remote().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_remoteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_login;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton remoteButton;
    private javax.swing.JPasswordField txt_pword;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
