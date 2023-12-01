/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.ThuKho;

import BUS.ChiTietKiemHangBus;
import BUS.HangHoaBus;
import BUS.PhieuKiemHangBus;
import DTO.ChiTietKiemHang_DTO;
import DTO.HangHoa_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khang
 */
public class ChiTietKiemHang extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietKiemHang
     */
    HangHoa_DTO selectedHangHoa;
    ChiTietKiemHangBus chitiet = new ChiTietKiemHangBus ();
    PhieuKiemHangBus phieuXuatBus = new PhieuKiemHangBus();
    HangHoaBus hhbus = new HangHoaBus();
    DefaultTableModel model;
    ArrayList<ChiTietKiemHang_DTO> list = new ArrayList<ChiTietKiemHang_DTO>();
    public ChiTietKiemHang(String ma) {
        initComponents();
        jtfMaPhieu.setText(ma);
    }
     public void LoadData(){
        model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        
        int i = 0;
        while (i <= list.size() - 1) {
            ChiTietKiemHang_DTO px = list.get(i);
            model.addRow(new Object[] {
                    px.getMaPhieu(),px.getMaSP(),px.getTenSP(),px.getSoLuong(),px.getDonVi(),px.getTinhTrangSP()
            });
            jTable.setModel(model);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfMaPhieu = new javax.swing.JTextField();
        jtfMaSanPham = new javax.swing.JTextField();
        jtfTenSanPham = new javax.swing.JTextField();
        jtfSoLuong = new javax.swing.JTextField();
        jtfDonVi = new javax.swing.JTextField();
        jtfTinhTrang = new javax.swing.JTextField();
        btnChon = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        btnTao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn vị", "Tình Trạng sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
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
        jScrollPane1.setViewportView(jTable);

        jPanel1.setBackground(new java.awt.Color(176, 206, 221));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết kiểm hàng"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Mã  phiếu");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Mã sản phẩm ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Tên sản phẩm");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Số lượng");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Đơn vị");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Tình trạng");

        jtfMaPhieu.setEditable(false);

        jtfMaSanPham.setEditable(false);

        jtfTenSanPham.setEditable(false);

        jtfDonVi.setEditable(false);

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

        jPanel2.setBackground(new java.awt.Color(176, 206, 221));
        jPanel2.setLayout(new java.awt.GridLayout(5, 0));

        btnThem.setBackground(new java.awt.Color(67, 138, 174));
        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADD.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem);

        btnSua.setBackground(new java.awt.Color(67, 138, 174));
        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/updated.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua);

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
        jPanel2.add(btnXoa);

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
        jPanel2.add(btnLamMoi);

        btnClear.setBackground(new java.awt.Color(67, 138, 174));
        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfMaPhieu)
                    .addComponent(jtfTinhTrang)
                    .addComponent(jtfSoLuong)
                    .addComponent(jtfDonVi)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfMaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfTenSanPham))
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChon))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnDong.setBackground(new java.awt.Color(67, 138, 174));
        btnDong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDong.setForeground(new java.awt.Color(255, 255, 255));
        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        btnDong.setText("ĐÓNG");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        btnTao.setBackground(new java.awt.Color(67, 138, 174));
        btnTao.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTao.setForeground(new java.awt.Color(255, 255, 255));
        btnTao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create.png"))); // NOI18N
        btnTao.setText("TẠO");
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnDong)
                .addGap(27, 27, 27))
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDong)
                    .addComponent(btnTao))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        HangHoa hangHoa = new HangHoa(this,0);
        hangHoa.setVisible(true);
        selectedHangHoa = hangHoa.getSelectedHangHoa();
        if(selectedHangHoa!=null){
            jtfMaSanPham.setText(selectedHangHoa.getMaSP());
            jtfTenSanPham.setText(selectedHangHoa.getTenSP());
            jtfDonVi.setText(selectedHangHoa.getDonVi());
        }
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int i = jTable.getSelectedRow();
        int index=-1;
        if(i>=0){
             if(hhbus.Sol(jTable.getModel().getValueAt(i, 1).toString())>Integer.valueOf(jtfSoLuong.getText())){
                for(int j = 0;j<list.size();j++){
                    ChiTietKiemHang_DTO ctpx = list.get(j);
                    if(ctpx.getMaSP().equals(jTable
                        .getModel().getValueAt(i, 1).toString())){
                        index = i;
                        break;
                    }
                }
                if(index>=0 ){
                    String maPx = jtfMaPhieu.getText();
                    String maHx = jtfMaSanPham.getText();
                    String tenSp = jtfTenSanPham.getText();
                    int soluong = Integer.parseInt(jtfSoLuong.getText());
                    String donViTinh = jtfDonVi.getText();
                    String tinhTrang= jtfTinhTrang.getText();
                    ChiTietKiemHang_DTO ctpx = new ChiTietKiemHang_DTO(maPx,maHx,tenSp,soluong,donViTinh,tinhTrang,true);
                    list.set(index,ctpx);
                    JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công");
                    LoadData();

                }
            }else{
                JOptionPane.showMessageDialog(this, "Số lượng lớn hơn số lượng hàng hoá trong kho");
      
            }
        }else{
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm muốn sửa.Mời chọn sản phẩm");
        }
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        boolean flag = false;
        for(ChiTietKiemHang_DTO ctpx : list){
            if(ctpx.getMaSP().equals(jtfMaSanPham.getText())){
                flag = true;
            }        
        }
        if(jtfSoLuong.getText().equals("") || jtfTinhTrang.getText().equals("")  ){
            JOptionPane.showMessageDialog(this,  "Vui lòng nhập đầy đủ thông tin !");
        }else if(!Handle.Check.isNumeric(jtfSoLuong.getText())){
             JOptionPane.showMessageDialog(this,  "Số lượng không hợp lệ. Mời nhập lại!");
        }else if(Integer.parseInt(jtfSoLuong.getText())<=0){
             JOptionPane.showMessageDialog(this,  "Số lượng phải lớn hơn 0");
        }else if(flag){             
            JOptionPane.showMessageDialog(this,  "Mã hàng đã được chọn, vui lòng chọn mã khác!");
        }else if(Integer.parseInt(jtfSoLuong.getText())> selectedHangHoa.getSoLuong()){
            JOptionPane.showMessageDialog(this,  "Số lượng lớn hơn số lượng trong kho!");
        }else{
            
            String maPx = jtfMaPhieu.getText();
            String maHx = jtfMaSanPham.getText();
            String tenSp = jtfTenSanPham.getText();
            int soluong = Integer.parseInt(jtfSoLuong.getText());
            String donViTinh = jtfDonVi.getText();
            
            String tinhTrang= jtfTinhTrang.getText();
            ChiTietKiemHang_DTO ctpx = new ChiTietKiemHang_DTO(maPx,maHx,tenSp,soluong,donViTinh,tinhTrang,true);
            if(list.add(ctpx)){
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào bảng chi tiết phiếu kiểm hàng thành công");
            }
            LoadData();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int i = jTable.getSelectedRow();
        if(i>=0){
            for(ChiTietKiemHang_DTO ctpx : list){
                if(ctpx.getMaSP().equals(jTable
                    .getModel().getValueAt(i, 1).toString())){
                    if(list.remove(ctpx)){
                        JOptionPane.showMessageDialog(this,  "Đã xoá!");
                    }else{
                        JOptionPane.showMessageDialog(this,  "Lỗi !");
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm muốn sửa.Mời chọn sản phẩm");
        }
        
        LoadData();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        LoadData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
        // TODO add your handling code here:
        boolean flag = false;
        if(list.isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm nào");
        }else{
            for(ChiTietKiemHang_DTO ctpx : list){
            if(chitiet.themCTKH(ctpx)){
                flag = true;
            }else{
                flag = false;
            }
               
        }
        if(flag){
            this.dispose();
        }
        }
        
    }//GEN-LAST:event_btnTaoActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int i = jTable.getSelectedRow();
        if (i >= 0) {
            jtfMaPhieu.setText(jTable.getModel().getValueAt(i, 0).toString());
            jtfMaSanPham.setText(jTable.getModel().getValueAt(i, 1).toString());
            jtfTenSanPham.setText(jTable.getModel().getValueAt(i, 2).toString());
            jtfSoLuong.setText(jTable.getModel().getValueAt(i, 3).toString());
            jtfDonVi.setText(jTable.getModel().getValueAt(i, 4).toString());
            jtfTinhTrang.setText(jTable.getModel().getValueAt(i, 5).toString());
            
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        jtfMaSanPham.setText("");
        jtfTenSanPham.setText("");
        jtfSoLuong.setText("");
        jtfDonVi.setText("");
        jtfTinhTrang.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTao;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jtfDonVi;
    private javax.swing.JTextField jtfMaPhieu;
    private javax.swing.JTextField jtfMaSanPham;
    private javax.swing.JTextField jtfSoLuong;
    private javax.swing.JTextField jtfTenSanPham;
    private javax.swing.JTextField jtfTinhTrang;
    // End of variables declaration//GEN-END:variables
}
