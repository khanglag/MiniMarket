/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.QuanLy;

import BUS.ChiTietPhieuNhapBus;
import BUS.NhaCungCapBus;
import BUS.PhieuNhapBus;
import BUS.PhieuYeuCauNhapBus;
import DAO.ChiTietPhieuNhapDAO;
import DAO.PhieuYeuCauNhapDAO;
import DTO.ChiTietPhieuNhap_DTO;
import DTO.PhieuNhap_DTO;
import Handle.Convert;
import java.text.DecimalFormat;
import java.time.LocalDate;
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
    PhieuNhapBus pnBUS = new PhieuNhapBus();
    Convert cv = new Convert();

    public ReadPhieuYeuCauNhap(String mapn) {
        initComponents();

        this.MaPN = mapn;
        txtMaPN.setText("Thông tin phiếu yêu cầu nhập hàng số " + MaPN);
        showPhieuNhapInTable();
        ArrayList<PhieuNhap_DTO> pn = pnBUS.timPhieuNhap(MaPN, null, null, null);
        if (pn.get(0).getTrangThai().equals("DA DUYET")) {
            btnUpdate.setEnabled(false);
            txtSuaGiaNhap.setEnabled(false);
            txtXuatXu.setEditable(false);
            txtSuaSoLuong.setEnabled(false);
            txtThongTinTrangThai.setText("Phiếu đã kiểm duyệt không thể chỉnh sửa");
        }
        if (pn.get(0).getTrangThai().equals("KHONG DUYET")) {
            btnUpdate.setEnabled(false);
            txtSuaGiaNhap.setEnabled(false);
            txtXuatXu.setEditable(false);
            txtSuaSoLuong.setEnabled(false);
            txtThongTinTrangThai.setText("Phiếu đã kiểm duyệt không thể chỉnh sửa");
        }
        if (pn.get(0).getTrangThai().equals("CHO")) {

            txtThongTinTrangThai.setText("Phiếu đang trong trạng thái chờ kiểm duyệt có thể chỉnh sửa");
        }
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
            String giaNhap = String.valueOf(ctpnDTO.getGiaNhap());
            model.addRow(new Object[]{ctpnDTO.getMaPhieuNhap(), ctpnDTO.getMaHangNhap(), ctpnDTO.getTenHangNhap(), tenNCC, ctpnDTO.getVAT(), ctpnDTO.getXuatXu(), ctpnDTO.getSoLuong(), ctpnDTO.getDonVi(), giaNhap, ctpnDTO.getTongTienNhap()});
        }
        model.addRow(new Object[]{null, null, null, null, null, null, null, null, "Tổng:", total});
//        pnBUS.suaTongtien(MaPN, total);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePhieuYeuCauNhap = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtMaSP = new javax.swing.JTextField();
        txtSuaGiaNhap = new javax.swing.JTextField();
        txtXuatXu = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtSuaSoLuong = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        txtThongTinTrangThai = new javax.swing.JLabel();
        txtMaPN = new javax.swing.JLabel();

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
        tablePhieuYeuCauNhap.setRowHeight(40);
        tablePhieuYeuCauNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePhieuYeuCauNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePhieuYeuCauNhap);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        txtMaSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã sản phẩm"));
        txtMaSP.setEnabled(false);

        txtSuaGiaNhap.setBorder(javax.swing.BorderFactory.createTitledBorder("Sửa giá nhập"));

        txtXuatXu.setBorder(javax.swing.BorderFactory.createTitledBorder("Sửa xuất xứ"));

        txtTenSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên sản phẩm"));
        txtTenSP.setEnabled(false);

        txtSuaSoLuong.setBorder(javax.swing.BorderFactory.createTitledBorder("Sửa số lượng"));

        btnUpdate.setBackground(new java.awt.Color(51, 255, 0));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/updated.png"))); // NOI18N
        btnUpdate.setText("SỬA THÔNG TIN");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtThongTinTrangThai.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtThongTinTrangThai.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSuaGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(206, 206, 206)
                        .addComponent(txtThongTinTrangThai))
                    .addComponent(txtSuaSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(423, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaSP)
                        .addComponent(txtSuaGiaNhap))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtThongTinTrangThai)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSuaSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtMaPN.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        txtMaPN.setForeground(new java.awt.Color(255, 0, 51));
        txtMaPN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaPN.setText("jLabel1");
        txtMaPN.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(txtMaPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaPN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        //timCTPN(String maPhieuNhap,String maHangNhap, String tenHangNhap, String xuatXu)
        String MaSP = txtMaSP.getText();
        String tenSP = txtTenSP.getText();
        String xuatXu = txtXuatXu.getText();
        String soLuong = txtSuaSoLuong.getText();
        String giaNhap = txtSuaGiaNhap.getText();
        int newSoLuong = Integer.parseInt(soLuong);
        double newGiaNhap = Double.parseDouble(giaNhap);
        if (newSoLuong <= 0) {
            JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0");
            return;
        }

        if (newGiaNhap <= 0) {
            JOptionPane.showMessageDialog(null, "Giá nhập phải lớn hơn 0");
            return;
        }

        if (soLuong.equals("") || giaNhap.equals("") || tenSP.equals("") || xuatXu.equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ giá trị");
            return;
        }
        try {
            int x = Integer.parseInt(soLuong);
            double y = Double.parseDouble(giaNhap);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nhập không đúng định dạng số.");
            return;
        }
        
        ArrayList<ChiTietPhieuNhap_DTO> ctpn = pycnDAO.searchCTPN(MaPN, MaSP, null, null);
      
        ctpn.get(0).setTenHangNhap(tenSP);
        ctpn.get(0).setXuatXu(xuatXu);
        ctpn.get(0).setGiaNhap(newGiaNhap);
        ctpn.get(0).setSoLuong(newSoLuong);
        ctpn.get(0).setTongTienNhap(newGiaNhap * newSoLuong);

        int dialogResult = JOptionPane.showConfirmDialog(null, "Xác nhận sửa yêu cầu sản phẩm", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            pycnDAO.updateCTPN(ctpn.get(0));
            ArrayList<ChiTietPhieuNhap_DTO> chiTietPhieuNhap = pycnDAO.searchCTPN(MaPN, null, null, null);
            double total = 0;
            for (int i = 0; i < chiTietPhieuNhap.size(); i++) {
                ChiTietPhieuNhap_DTO ctpnDTO = chiTietPhieuNhap.get(i);

                total += ctpnDTO.getTongTienNhap();

            }
            pnBUS.suaTongtien(MaPN, total);
            showPhieuNhapInTable();
        } else {
            return;
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tablePhieuYeuCauNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePhieuYeuCauNhapMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
            int selectedRow = tablePhieuYeuCauNhap.getSelectedRow();
            if (selectedRow != -1) {
                txtMaSP.setText((String) tablePhieuYeuCauNhap.getValueAt(selectedRow, 1));
                txtTenSP.setText((String) tablePhieuYeuCauNhap.getValueAt(selectedRow, 2));
                txtSuaSoLuong.setText(String.valueOf(tablePhieuYeuCauNhap.getValueAt(selectedRow, 6)));
                txtSuaGiaNhap.setText((String) tablePhieuYeuCauNhap.getValueAt(selectedRow, 8));
                txtXuatXu.setText((String) tablePhieuYeuCauNhap.getValueAt(selectedRow, 5));

            }
        }
    }//GEN-LAST:event_tablePhieuYeuCauNhapMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePhieuYeuCauNhap;
    private javax.swing.JLabel txtMaPN;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSuaGiaNhap;
    private javax.swing.JTextField txtSuaSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JLabel txtThongTinTrangThai;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}
