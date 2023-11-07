/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.ThuKho;

import BUS.PhieuNhapBus;
import BUS.PhieuYeuCauNhapBus;
import DTO.ChiTietPhieuNhap_DTO;
import DTO.HangHoa_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khang
 */
public class ChiTietPhieuNhap extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietPhieuNhap
     */
    PhieuYeuCauNhapBus phieuYeuCauNhapBus = new  PhieuYeuCauNhapBus();
    PhieuNhapBus phieuNhapBus = new PhieuNhapBus();
    DefaultTableModel model;
    ArrayList<ChiTietPhieuNhap_DTO> list = new ArrayList<ChiTietPhieuNhap_DTO>();
    
    double thanhtien =0;
    public ChiTietPhieuNhap(String ma) {
        initComponents();
        jtfMaPhieuNhap.setText(ma);
    }

    public void LoadData() {
        thanhtien=0;
        model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        
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
        jPanel2 = new javax.swing.JPanel();
        jtfMaHangNhap = new javax.swing.JTextField();
        btnChon = new javax.swing.JButton();
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
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnTaoYeuCau = new javax.swing.JButton();

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

        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jtfMaHangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfMaHangNhap)
                    .addComponent(btnChon, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel36.add(jPanel2);

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

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnTaoYeuCau.setText("Tạo yêu cầu nhập");
        btnTaoYeuCau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoYeuCauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaoYeuCau)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLamMoi)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDong)
                    .addComponent(btnTaoYeuCau))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDonViMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfDonViMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDonViMouseClicked

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

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        HangHoa hangHoa = new HangHoa(this,1);
        hangHoa.setVisible(true);
        HangHoa_DTO selectedHangHoa = hangHoa.getSelectedHangHoa();
        if(selectedHangHoa!=null){
            jtfMaHangNhap.setText(selectedHangHoa.getMaSP());
            jtfTenHangNhap.setText(selectedHangHoa.getTenSP());
            jtfDonVi.setText(selectedHangHoa.getDonVi());
            jtfXuatXu.setText(selectedHangHoa.getXuatXu());
            jtfVAT.setText("0.08");
            jtfMaNCC.setText(selectedHangHoa.getMaNCC());
            double gia = selectedHangHoa.getGiaBan();
            jtfGiaNhap.setText(Double.toString(gia));
            
            
        }
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        boolean flag = false;
        for(ChiTietPhieuNhap_DTO ctpn: list){
            if(ctpn.getMaHangNhap().equals(jtfMaHangNhap.getText())){
                flag = true;
            }
        }
        if(flag){
            JOptionPane.showMessageDialog(this,  "Mã hàng đã được chọn, vui lòng chọn mã khác!");
        }else{
            double gia = Double.parseDouble(jtfGiaNhap.getText());
            ChiTietPhieuNhap_DTO ctpn = new ChiTietPhieuNhap_DTO(jtfMaPhieuNhap.getText(),jtfMaHangNhap.getText(),jtfTenHangNhap.getText(),
                                                                 jtfMaNCC.getText(),0.08,jtfXuatXu.getText(),
                                                                 0,jtfDonVi.getText(),gia,0,true);
            list.add(ctpn);
        }
        LoadData();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int i = jTable.getSelectedRow();
        if(i>=0){
            for(ChiTietPhieuNhap_DTO ctpn : list){
                if(ctpn.getMaHangNhap().equals(jTable
                .getModel().getValueAt(i, 1).toString())){
                    if(list.remove(ctpn)){
                      JOptionPane.showMessageDialog(this,  "Đã xoá!");
                    }else{
                        JOptionPane.showMessageDialog(this,  "Lỗi !");
                    }  
                    
                }
            }
        }
        LoadData();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        LoadData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTaoYeuCauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoYeuCauActionPerformed
        // TODO add your handling code here:
        boolean flag = false;
        for(ChiTietPhieuNhap_DTO ctpn: list){
            if(phieuYeuCauNhapBus.themCTPN(ctpn)){
                flag = true;
            }else{
                flag = false;
            }
        }
        if(flag){
            JOptionPane.showMessageDialog(this,  "Tạo thành công");
            this.dispose();
        }
    }//GEN-LAST:event_btnTaoYeuCauActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTaoYeuCau;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
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
    private javax.swing.JPanel jPanel2;
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
