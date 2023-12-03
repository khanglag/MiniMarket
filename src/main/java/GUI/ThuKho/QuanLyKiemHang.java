/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ThuKho;

import BUS.PhieuKiemHangBus;
import Controller.TaiKhoanController;
import DTO.PhieuKiemHang_DTO;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khang
 */
public class QuanLyKiemHang extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyKiemHang
     */
    PhieuKiemHangBus phieuKiemHangBus = new PhieuKiemHangBus();
    DefaultTableModel model;
    ArrayList<PhieuKiemHang_DTO> list = new ArrayList<PhieuKiemHang_DTO>();
    public QuanLyKiemHang() {
        initComponents();
        jtfMaNV.setText(TaiKhoanController.getTendnString());
        LoadData();
    }

    public void LoadData() {
        model = (DefaultTableModel) jTablePhieuKiemHang.getModel();
        model.setRowCount(0);
        list = phieuKiemHangBus.rKiemHang_DTOs();
        int i = 0;
        while (i <= list.size() - 1) {
            PhieuKiemHang_DTO px = list.get(i);
            model.addRow(new Object[] {
                  px.getMaPhieu(),px.getMaNV(),px.getThoiGianKiemHang()
            });
            jTablePhieuKiemHang.setModel(model);
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
        jMenuItemXemChiTietPhieuKiemHang = new javax.swing.JMenuItem();
        jMenuItemTaoChiTietPhieuKiemHang = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePhieuKiemHang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfMaPhieu = new javax.swing.JTextField();
        jtfMaNV = new javax.swing.JTextField();
        jtfThoiGian = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        jtfTim = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnTaoPhieuKiemHang = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        jMenuItemXemChiTietPhieuKiemHang.setText("Xem chi tiết phiếu kiểm hàng");
        jMenuItemXemChiTietPhieuKiemHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemXemChiTietPhieuKiemHangActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemXemChiTietPhieuKiemHang);

        jMenuItemTaoChiTietPhieuKiemHang.setText("Tạo chi tiết phiếu kiểm hàng");
        jMenuItemTaoChiTietPhieuKiemHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTaoChiTietPhieuKiemHangActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemTaoChiTietPhieuKiemHang);

        setBackground(new java.awt.Color(176, 206, 221));

        jTablePhieuKiemHang.setForeground(new java.awt.Color(255, 255, 255));
        jTablePhieuKiemHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phiếu", "Mã nhân viên", "Thời gian"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePhieuKiemHang.setSelectionBackground(new java.awt.Color(176, 206, 221));
        jTablePhieuKiemHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePhieuKiemHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePhieuKiemHang);

        jPanel1.setBackground(new java.awt.Color(176, 206, 221));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Phiếu kiểm hàng"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Mã phiếu");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Thời gian");

        jtfMaPhieu.setEditable(false);

        jtfMaNV.setEditable(false);

        jtfThoiGian.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfMaPhieu)
                    .addComponent(jtfMaNV)
                    .addComponent(jtfThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel2.setBackground(new java.awt.Color(176, 206, 221));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTim)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(176, 206, 221));

        btnTaoPhieuKiemHang.setBackground(new java.awt.Color(67, 138, 174));
        btnTaoPhieuKiemHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTaoPhieuKiemHang.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoPhieuKiemHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create.png"))); // NOI18N
        btnTaoPhieuKiemHang.setText("TẠO PHIẾU KIỂM HÀNG");
        btnTaoPhieuKiemHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuKiemHangActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(67, 138, 174));
        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bin.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnTaoPhieuKiemHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(82, 82, 82)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoPhieuKiemHang)
                    .addComponent(btnXoa)))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        refreshData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int i = jTablePhieuKiemHang.getSelectedRow();
        if (i >= 0) {
            try {
           
                PhieuKiemHang_DTO nv = new PhieuKiemHang_DTO();
                nv.setMaPhieu(jTablePhieuKiemHang.getModel().getValueAt(i, 0).toString());
                
                JOptionPane.showMessageDialog(this, phieuKiemHangBus.xoaPhieu(nv));
                jTablePhieuKiemHang.repaint();
                refreshData();
            
            } catch (Exception ex) {

            }
        }else{
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn phiếu kiểm hàng muốn xóa");
        }
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTaoPhieuKiemHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhieuKiemHangActionPerformed
        // TODO add your handling code here:
        try {
           
                PhieuKiemHang_DTO nv = new PhieuKiemHang_DTO();
                nv.setMaNV(jtfMaNV.getText());
                nv.setThoiGianKiemHang(LocalDate.now());
                System.out.println(nv);
                phieuKiemHangBus.themPhieu(nv);
                jTablePhieuKiemHang.repaint();
                refreshData();
            
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnTaoPhieuKiemHangActionPerformed

    private void jTablePhieuKiemHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePhieuKiemHangMouseClicked
        // TODO add your handling code here:
        int i = jTablePhieuKiemHang.getSelectedRow();
        if (i >= 0) {
            jtfMaPhieu.setText(jTablePhieuKiemHang.getModel().getValueAt(i, 0).toString());
            jtfMaNV.setText(jTablePhieuKiemHang.getModel().getValueAt(i, 1).toString());
            jtfThoiGian.setText(jTablePhieuKiemHang.getModel().getValueAt(i, 2).toString());
            jPopupMenu.show(jTablePhieuKiemHang, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTablePhieuKiemHangMouseClicked

    private void jMenuItemXemChiTietPhieuKiemHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemXemChiTietPhieuKiemHangActionPerformed
        // TODO add your handling code here:
        int i = jTablePhieuKiemHang.getSelectedRow();
        if (i >= 0) {
            new ChiTietKiemHangView(jTablePhieuKiemHang.getModel().getValueAt(i, 0).toString()).setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemXemChiTietPhieuKiemHangActionPerformed

    private void jMenuItemTaoChiTietPhieuKiemHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTaoChiTietPhieuKiemHangActionPerformed
        // TODO add your handling code here:
        int i = jTablePhieuKiemHang.getSelectedRow();
        if (i >= 0) {
            if(!phieuKiemHangBus.checkExist(jtfMaPhieu.getText())){
                new ChiTietKiemHang(jTablePhieuKiemHang.getModel().getValueAt(i, 0).toString()).setVisible(true);
        
            }else
                JOptionPane.showMessageDialog(null, "Chi tiết kiểm hàng đã được tạo");
        }
    }//GEN-LAST:event_jMenuItemTaoChiTietPhieuKiemHangActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) jTablePhieuKiemHang.getModel();
        model.setRowCount(0);
        list = phieuKiemHangBus.timPhieu(jtfTim.getText(),null, null);
        int i = 0;
        while (i <= list.size() - 1) {
            PhieuKiemHang_DTO px = list.get(i);
            model.addRow(new Object[] {
                  px.getMaPhieu(),px.getMaNV(),px.getThoiGianKiemHang()
            });
            jTablePhieuKiemHang.setModel(model);
            ++i;
        }

        
    }//GEN-LAST:event_btnTimActionPerformed

    public void refreshData(){
        phieuKiemHangBus = new PhieuKiemHangBus();
        LoadData();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTaoPhieuKiemHang;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItemTaoChiTietPhieuKiemHang;
    private javax.swing.JMenuItem jMenuItemXemChiTietPhieuKiemHang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePhieuKiemHang;
    private javax.swing.JTextField jtfMaNV;
    private javax.swing.JTextField jtfMaPhieu;
    private javax.swing.JTextField jtfThoiGian;
    private javax.swing.JTextField jtfTim;
    // End of variables declaration//GEN-END:variables
}
