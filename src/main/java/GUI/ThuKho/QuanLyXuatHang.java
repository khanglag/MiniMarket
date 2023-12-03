/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ThuKho;

import BUS.ChiTietPhieuXuatBus;
import BUS.KhachHangBus;
import BUS.PhieuXuatBus;
import Controller.TaiKhoanController;
import DTO.KhachHang_DTO;
import DTO.PhieuXuat_DTO;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khang
 */
public class QuanLyXuatHang extends javax.swing.JPanel {

    PhieuXuatBus phieuXuatBus = new PhieuXuatBus();
    DefaultTableModel model;
    ArrayList<PhieuXuat_DTO> list = new ArrayList<PhieuXuat_DTO>();
    ChiTietPhieuXuatBus ctpx = new ChiTietPhieuXuatBus();
    /**
     * Creates new form QuanLyXuatHang
     */
    public QuanLyXuatHang() {
        initComponents();
        jtfMaNhanVien.setText(TaiKhoanController.getTendnString());
        LoadData();
    }
    public void LoadData() {
        model = (DefaultTableModel) jTableQuanLyXuatHang.getModel();
        model.setRowCount(0);
        list = phieuXuatBus.readPhieuXuat_DTOs();
        int i = 0;
        while (i <= list.size() - 1) {
            PhieuXuat_DTO px = list.get(i);
            model.addRow(new Object[] {
                    ++i, px.getMaPhieuXuat(),px.getMaNV(),px.getMaKH(),px.getTongTien(),px.getThoiGianXuat(),px.getLyDo(),px.getGhiChu()
            });
            jTableQuanLyXuatHang.setModel(model);

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
        jMenuItemTaoChiTietPhieuXuat = new javax.swing.JMenuItem();
        jMenuItemXemChiTietPhieuXuat = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableQuanLyXuatHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtfMaPhieuXuat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfMaNhanVien = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnChon = new javax.swing.JButton();
        jtfMaKhachHang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfTongTien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfThoiGianXuat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfLyDo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfGhiChu = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnTaoPhieuXuat = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jtfTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();

        jMenuItemTaoChiTietPhieuXuat.setText("Tạo chi tiết phiếu xuất");
        jMenuItemTaoChiTietPhieuXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTaoChiTietPhieuXuatActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemTaoChiTietPhieuXuat);

        jMenuItemXemChiTietPhieuXuat.setText("Xem chi tiết phiếu xuất");
        jMenuItemXemChiTietPhieuXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemXemChiTietPhieuXuatActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemXemChiTietPhieuXuat);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(176, 206, 221));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jTableQuanLyXuatHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu xuất", "Mã nhân viên", "Mã khách hàng", "Tổng tiền", "Thời gian xuất", "Lý do", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableQuanLyXuatHang.setSelectionBackground(new java.awt.Color(176, 206, 221));
        jTableQuanLyXuatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableQuanLyXuatHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableQuanLyXuatHang);
        if (jTableQuanLyXuatHang.getColumnModel().getColumnCount() > 0) {
            jTableQuanLyXuatHang.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jPanel2.setBackground(new java.awt.Color(176, 206, 221));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu xuất"));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(176, 206, 221));
        jPanel3.setLayout(new java.awt.GridLayout(7, 0, 0, 5));

        jLabel4.setText("Mã phiếu xuất");
        jPanel3.add(jLabel4);

        jtfMaPhieuXuat.setEditable(false);
        jPanel3.add(jtfMaPhieuXuat);

        jLabel8.setText("Mã nhân viên");
        jPanel3.add(jLabel8);

        jtfMaNhanVien.setEditable(false);
        jPanel3.add(jtfMaNhanVien);

        jLabel13.setText("Mã khách hàng");
        jPanel3.add(jLabel13);

        jPanel6.setBackground(new java.awt.Color(176, 206, 221));

        btnChon.setBackground(new java.awt.Color(67, 138, 174));
        btnChon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnChon.setForeground(new java.awt.Color(255, 255, 255));
        btnChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SELECT.png"))); // NOI18N
        btnChon.setText("CHỌN");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        jtfMaKhachHang.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jtfMaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtfMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel6);

        jLabel2.setText("Tổng tiền");
        jPanel3.add(jLabel2);

        jtfTongTien.setEditable(false);
        jPanel3.add(jtfTongTien);

        jLabel3.setText("Thời gian xuất");
        jPanel3.add(jLabel3);

        jtfThoiGianXuat.setEditable(false);
        jPanel3.add(jtfThoiGianXuat);

        jLabel1.setText("Lý do");
        jPanel3.add(jLabel1);
        jPanel3.add(jtfLyDo);

        jLabel9.setText("Ghi chú");
        jPanel3.add(jLabel9);
        jPanel3.add(jtfGhiChu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        btnTaoPhieuXuat.setBackground(new java.awt.Color(67, 138, 174));
        btnTaoPhieuXuat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTaoPhieuXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoPhieuXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create.png"))); // NOI18N
        btnTaoPhieuXuat.setText("TẠO PHIẾU XUẤT");
        btnTaoPhieuXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuXuatActionPerformed(evt);
            }
        });

        btnLoad.setBackground(new java.awt.Color(67, 138, 174));
        btnLoad.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLoad.setForeground(new java.awt.Color(255, 255, 255));
        btnLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync.png"))); // NOI18N
        btnLoad.setText("LÀM MỚI");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(67, 138, 174));
        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/broom.png"))); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(67, 138, 174));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excel.png"))); // NOI18N
        jButton6.setText("NHẬP EXCEL");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(btnTaoPhieuXuat)
                .addGap(67, 67, 67)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton6)
                .addGap(53, 53, 53)
                .addComponent(jButton7)
                .addGap(37, 37, 37)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(176, 206, 221));
        jPanel5.setLayout(new java.awt.GridLayout(6, 0, 0, 5));

        jtfTim.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm"));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTim))
                                .addGap(63, 63, 63))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnTim))
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1325, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(14, 14, 14)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int i = jTableQuanLyXuatHang.getSelectedRow();
        if(i >=0){
            KhachHangBus khbus = new KhachHangBus();
            KhachHang_DTO kh = khbus.timKhachHangMaKH(jtfMaKhachHang.getText());
            
            ctpx.xuatEX(jtfMaPhieuXuat.getText());
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu");
            
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTableQuanLyXuatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableQuanLyXuatHangMouseClicked
        // TODO add your handling code here:
        int i = jTableQuanLyXuatHang.getSelectedRow();
        if (i >= 0) {
            jtfMaPhieuXuat.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 1).toString());
            jtfMaNhanVien.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 2).toString());
            jtfMaKhachHang.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 3).toString());
            jtfTongTien.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 4).toString());
            jtfThoiGianXuat.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 5).toString());
            jtfLyDo.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 6).toString());
            jtfGhiChu.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 7).toString());
            jPopupMenu.show(jTableQuanLyXuatHang, evt.getX(), evt.getY());
        }
        
    }//GEN-LAST:event_jTableQuanLyXuatHangMouseClicked

    private void btnTaoPhieuXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhieuXuatActionPerformed
        // TODO add your handling code here:
        try {
            if (jtfMaKhachHang.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin");
            } else {
                PhieuXuat_DTO nv = new PhieuXuat_DTO();
                nv.setMaNV(jtfMaNhanVien.getText());
                nv.setMaKH(jtfMaKhachHang.getText());
                nv.setThoiGianXuat(LocalDate.now());
                nv.setLyDo(jtfLyDo.getText());
                nv.setGhiChu(jtfGhiChu.getText());
                phieuXuatBus.themPhieuXuat(nv);
                jTableQuanLyXuatHang.repaint();
                refreshData();
            }
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnTaoPhieuXuatActionPerformed

    private void jMenuItemTaoChiTietPhieuXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTaoChiTietPhieuXuatActionPerformed
        // TODO add your handling code here:int i = jTableQuanLyXuatHang.getSelectedRow();
        int i =jTableQuanLyXuatHang.getSelectedRow();
        if (i >= 0) {
            jtfMaPhieuXuat.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 1).toString());
            if(phieuXuatBus.checkExist(jtfMaPhieuXuat.getText()))
                new ChiTietPhieuXuat(jtfMaPhieuXuat.getText()).setVisible(true);
            else
                JOptionPane.showMessageDialog(this, "Đã tạo chi tiết phiếu xuất");
        }
        
    }//GEN-LAST:event_jMenuItemTaoChiTietPhieuXuatActionPerformed

    private void jMenuItemXemChiTietPhieuXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemXemChiTietPhieuXuatActionPerformed
        // TODO add your handling code here:
        new ChiTietPhieuXuatView(jtfMaPhieuXuat.getText(),jtfMaKhachHang.getText()).setVisible(true);
    }//GEN-LAST:event_jMenuItemXemChiTietPhieuXuatActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        KhachHang kh;
        kh = new KhachHang(null);
        kh.setVisible(true);
        String makh = kh.getMaKH();
        if(makh!=null){
            jtfMaKhachHang.setText(makh);
        }
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
       
        refreshData();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        ArrayList<PhieuXuat_DTO> listS = new ArrayList<PhieuXuat_DTO>();
        listS = phieuXuatBus.timPhieuXuat(jtfTim.getText(), null, null,null);
        model = (DefaultTableModel) jTableQuanLyXuatHang.getModel();
        model.setRowCount(0);
        int i = 0;
        while (i <= listS.size() - 1) {
            PhieuXuat_DTO px = listS.get(i);
            model.addRow(new Object[] {
                    ++i, px.getMaPhieuXuat(),px.getMaNV(),px.getMaKH(),px.getTongTien(),px.getThoiGianXuat(),px.getLyDo(),px.getGhiChu()
            });
            jTableQuanLyXuatHang.setModel(model);

        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        jtfMaPhieuXuat.setText("");
        jtfMaKhachHang.setText("");
        jtfTongTien.setText("");
        jtfThoiGianXuat.setText("");
        jtfLyDo.setText("");
        jtfGhiChu.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

      public void refreshData() {
        phieuXuatBus = new PhieuXuatBus();
        LoadData();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnTaoPhieuXuat;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItemTaoChiTietPhieuXuat;
    private javax.swing.JMenuItem jMenuItemXemChiTietPhieuXuat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableQuanLyXuatHang;
    private javax.swing.JTextField jtfGhiChu;
    private javax.swing.JTextField jtfLyDo;
    private javax.swing.JTextField jtfMaKhachHang;
    private javax.swing.JTextField jtfMaNhanVien;
    private javax.swing.JTextField jtfMaPhieuXuat;
    private javax.swing.JTextField jtfThoiGianXuat;
    private javax.swing.JTextField jtfTim;
    private javax.swing.JTextField jtfTongTien;
    // End of variables declaration//GEN-END:variables
}
