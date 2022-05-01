/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.finalproject.ui;

import com.finalproject.model.BusinessVehicle;
import com.finalproject.model.BusinessVehicleStatusType;
import com.finalproject.model.BusinessVehicleType;
import com.finalproject.model.PermissionType;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class VehicleJPanel extends javax.swing.JPanel {
    MainJFrame jFrame;
    BusinessVehicle vehicle;
    /**
     * Creates new form orderJPanel
     */
    public VehicleJPanel(MainJFrame jFrame) {
        initComponents();
        this.jFrame = jFrame;

        String className = "Vehicle";
        if (!jFrame.getUser().hasPermission(className, PermissionType.EDIT)) {
            vehicleModifyjButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.CREATE)) {
            vehicleCreatejButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.VIEW)) {
            vehicleViewjButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.DELETE)) {
            vehicleDeletejButton.setEnabled(false);
        }
    }

    public final void displayVehicle() {
        if (vehicle == null) {
            vehicleTypejComboBox.removeAllItems();
            statusjComboBox.removeAllItems();
		    for (BusinessVehicleType v: BusinessVehicleType.values()) {
				vehicleTypejComboBox.addItem(v);
		    }
            for (BusinessVehicleStatusType ts: BusinessVehicleStatusType.values()) {
                statusjComboBox.addItem(ts);
            }
		    createDatePicker.clear();
		    updateDatePicker.clear();
        } else {
            vehicle.refresh();
            vehicleTypejComboBox.setSelectedItem(vehicle.getVehicleType());
            createDatePicker.setDateTimeStrict(vehicle.getCreateDate());
            updateDatePicker.setDateTimeStrict(vehicle.getUpdateDate());
            statusjComboBox.setSelectedItem(vehicle.getVehicleStatusType());
        }
    }
    
    public final void displayVehicleList() {
        DefaultTableModel model = (DefaultTableModel) orderjTable.getModel();
        model.setRowCount(0);
        
        for (BusinessVehicle current: BusinessVehicle.find(BusinessVehicle.class)) {
            Object[] row = new Object[5];
            row[0] = current.getId();
            row[1] = current.getVehicleType();
            row[2] = current.getCreateDate();
            row[3] = current.getUpdateDate();
            row[4] = current.getVehicleStatusType();
            
            model.addRow(row);
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

        vehicleTypejComboBox = new javax.swing.JComboBox<>();
        buttonjPanel2 = new javax.swing.JPanel();
        vehicleModifyjButton = new javax.swing.JButton();
        vehicleDeletejButton = new javax.swing.JButton();
        vehicleCreatejButton = new javax.swing.JButton();
        vehicleViewjButton = new javax.swing.JButton();
        createDatePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        passwordjLabel1 = new javax.swing.JLabel();
        updateDatePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        statusjComboBox = new javax.swing.JComboBox<>();
        passwordjLabel = new javax.swing.JLabel();
        userRolesjLabel = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        orderjTable = new javax.swing.JTable();
        vehicleTypejLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 237, 231));

        buttonjPanel2.setBackground(new java.awt.Color(242, 237, 231));

        vehicleModifyjButton.setText("Modify");
        vehicleModifyjButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        vehicleModifyjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleModifyjButtonActionPerformed(evt);
            }
        });

        vehicleDeletejButton.setText("Delete");
        vehicleDeletejButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        vehicleDeletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleDeletejButtonActionPerformed(evt);
            }
        });

        vehicleCreatejButton.setText("Create");
        vehicleCreatejButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        vehicleCreatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleCreatejButtonActionPerformed(evt);
            }
        });

        vehicleViewjButton.setText("View");
        vehicleViewjButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        vehicleViewjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleViewjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonjPanel2Layout = new javax.swing.GroupLayout(buttonjPanel2);
        buttonjPanel2.setLayout(buttonjPanel2Layout);
        buttonjPanel2Layout.setHorizontalGroup(
            buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonjPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vehicleModifyjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vehicleDeletejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vehicleCreatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vehicleViewjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        buttonjPanel2Layout.setVerticalGroup(
            buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonjPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehicleModifyjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehicleDeletejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehicleCreatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehicleViewjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        createDatePicker.setEnabled(false);

        passwordjLabel1.setText("Update Date");
        passwordjLabel1.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        updateDatePicker.setEnabled(false);

        passwordjLabel.setText("Create Date");
        passwordjLabel.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        userRolesjLabel.setText("Status");
        userRolesjLabel.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        orderjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Vehicle Type", "Create Date", "Update Date", "Status"
            }
        ));
        jScrollPane11.setViewportView(orderjTable);

        vehicleTypejLabel.setText("Vehicle Type");
        vehicleTypejLabel.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordjLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordjLabel)
                                    .addComponent(userRolesjLabel)
                                    .addComponent(vehicleTypejLabel))
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(createDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vehicleTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(buttonjPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehicleTypejLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vehicleTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordjLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userRolesjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonjPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void vehicleModifyjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleModifyjButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = orderjTable.getSelectedRow();

        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) orderjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        vehicle = BusinessVehicle.findById(BusinessVehicle.class, id);

        try {
            vehicle.setVehicleType((BusinessVehicleType)vehicleTypejComboBox.getSelectedItem());
            vehicle.setCreateDate(createDatePicker.getDateTimeStrict());
            vehicle.setUpdateDate(updateDatePicker.getDateTimeStrict());
            vehicle.setVehicleStatusType((BusinessVehicleStatusType)statusjComboBox.getSelectedItem());

            vehicle.flush();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Modify error: " + e.getMessage());
            return;
        }
        JOptionPane.showMessageDialog(this, "Modify done");
        vehicle = null;
        displayVehicle();
        displayVehicleList();
    }//GEN-LAST:event_vehicleModifyjButtonActionPerformed

    private void vehicleDeletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleDeletejButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = orderjTable.getSelectedRow();

        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) orderjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        vehicle = BusinessVehicle.findById(BusinessVehicle.class, id);
        vehicle.delete();
        model.removeRow(selectedIndex);
        vehicle = null;
        displayVehicle();
        displayVehicleList();
    }//GEN-LAST:event_vehicleDeletejButtonActionPerformed

    private void vehicleCreatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleCreatejButtonActionPerformed
        // TODO add your handling code here:
        BusinessVehicle bo = new BusinessVehicle();
        try {
            bo.setVehicleType((BusinessVehicleType)vehicleTypejComboBox.getSelectedItem());
            bo.setCreateDate(createDatePicker.getDateTimeStrict());
            bo.setUpdateDate(updateDatePicker.getDateTimeStrict());
            bo.setVehicleStatusType((BusinessVehicleStatusType)statusjComboBox.getSelectedItem());

            bo.save();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Save error: " + e.getMessage());
            return;
        }
        JOptionPane.showMessageDialog(this, "Save done");
        bo = null;
        displayVehicle();
        vehicle = bo;
        displayVehicleList();
    }//GEN-LAST:event_vehicleCreatejButtonActionPerformed

    private void vehicleViewjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleViewjButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = orderjTable.getSelectedRow();

        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) orderjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        vehicle = BusinessVehicle.findById(BusinessVehicle.class, id);
        displayVehicle();
    }//GEN-LAST:event_vehicleViewjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonjPanel2;
    private com.github.lgooddatepicker.components.DateTimePicker createDatePicker;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTable orderjTable;
    private javax.swing.JLabel passwordjLabel;
    private javax.swing.JLabel passwordjLabel1;
    private javax.swing.JComboBox<BusinessVehicleStatusType> statusjComboBox;
    private com.github.lgooddatepicker.components.DateTimePicker updateDatePicker;
    private javax.swing.JLabel userRolesjLabel;
    private javax.swing.JButton vehicleCreatejButton;
    private javax.swing.JButton vehicleDeletejButton;
    private javax.swing.JButton vehicleModifyjButton;
    private javax.swing.JComboBox<BusinessVehicleType> vehicleTypejComboBox;
    private javax.swing.JLabel vehicleTypejLabel;
    private javax.swing.JButton vehicleViewjButton;
    // End of variables declaration//GEN-END:variables
}
