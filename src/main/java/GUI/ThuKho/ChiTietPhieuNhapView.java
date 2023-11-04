/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.ThuKho;

import BUS.PhieuYeuCauNhapBus;
import DTO.ChiTietPhieuNhap_DTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khang
 */
public class ChiTietPhieuNhapView extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietPhieuNhapView
     */
    PhieuYeuCauNhapBus phieuYeuCauNhapBus = new  PhieuYeuCauNhapBus();
    DefaultTableModel model;
    ArrayList<ChiTietPhieuNhap_DTO> list = new ArrayList<ChiTietPhieuNhap_DTO>();
    double thanhtien =0;
    String trangthai;
    
    public ChiTietPhieuNhapView(String ma, String trangthai) {
        initComponents();
        
        this.trangthai = trangthai;
        System.out.print(trangthai);
       
        setButton(trangthai);
        LoadData(ma);
    }
    public void setButton(String trangthai){
        if(trangthai.equals("Da duyet")){
            btnNhapHang.setVisible(true);
        }else{
            btnNhapHang.setVisible(false);
        }
    }

    public void LoadData(String ma) {
        thanhtien=0;
        model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        list = phieuYeuCauNhapBus.timCTPN(ma, null, null, null);
        int i = 0;
        while (i <= list.size() - 1) {
            ChiTietPhieuNhap_DTO px = list.get(i);
            model.addRow(new Object[] {
                    px.getMaPhieuNhap(),px.getMaHangNhap(),px.getTenHangNhap(),px.getMaNCC(),px.getVAT(),px.getXuatXu(),px.getSoLuong(),px.getDonVi(),px.getGiaNhap(),px.getTongTienNhap()
            });
            jTable.setModel(model);
            ++i;
            thanhtien+=px.getTongTienNhap();
        }
        model.addRow(new Object[] {
                    null,null,null,null, null,null,null
            });
        jTable.setModel(model);
         model.addRow(new Object[] {
                    null,null,null,null, null,null,null,null,"Tổng tiền: ",Handle.Convert.soqualon(thanhtien)
            });
         jTable.setModel(model);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jtfMaPhieuNhap = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jtfMaHangNhap = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jtfTenHangNhap = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfMaNCC = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jtfVAT = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfXuatXu = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jtfSoLuong = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jtfDonVi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfGiaNhap = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jtfThanhTien = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnDong = new javax.swing.JButton();
        btnNhapHang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel36.setLayout(new java.awt.GridLayout(5, 2, 0, 5));

        jLabel36.setText("Mã phiếu nhập");
        jPanel36.add(jLabel36);

        jtfMaPhieuNhap.setEditable(false);
        jPanel36.add(jtfMaPhieuNhap);

        jLabel37.setText("Mã hàng nhập");
        jPanel36.add(jLabel37);

        jtfMaHangNhap.setEditable(false);
        jPanel36.add(jtfMaHangNhap);

        jLabel38.setText("Tên hàng nhập");
        jPanel36.add(jLabel38);

        jtfTenHangNhap.setEditable(false);
        jPanel36.add(jtfTenHangNhap);

        jLabel1.setText("Mã nhà cung cấp");
        jPanel36.add(jLabel1);

        jtfMaNCC.setEditable(false);
        jPanel36.add(jtfMaNCC);

        jLabel39.setText("VAT");
        jPanel36.add(jLabel39);

        jtfVAT.setEditable(false);
        jPanel36.add(jtfVAT);

        jPanel1.add(jPanel36);

        jPanel37.setLayout(new java.awt.GridLayout(5, 2, 0, 5));

        jLabel2.setText("Xuất sứ");
        jPanel37.add(jLabel2);

        jtfXuatXu.setEditable(false);
        jPanel37.add(jtfXuatXu);

        jLabel41.setText("Số lượng");
        jPanel37.add(jLabel41);

        jtfSoLuong.setEditable(false);
        jPanel37.add(jtfSoLuong);

        jLabel40.setText("Đơn vị");
        jPanel37.add(jLabel40);

        jtfDonVi.setEditable(false);
        jtfDonVi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfDonViMouseClicked(evt);
            }
        });
        jPanel37.add(jtfDonVi);

        jLabel3.setText("Giá nhập");
        jPanel37.add(jLabel3);

        jtfGiaNhap.setEditable(false);
        jPanel37.add(jtfGiaNhap);

        jLabel42.setText("Thành tiền");
        jPanel37.add(jLabel42);

        jtfThanhTien.setEditable(false);
        jPanel37.add(jtfThanhTien);

        jPanel1.add(jPanel37);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu nhập", "Mã hàng nhập", "Tên hàng nhập", "Mã nhà cung cấp", "VAT", "Xuất sứ", "Số lượng", "Đơn vị", "Giá nhập", "Tổng tiền nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable);

        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        btnNhapHang.setText("Nhập hàng");
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(451, Short.MAX_VALUE)
                .addComponent(btnDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhapHang)
                .addGap(7, 7, 7))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(426, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDong)
                    .addComponent(btnNhapHang))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDonViMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfDonViMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDonViMouseClicked

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int i = jTable.getSelectedRow();
        if(i>=0){
            jtfMaPhieuNhap.setText(jTable.getModel().getValueAt(i, 0).toString());
            jtfMaHangNhap.setText(jTable.getModel().getValueAt(i, 1).toString());
            jtfTenHangNhap.setText(jTable.getModel().getValueAt(i, 2).toString());
            jtfMaNCC.setText(jTable.getModel().getValueAt(i, 3).toString());
            jtfVAT.setText(jTable.getModel().getValueAt(i, 4).toString());
            jtfXuatXu.setText(jTable.getModel().getValueAt(i, 5).toString());
            jtfSoLuong.setText(jTable.getModel().getValueAt(i, 6).toString());
            jtfDonVi.setText(jTable.getModel().getValueAt(i, 7).toString());
            jtfGiaNhap.setText(jTable.getModel().getValueAt(i, 8).toString());
            jtfThanhTien.setText(jTable.getModel().getValueAt(i, 9).toString());
                    
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhapHangActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jtfDonVi;
    private javax.swing.JTextField jtfGiaNhap;
    private javax.swing.JTextField jtfMaHangNhap;
    private javax.swing.JTextField jtfMaNCC;
    private javax.swing.JTextField jtfMaPhieuNhap;
    private javax.swing.JTextField jtfSoLuong;
    private javax.swing.JTextField jtfTenHangNhap;
    private javax.swing.JTextField jtfThanhTien;
    private javax.swing.JTextField jtfVAT;
    private javax.swing.JTextField jtfXuatXu;
    // End of variables declaration//GEN-END:variables
}
