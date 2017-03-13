/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George
 */
import java.sql.*;
import javax.swing.*;

public class UpdateArchive {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private String tblName;
    
    public UpdateArchive(String tbl){
        tblName = tbl;
    }
    
    public ResultSet updateTable(){
        try {
            String sql = "Select * from " + tblName +" WHERE CustArchive = 'T'";
            System.out.println(sql);
            conn = CCDBConnection.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "SQLException");
            return null;
        }/* finally{
        try{
            rs.close();
            pst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        }*/
    }
}


