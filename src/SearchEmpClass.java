/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author georgegeorgiades
 */

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
public class SearchEmpClass {
    EmployeeManagement em;
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    public SearchEmpClass(EmployeeManagement m){
        em = m;
        conn = CCDBConnection.ConnectDB();
    }
    
    public void searchTable(){
        String searchTerm = em.getSearchTerm();
        JTable tblR = em.getTable();
        String sql = "Select empID AS 'ID', empName AS 'Name', empSurname AS 'Surname', empUsername AS 'Username', "
                + "empContact AS 'Contact', empEmail  AS 'Email', Admin AS 'Admin', Access AS 'Access' FROM tblEmployee WHERE (empID Like '%" + searchTerm + "%'"
                + "OR empName Like '%" + searchTerm + "%' OR empSurname Like '%" + searchTerm + "%' OR empUsername Like '%" + searchTerm + "%'"
                + "OR empEmail Like '%" + searchTerm + "%' OR empContact Like '%" + searchTerm + "%')";
         try {
             System.out.println(sql);
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
    
    public boolean searchUsername(String un) throws SQLException{
                String sql = "Select empUsername AS 'Username' FROM tblEmployee WHERE empUsername = '" +un+ "'";
                 try{
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                 System.out.println(rs.toString());
                 }
                 catch (SQLException e){
                     JOptionPane.showMessageDialog(null,e);
                 }
                 if (rs.next())
                 {
                     return true;
                 }
                 else {
                     return false;
                 }
                        
                

    }
}
