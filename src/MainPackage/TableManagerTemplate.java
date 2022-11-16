package MainPackage;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p> {@code TableManagerTemplate} provides a flexible template for other classes
 * to use to perform CRUD operations (create, return, update, delete) on a table.
 * 
 * 
 * <p> Designed so the functions in this class can be easily modified to perform
 * CRUD operations other tables.
 * 
 * @since 1.0
 * @version 1.0
 * @author Ray Rafael Abenido
 */

public class TableManagerTemplate extends javax.swing.JFrame {

    // DO NOT FORGET TO MODIFY THESE VARIABLES BEFORE MODIFYING THE REST OF THE
    // PROGRAM
    Connection dbConnection;
    String tablename = "author"; //table being managed
    int dataInputsCount = 4; //how many inputs there are in the form
   

    /**
     * Creates a TableManagerTemplate instance
     */   
    public TableManagerTemplate(Connection dbConnection) throws SQLException {
        initComponents();
        this.dbConnection = dbConnection;
    }
    
     /**
     * A convenience method that packs the data typed into the manager as a single
     * {@code String[]} to both abstract and handle data retrieval. Should be called
     * before every CRUD operation to handle data input prior to execution.
     * 
     * @returns String[] holding the information inputted.
     */
    public String[] getFormData() {
        /*
        dataInputs[0] authorid
        dataInputs[1] firstName
        dataInputs[2] lastName
        dataInputs[3] address
        */
        
        String[] dataInputs = new String[dataInputsCount];
        dataInputs[0] = txtID.getText();
        dataInputs[1] = '\u0022' + txtFirstName.getText() + '\u0022';
        dataInputs[2] = '\u0022' + txtLastName.getText() + '\u0022';
        dataInputs[3] = '\u0022' + txtAddress.getText() + '\u0022';
        return dataInputs;
    }
    
    /**
     * Attempts to add a record to the table this {@code TableManagerTemplate}
     * instance manages.
     * 
     * @throws SQLException if the record was not added to the database.
     */
    
    public void addRecord()throws SQLException{
        try {
            String[] dataInputs = getFormData();
            String valuesList = "VALUES(" + dataInputs[1] + ", " + dataInputs[2]
                    + ", " + dataInputs[3] + ")";
            String query = "INSERT INTO " + tablename + "(firstname, lastname, "
                    + "address) " + valuesList + ";";
            System.out.println("QUERY GENERATED: " + query);
            Statement statement = dbConnection.createStatement();
            int temp = statement.executeUpdate(query);
            System.out.println("Record added successfully");
        }
        catch (SQLException e) {
            System.out.println("Failed to add record");
        }
    }
    
    public void getAllRecords(){
        
    }
    /**
     * Attempts to retrieve a record with a specific primary key on the table.
     * 
     * @throws SQLException if record retrieval failed.
     */
    public void getRecord() throws SQLException {
        try {
            String[] dataInputs = getFormData();
            String query = "SELECT * FROM " + tablename + " WHERE authorid = "
                    + dataInputs[0];
            Statement statement = dbConnection.createStatement();
            ResultSet record = statement.executeQuery(query);
            System.out.println("QUERY GENERATED: " + query);
            record.next(); //pointer isn't pointed at first row so next() is needed
            txtID.setText(String.valueOf(record.getInt(1)));
            txtFirstName.setText(record.getString(2));
            txtLastName.setText(record.getString(3));
            txtAddress.setText(record.getString(4));
            System.out.println("Record succesfully retrieved.");
            
        } catch (SQLException e){
            System.out.println("Failed to retrieve record.");
        }
    }
    
    /**
     * Attempts to update a record with a specific given primary key on the table.
     * 
     * @throws SQLException if attempt to update failed
     */
    
    public void updateRecord()throws SQLException {
        try {
            String[] dataInputs = getFormData();
            String query = "UPDATE " + tablename + " SET firstname = " + dataInputs[1]
                + ", lastname = " + dataInputs[2] + ", address = "  + dataInputs[3]
                + " WHERE authorid = " + Integer.parseInt(dataInputs[0]);
            System.out.println("QUERY GENERATED: " + query);
            Statement statement = dbConnection.createStatement();
            int temp = statement.executeUpdate(query);
            System.out.println("Record updated."); 
        }
        catch (SQLException e){
            System.out.println("Record update failed.");
        }
    }
    
    /**
     * Attempts to delete a record with a specific primary key on the table.
     * 
     * @throws SQLException if attempt to delete failed. It's most likely this
     * error is caused by the primary key of the record being deleted is the
     * primary key of some record in another table.
     */
    
    public void deleteRecord() throws SQLException {
        try {
            String[] dataInputs = getFormData();
            String query = "DELETE FROM "  + tablename + " WHERE authorid = " + 
                    dataInputs[0];
            System.out.println("QUERY GENERATED: " + query);
            Statement statement = dbConnection.createStatement();
            int temp = statement.executeUpdate(query);
            System.out.println("Delete record successful");
        } catch (SQLException e) {
            System.out.println("Delete record failed.");
        }
        
    }

    
    /**
     * Generates the GUI components of {@code DatabaseManager.java}. NetBeans
     * auto-generates this function so this can be safely ignored.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAddRecord = new javax.swing.JButton();
        btnDeleteRecord = new javax.swing.JButton();
        btnUpdateRecord = new javax.swing.JButton();
        createReport = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnGetRecord = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        txtLastName.setText("jTextField1");

        txtFirstName.setText("jTextField1");

        txtAddress.setText("jTextField1");

        jLabel1.setText("ID");

        jLabel2.setText("FirstName");

        jLabel3.setText("LastName");

        jLabel4.setText("Address");

        btnAddRecord.setText("ADD RECORD");
        btnAddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecordActionPerformed(evt);
            }
        });

        btnDeleteRecord.setText("DELETE RECORD");
        btnDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRecordActionPerformed(evt);
            }
        });

        btnUpdateRecord.setText("UPDATE RECORD");
        btnUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRecordActionPerformed(evt);
            }
        });

        createReport.setText("CREATE REPORT");
        createReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createReportActionPerformed(evt);
            }
        });

        txtID.setText("jTextField1");

        btnGetRecord.setText("GET RECORD");
        btnGetRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtID)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteRecord)
                            .addComponent(btnAddRecord)
                            .addComponent(btnUpdateRecord)
                            .addComponent(createReport)
                            .addComponent(btnGetRecord))))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)
                        .addComponent(btnGetRecord)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddRecord)
                        .addGap(12, 12, 12)
                        .addComponent(btnUpdateRecord)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteRecord)
                        .addGap(18, 18, 18)
                        .addComponent(createReport))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecordActionPerformed
        try{
            addRecord();
        }
        catch (Exception e) {
            System.out.println("Failed to add record.");
        }
    }//GEN-LAST:event_btnAddRecordActionPerformed

    private void createReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createReportActionPerformed
        try {
            openSampleReportGenerator();
        } catch (SQLException ex) {
            Logger.getLogger(TableManagerTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createReportActionPerformed

    private void btnUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRecordActionPerformed
        try {
            updateRecord();
        } catch (SQLException e)
            {
                System.out.println("Update record failed");
            }
    }//GEN-LAST:event_btnUpdateRecordActionPerformed

    private void btnDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRecordActionPerformed
        try {
            deleteRecord();
        } catch (SQLException e) {
            System.out.println("Delete record failed");
        }
    }//GEN-LAST:event_btnDeleteRecordActionPerformed

    private void btnGetRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetRecordActionPerformed
        // TODO add your handling code here:
        try{
            getRecord();
        }
        catch(SQLException e){
            System.out.println("Failed to get record.");
        }
    }//GEN-LAST:event_btnGetRecordActionPerformed

    public void openSampleReportGenerator() throws SQLException {
        SampleReportGenerator sp = new SampleReportGenerator(dbConnection);
        sp.setVisible(true);
        dispose();    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRecord;
    private javax.swing.JButton btnDeleteRecord;
    private javax.swing.JButton btnGetRecord;
    private javax.swing.JButton btnUpdateRecord;
    private javax.swing.JButton createReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables
}
