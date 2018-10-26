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
public class Exercise {
    public static String getUnit(String e_name){
        //SELECT * FROM fitness.food WHERE food.f_name='Almonds';
        String rtn = "";
        String e_cal = "", e_unit = "";
                try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "SELECT * FROM fitness.exercise WHERE exercise.e_name='"+e_name+"'";
            System.out.println("Query: "+query);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                e_cal = rs.getString("e_calories");
                e_unit = rs.getString("e_unit");
                rtn+=e_cal+" Cal/"+e_unit;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return rtn;
    }
}
