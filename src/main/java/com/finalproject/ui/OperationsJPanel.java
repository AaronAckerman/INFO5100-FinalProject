/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.finalproject.ui;
import com.finalproject.model.Role;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Administrator
 */
public class OperationsJPanel extends javax.swing.JPanel {
    MainJFrame jFrame;
    Map<String, Class<? extends JPanel>> panels = Map.ofEntries(
            entry("Admin", AdminJPanel.class),
            entry("CustomerServiceManager", CustomerServiceManagerJPanel.class),
            entry("Accountant", AccountantJPanel.class),
            entry("Auditor", AuditorJPanel.class),
            entry("QualityManager", QualityManagerJPanel.class),
            entry("MarketingManager", MarketingManagerJPanel.class),
            entry("TransportationManager", TransportationManagerJPanel.class),
            entry("Maintainer", MaintainerJPanel.class),
            entry("InventoryManager", InventoryManagerJPanel.class),
            entry("Purchaser", PurchaserJPanel.class)
    );

    /**
     * Creates new form operationsPanel
     */
    public OperationsJPanel(MainJFrame jFrame) {
        initComponents();

        List<Role> roles = jFrame.getUser().getRoles().stream().filter((role) -> panels.containsKey(role.getName())).toList();
        for (Role role: roles) {
            try {
                jTabbedPane.addTab(role.getName(), panels.get(role.getName()).getConstructor(MainJFrame.class).newInstance(jFrame));
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(OperationsJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (roles.isEmpty()) {
            return;
        }
        String name = jTabbedPane.getTitleAt(0);
        jFrame.setRole(jFrame.getUser().findRole(name));
        ((InfoJPanel)jFrame.getjSplitPane().getLeftComponent()).displayUser();

        jTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String name = jTabbedPane.getTitleAt(jTabbedPane.getSelectedIndex());
                jFrame.setRole(jFrame.getUser().findRole(name));
                ((InfoJPanel)jFrame.getjSplitPane().getLeftComponent()).displayUser();
            }
        });
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
