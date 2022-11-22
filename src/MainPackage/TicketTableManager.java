/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MainPackage;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.text.DateFormat; 
import java.text.SimpleDateFormat;  
/**
 *
 * @author Rac Elizaga
 * @author Ray Rafael Abenido
 */
public class TicketTableManager extends TableManagerTemplate {

    public TicketTableManager(Connection dbConnection) throws SQLException{
        super(dbConnection);
        tablename = "flight_ticket";
        dataInputsCount = 3;
        initComponents();
        getAllRecords();
        id_name = "ticket_id";
        fillDropDown();
    }

    @Override
    public void writeRecordsToTable(JTable tbl, ResultSet rs) throws SQLException {
        DefaultTableModel table = (DefaultTableModel)tblRecordsList.getModel();
        table.setRowCount(0);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); 
        while(rs.next())
            {
                String[] row = {
                    String.valueOf(rs.getInt(1)),
                    String.valueOf(rs.getInt(2)),
                    rs.getString(3),
                    String.valueOf(rs.getInt(4)),
                    rs.getString(5),
                    rs.getString(6),
                    dateFormat.format(rs.getDate(7)),
                    timeFormat.format(rs.getTime(8)),
                    
                };
                table.addRow(row);
            }
    }
    
    @Override
    public String setGetAllRecordsQuery() {
        String query = "select t.ticket_id, t.passenger_id, CONCAT(p.first_name , ' ' , p.middle_initial, ' ' , p.last_name), t.flight_id, c.city_name, d.city_name, f.departure_date, f.departure_time from flight_ticket t, passenger p, flight f, city c, city d where t.passenger_id = p.passenger_id and t.flight_id = f.flight_id and f.origin = c.city_id and f.destination = d.city_id order by t.ticket_id";
        return query;
    }
    
    @Override
    public String setAddQuery(String[] dataInputs) {
        String valuesList = "VALUES(" + dataInputs[0] + ", " + dataInputs[1] + ", " + dataInputs[2] + ")";
        String query = "INSERT INTO " + tablename + " " + valuesList + ";";
        return query;
    }
    
    @Override
    public String setUpdateQuery(String[] dataInputs) {
        String query = "UPDATE " + tablename + " SET ticket_id = " + dataInputs[0]
                + ", passenger_id = " + dataInputs[1]
                + ", flight_id = " + dataInputs[2]
                + " WHERE ticket_id = " + Integer.parseInt(dataInputs[0]);
        return query;
    }
    
    @Override
    public String[] getFormData() {
        /*
        dataInputs[0] ticket_id
        dataInputs[1] passenger_id
        dataInputs[2] flight_id
        */
        
        String[] dataInputs = new String[dataInputsCount];
        dataInputs[0] = txtID.getText();
        dataInputs[1] = (String)txtPassenger.getSelectedItem();
        dataInputs[2] = (String)txtFlight.getSelectedItem();
        
        return dataInputs;
    }
    
    @Override
    public void displayRecord(ResultSet result) throws SQLException
    {
        result.next();
        txtID.setText(String.valueOf(result.getInt(1)));
        txtPassenger.setSelectedItem(String.valueOf(result.getInt(2)));
        txtFlight.setSelectedItem(String.valueOf(result.getInt(3)));
    }
    
    private void fillDropDown() throws SQLException {
        String query = "SELECT flight_id from flight ORDER BY flight_id";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()) {
            txtFlight.addItem(rs.getString("flight_id"));
        }
        
        query = "SELECT passenger_id from passenger ORDER BY passenger_id";
        statement = dbConnection.createStatement();
        rs = statement.executeQuery(query);
        
        while(rs.next()) {
            txtPassenger.addItem(rs.getString("passenger_id"));
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnAddRecord = new javax.swing.JButton();
        btnDeleteRecord = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecordsList = new javax.swing.JTable();
        btnUpdateRecord = new javax.swing.JButton();
        btnGetRecord = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JButton();
        txtFlight = new javax.swing.JComboBox<>();
        txtPassenger = new javax.swing.JComboBox<>();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Flight ID");

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

        tblRecordsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ticket ID", "Passenger ID", "Name", "Flight ID", "Origin", "Destination", "Date", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRecordsList);

        btnUpdateRecord.setText("UPDATE RECORD");
        btnUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRecordActionPerformed(evt);
            }
        });

        btnGetRecord.setText("GET RECORD");
        btnGetRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetRecordActionPerformed(evt);
            }
        });

        jLabel1.setText("Passenger ID");

        mainMenu.setText("Back to Main Menu");
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });

        txtID.setText("1111");

        jLabel3.setText("Ticket ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteRecord)
                            .addComponent(btnAddRecord)
                            .addComponent(btnUpdateRecord)
                            .addComponent(btnGetRecord)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mainMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(38, 38, 38)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFlight, 0, 144, Short.MAX_VALUE)
                            .addComponent(txtPassenger, 0, 144, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainMenu)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGetRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteRecord)
                        .addGap(45, 45, 45))))
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

    private void btnDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRecordActionPerformed
        try {
            deleteRecord();
        } catch (SQLException e) {
            System.out.println("Delete record failed");
        }
    }//GEN-LAST:event_btnDeleteRecordActionPerformed

    private void btnUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRecordActionPerformed
        try {
            updateRecord();
        } catch (SQLException e)
        {
            System.out.println("Update record failed");
        }
    }//GEN-LAST:event_btnUpdateRecordActionPerformed

    private void btnGetRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetRecordActionPerformed
        // TODO add your handling code here:
        try{
            getRecord();
        }
        catch(SQLException e){
            System.out.println("Failed to get record.");
        }
    }//GEN-LAST:event_btnGetRecordActionPerformed

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        MainMenu tm = new MainMenu();
        tm.dbConnection = this.dbConnection;
        tm.setVisible(true);
        dispose();
    }//GEN-LAST:event_mainMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRecord;
    private javax.swing.JButton btnDeleteRecord;
    private javax.swing.JButton btnGetRecord;
    private javax.swing.JButton btnUpdateRecord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainMenu;
    private javax.swing.JTable tblRecordsList;
    private javax.swing.JComboBox<String> txtFlight;
    private javax.swing.JTextField txtID;
    private javax.swing.JComboBox<String> txtPassenger;
    // End of variables declaration//GEN-END:variables
}
