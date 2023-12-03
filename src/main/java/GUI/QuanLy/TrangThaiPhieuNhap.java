/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.QuanLy;

import BUS.PhieuNhapBus;
import DTO.PhieuNhap_DTO;
import java.awt.Window;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author acer
 */
public class TrangThaiPhieuNhap extends javax.swing.JPanel {

    private String MaPN;
    PhieuNhapBus pnBUS = new PhieuNhapBus();

    /**
     * Creates new form TrangThaiPhieuNhap
     */
    public TrangThaiPhieuNhap(String MaPN) {
        initComponents();
        this.MaPN = MaPN;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnDuyet = new javax.swing.JButton();
        btnKhongDuyet = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(176, 206, 221));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KIỂM DUYỆT PHIẾU NHẬP KHO");

        btnDuyet.setBackground(new java.awt.Color(67, 138, 174));
        btnDuyet.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDuyet.setForeground(new java.awt.Color(255, 255, 255));
        btnDuyet.setText("DUYỆT");
        btnDuyet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuyetActionPerformed(evt);
            }
        });

        btnKhongDuyet.setBackground(new java.awt.Color(211, 97, 120));
        btnKhongDuyet.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnKhongDuyet.setForeground(new java.awt.Color(255, 255, 255));
        btnKhongDuyet.setText("KHÔNG DUYỆT");
        btnKhongDuyet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongDuyetActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(110, 157, 181));
        btnCancel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(81, 81, 81))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnKhongDuyet)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhongDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDuyetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuyetActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Xác nhận duyệt phiếu yêu cầu?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            pnBUS.suaTrangThai(MaPN, "DA DUYET");
//            pnBUS.capNhatPhieuNhap(MaPN, "DA DUYET");
             JOptionPane.showMessageDialog(null,
                    "Đã duyệt thành công! VUI LÒNG CLICK VÀO DÒNG BẤT KÌ ĐỂ CẬP NHẬT BẢNG!");
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose();
            }
        } else {
            return;
        }


    }//GEN-LAST:event_btnDuyetActionPerformed

    private void btnKhongDuyetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongDuyetActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Xác nhận không duyệt phiếu yêu cầu?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            pnBUS.suaTrangThai(MaPN, "KHONG DUYET");
             JOptionPane.showMessageDialog(null,
                    "Không duyệt thành công! VUI LÒNG CLICK VÀO DÒNG BẤT KÌ ĐỂ CẬP NHẬT BẢNG!");
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) {

                window.dispose();
            }
        } else {
            return;
        }

    }//GEN-LAST:event_btnKhongDuyetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDuyet;
    private javax.swing.JButton btnKhongDuyet;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
