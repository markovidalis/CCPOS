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

public class CreateCustomerClass {

    CreateCustomer cc;
    Connection conn;
    PreparedStatement pst;

    public CreateCustomerClass(CreateCustomer c) {
        cc = c;
    }

    public boolean recordCustomer() {

        try {
            String sql = "INSERT INTO tblCustomer (custName, custSurname, custContact, custEmail, custAddress1, custAddress2, custAddress3, custArchive) VALUES ('"
                    + cc.getName() + "', '" + cc.getSurname() + "', '" + cc.getContact() + "', '" + cc.getEmail() + "', '" + cc.getAdLine1()
                    + "', '" + cc.getAdLine2() + "', '" + cc.getAdLine3() + "', 'F')";

            conn = CCDBConnection.ConnectDB();
            pst = conn.prepareStatement(sql);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error");
            return false;
        }
    }

}
