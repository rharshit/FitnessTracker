/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness.tracker.util;

/**
 *
 * @author student
 */
public class User {
    public String uname, name, email, dob, height, weight;
    public User(String uname, String name, String email, String dob, String height, String weight){
        this.uname = uname;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
    }
    
    public void printDetails(){
        System.out.println("Username:\t"+uname);
        System.out.println("Name:\t"+name);
        System.out.println("Email:\t"+email);
        System.out.println("Date of Birth:\t"+dob);
        System.out.println("Height:\t"+height);
        System.out.println("Weight:\t"+weight);
    }
}
