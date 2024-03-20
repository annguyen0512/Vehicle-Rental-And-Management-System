/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import motorservice.ClassDAO;
import motorservice.Color;
import motorservice.Customer;
import motorservice.CustomerClass;
import motorservice.CustomerDAO;
import motorservice.Vehicle;
import motorservice.VehicleStatus;

/**
 *
 * @author nguyenhoanggiaan
 */
public class CustomerManagement extends javax.swing.JFrame implements ActionListener {
    ClassDAO daoClass = new ClassDAO();
    CustomerDAO daoCustomer = new CustomerDAO();
    /**
     * Creates new form CustomerManagement
     */
    public CustomerManagement() {
        initComponents();
        setLocationRelativeTo(null);
        getDataCombobox();
        btncancel.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbresult = new javax.swing.JTable();
        btncancel = new javax.swing.JButton();
        closeButton1 = new javax.swing.JLabel();
        txtcustomername = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtphonenumber = new javax.swing.JTextField();
        cbxclass = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnshowall = new javax.swing.JButton();
        btnaddnew = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        lblstatus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcustomerid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbresult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Customer name", "Address", "Phone number", "Class"
            }
        ));
        tbresult.setSelectionBackground(new java.awt.Color(51, 153, 255));
        tbresult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbresultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbresult);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 256, 786, 331));

        btncancel.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btncancel.setForeground(new java.awt.Color(51, 153, 255));
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel1.add(btncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 599, -1, -1));

        closeButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        closeButton1.setForeground(new java.awt.Color(255, 255, 255));
        closeButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeButton1.setText("X");
        closeButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButton1MouseClicked(evt);
            }
        });
        jPanel1.add(closeButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 0, 53, 31));

        txtcustomername.setBackground(new java.awt.Color(51, 153, 255));
        txtcustomername.setForeground(new java.awt.Color(255, 255, 255));
        txtcustomername.setBorder(null);
        txtcustomername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcustomernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtcustomername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 290, -1));

        txtaddress.setBackground(new java.awt.Color(51, 153, 255));
        txtaddress.setForeground(new java.awt.Color(255, 255, 255));
        txtaddress.setBorder(null);
        txtaddress.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 290, -1));

        txtphonenumber.setBackground(new java.awt.Color(51, 153, 255));
        txtphonenumber.setForeground(new java.awt.Color(255, 255, 255));
        txtphonenumber.setBorder(null);
        jPanel1.add(txtphonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 290, -1));

        cbxclass.setBackground(new java.awt.Color(51, 153, 255));
        cbxclass.setForeground(new java.awt.Color(255, 255, 255));
        cbxclass.setBorder(null);
        jPanel1.add(cbxclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Customer Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Address");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Phone Number");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Class");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        btnshowall.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnshowall.setForeground(new java.awt.Color(51, 153, 255));
        btnshowall.setText("Show All");
        btnshowall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowallActionPerformed(evt);
            }
        });
        jPanel1.add(btnshowall, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 599, 87, -1));

        btnaddnew.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnaddnew.setForeground(new java.awt.Color(51, 153, 255));
        btnaddnew.setText("Add New");
        btnaddnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddnewActionPerformed(evt);
            }
        });
        jPanel1.add(btnaddnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 227, 161, -1));

        btndelete.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(51, 153, 255));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 227, 161, -1));

        lblstatus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblstatus.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 599, 233, 23));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Customer ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        txtcustomerid.setBackground(new java.awt.Color(51, 153, 255));
        txtcustomerid.setForeground(new java.awt.Color(255, 255, 255));
        txtcustomerid.setBorder(null);
        txtcustomerid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcustomeridActionPerformed(evt);
            }
        });
        jPanel1.add(txtcustomerid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 290, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("_____________________________________________");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("______________________________________________________");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, 20));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("______________________________________________________");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 290, 40));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("_____________________________________________________");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CUSTOMER INFORMATION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 10, 790, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 650));

        setSize(new java.awt.Dimension(784, 640));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelActionPerformed
    
    public void resetForm(){
        txtcustomerid.setText("");
        txtcustomername.setText("");
        txtaddress.setText("");
        txtphonenumber.setText("");
        cbxclass.setSelectedIndex(0);  
    }
    public Customer getModel(){
        Customer cus = new Customer();
        cus.setCustomerId(txtcustomerid.getText().trim());
        cus.setCustomerName(txtcustomername.getText().trim());
        cus.setAddress(txtaddress.getText().trim());
        cus.setPhoneNumber(txtphonenumber.getText().trim());
        cus.setCustomerClass((CustomerClass)cbxclass.getSelectedItem());
        return cus;
    }
    
    private void btnaddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddnewActionPerformed

        if(!checkValidInput()){
            JOptionPane.showMessageDialog(this,"You need to enter all information!");
        }else{
            Customer cus = getModel();
            System.out.println("=>"+cus.toString());
            if(daoCustomer.add(cus)>0){
                lblstatus.setText("Saved successfully");
                addSQL(cus);
                updateDataIntoTable();
                resetForm();
            }
        }
        
    }//GEN-LAST:event_btnaddnewActionPerformed
    public void setModel(Customer cus){
        txtcustomerid.setText(cus.getCustomerId());
        txtcustomername.setText(cus.getCustomerName());
        txtaddress.setText(cus.getAddress());
        txtphonenumber.setText(cus.getPhoneNumber());
        cbxclass.setSelectedItem(cus.getCustomerClass());
    }
    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        if(txtcustomerid.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"You need to enter Customer ID to search !");
        }else{
            if(daoCustomer.delete(txtcustomerid.getText().trim())>0){
                lblstatus.setText("Delete Successfully "+txtcustomerid.getText());
                deleteSQL(txtcustomerid.getText());
                updateDataIntoTable();
                resetForm();
            }else{
                lblstatus.setText("Can not found Customer "+txtcustomerid.getText());
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tbresultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbresultMouseClicked
        int rowID = tbresult.rowAtPoint(evt.getPoint());
        Customer cus = daoCustomer.getCustomerAtPoint(rowID);
        if(cus == null){
            return;
        }
        setModel(cus);
    }//GEN-LAST:event_tbresultMouseClicked

    private void closeButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButton1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeButton1MouseClicked

    private void btnshowallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowallActionPerformed
        updateDataIntoTable();
    }//GEN-LAST:event_btnshowallActionPerformed

    private void txtcustomernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcustomernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcustomernameActionPerformed

    private void txtcustomeridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcustomeridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcustomeridActionPerformed
    public void fillData(){
        DefaultTableModel  tbModel = (DefaultTableModel) tbresult.getModel();
        tbModel.setRowCount(0);
        for(Customer cus : daoCustomer.getAllCustomer()){
            Object[] rowData = new Object[5];
            rowData[0] = cus.getCustomerId();
            rowData[1] = cus.getCustomerName();
            rowData[2] = cus.getAddress();
            rowData[3] = cus.getPhoneNumber();
            rowData[4] = cus.getCustomerClass();
            tbModel.addRow(rowData);
        }
    }
    
    
    public void getDataCombobox(){
        DefaultComboBoxModel<CustomerClass> model 
                = (DefaultComboBoxModel) cbxclass.getModel();
        for(CustomerClass customerclass : daoClass.getAllClass()){
            model.addElement(customerclass);
        }

    }
    
    public boolean checkValidInput(){
        if(txtcustomerid.getText().isEmpty()
                ||txtcustomername.getText().isEmpty()
                ||txtaddress.getText().isEmpty()
                ||txtphonenumber.getText().isEmpty()
                ){
            return false;
        }
        return true;
    }
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
            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddnew;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnshowall;
    private javax.swing.JComboBox<String> cbxclass;
    private javax.swing.JLabel closeButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JTable tbresult;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtcustomerid;
    private javax.swing.JTextField txtcustomername;
    private javax.swing.JTextField txtphonenumber;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btncancel)){
            btnCancelClick();
        }
    }
    
    public void btnCancelClick(){
        new MenuScreen().setVisible(true);
        this.dispose();
    }
    
    public void addSQL(Customer cus){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Motobike_Servicing;user=sa;password=giaan512";
            try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
                String SQL = "INSERT INTO Customer (Customer_ID, Customer_Name, Address, Phone_Number, Class) VALUES (" 
                        + "'" + cus.getCustomerId()+"'" + "," 
                        + "'"+cus.getCustomerName()+"'" + ","
                        + "'"+cus.getAddress()+"'" + "," 
                        + "'"+cus.getPhoneNumber()+"'" + "," 
                        + "'"+cus.getCustomerClass()+"'" + ")";
                System.out.println(SQL);
                stmt.executeQuery(SQL);
            } catch (SQLException e) { 
                System.out.println(e);
            }
    }
    
    public void deleteSQL(String customerId){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Motobike_Servicing;user=sa;password=giaan512";
            try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
                String SQL = "DELETE FROM Customer WHERE Customer_ID =" + "'" + customerId + "'";
                stmt.executeQuery(SQL);
            } catch (SQLException e) { 
            }
    }
    
    public void updateDataIntoTable(){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Motobike_Servicing;user=sa;password=giaan512";
            try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
                String SQL = "Select * FROM Customer";
                ResultSet rs = stmt.executeQuery(SQL);
                DefaultTableModel  tbModel = (DefaultTableModel) tbresult.getModel();
                tbModel.setRowCount(0);
                Object[] rowData = new Object[5];
                
                while(rs.next()){
                    rowData[0] = rs.getString("Customer_ID");
                    rowData[1] = rs.getString("Customer_Name");
                    rowData[2] = rs.getString("Address");
                    rowData[3] = rs.getString("Phone_number");
                    rowData[4] = rs.getString("Class");
                    tbModel.addRow(rowData);
                }
            } catch (SQLException e) { 
                System.out.print(e);
            }
    }
}
