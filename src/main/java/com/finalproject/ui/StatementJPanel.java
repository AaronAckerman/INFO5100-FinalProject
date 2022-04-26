/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.finalproject.ui;

import com.finalproject.model.BusinessOrder;
import com.finalproject.model.BusinessPurchaseOrder;
import com.finalproject.model.BusinessRefundOrder;
import com.finalproject.model.BusinessSourceType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class StatementJPanel extends javax.swing.JPanel {
    MainJFrame jFrame;
    /**
     * Creates new form orderJPanel
     */
    public StatementJPanel(MainJFrame jFrame) {
        initComponents();
        this.jFrame = jFrame;
        displayStatementList();
    }
    
    public final void displayStatementList() {
        DefaultTableModel model = (DefaultTableModel) statementjTable.getModel();
        model.setRowCount(0);
        List<Object[]> objects = new ArrayList<>();

        LocalDateTime start = startDateTimePicker.getDateTimeStrict() == null ? LocalDateTime.of(1980, 1, 1, 0, 0): startDateTimePicker.getDateTimeStrict();
        LocalDateTime end = endDateTimePicker.getDateTimeStrict() == null ? LocalDateTime.of(2100, 1, 1, 0, 0): endDateTimePicker.getDateTimeStrict();

        for (BusinessOrder current: BusinessOrder.findByDate("Digital Platform", start, end)) {
            Object[] row = new Object[4];
            row[0] = BusinessSourceType.ORDER;
            row[1] = current.getId();
            row[2] = current.getCreateDate();
            row[3] = current.getTotalAmount()/ 100.0;

            objects.add(row);
        }

        for (BusinessRefundOrder current: BusinessRefundOrder.findByDate(start, end)) {
            Object[] row = new Object[4];
            row[0] = BusinessSourceType.REFUND_ORDER;
            row[1] = current.getId();
            row[2] = current.getCreateDate();
            row[3] = -current.getAmount()/ 100.0;

            objects.add(row);
        }
        
        for (BusinessPurchaseOrder current: BusinessPurchaseOrder.findByDate(start, end)) {
            Object[] row = new Object[4];
            row[0] = BusinessSourceType.PURCHASE_ORDER;
            row[1] = current.getId();
            row[2] = current.getCreateDate();
            row[3] = -current.getTotalAmount()/ 100.0;

            objects.add(row);
        }

        for (Object[] current: objects) {
            model.addRow(current);
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

        jScrollPane11 = new javax.swing.JScrollPane();
        statementjTable = new javax.swing.JTable();
        startDatejLabel = new javax.swing.JLabel();
        endDatejLabel = new javax.swing.JLabel();
        startDateTimePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        endDateTimePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        searchjButton = new javax.swing.JButton();

        statementjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "source type", "source id", "create_date", "amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(statementjTable);

        startDatejLabel.setText("start date");

        endDatejLabel.setText("end date");

        searchjButton.setText("Search");
        searchjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(endDatejLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(endDateTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startDatejLabel)
                                .addGap(66, 66, 66)
                                .addComponent(startDateTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(63, 63, 63)
                        .addComponent(searchjButton)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startDatejLabel)
                            .addComponent(startDateTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endDatejLabel)
                            .addComponent(endDateTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchjButton)
                        .addGap(53, 53, 53)))
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchjButtonActionPerformed
        // TODO add your handling code here:
        displayStatementList();
    }//GEN-LAST:event_searchjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DateTimePicker endDateTimePicker;
    private javax.swing.JLabel endDatejLabel;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JButton searchjButton;
    private com.github.lgooddatepicker.components.DateTimePicker startDateTimePicker;
    private javax.swing.JLabel startDatejLabel;
    private javax.swing.JTable statementjTable;
    // End of variables declaration//GEN-END:variables
}
