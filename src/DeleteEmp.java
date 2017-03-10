/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author georgegeorgiades
 */
import java.sql.*;
public class DeleteEmp {
    
    Connection conn=null;
    
    ResultSet rs = null;
    PreparedStatement pst = null;
    String id=null;
    
    public DeleteEmp (String i) throws SQLException{
        id=i;
        String sql= "DELETE FROM tblEmployee where empID = '"+id+"'";
        System.out.println(sql);
        conn = CCDBConnection.ConnectDB();
        pst = conn.prepareStatement(sql);
        pst.execute();
    }
    
}
