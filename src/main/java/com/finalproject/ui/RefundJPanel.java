/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.finalproject.ui;

import com.finalproject.model.BusinessOrder;
import com.finalproject.model.BusinessOrderStatusType;
import com.finalproject.model.BusinessRefundOrder;
import com.finalproject.model.BusinessRefundOrderStatusType;
import com.finalproject.model.PermissionType;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class RefundJPanel extends javax.swing.JPanel {
    MainJFrame jFrame;
    BusinessRefundOrder refund;
    /**
     * Creates new form orderJPanel
     */
    public RefundJPanel(MainJFrame jFrame) {
        initComponents();
        this.jFrame = jFrame;

        String className = "RefundOrder";
        if (!jFrame.getUser().hasPermission(className, PermissionType.EDIT)) {
            refundModifyjButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.CREATE)) {
            refundCreatejButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.VIEW)) {
            refundViewjButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.DELETE)) {
            refundDeletejButton.setEnabled(false);
        }
    }

    public final void displayRefundOrder() {
        if (refund == null) {
            orderjComboBox.removeAllItems();
            statusjComboBox.removeAllItems();
		    for (BusinessOrder order: BusinessOrder.find("Digital Platform")) {
				orderjComboBox.addItem(order);
		    }
            for (BusinessRefundOrderStatusType ts: BusinessRefundOrderStatusType.values()) {
                statusjComboBox.addItem(ts);
            }
		    createDatePicker.clear();
		    updateDatePicker.clear();
            amountjTextField.setText("");
        } else {
            refund.refresh();
            orderjComboBox.setSelectedItem(refund.getOrder());
            createDatePicker.setDateTimeStrict(refund.getCreateDate());
            updateDatePicker.setDateTimeStrict(refund.getUpdateDate());
            statusjComboBox.setSelectedItem(refund.getBusinessRefundOrderStatusType());
            amountjTextField.setText(String.valueOf(refund.getAmount() / 100.0));
        }
    }
    
    public final void displayRefundOrderList() {
        DefaultTableModel model = (DefaultTableModel) refundjTable.getModel();
        model.setRowCount(0);
        
        for (BusinessRefundOrder current: BusinessRefundOrder.find(BusinessRefundOrder.class)) {
            Object[] row = new Object[6];
            row[0] = current.getId();
            row[1] = current.getOrder();
            row[2] = current.getCreateDate();
            row[3] = current.getUpdateDate();
            row[4] = current.getBusinessRefundOrderStatusType();
            row[5] = current.getAmount() / 100.0;
            
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

        orderjComboBox = new javax.swing.JComboBox<>();
        buttonjPanel2 = new javax.swing.JPanel();
        refundModifyjButton = new javax.swing.JButton();
        refundDeletejButton = new javax.swing.JButton();
        refundCreatejButton = new javax.swing.JButton();
        refundViewjButton = new javax.swing.JButton();
        createDatePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        passwordjLabel1 = new javax.swing.JLabel();
        updateDatePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        statusjComboBox = new javax.swing.JComboBox<>();
        passwordjLabel = new javax.swing.JLabel();
        userRolesjLabel = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        refundjTable = new javax.swing.JTable();
        orderjLabel = new javax.swing.JLabel();
        amountjLabel = new javax.swing.JLabel();
        amountjTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(242, 237, 231));

        buttonjPanel2.setBackground(new java.awt.Color(242, 237, 231));

        refundModifyjButton.setText("modify");
        refundModifyjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundModifyjButtonActionPerformed(evt);
            }
        });

        refundDeletejButton.setText("delete");
        refundDeletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundDeletejButtonActionPerformed(evt);
            }
        });

        refundCreatejButton.setText("create");
        refundCreatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundCreatejButtonActionPerformed(evt);
            }
        });

        refundViewjButton.setText("view");
        refundViewjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundViewjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonjPanel2Layout = new javax.swing.GroupLayout(buttonjPanel2);
        buttonjPanel2.setLayout(buttonjPanel2Layout);
        buttonjPanel2Layout.setHorizontalGroup(
            buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonjPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refundModifyjButton, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refundViewjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refundCreatejButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refundDeletejButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonjPanel2Layout.setVerticalGroup(
            buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonjPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(refundModifyjButton)
                .addGap(18, 18, 18)
                .addComponent(refundDeletejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refundCreatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refundViewjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        createDatePicker.setEnabled(false);

        passwordjLabel1.setText("update_date");

        updateDatePicker.setEnabled(false);

        passwordjLabel.setText("create_date");

        userRolesjLabel.setText("status");

        refundjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "order", "create_date", "update_date", "status", "amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(refundjTable);

        orderjLabel.setText("order");

        amountjLabel.setText("amount");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordjLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordjLabel)
                                    .addComponent(userRolesjLabel)
                                    .addComponent(orderjLabel)
                                    .addComponent(amountjLabel))
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(createDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(orderjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(amountjTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(statusjComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 106, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(buttonjPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(orderjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(orderjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amountjLabel)
                            .addComponent(amountjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(buttonjPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refundModifyjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundModifyjButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = refundjTable.getSelectedRow();

        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) refundjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        refund = BusinessRefundOrder.findById(BusinessRefundOrder.class, id);

        try {
            refund.setOrder((BusinessOrder)orderjComboBox.getSelectedItem());
            refund.setCreateDate(createDatePicker.getDateTimeStrict());
            refund.setUpdateDate(updateDatePicker.getDateTimeStrict());
            refund.setBusinessRefundOrderStatusType((BusinessRefundOrderStatusType)statusjComboBox.getSelectedItem());
            refund.setAmount((int)(Double.parseDouble(amountjTextField.getText()) * 100));

            refund.flush();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Modify error: " + e.getMessage());
            return;
        }
        JOptionPane.showMessageDialog(this, "Modify done");
        refund = null;
        displayRefundOrder();
        displayRefundOrderList();
    }//GEN-LAST:event_refundModifyjButtonActionPerformed

    private void refundDeletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundDeletejButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = refundjTable.getSelectedRow();

        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) refundjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        refund = BusinessRefundOrder.findById(BusinessRefundOrder.class, id);
        refund.delete();
        model.removeRow(selectedIndex);
        refund = null;
        displayRefundOrder();
        displayRefundOrderList();
    }//GEN-LAST:event_refundDeletejButtonActionPerformed

    private void refundCreatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundCreatejButtonActionPerformed
        // TODO add your handling code here:
        if (((BusinessOrder)orderjComboBox.getSelectedItem()).getOrderStatusType() == BusinessOrderStatusType.REFUND) {
            JOptionPane.showMessageDialog(this, "This order has been refunded");
            return;
        }

        BusinessRefundOrder bf = new BusinessRefundOrder();
        try {
            bf.setOrder((BusinessOrder)orderjComboBox.getSelectedItem());
            bf.setCreateDate(createDatePicker.getDateTimeStrict());
            bf.setUpdateDate(updateDatePicker.getDateTimeStrict());
            bf.setBusinessRefundOrderStatusType((BusinessRefundOrderStatusType)statusjComboBox.getSelectedItem());
            bf.setAmount((int)(Double.parseDouble(amountjTextField.getText()) * 100));
            bf.save();

            BusinessOrder o = bf.getOrder();
            o.setOrderStatusType(BusinessOrderStatusType.REFUND);
            o.flush();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Save error: " + e.getMessage());
            return;
        }
        JOptionPane.showMessageDialog(this, "Save done");
        bf = null;
        displayRefundOrder();
        refund = bf;
        displayRefundOrderList();
    }//GEN-LAST:event_refundCreatejButtonActionPerformed

    private void refundViewjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundViewjButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = refundjTable.getSelectedRow();

        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) refundjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        refund = BusinessRefundOrder.findById(BusinessRefundOrder.class, id);
        displayRefundOrder();
    }//GEN-LAST:event_refundViewjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountjLabel;
    private javax.swing.JTextField amountjTextField;
    private javax.swing.JPanel buttonjPanel2;
    private com.github.lgooddatepicker.components.DateTimePicker createDatePicker;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JComboBox<BusinessOrder> orderjComboBox;
    private javax.swing.JLabel orderjLabel;
    private javax.swing.JLabel passwordjLabel;
    private javax.swing.JLabel passwordjLabel1;
    private javax.swing.JButton refundCreatejButton;
    private javax.swing.JButton refundDeletejButton;
    private javax.swing.JButton refundModifyjButton;
    private javax.swing.JButton refundViewjButton;
    private javax.swing.JTable refundjTable;
    private javax.swing.JComboBox<BusinessRefundOrderStatusType> statusjComboBox;
    private com.github.lgooddatepicker.components.DateTimePicker updateDatePicker;
    private javax.swing.JLabel userRolesjLabel;
    // End of variables declaration//GEN-END:variables
}
