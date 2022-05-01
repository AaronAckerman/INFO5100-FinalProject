/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.finalproject.ui;

import com.finalproject.model.Ticket;
import com.finalproject.model.BusinessOrder;
import com.finalproject.model.PermissionType;
import com.finalproject.model.TicketStatusType;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class CustomerServiceManagerJPanel extends javax.swing.JPanel {
    MainJFrame jFrame;
    Ticket ticket;
    /**
     * Creates new form adminJPanel
     */
    public CustomerServiceManagerJPanel(MainJFrame jFrame) {
        initComponents();
        this.jFrame = jFrame;
        displayTicket();
        displayTicketList();
        jTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int index = jTabbedPane.getSelectedIndex();
                switch (index) {
                    case 0:
						displayTicket();
                        displayTicketList();
                        break;
                    case 1:
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        });

        String className = "Ticket";
        if (!jFrame.getUser().hasPermission(className, PermissionType.EDIT)) {
            ticketModifyjButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.CREATE)) {
            ticketCreatejButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.VIEW)) {
            ticketViewjButton.setEnabled(false);
        }
        if (!jFrame.getUser().hasPermission(className, PermissionType.DELETE)) {
            ticketDeletejButton.setEnabled(false);
        }
    }
    
    public final void displayTicket() {
        if (ticket == null) {
            orderjComboBox.removeAllItems();
            statusjComboBox.removeAllItems();
		    for (BusinessOrder order: BusinessOrder.find("Digital Platform")) {
				orderjComboBox.addItem(order);
		    }
            for (TicketStatusType ts: TicketStatusType.values()) {
                statusjComboBox.addItem(ts);
            }
		    createDatePicker.clear();
		    updateDatePicker.clear();
            descriptionjTextArea.setText("");
        } else {
            ticket.refresh();
            orderjComboBox.setSelectedItem(ticket.getOrder());
            createDatePicker.setDateTimeStrict(ticket.getCreateDate());
            updateDatePicker.setDateTimeStrict(ticket.getUpdateDate());
            statusjComboBox.setSelectedItem(ticket.getTicketStatusType());
            descriptionjTextArea.setText(ticket.getProblemDescription());
        }
    }
    
    public final void displayTicketList() {
        DefaultTableModel model = (DefaultTableModel) ticketjTable.getModel();
        model.setRowCount(0);
        
        for (Ticket current: Ticket.find(Ticket.class)) {
            Object[] row = new Object[5];
            row[0] = current.getId();
            row[1] = current.getOrder();
            row[2] = current.getCreateDate();
            row[3] = current.getUpdateDate();
            row[4] = current.getTicketStatusType();
            
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

        jTabbedPane = new javax.swing.JTabbedPane();
        ticketjPanel = new javax.swing.JPanel();
        buttonjPanel2 = new javax.swing.JPanel();
        ticketModifyjButton = new javax.swing.JButton();
        ticketDeletejButton = new javax.swing.JButton();
        ticketCreatejButton = new javax.swing.JButton();
        ticketViewjButton = new javax.swing.JButton();
        passwordjLabel = new javax.swing.JLabel();
        userRolesjLabel = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        ticketjTable = new javax.swing.JTable();
        orderjLabel = new javax.swing.JLabel();
        orderjComboBox = new javax.swing.JComboBox<>();
        createDatePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        passwordjLabel1 = new javax.swing.JLabel();
        updateDatePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        statusjComboBox = new javax.swing.JComboBox<>();
        descriptionjLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionjTextArea = new javax.swing.JTextArea();

        jTabbedPane.setBackground(new java.awt.Color(242, 237, 231));

        ticketjPanel.setBackground(new java.awt.Color(242, 237, 231));

        buttonjPanel2.setBackground(new java.awt.Color(242, 237, 231));

        ticketModifyjButton.setText("Modify");
        ticketModifyjButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        ticketModifyjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketModifyjButtonActionPerformed(evt);
            }
        });

        ticketDeletejButton.setText("Delete");
        ticketDeletejButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        ticketDeletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketDeletejButtonActionPerformed(evt);
            }
        });

        ticketCreatejButton.setText("Create");
        ticketCreatejButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        ticketCreatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketCreatejButtonActionPerformed(evt);
            }
        });

        ticketViewjButton.setText("View");
        ticketViewjButton.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N
        ticketViewjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketViewjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonjPanel2Layout = new javax.swing.GroupLayout(buttonjPanel2);
        buttonjPanel2.setLayout(buttonjPanel2Layout);
        buttonjPanel2Layout.setHorizontalGroup(
            buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonjPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ticketModifyjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ticketDeletejButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ticketCreatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(ticketViewjButton)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        buttonjPanel2Layout.setVerticalGroup(
            buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonjPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(buttonjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ticketModifyjButton)
                    .addComponent(ticketDeletejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ticketCreatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ticketViewjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        passwordjLabel.setText("Create_date");
        passwordjLabel.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        userRolesjLabel.setText("Status");
        userRolesjLabel.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        ticketjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Order", "Create_date", "Update_date", "Status"
            }
        ));
        jScrollPane11.setViewportView(ticketjTable);

        orderjLabel.setText("Order");
        orderjLabel.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        createDatePicker.setBackground(new java.awt.Color(242, 237, 231));
        createDatePicker.setEnabled(false);

        passwordjLabel1.setText("Update_date");
        passwordjLabel1.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        updateDatePicker.setBackground(new java.awt.Color(242, 237, 231));
        updateDatePicker.setEnabled(false);

        descriptionjLabel.setText("Description");
        descriptionjLabel.setFont(new java.awt.Font("Chalkboard SE", 0, 14)); // NOI18N

        descriptionjTextArea.setColumns(20);
        descriptionjTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionjTextArea);

        javax.swing.GroupLayout ticketjPanelLayout = new javax.swing.GroupLayout(ticketjPanel);
        ticketjPanel.setLayout(ticketjPanelLayout);
        ticketjPanelLayout.setHorizontalGroup(
            ticketjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketjPanelLayout.createSequentialGroup()
                .addGroup(ticketjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ticketjPanelLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(ticketjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordjLabel1)
                            .addComponent(descriptionjLabel)
                            .addGroup(ticketjPanelLayout.createSequentialGroup()
                                .addGroup(ticketjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordjLabel)
                                    .addComponent(userRolesjLabel)
                                    .addComponent(orderjLabel))
                                .addGap(101, 101, 101)
                                .addGroup(ticketjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(updateDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(createDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)
                                    .addComponent(statusjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(orderjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ticketjPanelLayout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ticketjPanelLayout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(buttonjPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        ticketjPanelLayout.setVerticalGroup(
            ticketjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketjPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(ticketjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ticketjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(ticketjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordjLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ticketjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userRolesjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ticketjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ticketjPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(descriptionjLabel))
                    .addGroup(ticketjPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonjPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );

        jTabbedPane.addTab("Ticket", ticketjPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 604, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ticketModifyjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketModifyjButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = ticketjTable.getSelectedRow();
        
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) ticketjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        ticket = Ticket.findById(Ticket.class, id);
        
        try {
            ticket.setOrder((BusinessOrder)orderjComboBox.getSelectedItem());
            ticket.setCreateDate(createDatePicker.getDateTimeStrict());
            ticket.setUpdateDate(updateDatePicker.getDateTimeStrict());
            ticket.setProblemDescription(descriptionjTextArea.getText());
            ticket.setTicketStatusType((TicketStatusType)statusjComboBox.getSelectedItem());
            
            ticket.flush();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Modify error: " + e.toString());
            return;
        }
        JOptionPane.showMessageDialog(this, "Modify done");
        ticket = null;
        displayTicket();
        displayTicketList();
    }//GEN-LAST:event_ticketModifyjButtonActionPerformed

    private void ticketDeletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketDeletejButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = ticketjTable.getSelectedRow();
        
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) ticketjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        ticket = Ticket.findById(Ticket.class, id);
        ticket.delete();
        model.removeRow(selectedIndex);
        ticket = null;
        displayTicket();
        displayTicketList();
    }//GEN-LAST:event_ticketDeletejButtonActionPerformed

    private void ticketCreatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketCreatejButtonActionPerformed
        // TODO add your handling code here:
        Ticket t = new Ticket();
        try {
            t.setOrder((BusinessOrder)orderjComboBox.getSelectedItem());
            t.setCreateDate(createDatePicker.getDateTimeStrict());
            t.setUpdateDate(updateDatePicker.getDateTimeStrict());
            t.setProblemDescription(descriptionjTextArea.getText());
            t.setTicketStatusType((TicketStatusType)statusjComboBox.getSelectedItem());
            t.save();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Save error: " + e.toString());
            return;
        }
        JOptionPane.showMessageDialog(this, "Save done");
        t = null;
        displayTicket();
        ticket = t;
        displayTicketList();
    }//GEN-LAST:event_ticketCreatejButtonActionPerformed

    private void ticketViewjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketViewjButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex = ticketjTable.getSelectedRow();
        
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to view");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) ticketjTable.getModel();
        int id = (Integer) model.getValueAt(selectedIndex, 0);
        ticket = Ticket.findById(Ticket.class, id);
        displayTicket();
    }//GEN-LAST:event_ticketViewjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonjPanel2;
    private com.github.lgooddatepicker.components.DateTimePicker createDatePicker;
    private javax.swing.JLabel descriptionjLabel;
    private javax.swing.JTextArea descriptionjTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JComboBox<com.finalproject.model.BusinessOrder> orderjComboBox;
    private javax.swing.JLabel orderjLabel;
    private javax.swing.JLabel passwordjLabel;
    private javax.swing.JLabel passwordjLabel1;
    private javax.swing.JComboBox<TicketStatusType> statusjComboBox;
    private javax.swing.JButton ticketCreatejButton;
    private javax.swing.JButton ticketDeletejButton;
    private javax.swing.JButton ticketModifyjButton;
    private javax.swing.JButton ticketViewjButton;
    private javax.swing.JPanel ticketjPanel;
    private javax.swing.JTable ticketjTable;
    private com.github.lgooddatepicker.components.DateTimePicker updateDatePicker;
    private javax.swing.JLabel userRolesjLabel;
    // End of variables declaration//GEN-END:variables
}
