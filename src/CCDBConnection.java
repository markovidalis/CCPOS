
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marko
 */
public class CCDBConnection {
    
    Connection conn = null;
    static String un, pw, hAddress;
    public static Connection ConnectDB() {
        
        //Use only if the database needs login details.
        try {
  /*          Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CheckCleanersDB", "CCAdmin", "ccadmin");
            System.out.println("Connected");
            return conn;
*/
   Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://169.239.181.113/checkdry_pos", "checkdry", "Q!5RGwPnbe7(");
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace(); 
            System.out.println("Database connection error.");
            return null;
        }
    }
}
