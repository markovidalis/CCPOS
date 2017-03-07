
import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import java.io.*;

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

    Object[][] data;
    MainPane nr;
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    JTable tblItems;
    String[] columnNames = {"Qty", "Description", "Department", "Item Type", "Unit Price", "Total Price", "Notes"};
    JComboBox cmbDept, cmbItem;
    String[][] dept;
    String[][] tableDataArr = new String[1][7];
    int tableDataSize = 0;

    public NewReceiptClass(MainPane n, JComboBox cmbD, JComboBox cmbI, JTable tblCon) {
        nr = n;
        tblItems = tblCon;
        conn = CCDBConnection.ConnectDB();
        data = new Object[1][4];
        cmbDept = cmbD;
        tblCon.setModel(new DefaultTableModel(data, columnNames));
        FillComboBoxDepartment();
        cmbItem = cmbI;

    }

    public void recordOrder() throws IOException {
        String barcodeNum = generateBarcodeNumber();
        int empID = authenticateEmployee();
        try {
            if (empID != 0) {
                String custID = nr.getCustomerID();
                double amount = nr.getReceiptAmount();
                String paymentMethod = nr.getPaymentMethod();
                String sql = "INSERT INTO tblReceipt (custID, empID, receiptAmount, receiptPaymentMethod, delivery, receiptStatus, barcodeNumber)"
                        + " VALUES ('" + custID + "', '" + empID + "', '" + amount + "', '" + nr.getPaymentMethod() + "', '"
                        + nr.getDelivery() + "', 'Being Processed', '" + barcodeNum + "')";
                System.out.println(sql);
                conn = CCDBConnection.ConnectDB();
                pst = conn.prepareStatement(sql);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Receipt recorded successfully: " + barcodeNum);
                recordOrderItems(barcodeNum);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLError - recordReceipt" + sqle);
        }

    }
    
  public String generateBarcodeNumber() {
        String sql = "Select latestBarcode AS 'barNum' from tblBarNum";
        String barcodeNumber = "0000";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                barcodeNumber = rs.getString("barNum");
                barcodeNumber = String.format("%04d", Integer.parseInt(barcodeNumber) + 1);
                System.out.println("BarcodeNumber = " + barcodeNumber);
                Barcode barcode = null;
                sql = "UPDATE tblBarNum SET latestBarcode = "+ barcodeNumber;
                conn = CCDBConnection.ConnectDB();
                pst = conn.prepareStatement(sql);
                pst.execute();
                System.out.println(sql);
                try {
                    barcode = BarcodeFactory.createCode128B(barcodeNumber);
                } catch (BarcodeException e) {
                    // Error handling
                }
            }
            //panelBarcode.add(barcode, BorderLayout.CENTER);
            //panelBarcode.repaint();
        } catch (SQLException sqle) {
            System.out.println("Could not generate barcode - SQL ERROR:\n " + sqle);
        }
        return barcodeNumber;
    }
  
    public void recordOrderItems(String barcodeNum) {
        String sql1 = "Select receiptID AS 'barNum' FROM tblReceipt where barcodeNumber = '" + barcodeNum + "'";
        try {
            conn = CCDBConnection.ConnectDB();
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery();
            while (rs.next()) {
                String receiptID = rs.getString("barNum");
                JTable tblItems = nr.getTable();
                System.out.println(tblItems.getRowCount()+"");
                for (int i = 0; i < tblItems.getRowCount(); i++) {
                    String qty = tblItems.getValueAt(i, 0).toString();
                    String desc = tblItems.getValueAt(i, 1).toString();
                    String dept = tblItems.getValueAt(i, 2).toString();
                    String type = tblItems.getValueAt(i, 3).toString();
                    String unitP = tblItems.getValueAt(i, 4).toString();
                    String totalP = tblItems.getValueAt(i, 5).toString();
                    String notes = tblItems.getValueAt(i, 6).toString();

                    String sql = "INSERT INTO tblReceiptItems (receiptID, receiptItemQty, receiptItemDesc, receiptItemDept,"
                            + " receiptItemType, receiptItemUnitP, receiptItemTotalP, receiptItemNotes) VALUES ('" + receiptID + "', '" + qty + "', '" + desc + "', '"
                            + dept + "', '" + type + "', '" + unitP + "', '" + totalP + "', '" + notes + "')";
                    System.out.println("Barcode Num " + barcodeNum + " SQL: " + sql);
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                }
            }
        } catch (SQLException sqle) {
            System.out.println("SQL Exception recordOrderItems: " + sqle);
        }

    }

    public int authenticateEmployee() {
        //NEED TO ADD FINGERPRINT AUTHENTICATION FOR EMPLOYEE HERE.
        return 1;
    }

    public void FillComboBoxItemType() {
        cmbItem.removeAllItems();
        String deptName = cmbDept.getSelectedItem().toString();
        int count = 0;
        while (!dept[count][1].equals(deptName)) {
            count++;
        }
        String deptID = dept[count][0];
        try {
            int size = getRSSize("tblDeptItems");
            String[] items = new String[size + 1];
            items[0] = "";
            String sql = "select * from tblDeptItems WHERE deptID = " + deptID;
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            int count2 = 1;

            while (rs.next()) {
                items[count2] = rs.getString("deptItemName");
                count2++;
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(items);
            cmbItem.setModel(model);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

    public int getRSSize(String dbTblName) {
        int size;
        try {
            String rsSize = "Select COUNT(*) AS 'size' from tblDeptItems";
            pst = conn.prepareStatement(rsSize);
            rs = pst.executeQuery();
            rs.next();
            size = Integer.parseInt(rs.getString("size"));
        } catch (SQLException ex) {
            Logger.getLogger(NewReceiptClass.class.getName()).log(Level.SEVERE, null, ex);
            size = 0;
        }
        return size;
    }

    public void addItemToTable(JTextField txtQty, JTextField txtDesc, JTextField txtUnitP, JTextField txtTotalP, JTextArea txtNotes) {
        String[][] newTblDataArr = new String[tableDataSize + 1][7];
        for (int i = 0; i < tableDataArr.length; i++) {
            for (int j = 0; j < 7; j++) {
                newTblDataArr[i][j] = tableDataArr[i][j];
            }
        }
        newTblDataArr[tableDataSize][0] = txtQty.getText();
        newTblDataArr[tableDataSize][1] = txtDesc.getText();
        newTblDataArr[tableDataSize][2] = cmbDept.getSelectedItem().toString();
        newTblDataArr[tableDataSize][3] = cmbItem.getSelectedItem().toString();
        newTblDataArr[tableDataSize][4] = txtUnitP.getText();
        newTblDataArr[tableDataSize][5] = txtTotalP.getText();
        newTblDataArr[tableDataSize][6] = txtNotes.getText();

        tableDataArr = newTblDataArr;
        TableModel model = new DefaultTableModel(tableDataArr, columnNames);
        tblItems.setModel(model);
        tableDataSize++;

        //tblItems.getModel().insertRow(tblItems.getRowCount(),new Object[]{"hello","50"});
    }

    public void populateItemPrice(JTextField txtUnitP, String itemName) {

        try {
            int row = 0;
            String sql = "Select deptItemPrice from tblDeptItems where deptItemName = '" + itemName + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(itemName);
                System.out.println(rs.getString("deptItemPrice"));
                String price = rs.getString("deptItemPrice");
                txtUnitP.setText(price);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewReceiptClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calculateTotalPrice(JTextField txtQty, JTextField txtUnitP, JTextField txtTotalP) {
        String qty = txtQty.getText();
        String unitP = txtUnitP.getText();
        if (!qty.equals("") && !unitP.equals("")) {
            double total = Double.parseDouble(qty) * Double.parseDouble(unitP);
            txtTotalP.setText(total + "");
        }

    }

    public void FillComboBoxDepartment() {
        String sql = "SELECT * from tblDepartment ORDER BY deptName";
        int size = 0;
        int count = 0;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            dept = new String[10][2];
            while (rs.next()) {//adds each item to the list for the combo box
                dept[count][0] = rs.getString("deptID");
                dept[count][1] = rs.getString("deptName");
                cmbDept.addItem(dept[count][1]);
                count++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
