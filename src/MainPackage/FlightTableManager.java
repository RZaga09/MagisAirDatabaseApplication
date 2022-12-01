package MainPackage;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.text.DateFormat; 
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author InfoNet
 */
public class FlightTableManager extends TableManagerTemplate {

    public FlightTableManager(Connection dbConnection) throws SQLException{
        super(dbConnection);
        tablename = "flight";
        dataInputsCount = 9;
        initComponents();
        getAllRecords();
        id_name = "flight_id";
        fillDropDown();
        setLocationRelativeTo(null);
    }

    @Override
    public void writeRecordsToTable(JTable tbl, ResultSet rs) throws SQLException {
        DefaultTableModel table = (DefaultTableModel)tblRecordsList.getModel();
        table.setRowCount(0);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); 
        //DateTimeFormatter durationFormat = new DateTimeFormatter.ofPattern("HH:mm:ss");


        while(rs.next())
            {
                System.out.println("NEWLINE ");
                String[] row = {
                    String.valueOf(rs.getInt(1)),
                    String.valueOf(rs.getInt(2)),
                    rs.getString(3),
                    String.valueOf(rs.getString(4)),
                    rs.getString(5),
                    dateFormat.format(rs.getDate(6)),
                    timeFormat.format(rs.getTime(7)),
                    String.valueOf(rs.getString(8)),
                    rs.getString(9),
                    
                    dateFormat.format(rs.getDate(10)),
                    timeFormat.format(rs.getTime(11)),
                    String.valueOf(rs.getString(12))
                };
                table.addRow(row);
            }
    }
    
    @Override
    public String setGetAllRecordsQuery() {
        //String query = "SELECT flight.flight_id, flight.origin, origin.city_name, flight.destination, destination.city_name, flight.departure_date, flight.departure_time, flight.stopover_id, flight.total_flight_time, flight.arrival_date, flight.arrival_time, flight.flight_cost FROM flight, city origin, city destination WHERE flight.origin = origin.city_id AND flight.destination = destination.city_id";
        String query = "SELECT flight.flight_id, flight.origin, origin.city_name, flight.destination, destination.city_name, flight.departure_date, flight.departure_time, flight.stopover_id, timediff(Cast(CONCAT(arrival_date, ' ',arrival_time) as datetime), Cast(CONCAT(departure_date, ' ',departure_time) as datetime)), flight.arrival_date, flight.arrival_time, flight.flight_cost FROM flight, city origin, city destination WHERE flight.origin = origin.city_id AND flight.destination = destination.city_id ORDER BY flight.flight_id";
        
        return query;
    }
    
    @Override
    public String setAddQuery(String[] dataInputs) {
        String valuesList = "VALUES(" + dataInputs[0] + ", " + dataInputs[1] + ", " + dataInputs[2] + ", " + dataInputs[3] + ", " + dataInputs[4] + ", " + dataInputs[5] + ", " + dataInputs[6] + ", " + dataInputs[7] + ", " + dataInputs[8] + ")";
        String query = "INSERT INTO " + tablename + " " + valuesList + ";";
        return query;
    }
    
    @Override
    public String setUpdateQuery(String[] dataInputs) {
        String query = "UPDATE " + tablename + " SET flight_id = " + dataInputs[0]
                + ", origin = " + dataInputs[1]
                + ", destination = " + dataInputs[2]
                + ", departure_date = " + dataInputs[3]
                + ", departure_time = " + dataInputs[4]
                + ", stopover_id = " + dataInputs[5]
                + ", arrival_date = " + dataInputs[6]
                + ", arrival_time = " + dataInputs[7]
                + ", flight_cost = " + dataInputs[8]
                + " WHERE flight_id = " + Integer.parseInt(dataInputs[0]);
        return query;
    }
    
    @Override
    public String[] getFormData() {
        /*
        dataInputs[0] city_id
        dataInputs[1] city_name
        */
        
        String[] dataInputs = new String[dataInputsCount];
        dataInputs[0] = txtID.getText();
        dataInputs[1] = (String)txtOrigin.getSelectedItem();
        dataInputs[2] = (String)txtDestination.getSelectedItem();
        dataInputs[3] = '\u0022' + txtDepDate.getText() + '\u0022';
        dataInputs[4] = '\u0022' + txtDepTime.getText() + '\u0022';
        dataInputs[5] = (String)txtStopover.getSelectedItem();
        dataInputs[6] = '\u0022' + txtArrDate.getText() + '\u0022';
        dataInputs[7] = '\u0022' + txtArrTime.getText() + '\u0022';
        dataInputs[8] = txtCost.getText();
        
        return dataInputs;
    }
    
    public void displayRecord(ResultSet result) throws SQLException{
        result.next();
        txtID.setText(String.valueOf(result.getInt(1)));
        txtOrigin.setSelectedItem(String.valueOf(result.getString(2)));
        txtDestination.setSelectedItem(String.valueOf(result.getString(3)));
        txtDepDate.setText(result.getString(4));
        txtDepTime.setText(result.getString(5));
        txtStopover.setSelectedItem(result.getString(6));
        txtArrDate.setText(result.getString(7));
        txtArrTime.setText(result.getString(8));
        txtCost.setText(String.valueOf(result.getInt(9)));
    }
    
    private void fillDropDown() throws SQLException {
        String query = "SELECT city_id from city ORDER BY city_id";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()) {
            txtOrigin.addItem(rs.getString("city_id"));
            txtDestination.addItem(rs.getString("city_id"));
        }
        
        query = "SELECT stopover_id from stopover ORDER BY stopover_id";
        statement = dbConnection.createStatement();
        rs = statement.executeQuery(query);
        
        while(rs.next()) {
            txtStopover.addItem(rs.getString("stopover_id"));
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
        txtID = new javax.swing.JTextField();
        btnGetRecord = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDepDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtDepTime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtArrDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtArrTime = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        txtOrigin = new javax.swing.JComboBox<>();
        txtDestination = new javax.swing.JComboBox<>();
        txtStopover = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setText("Origin CIty ID");

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
                "Flight ID", "Origin ID", "Origin City", "Destination ID", "Destination Name", "Departure Date", "Departure Time", "Stopover ID", "Flight Time", "Arrival Date", "Arrival Time", "Cost (Pesos)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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

        txtID.setText("1234");

        btnGetRecord.setText("GET RECORD");
        btnGetRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetRecordActionPerformed(evt);
            }
        });

        jLabel1.setText("Flight ID");

        jLabel3.setText("Destination City ID");

        txtDepDate.setText("2022-01-01");

        jLabel4.setText("Departure (yyyy-mm-dd)");

        mainMenu.setText("Back to Main Menu");
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });

        jLabel5.setText("Departure Time (hh:mm:ss)");

        txtDepTime.setText("01:00:00");

        jLabel6.setText("Stopover ID");

        jLabel8.setText("Arrival Date");

        txtArrDate.setText("2022-01-01");

        jLabel9.setText("Arrival Time");

        txtArrTime.setText("23:59:59");

        jLabel10.setText("Flight Cost");

        txtCost.setText("10000");

        txtStopover.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mainMenu)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDepDate, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDepTime, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(496, 496, 496)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(53, 53, 53)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                            .addComponent(txtDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtStopover, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtArrDate, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGetRecord)
                            .addComponent(btnAddRecord)
                            .addComponent(btnUpdateRecord)
                            .addComponent(btnDeleteRecord))
                        .addGap(160, 160, 160))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDepDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDepTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtStopover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnGetRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtArrDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainMenu;
    private javax.swing.JTable tblRecordsList;
    private javax.swing.JTextField txtArrDate;
    private javax.swing.JTextField txtArrTime;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtDepDate;
    private javax.swing.JTextField txtDepTime;
    private javax.swing.JComboBox<String> txtDestination;
    private javax.swing.JTextField txtID;
    private javax.swing.JComboBox<String> txtOrigin;
    private javax.swing.JComboBox<String> txtStopover;
    // End of variables declaration//GEN-END:variables
}
