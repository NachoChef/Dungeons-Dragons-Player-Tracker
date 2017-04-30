/*
 * This is the initial database connection.
 */
package dndpt;

/**
 *
 * @author Justin jones
 */
import java.security.MessageDigest;
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


public static String SHA(String sha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] array = md.digest(sha.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
    return null;
    }
}