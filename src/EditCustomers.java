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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
public class EditCustomers {
    Connection  conn=null;
    ResultSet rs=null;
    PreparedStatement pst= null;
    SearchCustomer sc;
    
    
    public EditCustomers(SearchCustomer s){
        sc=s;
        conn= CCDBConnection.ConnectDB();
        
    }
    
    public void sendEdits() throws SQLException{
        boolean flag = false;
        JTable tblName= sc.getTable();
        int custID = Integer.parseInt(tblName.getValueAt(0,0) + "");

        for(int i = 0; i < tblName.getRowCount(); i++){
            
            String sql1 = "Update tblCustomer SET CustName = '" + tblName.getValueAt(i,1) + "', CustSurname = '"
                    + tblName.getValueAt(i,2) +"', CustContact = '" + tblName.getValueAt(i,3) + "', CustEmail = '" + tblName.getValueAt(i,4)
                    +"', CustAddress1 = '" + tblName.getValueAt(i, 5) + "', CustAddress2 = '" + tblName.getValueAt(i, 6) + "', CustAddress3 = '"
                    + tblName.getValueAt(i,7) + "' Where CustID = '" + tblName.getValueAt(i, 0) + "'";
            if(i == 0){
                pst = conn.prepareStatement(sql1);
                    pst.execute(); 
            }
            
            System.out.println(sql1);
            try {
                if(custID != Integer.parseInt(tblName.getValueAt(i,0) + ""))
                {
                    custID = Integer.parseInt(tblName.getValueAt(i,0) + "");
                    pst = conn.prepareStatement(sql1);
                    pst.execute(); 
                }
               
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "There was an error in updating the database. Please try again.");
                Logger.getLogger(SearchCustomerClass.class.getName()).log(Level.SEVERE, null, ex);
                flag = true;
            }
            
        }
        if(flag == false){
            JOptionPane.showMessageDialog(null, "All edits were successfully saved to the database");

        }
    }
    
}
