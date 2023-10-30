/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.ThuKho;

import BUS.ChiTietPhieuXuatBus;
import BUS.PhieuXuatBus;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.HangHoa_DTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khang
 */
public class ChiTietPhieuXuat extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietPhieuXuat
     */
    ChiTietPhieuXuatBus chitiet = new ChiTietPhieuXuatBus();
    PhieuXuatBus phieuXuatBus = new PhieuXuatBus();
    DefaultTableModel model;
    ArrayList<ChiTietPhieuXuat_DTO> list = new ArrayList<ChiTietPhieuXuat_DTO>();
    double thanhtien = 0;
    
    public ChiTietPhieuXuat(String mapx) {
        initComponents();
        jtfMaPhieuXuat.setText(mapx);
    }
    
    public void LoadData(){
        model = (DefaultTableModel) jTablePhieuXuatHang.getModel();
        model.setRowCount(0);
        
        int i = 0;
        while (i <= list.size() - 1) {
            ChiTietPhieuXuat_DTO px = list.get(i);
            model.addRow(new Object[] {
                    ++i, px.getMaPhieuXuat(),px.getMaHangXuat(),px.getSoLuongYC(),px.getSoLuongThucTe(),px.getDonVi(),px.getDonGia(),px.getThanhTien()
            });
            thanhtien+=px.getThanhTien();
            jTablePhieuXuatHang.setModel(model);

        }
        model.addRow(new Object[] {
                    null,null,null,null, null,null,null,null
            });
        jTablePhieuXuatHang.setModel(model);
         model.addRow(new Object[] {
                    null,null,null,null, null,null,"Tổng tiền: ",thanhtien
            });
         jTablePhieuXuatHang.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jtfMaPhieuXuat = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        btnChonMaHang = new javax.swing.JButton();
        jtfMaHang = new javax.swing.JTextField();
        jtfTenHang = new javax.swing.JTextField();
        jtfSoLuongYeuCau = new javax.swing.JTextField();
        jtfSoLuongThucXuat = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jtfDonViTinh = new javax.swing.JTextField();
        jtfDonGia = new javax.swing.JTextField();
        jtfThanhTien = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePhieuXuatHang = new javax.swing.JTable();
        btnHuy = new javax.swing.JButton();
        btnXuatHang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Phiếu xuất hàng"));

        jPanel3.setLayout(new java.awt.GridLayout(5, 0, 0, 12));

        jLabel1.setText("Mã phiếu xuất");
        jPanel3.add(jLabel1);

        jLabel4.setText("Mã hàng");
        jPanel3.add(jLabel4);

        jLabel2.setText("Tên hàng");
        jPanel3.add(jLabel2);

        jLabel11.setText("Số lượng yêu cầu");
        jPanel3.add(jLabel11);

        jLabel7.setText("Số lượng thực xuất");
        jPanel3.add(jLabel7);

        jPanel4.setLayout(new java.awt.GridLayout(5, 0, 0, 5));

        jtfMaPhieuXuat.setEditable(false);
        jPanel4.add(jtfMaPhieuXuat);

        btnChonMaHang.setText("chọn");
        btnChonMaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonMaHangActionPerformed(evt);
            }
        });

        jtfMaHang.setEditable(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jtfMaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChonMaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChonMaHang)
                    .addComponent(jtfMaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.add(jPanel9);

        jtfTenHang.setEditable(false);
        jPanel4.add(jtfTenHang);
        jPanel4.add(jtfSoLuongYeuCau);
        jPanel4.add(jtfSoLuongThucXuat);

        jPanel5.setLayout(new java.awt.GridLayout(5, 0, 0, 12));

        jLabel6.setText("Đơn vị tính");
        jPanel5.add(jLabel6);

        jLabel8.setText("Đơn giá");
        jPanel5.add(jLabel8);

        jLabel9.setText("Thành tiền");
        jPanel5.add(jLabel9);

        jPanel7.setPreferredSize(new java.awt.Dimension(215, 130));
        jPanel7.setLayout(new java.awt.GridLayout(5, 0, 0, 5));

        jtfDonViTinh.setEditable(false);
        jPanel7.add(jtfDonViTinh);

        jtfDonGia.setEditable(false);
        jPanel7.add(jtfDonGia);

        jtfThanhTien.setEditable(false);
        jPanel7.add(jtfThanhTien);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTablePhieuXuatHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã phiếu xuất", "Mã hàng", "Số lượng yêu cầu", "Số lượng thực xuất", "Đơn vị tính", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePhieuXuatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePhieuXuatHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePhieuXuatHang);

        btnHuy.setText("Huỷ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXuatHang.setText("Xuất hàng");
        btnXuatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(428, Short.MAX_VALUE)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(482, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy)
                    .addComponent(btnXuatHang))
                .addGap(10, 10, 10))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
         //JOptionPane.showMessageDialog(null,  "Vui lòng nhập đầy đủ thông tin !");
        boolean flag = false;
        for(ChiTietPhieuXuat_DTO ctpx : list){
            if(ctpx.getMaHangXuat().equals(jtfMaHang.getText())){
                flag = true;
            }        
        }
        if(jtfSoLuongYeuCau.getText().equals("") || jtfSoLuongThucXuat.equals("")  || jtfMaHang.equals("") ){
            JOptionPane.showMessageDialog(this,  "Vui lòng nhập đầy đủ thông tin !");
        }else if(flag){             
            JOptionPane.showMessageDialog(this,  "Mã hàng đã được chọn, vui lòng chọn mã khác!");
        }else{
            double a = Double.parseDouble(jtfSoLuongThucXuat.getText())*Double.parseDouble(jtfDonGia.getText());
            jtfThanhTien.setText(Double.toString(a));
            String maPx = jtfMaPhieuXuat.getText();
            String maHx = jtfMaHang.getText();
            int soLuongYC = Integer.parseInt(jtfSoLuongYeuCau.getText());
            int soLuongTX = Integer.parseInt(jtfSoLuongThucXuat.getText());
            String donViTinh = jtfDonViTinh.getText();
            double donGia = Double.parseDouble(jtfDonGia.getText());
            double thanhTien = Double.parseDouble(jtfThanhTien.getText());
            ChiTietPhieuXuat_DTO ctpx = new ChiTietPhieuXuat_DTO(maPx,maHx,soLuongYC,soLuongTX, donViTinh, donGia, thanhTien,true);
            list.add(ctpx);
            LoadData();
        }
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:int i = jTablePhieuXuatHang.getSelectedRow();
        int i = jTablePhieuXuatHang.getSelectedRow();
        int index=-1;
        if(i>=0){
            for(int j = 0;j<list.size();j++){
                ChiTietPhieuXuat_DTO ctpx = list.get(j);
                if(ctpx.getMaHangXuat().equals(jTablePhieuXuatHang
                    .getModel().getValueAt(i, 2).toString())){
                    index = i;
                }
            }
        }
        if(index>=0 ){
            double a = Double.parseDouble(jtfSoLuongThucXuat.getText())*Double.parseDouble(jtfDonGia.getText());
        jtfThanhTien.setText(Double.toString(a));
        String maPx = jtfMaPhieuXuat.getText();
        String maHx = jtfMaHang.getText();
        int soLuongYC = Integer.parseInt(jtfSoLuongYeuCau.getText());
        int soLuongTX = Integer.parseInt(jtfSoLuongThucXuat.getText());
        String donViTinh = jtfDonViTinh.getText();
        double donGia = Double.parseDouble(jtfDonGia.getText());
        double thanhTien = Double.parseDouble(jtfThanhTien.getText());
        ChiTietPhieuXuat_DTO ctpx = new ChiTietPhieuXuat_DTO(maPx,maHx,soLuongYC,soLuongTX, donViTinh, donGia, thanhTien,true);
        System.out.println(list.get(i));
        list.set(index,ctpx);
        }
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int i = jTablePhieuXuatHang.getSelectedRow();
        if(i>=0){
            for(ChiTietPhieuXuat_DTO ctpx : list){
                if(ctpx.getMaHangXuat().equals(jTablePhieuXuatHang
                    .getModel().getValueAt(i, 2).toString())){
                    if(list.remove(ctpx)){
                        JOptionPane.showMessageDialog(this,  "Đã xoá!");
                    }else{
                        JOptionPane.showMessageDialog(this,  "Lỗi !");
                    }
                }
            }
        }
        if(list.isEmpty()){
            model.setRowCount(0);
        }
        LoadData();
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        LoadData();
        
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void jTablePhieuXuatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePhieuXuatHangMouseClicked
        // TODO add your handling code here:
        int i = jTablePhieuXuatHang
                .getSelectedRow();
        if (i >= 0) {
            jtfMaPhieuXuat.setText(jTablePhieuXuatHang
                    .getModel().getValueAt(i, 1).toString());
            jtfMaHang.setText(jTablePhieuXuatHang
                    .getModel().getValueAt(i, 2).toString());
            jtfSoLuongYeuCau.setText(jTablePhieuXuatHang
                    .getModel().getValueAt(i, 3).toString());
            jtfSoLuongThucXuat.setText(jTablePhieuXuatHang
                    .getModel().getValueAt(i, 4).toString());
            jtfDonViTinh.setText(jTablePhieuXuatHang
                    .getModel().getValueAt(i, 5).toString());
            jtfDonGia.setText(jTablePhieuXuatHang
                    .getModel().getValueAt(i, 6).toString());
             jtfThanhTien.setText(jTablePhieuXuatHang
                    .getModel().getValueAt(i, 6).toString());
            
        }
    }//GEN-LAST:event_jTablePhieuXuatHangMouseClicked


    private void btnChonMaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonMaHangActionPerformed
        // TODO add your handling code here:
        HangHoa hangHoa = new HangHoa(this);
        hangHoa.setVisible(true);
        HangHoa_DTO selectedHangHoa = hangHoa.getSelectedHangHoa();
        if(selectedHangHoa!=null){
            System.out.println(selectedHangHoa.getMaSP());
            jtfMaHang.setText(selectedHangHoa.getMaSP());
            jtfTenHang.setText(selectedHangHoa.getTenSP());
            jtfDonViTinh.setText(selectedHangHoa.getDonVi());
            double gia = selectedHangHoa.getGiaBan();
            jtfDonGia.setText(Double.toString(gia));
        }
           
        
        System.out.println("Da in");
    }//GEN-LAST:event_btnChonMaHangActionPerformed

    private void btnXuatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHangActionPerformed
        // TODO add your handling code here:
        boolean flag = false;
        for(ChiTietPhieuXuat_DTO ctpx : list){
            if(chitiet.themChiTietPhieuXuat(ctpx)){
                flag = true;
            }else{
                flag = false;
            }
               
        }
        if(flag){
            phieuXuatBus.suaPhieuXuat(jtfMaPhieuXuat.getText(), thanhtien);
            this.dispose();
        }
        
        
    }//GEN-LAST:event_btnXuatHangActionPerformed


    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ChiTietPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChiTietPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChiTietPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChiTietPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChiTietPhieuXuat().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonMaHang;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePhieuXuatHang;
    private javax.swing.JTextField jtfDonGia;
    private javax.swing.JTextField jtfDonViTinh;
    private javax.swing.JTextField jtfMaHang;
    private javax.swing.JTextField jtfMaPhieuXuat;
    private javax.swing.JTextField jtfSoLuongThucXuat;
    private javax.swing.JTextField jtfSoLuongYeuCau;
    private javax.swing.JTextField jtfTenHang;
    private javax.swing.JTextField jtfThanhTien;
    // End of variables declaration//GEN-END:variables
}
