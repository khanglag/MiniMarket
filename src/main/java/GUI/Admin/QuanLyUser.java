/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Admin;

import BUS.NhanvienBus;
import BUS.TaiKhoanBus;
import DTO.NhanVien_DTO;
import DTO.TaiKhoan_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khang
 */
public class QuanLyUser extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyUser
     */
    NhanvienBus nhanVienBus = new NhanvienBus();
    TaiKhoanBus taiKhoanBus = new TaiKhoanBus();
    DefaultTableModel model;
    int value = 0;
    ArrayList<NhanVien_DTO> list = new ArrayList<NhanVien_DTO>();
    public QuanLyUser() {
        initComponents();
        LoadData();
    }

    public void LoadData() {
        model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        list = nhanVienBus.dsNhanVien();
        int i = 0;
        while (i <= list.size() - 1) {
            NhanVien_DTO px = list.get(i);
            String str = nhanVienBus.kiemtraTK(px.getMaNV());
            model.addRow(new Object[] {
                    px.getMaNV(),px.getTenNV(),px.getNgaySinh(),px.getMaQuyen(),str
            });
            jTable.setModel(model);
            ++i;
        }

    }
    public void refreshData(){
        nhanVienBus = new NhanvienBus();
        LoadData();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jRadioButtonMenuThemTaiKhoan = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfMaNV = new javax.swing.JTextField();
        jtfTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfNgaySinh = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jtfMaQuyen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfTenQuyen = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnKhoa = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnMoKhoa = new javax.swing.JButton();
        btnDatLaiMatKhau = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        jtfTim = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jRadioButtonMenuThemTaiKhoan.setSelected(true);
        jRadioButtonMenuThemTaiKhoan.setText("jRadioButtonMenuItem1");
        jRadioButtonMenuThemTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuThemTaiKhoanActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jRadioButtonMenuThemTaiKhoan);

        jPanel1.setBackground(new java.awt.Color(176, 206, 221));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(176, 206, 221));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Mã nhân viên");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Họ tên");

        jtfMaNV.setEditable(false);

        jtfTen.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Ngày sinh");

        jtfNgaySinh.setEditable(false);

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel33.setText("Mã quyền");

        jtfMaQuyen.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Tên quyền");

        jtfTenQuyen.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(46, 46, 46)
                        .addComponent(jtfMaQuyen))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfMaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(jtfTen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfNgaySinh)
                            .addComponent(jtfTenQuyen))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfTenQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jtfMaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(176, 206, 221));
        jPanel3.setLayout(new java.awt.GridLayout(6, 0));

        btnKhoa.setBackground(new java.awt.Color(67, 138, 174));
        btnKhoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnKhoa.setForeground(new java.awt.Color(255, 255, 255));
        btnKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bin.png"))); // NOI18N
        btnKhoa.setText("KHÓA TÀI KHOẢN");
        btnKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaActionPerformed(evt);
            }
        });
        jPanel3.add(btnKhoa);

        btnLoad.setBackground(new java.awt.Color(67, 138, 174));
        btnLoad.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLoad.setForeground(new java.awt.Color(255, 255, 255));
        btnLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync.png"))); // NOI18N
        btnLoad.setText("LÀM MỚI");
        btnLoad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        jPanel3.add(btnLoad);

        btnMoKhoa.setBackground(new java.awt.Color(67, 138, 174));
        btnMoKhoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnMoKhoa.setForeground(new java.awt.Color(255, 255, 255));
        btnMoKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SELECT.png"))); // NOI18N
        btnMoKhoa.setText("MỞ KHÓA TÀI KHOẢN");
        btnMoKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoKhoaActionPerformed(evt);
            }
        });
        jPanel3.add(btnMoKhoa);

        btnDatLaiMatKhau.setBackground(new java.awt.Color(67, 138, 174));
        btnDatLaiMatKhau.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDatLaiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        btnDatLaiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reset_password.png"))); // NOI18N
        btnDatLaiMatKhau.setText("ĐẶT LẠI MẬT KHẨU");
        btnDatLaiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLaiMatKhauActionPerformed(evt);
            }
        });
        jPanel3.add(btnDatLaiMatKhau);

        btnThem.setBackground(new java.awt.Color(67, 138, 174));
        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ADD.png"))); // NOI18N
        btnThem.setText("THÊM TÀI KHOẢN");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel3.add(btnThem);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel3))
        );

        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

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

        jtfTim.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm"));
        jtfTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnTim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfTim))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Mã quyền", "Trạng thái tài khoản"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setSelectionBackground(new java.awt.Color(176, 206, 221));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        new ThemTaiKhoan(null,jtfMaNV.getText(),jtfMaQuyen.getText()).setVisible(true);
        LoadData();
    }//GEN-LAST:event_btnThemActionPerformed

    private void jRadioButtonMenuThemTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuThemTaiKhoanActionPerformed
        // TODO add your handling code here:
        int i = jTable.getSelectedRow();
        String str1=null,str2 = null;
        if (i >= 0) {
            str1 = jTable.getModel().getValueAt(i, 2).toString();
            str2 = jTable.getModel().getValueAt(i, 3).toString();
        }
        
    }//GEN-LAST:event_jRadioButtonMenuThemTaiKhoanActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int i = jTable.getSelectedRow();
        if(i>=0){
            
            jtfMaNV.setText(jTable.getModel().getValueAt(i, 0).toString());
            jtfTen.setText(jTable.getModel().getValueAt(i, 1).toString());
            jtfNgaySinh.setText(jTable.getModel().getValueAt(i, 2).toString());
            jtfMaQuyen.setText(jTable.getModel().getValueAt(i, 3).toString());
            if(jtfMaQuyen.getText().equals("NVBH203")){
                jtfTenQuyen.setText("Nhân viên bán hàng");
            }
            if(jtfMaQuyen.getText().equals("NVTK203")){
                jtfTenQuyen.setText("Nhân viên thủ kho");
            }
            if(jtfMaQuyen.getText().equals("QL20003")){
                jtfTenQuyen.setText("Quản lý");
            }
            if(jtfMaQuyen.getText().equals("ADMIN01")){
                jtfTenQuyen.setText("Admin");
            }
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void btnKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaActionPerformed
        // TODO add your handling code here:
        int i = jTable.getSelectedRow();
        
        if(i>=0){
            String str = jTable.getModel().getValueAt(i, 4).toString();
            if(str.equals("Đã có tài khoản!")){
            TaiKhoan_DTO tk = new TaiKhoan_DTO(jtfMaNV.getText().toString(),null,jtfMaQuyen.getText().toString(),true);
            if(taiKhoanBus.xoaTaiKhoan(tk)){
                JOptionPane.showMessageDialog(null, "Đã khoá tài khoản!");
            }
            }else if (str.equals("Chưa có tài khoản")){
                JOptionPane.showMessageDialog(null, "Người dùng chưa có tài khoản!");
            }else{
                JOptionPane.showMessageDialog(null, "Tài khoản đã bị khoá");
            }
            LoadData();
        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn tài khoản muốn xoá!");
        }
    }//GEN-LAST:event_btnKhoaActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        refreshData();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnDatLaiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLaiMatKhauActionPerformed
        // TODO add your handling code here:
        int i = jTable.getSelectedRow();
        if(i>=0){
            int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt lại mật khẩu không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                if(taiKhoanBus.doiMatKhau(jtfMaNV.getText(), "Abc@1234")){
                    JOptionPane.showMessageDialog(this, "Đặt lại mật khẩu thành công!");
                }
            } else {
            
            }
        }else{
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn tài khoản muốn đặt lại mật khẩu!");
        }
        
    }//GEN-LAST:event_btnDatLaiMatKhauActionPerformed

    private void jtfTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTimActionPerformed

    private void btnMoKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoKhoaActionPerformed
        // TODO add your handling code here:
        int i = jTable.getSelectedRow();
        if(i>=0){
            String str = jTable.getModel().getValueAt(i, 4).toString();
            if(str.equals("Tài khoản bị khoá")){
                TaiKhoan_DTO tk = new TaiKhoan_DTO(jtfMaNV.getText().toString(),null,jtfMaQuyen.getText().toString(),true);
                if(taiKhoanBus.moTK(tk)){
                    JOptionPane.showMessageDialog(null, "Đã mở khoá tài khoản!");
                }
            }else if (str.equals("Chưa có tài khoản")){
                JOptionPane.showMessageDialog(null, "Người dùng chưa có tài khoản!");
            }else{
                JOptionPane.showMessageDialog(null, "Tài khoản hiện không khoá!");
            }
            LoadData();
        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn tài khoản muốn mở khoá!");
        }
    }//GEN-LAST:event_btnMoKhoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        
        list = nhanVienBus.timNhanVienM(jtfTim.getText());
        int i = 0;
        while (i <= list.size() - 1) {
            NhanVien_DTO px = list.get(i);
            String str = nhanVienBus.kiemtraTK(px.getMaNV());
            model.addRow(new Object[] {
                   px.getMaNV(),px.getTenNV(),px.getNgaySinh(),px.getMaQuyen(),str
            });
            jTable.setModel(model);
            ++i;
        }
    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLaiMatKhau;
    private javax.swing.JButton btnKhoa;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnMoKhoa;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuThemTaiKhoan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jtfMaNV;
    private javax.swing.JTextField jtfMaQuyen;
    private javax.swing.JTextField jtfNgaySinh;
    private javax.swing.JTextField jtfTen;
    private javax.swing.JTextField jtfTenQuyen;
    private javax.swing.JTextField jtfTim;
    // End of variables declaration//GEN-END:variables
}
