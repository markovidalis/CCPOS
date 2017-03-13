
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
public class SearchCustomer extends javax.swing.JFrame {

    /**
     * Creates new form SearchCustomer
     */ResultSet rs = null;
    public SearchCustomer() {
        initComponents();
        updateTblCustomers();

    }
    MainPane mp;
    EditReceipt e;
    public SearchCustomer(MainPane m) {
        initComponents();
        mp = m;
       updateTblCustomers();
    }
    public SearchCustomer(EditReceipt er) {
        initComponents();
        e = er;
       updateTblCustomers();
    }
    
    public void updateTblCustomers(){
         UpdateSearch up = new UpdateSearch("tblCustomer");
         rs = up.updateTable();
         tblCustomers.setModel(DbUtils.resultSetToTableModel(rs));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAddNewCustomer = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnArchive = new javax.swing.JButton();
        btnViewRecDel = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnNewReceipt = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Customer Information");

        btnAddNewCustomer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAddNewCustomer.setText("Add New Customer");
        btnAddNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewCustomerActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtSearch.setText("Search...");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnArchive.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnArchive.setText("Archive Customer");
        btnArchive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchiveActionPerformed(evt);
            }
        });

        btnViewRecDel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnViewRecDel.setText("Archives");
        btnViewRecDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRecDelActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnNewReceipt.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnNewReceipt.setText("New Receipt");
        btnNewReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewReceiptActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnEdit.setText("Edit Customer");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCustomers);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddNewCustomer)
                                .addGap(50, 50, 50)
                                .addComponent(btnArchive, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSearch))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewRecDel, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNewReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(348, 348, 348))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNewCustomer)
                    .addComponent(btnArchive)
                    .addComponent(btnViewRecDel)
                    .addComponent(btnEdit))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnNewReceipt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void hideNewReceiptButton(){
        btnNewReceipt.setVisible(false);
    }
    private void btnAddNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewCustomerActionPerformed

        new CreateCustomer(this).setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddNewCustomerActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchiveActionPerformed
      int rowVal = tblCustomers.getSelectedRow();
      if(rowVal!=-1){
              ArchiveCustomer ac = new ArchiveCustomer((int) tblCustomers.getValueAt(rowVal,0));
              ac.archiveCust();
              updateTblCustomers();
      }
        
    }//GEN-LAST:event_btnArchiveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        SearchCustomerClass scc = new SearchCustomerClass(this);
        scc.search();
        
    }//GEN-LAST:event_btnSearchActionPerformed

    public String getSearchTerm() {
        return txtSearch.getText();
    }

    public JTable getTable() {
        return tblCustomers;
    }
    private void btnNewReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewReceiptActionPerformed
        int rowVal = tblCustomers.getSelectedRow();
        if (rowVal != -1) {

            int custID = (int) tblCustomers.getValueAt(rowVal, 0);
            String custName = tblCustomers.getValueAt(rowVal, 1).toString();
            String custSurname = tblCustomers.getValueAt(rowVal, 2).toString();
            String custContact = tblCustomers.getValueAt(rowVal, 3).toString();
            String custEmail = tblCustomers.getValueAt(rowVal, 4).toString();
            String custAddress1 = tblCustomers.getValueAt(rowVal, 5).toString();
            String custAddress2 = tblCustomers.getValueAt(rowVal, 6).toString();
            String custAddress3 = tblCustomers.getValueAt(rowVal, 7).toString();
            if (mp != null){
            mp.populateCustomerDetails(custID, custName, custSurname, custContact, custEmail, custAddress1, custAddress2, custAddress3);
            this.setVisible(false);
            } else if(e != null){
                e.populateCustomerDetails(custID, custName, custSurname, custContact, custEmail, custAddress1, custAddress2, custAddress3);
            this.setVisible(false);
            } else {
                MainPane m = new MainPane();
                m.populateCustomerDetails(custID, custName, custSurname, custContact, custEmail, custAddress1, custAddress2, custAddress3);
                this.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an existing customer in the table below!");
        }
    }//GEN-LAST:event_btnNewReceiptActionPerformed

    private void btnViewRecDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRecDelActionPerformed
        // TODO add your handling code here:
        new ArchiveViewer().setVisible(true);
    }//GEN-LAST:event_btnViewRecDelActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        updateTblCustomers();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to save your edits? \n Note: This cannot be undone.", "CONFIRM?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            EditCustomers e= new EditCustomers (this);
            try{
            e.sendEdits();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex);
            }
            
            
        }
        else {
           JOptionPane.showMessageDialog(null, "Action Cancelled");
        }
    }//GEN-LAST:event_btnEditActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchCustomer().setVisible(true);
            }
        });
    }
    
    public JTable sendTable(){
        return tblCustomers;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewCustomer;
    private javax.swing.JButton btnArchive;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNewReceipt;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewRecDel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
