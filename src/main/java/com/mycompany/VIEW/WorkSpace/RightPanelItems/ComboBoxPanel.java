/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.VIEW.WorkSpace.RightPanelItems;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ASUS-PC
 */
public class ComboBoxPanel extends javax.swing.JPanel {

    /**
     * Creates new form ComboBoxPane
     */
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    
    public ComboBoxPanel() {
        initComponents();
    }
    public ComboBoxPanel(String labelString) {
        initComponents();
        jComboBox1.setModel(model);
        
        label.setText(labelString);
    }
    
    public String getResult () {
        return (String) jComboBox1.getSelectedItem();
    }
    
    public void addElement(String... elements) {
        for (String element: elements) {
            model.addElement(element);
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

        label = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(2147483647, 30));
        setLayout(new java.awt.BorderLayout());

        label.setText("jLabel1");
        add(label, java.awt.BorderLayout.LINE_START);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
