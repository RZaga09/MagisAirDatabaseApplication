/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author InfoNet
 */

public class MainMenu extends javax.swing.JFrame {
    
    Connection dbConnection;

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void setConnection(Connection c) {
        dbConnection = c;
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
        cityButton = new javax.swing.JButton();
        stopoverButton = new javax.swing.JButton();
        flightButton = new javax.swing.JButton();
        passengerButton = new javax.swing.JButton();
        luggageButton = new javax.swing.JButton();
        crewButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        ticketButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MAIN MENU");

        cityButton.setText("CITY");
        cityButton.setName(""); // NOI18N
        cityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityButtonActionPerformed(evt);
            }
        });

        stopoverButton.setText("STOPOVER");
        stopoverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopoverButtonActionPerformed(evt);
            }
        });

        flightButton.setText("FLIGHT");
        flightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightButtonActionPerformed(evt);
            }
        });

        passengerButton.setText("PASSENGER");
        passengerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passengerButtonActionPerformed(evt);
            }
        });

        luggageButton.setText("LUGGAGE");
        luggageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luggageButtonActionPerformed(evt);
            }
        });

        crewButton.setText("CREW");
        crewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crewButtonActionPerformed(evt);
            }
        });

        reportButton.setText("REPORT");
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        ticketButton.setText("TICKET");
        ticketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(stopoverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ticketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(luggageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(flightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(passengerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(crewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopoverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passengerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(luggageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ticketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityButtonActionPerformed

        try {
            CityTableManager tm = new CityTableManager(dbConnection);
            tm.setVisible(true);
            dispose();
        } 
        catch (SQLException e){
            System.out.println("TableManager failed to load.");
        }  
    }//GEN-LAST:event_cityButtonActionPerformed

    private void stopoverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopoverButtonActionPerformed
        try {
            StopoverTableManager tm = new StopoverTableManager(dbConnection);
            tm.setVisible(true);
            dispose();
        } 
        catch (SQLException e){
            System.out.println("TableManager failed to load.");
        }  
    }//GEN-LAST:event_stopoverButtonActionPerformed

    private void flightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightButtonActionPerformed
        try {
            FlightTableManager tm = new FlightTableManager(dbConnection);
            tm.setVisible(true);
            dispose();
        } 
        catch (SQLException e){
            System.out.println("TableManager failed to load.");
        }  
    }//GEN-LAST:event_flightButtonActionPerformed

    private void passengerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passengerButtonActionPerformed
        try {
            PassengerTableManager tm = new PassengerTableManager(dbConnection);
            tm.setVisible(true);
            dispose();
        } 
        catch (SQLException e){
            System.out.println("TableManager failed to load.");
        }  
    }//GEN-LAST:event_passengerButtonActionPerformed

    private void luggageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luggageButtonActionPerformed
        try {
            LuggageTableManager tm = new LuggageTableManager(dbConnection);
            tm.setVisible(true);
            dispose();
        } 
        catch (SQLException e){
            System.out.println("TableManager failed to load.");
        }  
    }//GEN-LAST:event_luggageButtonActionPerformed

    private void crewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crewButtonActionPerformed
        try {
            CrewTableManager tm = new CrewTableManager(dbConnection);
            tm.setVisible(true);
            dispose();
        } 
        catch (SQLException e){
            System.out.println("TableManager failed to load.");
        }  
    }//GEN-LAST:event_crewButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        try {
            BookingReport report = new BookingReport(dbConnection);
            report.setVisible(true);
            this.dispose();
            
        } catch (SQLException e) {
            System.out.println("ReportGenerator failed to load");
        }
    }//GEN-LAST:event_reportButtonActionPerformed

    private void ticketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketButtonActionPerformed
        try {
            TicketTableManager tm = new TicketTableManager(dbConnection);
            tm.setVisible(true);
            dispose();
        } 
        catch (SQLException e){
            System.out.println("TableManager failed to load.");
        } 
    }//GEN-LAST:event_ticketButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cityButton;
    private javax.swing.JButton crewButton;
    private javax.swing.JButton flightButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton luggageButton;
    private javax.swing.JButton passengerButton;
    private javax.swing.JButton reportButton;
    private javax.swing.JButton stopoverButton;
    private javax.swing.JButton ticketButton;
    // End of variables declaration//GEN-END:variables
}
