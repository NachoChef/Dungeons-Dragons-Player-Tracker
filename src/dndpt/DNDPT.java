/*
 * Main class that initiates the program
 * 
 */
package dndpt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Justin Jones
 */

public class DNDPT {
    public static Connection conn;
    public static void setConnection(String username, String password){
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:dnd35.db");
            JOptionPane.showMessageDialog(null, "Success!");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ef) {
                JOptionPane.showMessageDialog(null, ef.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //initialize the login window
        new Login().setVisible(true);
    }
    
}
