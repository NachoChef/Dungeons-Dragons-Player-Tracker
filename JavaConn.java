/*
 * This is the initial database connection.
 */
package dndpt;

/**
 *
 * @author Justin jones
 */
import java.sql.*;
import javax.swing.*;
public class JavaConn {
    Connection conn= null;
    public static Connection ConnectDb(String server, String cnctn){
        try{
            Class.forName(server);
            Connection conn = DriverManager.getConnection(cnctn);
            conn.setAutoCommit(true);
            return conn;
        }catch (Exception e){
           JOptionPane.showMessageDialog(null, e);
        return null;
        }
    }
}