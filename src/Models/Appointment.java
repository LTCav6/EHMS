package Models;


import MainPackage.QueryExecuter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thom
 */
public class Appointment {
    static QueryExecuter qe = new QueryExecuter();
    int appId;
    String appDate;
    String appTime;
    
    public Appointment(int id, String date, String time){
        appId = id;
        appDate = date;
        appTime = time; 
    }
    
    public void appComplete(){
        
    }
    
    
    public static String getAppInfo(int appId, Connection con){
        String appQuery = "";
        return appQuery;
    }
    
    public static String[] getAppointments(Connection con){
        String appQuery = "SELECT a.AppointmentID, a.AppointmentTime, p.FirstName, p.LastName FROM Patients p JOIN AppointmentLine l join Appointments a\n" +
"where p.PatientID = l.PatientID AND l.AppointmentID = a.AppointmentID;";
        
        ResultSet apps = qe.runQuery(con, appQuery);
        String[] appointments = new String[getRowCount(apps)]; 
        String idspacing;
        String spacing = "     ";
        
        int counter = 0;
        try {
            while(apps.next()){
                
                int id = apps.getInt("AppointmentID");
                String time = apps.getString("AppointmentTime");
                String fname = apps.getString("FirstName");
                String lname = apps.getString("LastName");
                if(id > 9){
                    idspacing = "   ";
                }
                else
                    idspacing = "     ";
                appointments[counter] = id + idspacing + time + spacing + fname + " " + lname; 
                counter++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return appointments;
    }
    
    private static int getRowCount(ResultSet resultSet) {
        if (resultSet == null) {
            return 0;
        }
        try {
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            try {
                resultSet.beforeFirst();
            } catch (SQLException exp) {
                exp.printStackTrace();
            }
        }
        return 0;
    }
    
}
