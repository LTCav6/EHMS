package Models;

import MainPackage.QueryExecuter;
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thom
 */
public class Employee {
    QueryExecuter qe = new QueryExecuter();
    Connection con;
    
    int id;
    String firstName;
    String lastName;
    String username;
    
    public Employee(int staffId, String fname, String lname, Connection connect){
        id = staffId;
        firstName = fname;
        lastName = lname;
        con  = connect;
    }
    
    public void ClockIn(){
        String clockInQuery = "UPDATE Staff\n" +
                              "SET SignedIn = 'Yes'\n" +
                              "WHERE StaffID = " + id + ";";
        qe.runQuery(con, clockInQuery);
    }
    
    public void ClockOut(){
        String clockOutQuery = "UPDATE Staff\n" +
                              "SET SignedIn = 'No'\n" +
                              "WHERE StaffID = " + id + ";";
        qe.runQuery(con, clockOutQuery);
    }
    
    public void setFirstName(String fname){
        firstName = fname;
    }
    
    public void setLastName(String lname){
        lastName = lname;
    }
    
    public String getName(){
        return firstName + " " + lastName;
    }
}
