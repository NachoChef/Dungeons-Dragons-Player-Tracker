/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndpt;

/**
 *
 * @author Justin
 */
import java.sql.*;
import javax.swing.*;
public class JavaConn {
    Connection conn= null;
    public static Connection ConnectDb(){
 
    try{
    Class.forName("org.sqlite.JDBC");
    Connection conn = DriverManager.getConnection("jdbc:sqlite:dnd35.db");
    return conn;
       }catch (Exception e){
           JOptionPane.showMessageDialog(null, e);
       return null;
     
       }
 
    }
}