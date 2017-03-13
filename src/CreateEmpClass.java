
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author georgegeorgiades
 */
public class CreateEmpClass {



    CreateEmp ce;
    Connection conn;
    PreparedStatement pst;
    String num;

    public CreateEmpClass(CreateEmp c) {
        ce = c;
    }
    
    public String checkEmployeeDetails(){
        String legitCheck= "";
        String cellNum= ce.getContact();
        String regexStr = "^[0-9]{10}$";
        if (ce.getName().equals(""))
        {
            legitCheck= "No name entered";
            return legitCheck;
            
            
        }
        if (ce.getName().contains(" ")||ce.getSurname().contains(" ")){
            return "Name and surname may not contain and spaces";
        }

        if (ce.getName().equals("")|| ce.getSurname().equals("")||ce.getContact().equals("")){
            legitCheck= "Ensure all fields are entered correctly";
        }
        if (!(cellNum.length()==10 && cellNum.charAt(0)=='0' && cellNum.matches(regexStr))){
            legitCheck= "Invalid contact number. \nEnsure that the number contains a '0' and is ten digits long";
            return legitCheck;
        }
            else
            if (!ce.getEmail().equals("") && (!ce.getEmail().contains("@") || !ce.getEmail().contains(".")))
            {
                legitCheck="Invalid email";
                return legitCheck;
    // Handle bad address
            }
        if (ce.getCheckAccess()== true && (ce.getUsername().equals("")|| ce.getPassword().equals(""))){
           return "Each employee with POS access requires a username and password";
        }
        if (ce.getCheckAccess()==true && (ce.getUsername().contains(" ")|| ce.getPassword().contains(" ")))
                {
                    return "No spaces allowed in username and password";
                }
       
      
        
        
    
            
        else {
            return legitCheck; 
        }
        
    }
    
    public void updateNumer(String n){
        num=n;
    }
    public boolean recordEmployee() {
        try {
            String sql = "INSERT INTO tblEmployee (empName, empSurname, empUsername, empPassword, empContact, empEmail, Admin, Access) VALUES ('"
                    + ce.getName() + "', '" + ce.getSurname() + "', '" + ce.getUsername() + "', '" + ce.getPassword() + "', '" + ce.getContact()
                    + "', '" + ce.getEmail() + "', '" +ce.getCheckAdmin() + "', '"+ ce.getAccess()+"')";

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


