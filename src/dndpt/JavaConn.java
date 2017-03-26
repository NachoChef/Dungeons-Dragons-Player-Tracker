/*
 * This is the initial database connection.
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