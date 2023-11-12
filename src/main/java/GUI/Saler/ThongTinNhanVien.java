/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Saler;

import Controller.TaiKhoanController;
import DAO.NhanVienDAO;
import DTO.NhanVien_DTO;
import GUI.Admin.DoiMatKhau;
import GUI.Login.TaiKhoan;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class ThongTinNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form TimKiemSanPham
     */
    NhanVienDAO nvDAO = new NhanVienDAO();

    public ThongTinNhanVien() {
        initComponents();
        showInfoStaff();
    }

    public void showInfoStaff() {
        TaiKhoan tk = new TaiKhoan();
        ArrayList<NhanVien_DTO> nhanVien = nvDAO.searchNhanVien(tk.getTen_dn(), null, null);
        for (int i = 0; i < nhanVien.size(); i++) {
            NhanVien_DTO nv = nhanVien.get(i);
            txtHoTen.setText(nv.getTenNV());//sdt em ns dc cc
            txtSDT.setText(nv.getSdt());
            txtEmail.setText(nv.getEmail());
            LocalDate ngaySinh = nv.getNgaySinh();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Định dạng ngày tháng
            String ngaySinhStr = ngaySinh.format(formatter);
            txtNgaySinh.setText(ngaySinhStr);
            txtDiaChi.setText(nv.getDiaChi());
            txtCanCuoc.setText(nv.getCccd());
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtHoTen = new javax.swing.JLabel();
        txtSDT = new javax.swing.JLabel();
        txtCanCuoc = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(173, 187, 198));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THÔNG TIN CÁ NHÂN");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel1.setText("HỌ TÊN");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel3.setText("SỐ ĐIỆN THOẠI");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel4.setText("EMAIL");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setText("NGÀY SINH");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel6.setText("ĐỊA CHỈ");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel7.setText("CĂN CƯỚC");

        btnUpdate.setText("Đổi mật khẩu");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtHoTen.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtHoTen.setForeground(new java.awt.Color(255, 51, 51));
        txtHoTen.setText("jLabel8");

        txtSDT.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtSDT.setForeground(new java.awt.Color(255, 51, 0));
        txtSDT.setText("jLabel8");

        txtCanCuoc.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtCanCuoc.setForeground(new java.awt.Color(255, 51, 0));
        txtCanCuoc.setText("jLabel8");

        txtNgaySinh.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtNgaySinh.setForeground(new java.awt.Color(255, 51, 0));
        txtNgaySinh.setText("jLabel8");

        txtDiaChi.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtDiaChi.setForeground(new java.awt.Color(255, 51, 0));
        txtDiaChi.setText("jLabel8");

        txtEmail.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 51, 0));
        txtEmail.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail)
                    .addComponent(txtNgaySinh)
                    .addComponent(txtDiaChi)
                    .addComponent(txtCanCuoc)
                    .addComponent(txtSDT)
                    .addComponent(txtHoTen))
                .addContainerGap(736, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(236, 236, 236))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHoTen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSDT))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgaySinh))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiaChi))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCanCuoc))
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(0, 154, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
          new DoiMatKhau(TaiKhoanController.getTendnString()).setVisible(true);

    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel txtCanCuoc;
    private javax.swing.JLabel txtDiaChi;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtHoTen;
    private javax.swing.JLabel txtNgaySinh;
    private javax.swing.JLabel txtSDT;
    // End of variables declaration//GEN-END:variables
}
