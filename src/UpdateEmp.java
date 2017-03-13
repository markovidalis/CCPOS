
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class UpdateEmp {



    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public UpdateEmp (){
    }
    
    public ResultSet updateTable(){
        try {
            String sql = "SELECT empID,empName,empSurname, empUsername, empContact, empEmail, Admin, Access from tblEmployee ORDER BY empID desc";
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
