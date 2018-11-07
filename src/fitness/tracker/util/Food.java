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
public class Food {
    
    public static String getUnit(String f_name){
        //SELECT * FROM fitness.food WHERE food.f_name='Almonds';
        String rtn = "";
        String f_cal = "", f_unit = "";
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "SELECT * FROM fitness.food WHERE food.f_name='"+f_name+"'";
            System.out.println("Query: "+query);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                f_cal = rs.getString("f_calories");
                f_unit = rs.getString("f_unit");
                rtn+=f_cal+" Cal/"+f_unit;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return rtn;
    }

    public static String mostConsumed(){
        String s = "";
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "SELECT f_name "
                    + "FROM fitness.total_consumed "
                    + "WHERE qty = (SELECT max(qty) FROM fitness.total_consumed);";
            System.out.println("Query: "+query);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                s = rs.getString("f_name");
            } else {
                s = "Fetching";
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return s;
    }
}
