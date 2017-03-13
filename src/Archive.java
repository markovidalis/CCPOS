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
import javax.swing.JOptionPane;
import javax.swing.JTable;
public class Archive {
    Connection  conn=null;
    ResultSet rs=null;
    PreparedStatement pst= null;
    
    public Archive (String id){
        conn = CCDBConnection.ConnectDB();
        String sql= "INSERT INTO tblArchiveCustomer (custID, custName, custSurname, custContact, custEmail, custAddress1, custAddress2, custAddress3) SELECT * FROM tblCustomer WHERE custId="+id+". DELETE FROM tblCustomer WHERE custID="+id;
        try{
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery(); 
        System.out.println (rs);
        JOptionPane.showMessageDialog(null, "CUSTOMER SUCCESFULLLY ARCHIVED.");
        }
      catch (Exception e) {        
    }
    }
    
}
