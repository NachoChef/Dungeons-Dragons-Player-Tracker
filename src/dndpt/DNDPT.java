/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndpt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Justin
 */

public class DNDPT {
    public static Connection conn;
    public static void setConnection(String username, String password){
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:dnd35.db");
            JOptionPane.showMessageDialog(null, "Success!");
            //JOptionPane.setVisible(MainWindow);
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
        // TODO code application logic here
        new Login().setVisible(true);        
            /*
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
    }
    
}
