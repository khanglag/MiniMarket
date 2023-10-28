/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Saler;

import BUS.KhachHangBus;
import DAO.KhachHangDAO;
import DTO.KhachHang_DTO;
import Handle.Timeconvert;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class ThemKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form ThemKhachHang
     */
    KhachHangDAO khd = new KhachHangDAO();
     KhachHangBus khb = new KhachHangBus();
    public ThemKhachHang() {
        initComponents();
        createButtonGroup();
        showCustomerInTable();   
//         String dateStr = "13/03/2003";
//
//        // Định dạng của chuỗi ngày
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        // Chuyển đổi chuỗi thành LocalDate
//        LocalDate localDate = LocalDate.parse(dateStr, formatter);
//
//        System.out.println("LocalDate: " + localDate);
    }

    public void showCustomerInTable() {
        DefaultTableModel model = (DefaultTableModel) TableCustomer.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng

        ArrayList<KhachHang_DTO> danhSachKhachHang = khd.ReadKhachHang();
        int soLuongKH = danhSachKhachHang.size();
        for (int i = 0; i < soLuongKH; i++) {
            KhachHang_DTO khachHang = danhSachKhachHang.get(i);
            String maKH = khachHang.getMaKH();
            String tenKH = khachHang.getTenKH();
            String sdt = khachHang.getSdt();
            LocalDate ngaySinh = khachHang.getNgaySinh();
            String diaChi = khachHang.getDiaChi();
            model.addRow(new Object[]{i + 1, maKH, tenKH, sdt,ngaySinh,diaChi});
        }
    }

    public void createButtonGroup() {
        ButtonGroup arrangeGroup = new ButtonGroup();
        arrangeGroup.add(chkArrangeAZ);
        arrangeGroup.add(chkArrangeZA);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btnFindCustomer = new javax.swing.JButton();
        btnAddCustomer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCustomer = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtNumberPhone = new javax.swing.JTextField();
        btnArrange = new javax.swing.JButton();
        chkArrangeAZ = new javax.swing.JRadioButton();
        chkArrangeZA = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnFindCustomer.setText("Tìm kiếm");
        btnFindCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCustomerActionPerformed(evt);
            }
        });

        btnAddCustomer.setText("Thêm");
        btnAddCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddCustomerMouseClicked(evt);
            }
        });
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddCustomer)
                .addGap(18, 18, 18)
                .addComponent(btnFindCustomer)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnFindCustomer)
                    .addComponent(btnAddCustomer))
                .addContainerGap())
        );

        TableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Ngày sinh", "Địa chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableCustomer);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        jLabel5.setText("Họ tên");

        jLabel13.setText("Số điện thoại");

        btnArrange.setText("Sắp xếp");
        btnArrange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnArrangeMouseClicked(evt);
            }
        });

        chkArrangeAZ.setText("A - Z");

        chkArrangeZA.setText("Z - A");

        jLabel1.setText("Ngày sinh");

        jLabel3.setText("Địa chỉ");

        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(96, 96, 96)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNumberPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnArrange)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkArrangeAZ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkArrangeZA)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnArrange)
                            .addComponent(chkArrangeAZ)
                            .addComponent(chkArrangeZA))
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(txtNumberPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(173, 187, 198));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THÊM KHÁCH HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void btnAddCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCustomerMouseClicked
        // TODO add your handling code here:
        String hoTen = txtName.getText();
        String soDT = txtNumberPhone.getText();
        String ngaySinh = txtNgaySinh.getText();
        String diaChi = txtDiaChi.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(ngaySinh, formatter);
       
        khb.themKhanhHang(hoTen, localDate, soDT, diaChi, true);
        showCustomerInTable();
    }//GEN-LAST:event_btnAddCustomerMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtName.setText("");
        txtNumberPhone.setText("");
        txtNgaySinh.setText("");
        txtDiaChi.setText("");
        showCustomerInTable();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnFindCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCustomerActionPerformed
        // TODO add your handling code here:
        String numberPhone = txtNumberPhone.getText().trim();
        ArrayList<KhachHang_DTO> danhSachKhachHang = khd.ReadKhachHang();
        int soLuongKH = danhSachKhachHang.size();
        for (int i = 0; i < soLuongKH; i++) {
            KhachHang_DTO khachHang = danhSachKhachHang.get(i);
            if (numberPhone.equals(khachHang.getSdt())) {
                DefaultTableModel model = (DefaultTableModel) TableCustomer.getModel();
                model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng 
                String maKH = khachHang.getMaKH();
                String tenKH = khachHang.getTenKH();
                String sdt = khachHang.getSdt();
                LocalDate ngaySinh = khachHang.getNgaySinh();
                String diaChi = khachHang.getDiaChi();
                model.addRow(new Object[]{1, maKH, tenKH, sdt,ngaySinh,diaChi});
            }
        }
    }//GEN-LAST:event_btnFindCustomerActionPerformed

    private void btnArrangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArrangeMouseClicked
        DefaultTableModel model = (DefaultTableModel) TableCustomer.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng
        ArrayList<KhachHang_DTO> danhSachKhachHang = khd.ReadKhachHang();

        // Sắp xếp danh sách theo tenKH bằng cách sử dụng Comparator
        Collections.sort(danhSachKhachHang, new Comparator<KhachHang_DTO>() {
            @Override
            public int compare(KhachHang_DTO kh1, KhachHang_DTO kh2) {
                return kh1.getTenKH().compareTo(kh2.getTenKH());
            }
        });
        int soLuongKH = danhSachKhachHang.size();
        if (chkArrangeAZ.isSelected()) {
            for (int i = 0; i < soLuongKH; i++) {
                KhachHang_DTO khachHang = danhSachKhachHang.get(i);
                String maKH = khachHang.getMaKH();
                String tenKH = khachHang.getTenKH();
                String sdt = khachHang.getSdt();
                LocalDate ngaySinh = khachHang.getNgaySinh();
                String diaChi = khachHang.getDiaChi();
                model.addRow(new Object[]{1, maKH, tenKH, sdt,ngaySinh,diaChi});
            }
        }
        if (chkArrangeZA.isSelected()) {
            for (int i = soLuongKH - 1; i >= 0; i--) {
                KhachHang_DTO khachHang = danhSachKhachHang.get(i);
                String maKH = khachHang.getMaKH();
                String tenKH = khachHang.getTenKH();
                String sdt = khachHang.getSdt();
                LocalDate ngaySinh = khachHang.getNgaySinh();
                String diaChi = khachHang.getDiaChi();
                model.addRow(new Object[]{1, maKH, tenKH, sdt,ngaySinh,diaChi});
            }
        }
    }//GEN-LAST:event_btnArrangeMouseClicked

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void TableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCustomerMouseClicked
        // TODO add your handling code here:
         Timeconvert timeConvert = new Timeconvert();
        if (evt.getClickCount() == 1) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
            int selectedRow = TableCustomer.getSelectedRow();
            if (selectedRow != -1) {
                String soDT = (String) TableCustomer.getValueAt(selectedRow, 3);
                ArrayList<KhachHang_DTO> danhSachKhachHang = khd.ReadKhachHang();
                int soLuongKH = danhSachKhachHang.size();
                for (int i = 0; i < soLuongKH; i++) {
                    KhachHang_DTO khachHang = danhSachKhachHang.get(i);
                    if (soDT.equals(khachHang.getSdt())) {
                        txtName.setText(khachHang.getTenKH());
                        txtNumberPhone.setText(khachHang.getSdt());
                        String ngaySinh = timeConvert.convert(khachHang.getNgaySinh());
                        txtNgaySinh.setText(ngaySinh);
                        txtDiaChi.setText(khachHang.getDiaChi());
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_TableCustomerMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCustomer;
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnArrange;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFindCustomer;
    private javax.swing.JRadioButton chkArrangeAZ;
    private javax.swing.JRadioButton chkArrangeZA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNumberPhone;
    // End of variables declaration//GEN-END:variables
}
