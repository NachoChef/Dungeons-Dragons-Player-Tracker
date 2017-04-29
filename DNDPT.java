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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //initialize the login window
        new Login().setVisible(true);
    }
    
}
