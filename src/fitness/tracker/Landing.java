/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness.tracker;

import fitness.tracker.pages.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author student
 */
public class Landing {

    /**
     * @param args the command line arguments
     */
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123qwe";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/test";
    
    public static Connection con = null;
    
    static void connectDB(){
        con = null;
        try{
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected to "+CONN_STRING+" @ "+USERNAME);
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Landing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Landing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Landing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Landing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        connectDB();
        new Login().show();
    }
}
