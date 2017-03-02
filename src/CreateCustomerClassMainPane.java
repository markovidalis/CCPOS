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
import javax.swing.*;
public class CreateCustomerClassMainPane {
    MainPane mp;
    Connection conn;
    PreparedStatement pst;

    public CreateCustomerClassMainPane (MainPane c) {
        mp = c;
    }
    
    public String checkCustomerDetails(){
        String legitCheck= "Legit";
        
        if (mp.getName().equals(""))
        {
            legitCheck= "No name entered";
            return legitCheck;
            
        }
        else
            if (!mp.getEmail().equals("") && (!mp.getEmail().contains("@") || !mp.getEmail().contains(".")))
            {
                legitCheck="Invalid email";
                return legitCheck;
    // Handle bad address
            }
        else {
            return legitCheck; 
        }
        
    }

    public boolean recordCustomer() {

        try {
            String sql = "INSERT INTO tblCustomer (CustName, CustSurname, CustContact, CustEmail, CustAddress1, CustAddress2, CustAddress3, CustArchive) VALUES ('"
                    + mp.getName() + "', '" + mp.getSurname() + "', '" + mp.getContact() + "', '" + mp.getEmail() + "', '" + mp.getAdLine1()
                    + "', '" + mp.getAdLine2() + "', '" + mp.getAdLine3() + "', 'F')";

            conn = CCDBConnection.ConnectDB();
            pst = conn.prepareStatement(sql);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error " + e);
            return false;
        }
    }
    
}
