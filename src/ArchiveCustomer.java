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
public class ArchiveCustomer {
    Connection  conn=null;
    ResultSet rs=null;
    PreparedStatement pst= null;
    int custID;
    public ArchiveCustomer (int id){
        custID = id;
        
    }
    
    public void archiveCust(){
        conn = CCDBConnection.ConnectDB();
        //String sql= "INSERT INTO tblArchiveCustomer (archCustName, archCustSurname,archCustContact, archCustEmail, archCustAddress1, archCustAddress2, archCustAddress3) SELECT custName, custSurname, custContact, custEmail, custAddress1, custAddress2, custAddress3 FROM tblCustomer WHERE custId="+custID+". DELETE FROM tblCustomer WHERE custID="+custID;
        String sql= "UPDATE tblCustomer SET custArchive = 'T' WHERE custID= '"+custID+"'";
        try{
            System.out.println(sql);
            pst = conn.prepareStatement(sql);
            pst.execute(); 
        
        JOptionPane.showMessageDialog(null, "CUSTOMER SUCCESFULLLY ARCHIVED.");
        
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "The customer was not found in the database.");
            System.out.println(e);
        }
    }
    
}
