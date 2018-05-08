
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class QueryExecuter {
    public ResultSet runQuery(Connection con, String statement){
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            return rs;
        } catch (SQLException ex) {
            //should put something else here to the screen
            Logger.getLogger(QueryExecuter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
}
