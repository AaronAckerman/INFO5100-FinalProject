/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.finalproject.ui;
import com.finalproject.model.Role;
import java.awt.Component;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.HashMap;
import static java.util.Map.entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class OperationsPanel extends javax.swing.JPanel {
    MainJFrame jFrame;
    Map<String, Class<? extends JPanel>> panels = Map.ofEntries(
            entry("Admin", AdminJPanel.class),
            entry("CustomerService", CustomerServiceManagerJPanel.class)
    );

    /**
     * Creates new form operationsPanel
     */
    public OperationsPanel(MainJFrame jFrame) {
        initComponents();

        for (Role role: jFrame.getUser().getRoles()) {
            if (panels.containsKey(role.getName())) {
                try {
                    jTabbedPane.addTab(role.getName(), panels.get(role.getName()).getConstructor(MainJFrame.class).newInstance(jFrame));
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(OperationsPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(OperationsPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(OperationsPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(OperationsPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(OperationsPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(OperationsPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}
