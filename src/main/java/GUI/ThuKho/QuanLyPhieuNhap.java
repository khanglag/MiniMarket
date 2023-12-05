/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ThuKho;

import BUS.PhieuNhapBus;
import BUS.PhieuYeuCauNhapBus;
import Controller.TaiKhoanController;
import DTO.ChiTietPhieuNhap_DTO;
import DTO.PhieuNhap_DTO;
import GUI.QuanLy.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class QuanLyPhieuNhap extends javax.swing.JPanel {

    /**
     * Creates new form QuanLySanPham
     */
    PhieuYeuCauNhapBus phieuYeuCauNhapBus = new  PhieuYeuCauNhapBus();
    ArrayList<ChiTietPhieuNhap_DTO> listEx = new ArrayList<ChiTietPhieuNhap_DTO>();
    PhieuNhapBus phieuNhapBus = new PhieuNhapBus();
    DefaultTableModel model;
    ArrayList<PhieuNhap_DTO> list = new ArrayList<PhieuNhap_DTO>();
    PhieuYeuCauNhapBus pyc = new PhieuYeuCauNhapBus();
    
    public QuanLyPhieuNhap() {
        initComponents();
        jtfMaNhanVien.setText(TaiKhoanController.getTendnString());
        LoadData();
    }
    public void LoadData() {
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        list = phieuNhapBus.rPhieuNhap_DTOs();
        int i = 0;
        while (i <= list.size() - 1) {
            PhieuNhap_DTO px = list.get(i);
            model.addRow(new Object[] {
                    px.getMaPhieuNhap(),px.getMaNV(),px.getThoiGianLap(),px.getVAT(),px.getSoMatHang(),px.getTongTien(),px.getTrangThai()
            });
            table.setModel(model);
            ++i;
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

        jPopupMenu = new javax.swing.JPopupMenu();
        jMenuItemTaoChiTietPhieuNhap = new javax.swing.JMenuItem();
        jMenuItemXemChiTietPhieuNhap = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtfMaPhieuNhap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfMaNhanVien = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtfThoiGian = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfVAT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfSoMatHang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfTongTien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfTrangThai = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnTaoPhieuXuat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnNhapEx = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        jtfTim = new javax.swing.JTextField();

        jMenuItemTaoChiTietPhieuNhap.setText("Tạo chi tiết phiếu nhập");
        jMenuItemTaoChiTietPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTaoChiTietPhieuNhapActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemTaoChiTietPhieuNhap);

        jMenuItemXemChiTietPhieuNhap.setText("Xem chi tiết phiếu nhập");
        jMenuItemXemChiTietPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemXemChiTietPhieuNhapActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemXemChiTietPhieuNhap);

        setBackground(new java.awt.Color(176, 206, 221));
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(176, 206, 221));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu nhập"));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(176, 206, 221));
        jPanel2.setLayout(new java.awt.GridLayout(7, 2, 5, 5));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Mã Phiếu nhập");
        jPanel2.add(jLabel4);

        jtfMaPhieuNhap.setEditable(false);
        jtfMaPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMaPhieuNhapActionPerformed(evt);
            }
        });
        jPanel2.add(jtfMaPhieuNhap);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Mã nhân viên");
        jPanel2.add(jLabel8);

        jtfMaNhanVien.setEditable(false);
        jtfMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMaNhanVienActionPerformed(evt);
            }
        });
        jPanel2.add(jtfMaNhanVien);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Thời gian");
        jPanel2.add(jLabel13);

        jtfThoiGian.setEditable(false);
        jPanel2.add(jtfThoiGian);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("VAT");
        jPanel2.add(jLabel7);

        jtfVAT.setEditable(false);
        jPanel2.add(jtfVAT);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Số mặt hàng");
        jPanel2.add(jLabel1);

        jtfSoMatHang.setEditable(false);
        jPanel2.add(jtfSoMatHang);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Tổng tiền");
        jPanel2.add(jLabel9);

        jtfTongTien.setEditable(false);
        jPanel2.add(jtfTongTien);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Trạng thái");
        jPanel2.add(jLabel2);

        jtfTrangThai.setEditable(false);
        jPanel2.add(jtfTrangThai);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        btnTaoPhieuXuat.setBackground(new java.awt.Color(67, 138, 174));
        btnTaoPhieuXuat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTaoPhieuXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoPhieuXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create.png"))); // NOI18N
        btnTaoPhieuXuat.setText("TẠO PHIẾU NHẬP");
        btnTaoPhieuXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuXuatActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(67, 138, 174));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync.png"))); // NOI18N
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnNhapEx.setBackground(new java.awt.Color(67, 138, 174));
        btnNhapEx.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNhapEx.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Excel (2).png"))); // NOI18N
        btnNhapEx.setText("NHẬP EXCEL");
        btnNhapEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapExActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(67, 138, 174));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/XuatExcel.png"))); // NOI18N
        jButton7.setText("XUẤT EXCEL");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(67, 138, 174));
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Print.png"))); // NOI18N
        jButton8.setText("IN");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu nhập", "Mã nhân viên", "Thời gian", "VAT", "Số mặt hàng", "Tổng tiền", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionBackground(new java.awt.Color(176, 206, 221));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btnTaoPhieuXuat)
                .addGap(61, 61, 61)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnNhapEx, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapEx, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setLayout(new java.awt.GridLayout(5, 0, 0, 5));

        btnTim.setBackground(new java.awt.Color(67, 138, 174));
        btnTim.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btnTim.setText("TÌM KIẾM");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jtfTim.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnTim)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnTaoPhieuXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhieuXuatActionPerformed
        // TODO add your handling code here:
        try {
                PhieuNhap_DTO nv = new PhieuNhap_DTO();
                nv.setMaNV(jtfMaNhanVien.getText());
                nv.setThoiGianLap(LocalDate.now());
                nv.setVAT(0);
                nv.setSoMatHang(0);
                nv.setTongTien(0);
                nv.setTrangThai("CHO");
                phieuNhapBus.themPhieuNhap(nv);
                table.repaint();
                refreshData();
            
        } catch (Exception ex) {

        }
        
    }//GEN-LAST:event_btnTaoPhieuXuatActionPerformed

    public void refreshData(){
        phieuNhapBus = new PhieuNhapBus();
        LoadData();
    }
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        refreshData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int i = table.getSelectedRow();
        if(i>=0){
            jtfMaPhieuNhap.setText(table.getModel().getValueAt(i, 0).toString());
            jtfMaNhanVien.setText((String) table.getModel().getValueAt(i, 1));
            jtfThoiGian.setText(table.getModel().getValueAt(i, 2).toString());
            jtfVAT.setText(table.getModel().getValueAt(i, 3).toString());
            jtfSoMatHang.setText(table.getModel().getValueAt(i, 4).toString());
            jtfTongTien.setText(Handle.Convert.soqualon((double) table.getModel().getValueAt(i, 5)));
            jtfTrangThai.setText(table.getModel().getValueAt(i, 6).toString());
            jPopupMenu.show(table, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tableMouseClicked

    private void jMenuItemXemChiTietPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemXemChiTietPhieuNhapActionPerformed
        // TODO add your handling code here:
        int i = table.getSelectedRow();
        new ChiTietPhieuNhapView(table.getModel().getValueAt(i, 0).toString(),jtfTrangThai.getText()).setVisible(true);
    }//GEN-LAST:event_jMenuItemXemChiTietPhieuNhapActionPerformed

    private void jMenuItemTaoChiTietPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTaoChiTietPhieuNhapActionPerformed
        // TODO add your handling code here:
        int i = table.getSelectedRow();
        if(jtfTrangThai.getText().toUpperCase().equals("DA NHAP")){
            JOptionPane.showMessageDialog(this,  "Phiếu nhập đã được nhập");
        }else if(!pyc.checkExist(table.getModel().getValueAt(i, 0).toString())){
               new ChiTietPhieuNhap(table.getModel().getValueAt(i, 0).toString()).setVisible(true);
        }else if(jtfTrangThai.getText().toUpperCase().equals("KHONG DUYET")){
            JOptionPane.showMessageDialog(this,  "Phiếu nhập đã bị từ chối");
        }else{
            JOptionPane.showMessageDialog(this,  "Phiếu nhập đã được tạo");
        }
        
    }//GEN-LAST:event_jMenuItemTaoChiTietPhieuNhapActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        list = phieuNhapBus.timPhieuNhap(jtfTim.getText(), null, null, null);
        int i = 0;
        while (i <= list.size() - 1) {
            PhieuNhap_DTO px = list.get(i);
            model.addRow(new Object[] {
                    px.getMaPhieuNhap(),px.getMaNV(),px.getThoiGianLap(),px.getVAT(),px.getSoMatHang(),px.getTongTien(),px.getTrangThai()
            });
            table.setModel(model);
            ++i;
        }

    }//GEN-LAST:event_btnTimActionPerformed

    private void jtfMaPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMaPhieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMaPhieuNhapActionPerformed

    private void jtfMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMaNhanVienActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton8ActionPerformed

    public void NhapEx(){
        
            try {
                // TODO add your handling code here:

                listEx = phieuYeuCauNhapBus.nhapPN(jtfMaPhieuNhap.getText());
            } catch (IOException ex) {
            }
            double tongtien =0;
            int n = listEx.size();
            boolean flag = false;
            for(ChiTietPhieuNhap_DTO ctpn: listEx){
                if(phieuYeuCauNhapBus.themCTPN(ctpn)){
                    flag = true;
                    tongtien += ctpn.getTongTienNhap();
                }else{
                    flag = false;
                }
            }
            if(flag){

                JOptionPane.showMessageDialog(this,  "Tạo thành công!");
                phieuNhapBus.suaPhieuNhap(jtfMaPhieuNhap.getText(), 0.08, n, tongtien, "CHO");

                }
        
    }
    private void btnNhapExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapExActionPerformed
        int i = table.getSelectedRow();
        if(i>=0){
            if(jtfTrangThai.getText().toUpperCase().equals("DA NHAP")){
                JOptionPane.showMessageDialog(this,  "Phiếu nhập đã được nhập");
            }else if(!pyc.checkExist(table.getModel().getValueAt(i, 0).toString())){
                   try {
                // TODO add your handling code here:

                listEx = phieuYeuCauNhapBus.nhapPN(jtfMaPhieuNhap.getText());
            } catch (IOException ex) {
            }
            double tongtien =0;
            int n = listEx.size();
            boolean flag = false;
            for(ChiTietPhieuNhap_DTO ctpn: listEx){
                if(phieuYeuCauNhapBus.themCTPN(ctpn)){
                    flag = true;
                    tongtien += ctpn.getTongTienNhap();
                }else{
                    flag = false;
                }
            }
            if(flag){

                JOptionPane.showMessageDialog(this,  "Tạo thành công!");
                phieuNhapBus.suaPhieuNhap(jtfMaPhieuNhap.getText(), 0.08, n, tongtien, "CHO");

                }
            }else if(jtfTrangThai.getText().toUpperCase().equals("KHONG DUYET")){
                JOptionPane.showMessageDialog(this,  "Phiếu nhập đã bị từ chối");
            }else{
                JOptionPane.showMessageDialog(this,  "Phiếu nhập đã được tạo");
            }
        }else{
            JOptionPane.showMessageDialog(this,  "Bạn chưa chọn phiếu");
        }
        
    }//GEN-LAST:event_btnNhapExActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnNhapEx;
    private javax.swing.JButton btnTaoPhieuXuat;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItemTaoChiTietPhieuNhap;
    private javax.swing.JMenuItem jMenuItemXemChiTietPhieuNhap;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfMaNhanVien;
    private javax.swing.JTextField jtfMaPhieuNhap;
    private javax.swing.JTextField jtfSoMatHang;
    private javax.swing.JTextField jtfThoiGian;
    private javax.swing.JTextField jtfTim;
    private javax.swing.JTextField jtfTongTien;
    private javax.swing.JTextField jtfTrangThai;
    private javax.swing.JTextField jtfVAT;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
