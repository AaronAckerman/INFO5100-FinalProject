/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.finalproject.ui;

import com.finalproject.model.BusinessOrder;
import com.finalproject.model.BusinessOrderStatusType;
import com.finalproject.model.BusinessProduct;
import com.finalproject.model.Email;
import com.finalproject.model.PermissionType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class OrderJPanel extends javax.swing.JPanel {
    MainJFrame jFrame;
    BusinessOrder order;
    /**
     * Creates new form orderJPanel
     */
    public OrderJPanel(MainJFrame jFrame) {
        initComponents();
        this.jFrame = jFrame;

        String className = "Order";
        if (!jFrame.getUser().hasPermission(className, PermissionType.EDIT)) {
            orderModifyjButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.CREATE)) {
            orderCreatejButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.VIEW)) {
            orderViewjButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.DELETE)) {
            orderDeletejButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission("Order.status", PermissionType.EDIT)) {
            statusjComboBox.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission("Order.shippment", PermissionType.EDIT)) {
            shipjButton.setEnabled(false);
        }
    }

    public final void displayOrder() {
        if (order == null) {
            productjComboBox.removeAllItems();
            statusjComboBox.removeAllItems();
		    for (BusinessProduct product: BusinessProduct.findAvailableProduct("Digital Platform")) {
				productjComboBox.addItem(product);
		    }
            for (BusinessOrderStatusType ts: BusinessOrderStatusType.values()) {
                statusjComboBox.addItem(ts);
            }
		    createDatePicker.clear();
		    updateDatePicker.clear();
            totalAmountjTextField.setText("");
            quantityjTextField.setText("");
            customerjTextField.setText("");
        } else {
            order.refresh();
            productjComboBox.setSelectedItem(order.getProduct());
            createDatePicker.setDateTimeStrict(order.getCreateDate());
            updateDatePicker.setDateTimeStrict(order.getUpdateDate());
            statusjComboBox.setSelectedItem(order.getOrderStatusType());
            totalAmountjTextField.setText(String.valueOf(order.getTotalAmount() / 100.0));
            quantityjTextField.setText(String.valueOf(order.getQuantity()));
            customerjTextField.setText(order.getCustomerName());
        }
    }
    
    public final void displayOrderList() {
        DefaultTableModel model = (DefaultTableModel) orderjTable.getModel();
        model.setRowCount(0);
        
        for (BusinessOrder current: BusinessOrder.find("Digital Platform")) {
            Object[] row = new Object[8];
            row[0] = current.getId();
            row[1] = current.getProduct();
            row[2] = current.getCreateDate();
            row[3] = current.getUpdateDate();
            row[4] = current.getOrderStatusType();
            row[5] = current.getTotalAmount() / 100.0;
            row[6] = current.getQuantity();
            row[7] = current.getCustomerName();
            
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

        productjComboBox = new javax.swing.JComboBox<>();
        buttonjPanel2 = new javax.swing.JPanel();
        orderModifyjButton = new javax.swing.JButton();
        orderDeletejButton = new javax.swing.JButton();
        orderCreatejButton = new javax.swing.JButton();
        orderViewjButton = new javax.swing.JButton();
        shipjButton = new javax.swing.JButton();
        createDatePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        passwordjLabel1 = new javax.swing.JLabel();
        updateDatePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        statusjComboBox = new javax.swing.JComboBox<>();
        passwordjLabel = new javax.swing.JLabel();
        userRolesjLabel = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        orderjTable = new javax.swing.JTable();
        productjLabel = new javax.swing.JLabel();
        totalAmountjLabel = new javax.swing.JLabel();
        quantityjLabel = new javax.swing.JLabel();
        totalAmountjTextField = new javax.swing.JTextField();
        quantityjTextField = new javax.swing.JTextField();
        customerjLabel = new javax.swing.JLabel();
        customerjTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(242, 237, 231));

        buttonjPanel2.setBackground(new java.awt.Color(242, 237, 231));

        orderModifyjButton.setText("Modify");
        orderModifyjButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        orderModifyjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderModifyjButtonActionPerformed(evt);
            }
        });

        orderDeletejButton.setText("Delete");
        orderDeletejButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        orderDeletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderDeletejButtonActionPerformed(evt);
            }
        });

        orderCreatejButton.setText("Create");
        orderCreatejButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        orderCreatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderCreatejButtonActionPerformed(evt);
            }
        });

        orderViewjButton.setText("View");
        orderViewjButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        orderViewjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderViewjButtonActionPerformed(evt);
            }
        });

        shipjButton.setText("Ship");
        shipjButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        shipjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shipjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonjPanel2Layout = new javax.swing.GroupLayout(buttonjPanel2);
        buttonjPanel2.setLayout(buttonjPanel2Layout);
        buttonjPanel2Layout.setHorizontalGroup(
            buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonjPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shipjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderModifyjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderDeletejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderCreatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderViewjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        buttonjPanel2Layout.setVerticalGroup(
            buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonjPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderModifyjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderDeletejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderCreatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderViewjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shipjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
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
                "ID", "Product", "Create Date", "Update Date", "Status", "Total amount", "Quantity", "Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane11.setViewportView(orderjTable);

        productjLabel.setText("Product");
        productjLabel.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        totalAmountjLabel.setText("Total Amount");
        totalAmountjLabel.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        quantityjLabel.setText("Quantity");
        quantityjLabel.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        totalAmountjTextField.setEnabled(false);

        customerjLabel.setText("Customer");
        customerjLabel.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordjLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordjLabel)
                            .addComponent(userRolesjLabel)
                            .addComponent(productjLabel)
                            .addComponent(totalAmountjLabel)
                            .addComponent(quantityjLabel)
                            .addComponent(customerjLabel))
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(customerjTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(quantityjTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(totalAmountjTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(statusjComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 236, Short.MAX_VALUE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonjPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(386, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(totalAmountjLabel)
                    .addComponent(totalAmountjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityjLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerjLabel)
                    .addComponent(customerjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonjPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void orderModifyjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderModifyjButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = orderjTable.getSelectedRow();

        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) orderjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        order = BusinessOrder.findById(BusinessOrder.class, id);

        try {
            order.setProduct((BusinessProduct)productjComboBox.getSelectedItem());
            order.setCreateDate(createDatePicker.getDateTimeStrict());
            order.setUpdateDate(updateDatePicker.getDateTimeStrict());
            order.setOrderStatusType((BusinessOrderStatusType)statusjComboBox.getSelectedItem());
            order.setQuantity(Integer.parseInt(quantityjTextField.getText()));
            order.setTotalAmount(order.getQuantity() * order.getProduct().getSellPrice());
            order.setCustomerName(customerjTextField.getText());

            order.flush();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Modify error: " + e.getMessage());
            return;
        }
        JOptionPane.showMessageDialog(this, "Modify done");
        order = null;
        displayOrder();
        displayOrderList();
    }//GEN-LAST:event_orderModifyjButtonActionPerformed

    private void orderDeletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderDeletejButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = orderjTable.getSelectedRow();

        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) orderjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        order = BusinessOrder.findById(BusinessOrder.class, id);
        order.delete();
        model.removeRow(selectedIndex);
        order = null;
        displayOrder();
        displayOrderList();
    }//GEN-LAST:event_orderDeletejButtonActionPerformed

    private void orderCreatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderCreatejButtonActionPerformed
        // TODO add your handling code here:
        BusinessOrder bo = new BusinessOrder();
        try {
            bo.setProduct((BusinessProduct)productjComboBox.getSelectedItem());
            bo.setCreateDate(createDatePicker.getDateTimeStrict());
            bo.setUpdateDate(updateDatePicker.getDateTimeStrict());
            bo.setOrderStatusType((BusinessOrderStatusType)statusjComboBox.getSelectedItem());
            bo.setQuantity(Integer.parseInt(quantityjTextField.getText()));
            bo.setTotalAmount(bo.getQuantity() * bo.getProduct().getSellPrice());
            bo.setCustomerName(customerjTextField.getText());
            bo.save();

            Email.send(jFrame.getUser(), "New order", jFrame.getUser().getUsername() + " is adding a new order as a " + jFrame.getRole().getName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Save error: " + e.getMessage());
            return;
        }
        JOptionPane.showMessageDialog(this, "Save done");
        bo = null;
        displayOrder();
        order = bo;
        displayOrderList();
    }//GEN-LAST:event_orderCreatejButtonActionPerformed

    private void orderViewjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderViewjButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = orderjTable.getSelectedRow();

        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) orderjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        order = BusinessOrder.findById(BusinessOrder.class, id);
        displayOrder();
    }//GEN-LAST:event_orderViewjButtonActionPerformed

    private void shipjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shipjButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = orderjTable.getSelectedRow();
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to ship");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) orderjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        order = BusinessOrder.findById(BusinessOrder.class, id);
        if (order.getOrderStatusType() != BusinessOrderStatusType.CREATE) {
            JOptionPane.showMessageDialog(this, "Only ship the order of CREATE status");
            return;
        }

        JFrame frame = new ShippmentJFrame(this.jFrame, order);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                //frame.dispose();
                frame.setVisible(false);
                displayOrderList();
            }
        });
        frame.setVisible(true);
    }//GEN-LAST:event_shipjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonjPanel2;
    private com.github.lgooddatepicker.components.DateTimePicker createDatePicker;
    private javax.swing.JLabel customerjLabel;
    private javax.swing.JTextField customerjTextField;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JButton orderCreatejButton;
    private javax.swing.JButton orderDeletejButton;
    private javax.swing.JButton orderModifyjButton;
    private javax.swing.JButton orderViewjButton;
    private javax.swing.JTable orderjTable;
    private javax.swing.JLabel passwordjLabel;
    private javax.swing.JLabel passwordjLabel1;
    private javax.swing.JComboBox<com.finalproject.model.BusinessProduct> productjComboBox;
    private javax.swing.JLabel productjLabel;
    private javax.swing.JLabel quantityjLabel;
    private javax.swing.JTextField quantityjTextField;
    private javax.swing.JButton shipjButton;
    private javax.swing.JComboBox<BusinessOrderStatusType> statusjComboBox;
    private javax.swing.JLabel totalAmountjLabel;
    private javax.swing.JTextField totalAmountjTextField;
    private com.github.lgooddatepicker.components.DateTimePicker updateDatePicker;
    private javax.swing.JLabel userRolesjLabel;
    // End of variables declaration//GEN-END:variables
}
