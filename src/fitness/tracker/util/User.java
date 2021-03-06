/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness.tracker.util;

import fitness.tracker.util.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class User {
    public String uname, psw, name, email, dob, height, weight;
    public User(String uname, String psw, String name, String email, String dob, String height, String weight){
        this.uname = uname;
        this.psw = psw;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
    }
    
    public void printDetails(){
        System.out.println("Username:\t"+uname);
        System.out.println("Password:\t"+psw);
        System.out.println("Name:\t"+name);
        System.out.println("Email:\t"+email);
        System.out.println("Date of Birth:\t"+dob);
        System.out.println("Height:\t"+height);
        System.out.println("Weight:\t"+weight);
    }
    
    static public User insertUser(String uname, String psw, String name, String email, String dob, String height, String weight){
        //INSERT INTO `fitness`.`user` (`username`, `password`, `name`, `email`, `dob`, `height`, `weight`) VALUES ('test2', 'test1234', 'Test2 User', 'test2@user.com', '1990-04-13', '172', '69');
        User user = new User(uname, psw, name, email, dob, height, weight);
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String insert = "INSERT INTO `fitness`.`user` (`username`, `password`, `name`, `email`, `dob`, `height`, `weight`) VALUES ('"
                    +uname+"', '"+psw+"', '"+name+"', '"+email+"', DATE '"+dob
                    +"', '"+height+"', '"+weight+"')";
            System.out.println(insert);
            stmt.execute(insert);
            updateHeight(user, height);
            updateWeight(user, weight);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return user;
    }
    
    public static User fetchUser(String uname, String psw){
        String name=null, email=null, dob=null, height=null, weight=null;
        int r=0;
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "SELECT * FROM user where user.username='"+uname+"' and user.password='"+psw+"'";
            System.out.println("Query: "+query);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                name = rs.getString("name");
                email = rs.getString("email");
                dob = rs.getString("dob");
                height = Integer.toString(rs.getInt("height"));
                weight = Integer.toString(rs.getInt("weight"));
                r++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        if(r==1){
            return new User(uname, psw, name, email, dob, height, weight);
        } else {
            System.out.println("User: Number of rows selected "+r);
            return null;
        }
    }
    
    public static boolean checkOldPassword(String uname, String new_psw){
        String psw;
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "SELECT * FROM password where password.username='"+uname+"'";
            System.out.println("Query: "+query);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                psw = rs.getString("password");
                System.out.println(psw+" "+new_psw);
                if(new_psw.equals(psw)){
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public static User updatePassword(User user, String new_psw) {
        //INSERT INTO `fitness`.`password` (`username`, `password`) VALUES ('user123', 'psw123');
        //UPDATE `fitness`.`user` SET `password` = '123' WHERE (`username` = 'rharshit');
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String insert = "INSERT INTO `fitness`.`password` (`username`, `password`) VALUES ('"+user.uname+"', '"+user.psw+"');";
            System.out.println(insert);
            stmt.execute(insert);
            Statement stmte = (Statement) con.createStatement();
            String update = "UPDATE `fitness`.`user` SET `password` = '"+new_psw+"' WHERE (`username` = '"+user.uname+"');";
            System.out.println(update);
            stmte.execute(update);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        user.psw = new_psw;
        return user;
    }
    
    public static User updateHeight(User user, String height) {
        //SELECT * FROM fitness.track WHERE track.username='1' and track.date='2018-10-27'
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "SELECT * FROM fitness.track WHERE track.username='"
                    +user.uname+"' and track.date='"+java.time.LocalDate.now().toString()+"'";
            System.out.println("Query: "+query);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                //UPDATE `fitness`.`track` SET `height` = '170' WHERE (`username` = '1') and (`date` = '2018-10-26');
                //UPDATE `fitness`.`user` SET `height` = '170' WHERE (`username` = '1');
                String update;
                update = "UPDATE `fitness`.`track` SET `height` = '"
                        +height+"' WHERE (`username` = '"+user.uname+"') and (`date` = '"
                        +java.time.LocalDate.now().toString()+"')";
                System.out.println("Update: "+update);
                stmt.execute(update);
                update = "UPDATE `fitness`.`user` SET `height` = '"
                        +height+"' WHERE (`username` = '"+user.uname+"')";
                System.out.println("Update: "+update);
                stmt.execute(update);
                user.height = height;
                return user;
            } else {
                insertTrack(user);
                return updateHeight(user, height);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static User updateWeight(User user, String weight) {
        //SELECT * FROM fitness.track WHERE track.username='1' and track.date='2018-10-27'
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "SELECT * FROM fitness.track WHERE track.username='"
                    +user.uname+"' and track.date='"+java.time.LocalDate.now().toString()+"'";
            System.out.println("Query: "+query);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                //UPDATE `fitness`.`track` SET `weight` = '70' WHERE (`username` = '1') and (`date` = '2018-10-26');
                //UPDATE `fitness`.`user` SET `weight` = '70' WHERE (`username` = '1');
                String update;
                update = "UPDATE `fitness`.`track` SET `weight` = '"
                        +weight+"' WHERE (`username` = '"+user.uname+"') and (`date` = '"
                        +java.time.LocalDate.now().toString()+"')";
                System.out.println("Update: "+update);
                stmt.execute(update);
                update = "UPDATE `fitness`.`user` SET `weight` = '"
                        +weight+"' WHERE (`username` = '"+user.uname+"')";
                System.out.println("Update: "+update);
                stmt.execute(update);
                user.weight = weight;
                return user;
            } else {
                insertTrack(user);
                return updateWeight(user, weight);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    static public void insertTrack(User user){
        //INSERT INTO `fitness`.`track` (`username`, `date`) VALUES ('1', '2018-10-26');
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String insert = "INSERT INTO `fitness`.`track` (`username`, `date`) VALUES ('"+user.uname+"', '"+java.time.LocalDate.now().toString()+"');";
            System.out.println(insert);
            stmt.execute(insert);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static User updateFood(User user, String f_name, String quantity) {
        //call addFood('rharshit', 'Apple', 1, 88, '2018-11-06'); 
        String unit = Food.getUnit(f_name);
        String date = java.time.LocalDate.now().toString();
        float cal_per_unit = Float.parseFloat(unit.split("/")[0].split(" ")[0]);
        float cal_unit = Float.parseFloat(unit.split("/")[1].split(" ")[0]);
        float cal = Float.parseFloat(quantity)*cal_per_unit/cal_unit;
        System.out.println("Unit: "+unit);
        System.out.println("Cal Unit: "+cal_unit);
        System.out.println("Cal/Unit: "+cal_per_unit);
        System.out.println("Toal Cal: "+cal);
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "call addFood('"
                    +user.uname+"', '"+f_name+"', "+quantity+", "
                    +Float.toString(cal)+", '"+date+"')";
            System.out.println("Query: "+query);
            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return user;
    }
    
    public static User updateExercise(User user, String e_name, String duration) {
        String unit = Exercise.getUnit(e_name);
        String date = java.time.LocalDate.now().toString();
        float cal_per_unit = Float.parseFloat(unit.split("/")[0].split(" ")[0]);
        float cal_unit = Float.parseFloat(unit.split("/")[1].split(" ")[0]);
        float cal = Float.parseFloat(duration)*cal_per_unit/cal_unit;
        System.out.println("Unit: "+unit);
        System.out.println("Cal Unit: "+cal_unit);
        System.out.println("Cal/Unit: "+cal_per_unit);
        System.out.println("Toal Cal: "+cal);
        try {
            Connection con = Connect.connectDB();
            Statement stmt = (Statement) con.createStatement();
            String query = "call addActivity('"
                    +user.uname+"', '"+e_name+"', "+duration+", "
                    +Float.toString(cal)+", '"+date+"')";
            System.out.println("Query: "+query);
            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return user;
    }
}
