/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ThuKho;

import BUS.PhieuXuat_BUS;
import DTO.PhieuXuat_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khang
 */
public class QuanLyXuatHang extends javax.swing.JPanel {

    PhieuXuat_BUS phieuXuatBus = new PhieuXuat_BUS();
    DefaultTableModel model;
    ArrayList<PhieuXuat_DTO> list = new ArrayList<PhieuXuat_DTO>();
    /**
     * Creates new form QuanLyXuatHang
     */
    public QuanLyXuatHang() {
        initComponents();
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
                    ++i, px.getMaPhieuXuat(),px.getMaNV(),px.getMaKH(),px.getTongTien(),px.getLyDo(),px.getGhiChu()
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
        jMenuItem3 = new javax.swing.JMenuItem();
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
        jtfMaKhachHang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfTongTien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfLyDo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfGhiChu = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jtfTim = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnTaoPhieuXuat = new javax.swing.JButton();

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

        jMenuItem3.setText("jMenuItem3");
        jPopupMenu.add(jMenuItem3);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jTableQuanLyXuatHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu xuất", "Mã nhân viên", "Mã khách hàng", "Tổng tiền", "Lý do", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableQuanLyXuatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableQuanLyXuatHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableQuanLyXuatHang);
        if (jTableQuanLyXuatHang.getColumnModel().getColumnCount() > 0) {
            jTableQuanLyXuatHang.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu xuất"));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setLayout(new java.awt.GridLayout(6, 2, 5, 5));

        jLabel4.setText("Mã phiếu xuất");
        jPanel3.add(jLabel4);

        jtfMaPhieuXuat.setEditable(false);
        jPanel3.add(jtfMaPhieuXuat);

        jLabel8.setText("Mã nhân viên");
        jPanel3.add(jLabel8);
        jPanel3.add(jtfMaNhanVien);

        jLabel13.setText("Mã khách hàng");
        jPanel3.add(jLabel13);
        jPanel3.add(jtfMaKhachHang);

        jLabel2.setText("Tổng tiền");
        jPanel3.add(jLabel2);

        jtfTongTien.setEditable(false);
        jPanel3.add(jtfTongTien);

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jtfTim.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm"));

        jButton5.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel5.setLayout(new java.awt.GridLayout(5, 0, 0, 5));

        jButton3.setText("Clear");
        jPanel5.add(jButton3);

        jButton6.setText("Nhập Excel");
        jPanel5.add(jButton6);

        jButton7.setText("Xuất Excel");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7);

        jButton8.setText("In");
        jPanel5.add(jButton8);

        btnTaoPhieuXuat.setText("Tạo phiếu xuất");
        btnTaoPhieuXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuXuatActionPerformed(evt);
            }
        });
        jPanel5.add(btnTaoPhieuXuat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(14, 14, 14)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTableQuanLyXuatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableQuanLyXuatHangMouseClicked
        // TODO add your handling code here:
        int i = jTableQuanLyXuatHang.getSelectedRow();
        if (i >= 0) {
            jtfMaPhieuXuat.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 1).toString());
            jtfMaNhanVien.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 2).toString());
            jtfMaKhachHang.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 3).toString());
            jtfTongTien.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 4).toString());
            jtfLyDo.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 5).toString());
            jtfGhiChu.setText(jTableQuanLyXuatHang.getModel().getValueAt(i, 6).toString());
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
                nv.setLyDo(jtfLyDo.getText());
                nv.setGhiChu(jtfGhiChu.getText());
                JOptionPane.showMessageDialog(this, phieuXuatBus.themPhieuXuat(nv));
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
            new ChiTietPhieuXuat(jtfMaPhieuXuat.getText()).setVisible(true);
        }
        
    }//GEN-LAST:event_jMenuItemTaoChiTietPhieuXuatActionPerformed

    private void jMenuItemXemChiTietPhieuXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemXemChiTietPhieuXuatActionPerformed
        // TODO add your handling code here:
        new ChiTietPhieuXuatView(jtfMaPhieuXuat.getText(),jtfMaKhachHang.getText()).setVisible(true);
    }//GEN-LAST:event_jMenuItemXemChiTietPhieuXuatActionPerformed

      public void refreshData() {
        phieuXuatBus = new PhieuXuat_BUS();
        LoadData();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoPhieuXuat;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemTaoChiTietPhieuXuat;
    private javax.swing.JMenuItem jMenuItemXemChiTietPhieuXuat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableQuanLyXuatHang;
    private javax.swing.JTextField jtfGhiChu;
    private javax.swing.JTextField jtfLyDo;
    private javax.swing.JTextField jtfMaKhachHang;
    private javax.swing.JTextField jtfMaNhanVien;
    private javax.swing.JTextField jtfMaPhieuXuat;
    private javax.swing.JTextField jtfTim;
    private javax.swing.JTextField jtfTongTien;
    // End of variables declaration//GEN-END:variables
}
