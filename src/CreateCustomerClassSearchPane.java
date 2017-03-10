/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marko
 */
import java.sql.*;
import javax.swing.*;

public class CreateCustomerClassSearchPane {

    CreateCustomer cc;
    Connection conn;
    PreparedStatement pst;
    String num;

    public CreateCustomerClassSearchPane(CreateCustomer c) {
        cc = c;
    }
    
    public String checkCustomerDetails(){
        String legitCheck= "Legit";
        String cellNum= cc.getContact();
        String regexStr = "^[0-9]{10}$";
        
        if (!(cellNum.length()==10 && cellNum.charAt(0)=='0' && cellNum.matches(regexStr))){
            legitCheck= "Invalid contact number. \nEnsure that the number contains a '0' and is ten digits long";
            return legitCheck;
        }

        
        if (cc.getName().equals(""))
        {
            legitCheck= "No name entered";
            return legitCheck;
            
        }
       
            if (!cc.getEmail().equals("") && (!cc.getEmail().contains("@") || !cc.getEmail().contains(".")))
            {
                legitCheck="Invalid email";
                return legitCheck;
    // Handle bad address
            }
            
        else {
            return legitCheck; 
        }
        
    }
    public void updateNumer(String n){
        num=n;
    }
    public boolean recordCustomer() {

        try {
            String sql = "INSERT INTO tblCustomer (CustName, CustSurname, CustContact, CustEmail, CustAddress1, CustAddress2, CustAddress3, CustArchive) VALUES ('"
                    + cc.getName() + "', '" + cc.getSurname() + "', '" + num + "', '" + cc.getEmail() + "', '" + cc.getAdLine1()
                    + "', '" + cc.getAdLine2() + "', '" + cc.getAdLine3() + "', 'F')";

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
