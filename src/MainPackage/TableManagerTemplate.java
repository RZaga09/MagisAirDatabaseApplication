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
        dataInputs[0] id
        dataInputs[1] firstName
        dataInputs[2] lastName
        dataInputs[3] address
        */
        
        String[] dataInputs = new String[dataInputsCount];
        dataInputs[0] = '\u0022' + lblID.getText() + '\u0022';
        dataInputs[1] = '\u0022' + txtFirstName.getText() + '\u0022';
        dataInputs[2] = '\u0022' + txtLastName.getText() + '\u0022';
        dataInputs[3] = '\u0022' + txtAddress.getText() + '\u0022';
        return dataInputs;
    }
    
    /**
     * Adds a record to the table this {@code TableManagerTemplate} manages
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
            System.out.println(query);
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
    
    public void getspecificRecord(){
        
    }
    
    public void updateRecord(){
        
    }
    
    public void deleteRecord(){
        
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
        lblID = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        createReport = new javax.swing.JButton();

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

        lblID.setText("##########");

        jButton1.setText("ADD RECORD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("DELETE RECORD");

        jButton3.setText("UPDATE RECORD");

        createReport.setText("CREATE REPORT");
        createReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createReportActionPerformed(evt);
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
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(createReport))))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblID))
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
                        .addGap(40, 40, 40)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(createReport)
                        .addGap(45, 45, 45))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            addRecord();
        }
        catch (Exception e) {
            System.out.println("Failed to add record.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void createReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createReportActionPerformed
        try {
            openSampleReportGenerator();
        } catch (SQLException ex) {
            Logger.getLogger(TableManagerTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createReportActionPerformed

    public void openSampleReportGenerator() throws SQLException {
        SampleReportGenerator sp = new SampleReportGenerator(dbConnection);
        sp.setVisible(true);
        dispose();    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createReport;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblID;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables
}
