
import java.sql.*;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marko
 */
public class CCLogin {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    boolean isAdmin;
    int userID;
    
    public CCLogin() {
        conn = CCDBConnection.ConnectDB();

    }

    public boolean validateUser(JTextField un, JTextField pw) throws SQLException {
        boolean exists = false;

//        String sql = "Select * from tblAdmin where adminUsername = '" + un.getText() + "' AND adminPassword = '" + pw.getText() + "'";
//        pst = conn.prepareStatement(sql);
//        rs = pst.executeQuery();
//        if (rs.next()) {
//            System.out.println("Login success");
//            isAdmin = true;
//            userID = Integer.parseInt(rs.getString("adminID"));
//            exists = true;
//        } else {

            String sql = "Select * from tblEmployee where empUsername = '" + un.getText() + "' AND empPassword = '" + pw.getText() + "' AND Admin='true' AND Access= 'true'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Login success");
                isAdmin = false;
                userID = Integer.parseInt(rs.getString("empID"));
                exists = true;
            }
            System.out.println("Invalid details entered");
        

        return exists;

    }
    
    public boolean getUserType(){
        return isAdmin;
    }
    
    public int getUserID(){
        return userID;
    }

}
