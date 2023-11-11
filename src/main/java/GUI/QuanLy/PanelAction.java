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

        btnStatus.setBackground(new java.awt.Color(102, 255, 51));
        btnStatus.setText("Không duyệt");

        btnWatch.setBackground(new java.awt.Color(0, 153, 255));
        btnWatch.setText("Xem");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnWatch, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnWatch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStatus;
    private javax.swing.JButton btnWatch;
    // End of variables declaration//GEN-END:variables
}
