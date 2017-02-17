
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
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
import javax.swing.JTable;
public class SearchCustomerClass {
    MainPane mp;
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    public SearchCustomerClass(MainPane m){
        mp = m;
        conn = CCDBConnection.ConnectDB();
    }
    
    public void search(){
        String searchTerm = mp.getSearchTerm();
        JTable tblR = mp.getTable();
        String sql = "Select custID AS 'ID', custName AS 'Name', custSurname AS 'Surname', custContact AS 'Contact', custEmail AS 'Email', "
                + "custAddress1 + custAddress2 + custAddress3 AS 'Address' FROM tblCustomer";
         try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (!rs.equals(null)) {
                tblR.setModel(DbUtils.resultSetToTableModel(rs));

                tblR.setAutoCreateRowSorter(true);
                tblR.getColumnModel().getColumn(0).setWidth(70);
                tblR.getColumnModel().getColumn(1).setWidth(300);
                tblR.getColumnModel().getColumn(2).setWidth(300);
                tblR.getColumnModel().getColumn(3).setWidth(150);
                tblR.getColumnModel().getColumn(4).setWidth(500);

                
            } 
            if(tblR.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "No matches were found according to your search criteria. Please make sure all entered data is correct.");
            }
        } catch (Exception e) {
            System.out.println("Connection timed out");
//            conn = CCDBConnection.ConnectDB();
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            if (rs.next()) {
//                tblR.setModel(DbUtils.resultSetToTableModel(rs));
////                tblDeleted.setModel(DbUtils.resultSetToTableModel(rs));
//            } else {
//                JOptionPane.showMessageDialog(null, "No matches were found according to your search criteria. Please make sure all entered data is correct.");
//            }
        }
        System.out.println("Ended");
    }
}
