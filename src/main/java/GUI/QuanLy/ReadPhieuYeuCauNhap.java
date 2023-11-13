/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.QuanLy;

import BUS.ChiTietPhieuNhapBus;
import BUS.NhaCungCapBus;
import BUS.PhieuYeuCauNhapBus;
import DAO.ChiTietPhieuNhapDAO;
import DAO.PhieuYeuCauNhapDAO;
import DTO.ChiTietPhieuNhap_DTO;
import Handle.Convert;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class ReadPhieuYeuCauNhap extends javax.swing.JPanel {

    private String MaPN;
    ChiTietPhieuNhapBus ctpnBUS = new ChiTietPhieuNhapBus();
    ChiTietPhieuNhapDAO ctpnDAO = new ChiTietPhieuNhapDAO();
    NhaCungCapBus nccBUS = new NhaCungCapBus();
    PhieuYeuCauNhapDAO pycnDAO = new PhieuYeuCauNhapDAO();
    Convert cv = new Convert();
    public ReadPhieuYeuCauNhap(String mapn) {
        initComponents();

        this.MaPN = mapn;
        showPhieuNhapInTable();
    }

    public void showPhieuNhapInTable() {
        DefaultTableModel model = (DefaultTableModel) tablePhieuYeuCauNhap.getModel();
        model.setRowCount(0);
        ArrayList<ChiTietPhieuNhap_DTO> chiTietPhieuNhap = pycnDAO.searchCTPN(MaPN, null, null, null);
        double total = 0;
        for (int i = 0; i < chiTietPhieuNhap.size(); i++) {
            ChiTietPhieuNhap_DTO ctpnDTO = chiTietPhieuNhap.get(i);
            String tenNCC = nccBUS.timTenNCC(ctpnDTO.getMaNCC());
            total += ctpnDTO.getTongTienNhap();
            model.addRow(new Object[]{ctpnDTO.getMaPhieuNhap(), ctpnDTO.getMaHangNhap(), ctpnDTO.getTenHangNhap(), tenNCC, ctpnDTO.getVAT(), ctpnDTO.getXuatXu(), ctpnDTO.getSoLuong(), ctpnDTO.getDonVi(),  ctpnDTO.getGiaNhap(), ctpnDTO.getTongTienNhap()});
        }
        model.addRow(new Object[]{null, null, null, null, null, null, null, null ,"Tổng:", total});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePhieuYeuCauNhap = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        txtXuatXu = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtMaSP = new javax.swing.JTextField();
        txtSuaGiaNhap = new javax.swing.JTextField();
        txtSuaSoLuong = new javax.swing.JTextField();

        tablePhieuYeuCauNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu", "Mã mặt hàng", "Tên mặt hàng", "Tên NCC", "VAT", "Xuất xứ", "Số lượng", "Đơn vị", "Giá nhập", "Tổng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePhieuYeuCauNhap.setRowHeight(35);
        tablePhieuYeuCauNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePhieuYeuCauNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePhieuYeuCauNhap);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin mặt hàng"));

        btnUpdate.setBackground(new java.awt.Color(102, 255, 102));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setText("Sửa thông tin");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtXuatXu.setBorder(javax.swing.BorderFactory.createTitledBorder("Xuất xứ"));

        txtTenSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên mặt hàng"));
        txtTenSP.setEnabled(false);

        txtMaSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã mặt hàng"));
        txtMaSP.setEnabled(false);

        txtSuaGiaNhap.setBorder(javax.swing.BorderFactory.createTitledBorder("Sửa giá nhập"));

        txtSuaSoLuong.setBorder(javax.swing.BorderFactory.createTitledBorder("Sửa số lượng"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtXuatXu, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSuaSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSuaGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(426, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSuaSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSuaGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablePhieuYeuCauNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePhieuYeuCauNhapMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
            int selectedRow = tablePhieuYeuCauNhap.getSelectedRow();
            if (selectedRow != -1) {
                String giaNhap = String.valueOf(tablePhieuYeuCauNhap.getValueAt(selectedRow, 8));
                String soLuong = String.valueOf(tablePhieuYeuCauNhap.getValueAt(selectedRow, 6));
                String tenNCC = String.valueOf(tablePhieuYeuCauNhap.getValueAt(selectedRow, 3));
                String maSP = String.valueOf(tablePhieuYeuCauNhap.getValueAt(selectedRow, 1));
                String tenSP = String.valueOf(tablePhieuYeuCauNhap.getValueAt(selectedRow, 2));
                String xuatXu = String.valueOf(tablePhieuYeuCauNhap.getValueAt(selectedRow, 5));
                txtSuaGiaNhap.setText(giaNhap);
                txtSuaSoLuong.setText(soLuong);
                txtMaSP.setText(maSP);
                txtTenSP.setText(tenSP);
                txtXuatXu.setText(xuatXu);
            }
        }
    }//GEN-LAST:event_tablePhieuYeuCauNhapMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
       
        try {       
            int soLuong = Integer.parseInt(txtSuaSoLuong.getText());         
        } catch (NumberFormatException e) {
            // Xử lý ngoại lệ nếu không thể chuyển đổi sang kiểu số nguyên
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số lượng vd: 100, 200, 300, ...");
            return;
        }
        double newGiaNhap = Double.parseDouble(txtSuaGiaNhap.getText());
        int newSoLuong = Integer.parseInt(txtSuaSoLuong.getText());

        String tenSP = txtTenSP.getText();
        String maSP = txtMaSP.getText();
        String xuatXu = txtXuatXu.getText();

        ArrayList<ChiTietPhieuNhap_DTO> chiTietMatHangNhapTrongPhieu = pycnDAO.searchCTPN(MaPN, maSP, null, null);

        double total = newSoLuong * newGiaNhap;
        chiTietMatHangNhapTrongPhieu.get(0).setGiaNhap(newGiaNhap);
        chiTietMatHangNhapTrongPhieu.get(0).setSoLuong(newSoLuong);
        chiTietMatHangNhapTrongPhieu.get(0).setXuatXu(xuatXu);
        chiTietMatHangNhapTrongPhieu.get(0).setTongTienNhap(total);
        int dialogResult = JOptionPane.showConfirmDialog(null, "Xác nhận sửa thông tin mặt hàng này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {

                pycnDAO.updateCTPN(chiTietMatHangNhapTrongPhieu.get(0));
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                showPhieuNhapInTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                return;
            }
        } else {
            return;
        }
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePhieuYeuCauNhap;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSuaGiaNhap;
    private javax.swing.JTextField txtSuaSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}
