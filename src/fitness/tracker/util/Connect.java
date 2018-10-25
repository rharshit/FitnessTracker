package fitness.tracker.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rhars
 */
public class Connect {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123qwe";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/fitness";
    
    public static Connection con = null;
    
    static Connection connectDB(){
        con = null;
        try{
            con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected to "+CONN_STRING+" @ "+USERNAME);
        }catch(SQLException e){
            System.err.println(e);
            return null;
        }
        return con;
    }
}
