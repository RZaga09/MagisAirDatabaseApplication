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
public class BookingReport extends TableManagerTemplate {
    
    int totalCost = 0;

    public BookingReport(Connection dbConnection) throws SQLException{
        super(dbConnection);
        tablename = "stopover";
        dataInputsCount = 4;
        initComponents();
        fillDropDown();
        getAllRecords();
        id_name = "stopover_id";
        
    }

    @Override
    public void getAllRecords()throws SQLException {
        try{
            String id = (String)txtPassenger.getSelectedItem();
            
            String passengerQuery = setGetPassengerRecordsQuery(id);
            Statement statement = dbConnection.createStatement();
            ResultSet recordsList = statement.executeQuery(passengerQuery);
            
            writePassengerData(recordsList);
            
            String flightQuery = setGetFlightRecordsQuery(id);
            statement = dbConnection.createStatement();
            recordsList = statement.executeQuery(flightQuery);
            
            writeFlightData(recordsList);
            
            String luggageQuery = setGetLuggageRecordsQuery(id);
            statement = dbConnection.createStatement();
            recordsList = statement.executeQuery(luggageQuery);
            
            writeLuggageData(recordsList);
            
            labelCost.setText("Php " + String.valueOf(totalCost));
            totalCost = 0;
            
            System.out.println("Records from data base retrieved.");
        } catch (SQLException e){
            System.out.println("Failed to get records from table at getAllRecords().");
        }
    }
    
    public String setGetFlightRecordsQuery(String id) {
        String query = "select t.flight_id, c.city_name, d.city_name, CONCAT(f.departure_date, ' ', f.departure_time), CONCAT(f.arrival_date, ' ', f.arrival_time),  timediff(Cast(CONCAT(arrival_date, ' ',arrival_time) as datetime), Cast(CONCAT(departure_date, ' ',departure_time) as datetime)), f.flight_cost from flight f, city c, city d, passenger p, flight_ticket t where t.flight_id = f.flight_id and t.passenger_id = p.passenger_id and f.origin = c.city_id and f.destination = d.city_id and p.passenger_id = " + id;
        return query;
    }
    
    public String setGetPassengerRecordsQuery(String id) {
        String query = "select CONCAT(' ', last_name, ', ', first_name, ' ', middle_initial), date_booked, birthday, gender from passenger where passenger_id = " + id;
        return query;
    }
    
    public String setGetLuggageRecordsQuery(String id) {
        String query = "select l.description, l.qty, l.luggage_cost from luggage l, passenger p where l.passenger_id = p.passenger_id  and p.passenger_id = " + id;
        return query;
    }
    
    public void writePassengerData(ResultSet rs) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); 
        while(rs.next())
            {
                labelPassenger.setText(rs.getString(1));
                labelDate.setText(dateFormat.format(rs.getDate(2)));
                labelBirthday.setText(dateFormat.format(rs.getDate(3)));
                labelGender.setText(rs.getString(4));
            }
    }
    
    public void writeFlightData(ResultSet rs) throws SQLException {
        DefaultTableModel table = (DefaultTableModel)tblFlights.getModel();
        table.setRowCount(0);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        while(rs.next())
            {
                String[] row = {
                    String.valueOf(rs.getInt(1)),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    "Php " + String.valueOf(rs.getInt(7)),
                    
                };
                totalCost += rs.getInt(7);
                table.addRow(row);
            }
    }
    
    public void writeLuggageData(ResultSet rs) throws SQLException {
        DefaultTableModel table = (DefaultTableModel)tblItems.getModel();
        table.setRowCount(0);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        while(rs.next())
            {
                String[] row = {
                    rs.getString(1),
                    String.valueOf(rs.getInt(2)),
                    "Php " + String.valueOf(rs.getInt(3)),
                    
                };
                totalCost += rs.getInt(3);
                table.addRow(row);
            }
    } 
    
    private void fillDropDown() throws SQLException {
        String query = "SELECT passenger_id from passenger ORDER BY passenger_id";
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        
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

        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFlights = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JButton();
        txtPassenger = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelPassenger = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        labelBirthday = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelGender = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelCost = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight", "Origin", "Destination", "Departure", "Arrival", "Duration", "Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFlights);

        jLabel4.setText("Passenger ID");

        mainMenu.setText("Back to Main Menu");
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });

        txtPassenger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassengerActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ADDITIONAL ITEMS");

        jLabel1.setText("Passenger:");

        labelPassenger.setText("Jensen, Jimmy J.");

        jLabel2.setText("Date:");

        labelDate.setText("2022-01-01");

        labelBirthday.setText("2022-01-01");

        jLabel3.setText("Birthdate:");

        labelGender.setText("Male");

        jLabel6.setText("Gender");

        labelCost.setText("Php 122");

        jLabel7.setText("Total Cost:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("FLIGHT BOOKING");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TRIP ITINERARY");

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "Quantity", "Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblItems);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mainMenu)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelGender, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCost, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainMenu)
                    .addComponent(jLabel4)
                    .addComponent(txtPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelPassenger)
                    .addComponent(jLabel2)
                    .addComponent(labelDate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelBirthday)
                    .addComponent(jLabel6)
                    .addComponent(labelGender)
                    .addComponent(jLabel7)
                    .addComponent(labelCost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        MainMenu tm = new MainMenu();
        tm.dbConnection = this.dbConnection;
        tm.setVisible(true);
        dispose();
    }//GEN-LAST:event_mainMenuActionPerformed

    private void txtPassengerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassengerActionPerformed
        try {
            getAllRecords();
        } catch (SQLException ex) {
            Logger.getLogger(BookingReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPassengerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBirthday;
    private javax.swing.JLabel labelCost;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelPassenger;
    private javax.swing.JButton mainMenu;
    private javax.swing.JTable tblFlights;
    private javax.swing.JTable tblItems;
    private javax.swing.JComboBox<String> txtPassenger;
    // End of variables declaration//GEN-END:variables
}
