/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.QuanLy;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author acer
 */
public class PanelAction extends javax.swing.JPanel {
    public PanelAction() {
        initComponents();
    }
    public void updateStatusButton(String color,String text,Boolean isBoolean){
        btnStatus.setText(text);
        if(color == "RED"){
              
               btnStatus.setEnabled(false);
                btnStatus.setBackground(Color.RED);
        }
        if(color == "GREEN"){
               
               btnStatus.setEnabled(false);
               btnStatus.setBackground(Color.GREEN);
        }
        if(color == "YELLOW"){
               btnStatus.setBackground(Color.YELLOW);
               btnStatus.setEnabled(true);
        } 
    }
    public void initEvent(TableActionEvent event, int row,String MaPhieuNhap) {
        btnStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onStatus(row,MaPhieuNhap);
            }
        });
          btnWatch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onRead(row,MaPhieuNhap);
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStatus = new javax.swing.JButton();
        btnWatch = new javax.swing.JButton();

        btnStatus.setBackground(new java.awt.Color(211, 97, 120));
        btnStatus.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnStatus.setForeground(new java.awt.Color(255, 255, 255));
        btnStatus.setText("KHÔNG DUYỆT");
        btnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusActionPerformed(evt);
            }
        });

        btnWatch.setBackground(new java.awt.Color(67, 138, 174));
        btnWatch.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnWatch.setForeground(new java.awt.Color(255, 255, 255));
        btnWatch.setText("XEM");
        btnWatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWatchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnWatch, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnWatch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStatusActionPerformed

    private void btnWatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWatchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnWatchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStatus;
    private javax.swing.JButton btnWatch;
    // End of variables declaration//GEN-END:variables
}
