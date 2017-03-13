
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class SearchReceiptClass {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    JTable tblR;
    JTextField txtSearch;

    public SearchReceiptClass(JTable tbl, JTextField txtS) {
        conn = CCDBConnection.ConnectDB();
        tblR = tbl;
        txtSearch = txtS;
    }

    public void searchReceipt() {
        try {
            String sql = constructSearchSQL();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tblR.setModel(DbUtils.resultSetToTableModel(rs));
            tblR.setAutoCreateRowSorter(true);
            while (rs.next()) {
                tblR.setModel(DbUtils.resultSetToTableModel(rs));
                tblR.setAutoCreateRowSorter(true);
            }
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SearchReceiptClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void searchIncompleteReceipt(String args){
         try {
               String sql = "SELECT tblReceipt.barcodeNumber AS 'Barcode#', tblCustomer.custID AS 'CustomerID', tblCustomer.custName AS 'Name', tblCustomer.custSurname AS 'Surname', tblCustomer.custContact AS 'Contact', tblCustomer.custEmail AS 'Email'"
                + ", tblReceipt.receiptAmount AS 'Amount', tblReceipt.receiptStatus AS 'Status', tblReceipt.receiptPaymentMethod"
                + " AS 'Payment Method', tblReceipt.delivery AS 'Delivery',  tblReceipt.receiptDate AS 'Date', tblReceipt.receiptTime"
                 + " AS 'Time' FROM tblCustomer LEFT JOIN tblReceipt ON tblCustomer.custID = tblReceipt.custID WHERE tblReceipt.receiptStatus = '" + args + "' ORDER BY tblReceipt.barcodeNumber DESC";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tblR.setModel(DbUtils.resultSetToTableModel(rs));
            tblR.setAutoCreateRowSorter(true);
            while (rs.next()) {
                tblR.setModel(DbUtils.resultSetToTableModel(rs));
                tblR.setAutoCreateRowSorter(true);
            }
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SearchReceiptClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void searchReceipt(String args){
        txtSearch.setText(args);
        searchReceipt();
        txtSearch.setText("");
    }

    public String constructSearchSQL() {
       String condition = txtSearch.getText();
        if(!condition.equals("") && !condition.equals("Enter Search Term...")){
            condition = "Where tblCustomer.custName = '" + condition + "' OR tblCustomer.custSurname = '" + condition + "' OR tblCustomer.custContact = '" + condition + "' OR tblReceipt.barcodeNumber = '" + condition + "' OR tblReceipt.receiptDate = '" + condition + "' OR tblReceipt.receiptStatus = '" + condition + "'";
        }
         String sql = "SELECT tblReceipt.barcodeNumber AS 'Barcode#', tblCustomer.custID AS 'CustomerID', tblCustomer.custName AS 'Name', tblCustomer.custSurname AS 'Surname', tblCustomer.custContact AS 'Contact', tblCustomer.custEmail AS 'Email'"
                + ", tblReceipt.receiptAmount AS 'Amount', tblReceipt.receiptStatus AS 'Status', tblReceipt.receiptPaymentMethod"
                + " AS 'Payment Method', tblReceipt.delivery AS 'Delivery', tblReceipt.receiptDate AS 'Date', tblReceipt.receiptTime"
                 + " AS 'Time' FROM tblCustomer LEFT JOIN tblReceipt ON tblCustomer.custID = tblReceipt.custID "+ condition + " ORDER BY tblReceipt.barcodeNumber DESC";
                 System.out.println(sql);
                 
        
        return sql;
    }
}
