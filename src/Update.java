
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

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
public class Update {
    
    Connection  conn=null;
    ResultSet rs=null;
    PreparedStatement pst= null;

 
    
     public void Update(JTable tblName)
      {    
            try {
            String sql= "SELECT *FROM "+tblName; //ordered by type, so that users can shop in an efficient manner
            pst= conn.prepareStatement(sql);
            rs= pst.executeQuery();

            tblName.setModel (DbUtils.resultSetToTableModel(rs)); //Set the table to show the Groceries table
            }
            catch (SQLException e){
                  JOptionPane.showMessageDialog (null, "ERROR: "+e);
            }
             finally {
                  try
                  {
                        rs.close();
                        pst.close();
                        
                  }
                  catch (Exception e)
                  {
                        JOptionPane.showMessageDialog (null, e);
                  }
            }
      }
    
}
