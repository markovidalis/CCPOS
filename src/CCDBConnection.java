
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
    public static Connection ConnectDB(/*String usn, String psw*/) {
        /*un = usn;
        pw = psw;*/ 
        //Use only if the database needs login details.
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://C://development//CheckCleaners//CheckCleaners//CheckCleaners.accdb"/*, un, pw*/);
            return conn;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Database connection error.");
            return null;
        }
    }
    
}
