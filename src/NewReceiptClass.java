
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marko
 */
public final class NewReceiptClass {
    Object [][] data;
    MainPane nr;
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    JTable tblCon;
    String [] columnNames = {"Qty", "Description", "Department", "Item Type", "Unit Price", "Total Price"};
    
    public NewReceiptClass(MainPane n){
        nr = n;
        conn = CCDBConnection.ConnectDB();
        tblCon = n.getTable();
        data = new Object [1][4];
        tblCon.setModel(new DefaultTableModel(data, columnNames));

        FillComboBoxDepartment();
    }
    
    public void setCmbDept(JTable tblItems){
        
    }
    
    public void FillComboBoxItemType(){
        JTable tblCon = nr.getTable();
        int row = tblCon.getSelectedRow();
        
        String sql = "SELECT * from tblDryCleanPrices";
        int size = 0;
        int count = 0;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            List<String> list = new ArrayList<>();
            while (rs.next()) {//adds each item to the list for the combo box
                list.add(rs.getString("dryCleanName"));
            }
            count = list.size();
            String[] items = list.toArray(new String[list.size()]);
            JComboBox<String> jcb = new JComboBox<>(items);
           // TableColumn tc = tblCon.getColumnModel().getColumn(3);
            TableCellRenderer tcr;
            TableCellEditor tce = new DefaultCellEditor(jcb);//adds the combo box to the relevant cell in the table.
            //tc.setCellEditor(tce);
            
            tblCon.setValueAt(jcb, row, 3);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void updateColumns() {

        for (int k = 0; k < data.length; k++) {
            for (int i = 0; i < 2; i++) {
                data[k][i] = tblCon.getValueAt(k, i);
            }//updates the 2Dobject according to the information entered by the user in the table.
            String sql = "";
            if (data[k][0] != "" && data[k][1] != "" && data[k][2] != "") {
                try {
                    try {
                        System.out.println((String) data[k][2] + "department");
                        sql = "Select dryCleanName from tblDryCleanPrices";
                        pst = conn.prepareStatement(sql);
                        rs = pst.executeQuery();
                        if (rs.next()) {//sets the individual and total prices for each item recorded in the table.
                            data[k][2] = rs.getString("dryCleanName");

                            //double total1 = Double.parseDouble((String) data[k][2]) * Integer.parseInt((String) data[k][0]);
                           // data[k][3] = total1;
                            if (!data[k][2].equals(0) && k == data.length - 1) {
                              //  updateTotal();
                                tblCon.setModel(new DefaultTableModel(data, columnNames));
                            } else {
                            }
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "SQL error btnAddItem " + e);
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "An invalid quantity has been entered. Please make sure the quantity fields have been filled in correctly. (Numbers only)");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please complete the Parts field for all rows, otherwise delete the blank row(s)");
            }
        }
    }
    
    public void FillComboBoxDepartment() {

        String sql = "SELECT * from tblDepartment ORDER BY deptName";
        int size = 0;
        int count = 0;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            List<String> list = new ArrayList<>();
            while (rs.next()) {//adds each item to the list for the combo box
                list.add(rs.getString("deptName"));
            }
            count = list.size();
            String[] items = list.toArray(new String[list.size()]);
            JComboBox<String> jcb = new JComboBox<>(items);
            TableColumn tc = tblCon.getColumnModel().getColumn(2);
            TableCellEditor tce = new DefaultCellEditor(jcb);//adds the combo box to the relevant cell in the table.
            tc.setCellEditor(tce);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
