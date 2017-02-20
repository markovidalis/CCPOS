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
public class RestoreCustomer {
    Connection  conn=null;
    ResultSet rs=null;
    PreparedStatement pst= null;
    public RestoreCustomer(){
            conn = CCDBConnection.ConnectDB();
    }

    
    public void Restore(int id){
        String sql= "INSERT INTO tblCustomer (custName, custSurname,custContact, custEmail, custAddress1, custAddress2, custAddress3) SELECT archCustName, archCustSurname, archCustContact, archCustEmail, archCustAddress1, archCustAddress2, archCustAddress3 FROM tblArchiveCustomer WHERE archCustId="+id+". DELETE FROM tblArchiveCustomer WHERE archCustID="+id;
        try{
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery(); 
        System.out.println (rs);
        JOptionPane.showMessageDialog(null, "CUSTOMER SUCCESFULLLY RESTORED.");
        }
      catch (Exception e) {        
    }
    }
    
    
    
}
