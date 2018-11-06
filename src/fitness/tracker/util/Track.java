/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness.tracker.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rhars
 */
public class Track {
    public static ResultSet trackCalCons(User user){
        //call trackCalCons('rharshit', '2018-11-06');
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "call trackCalCons('"+user.uname+"', '"+java.time.LocalDate.now().toString()+"');";
            System.out.println("Query: "+query);
            return stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet trackCalBurnt(User user){
        //call trackCalCons('rharshit', '2018-11-06');
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "call trackCalBurnt('"+user.uname+"', '"+java.time.LocalDate.now().toString()+"');";
            System.out.println("Query: "+query);
            return stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
