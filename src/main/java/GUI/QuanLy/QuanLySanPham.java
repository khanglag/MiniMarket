/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.QuanLy;

import BUS.HangHoaBus;
import BUS.NhaCungCapBus;
import DAO.HangHoaDAO;
import DAO.NhaCungCapDAO;
import DTO.HangHoa_DTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class QuanLySanPham extends javax.swing.JPanel {

    /**
     * Creates new form QuanLySanPham
     */
    HangHoaDAO hhd = new HangHoaDAO();
    NhaCungCapDAO nccd = new NhaCungCapDAO();
    NhaCungCapBus nccb = new NhaCungCapBus();
    HangHoaBus hhBus = new HangHoaBus();
    public QuanLySanPham() {
        initComponents();
        createButtonGroup();
        //hiển thị sản phẩm vào table
        showProductsInTable();
    }

    public void showProductsInTable() {
        DefaultTableModel model = (DefaultTableModel) TableProducts.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng
        ArrayList<HangHoa_DTO> danhSachSanPham = hhd.ReadHangHoa();
        int soLuongSP = danhSachSanPham.size();
        for (int i = 0; i < soLuongSP; i++) {
            HangHoa_DTO sanPham = danhSachSanPham.get(i);
            String maSP = sanPham.getMaSP();
            String tenSP = sanPham.getTenSP();
            int soLuong = sanPham.getSoLuong();
            double giaNhap = sanPham.getGiaNhap();
            double giaBan = sanPham.getGiaBan();
            String tenNCC = nccb.timTenNCC(sanPham.getMaNCC());

            String xuatXu = sanPham.getXuatXu();
            String donVi = sanPham.getDonVi();
            boolean tt = sanPham.isTonTai();
            String tinhTrang = "";
            if (tt = true) {
                tinhTrang = "Đang bán";
            } else {
                tinhTrang = "Ngưng bán";
            }
            model.addRow(new Object[]{i + 1, maSP, tenSP, soLuong, giaNhap, giaBan, tenNCC, xuatXu, donVi, tinhTrang});
        }
    }

    public void createButtonGroup() {
        ButtonGroup arrangeGroup = new ButtonGroup();
        arrangeGroup.add(ChkArrangeByName);
        arrangeGroup.add(ChkArrangeByPrice);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProducts = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        BtnArrange = new javax.swing.JButton();
        ChkArrangeByName = new javax.swing.JRadioButton();
        ChkArrangeByPrice = new javax.swing.JRadioButton();
        lbImg = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtXuatXu = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDonVi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtSoLuongSP = new javax.swing.JTextField();
        txtNhaCC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbbMaNhomHang = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbbMaNCC = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(173, 187, 198));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ SẢN PHẨM");

        TableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá nhập", "Giá bán", "Nhà cung cấp", "Xuất xứ", "Đơn vị", "Tình trạng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProducts);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        BtnArrange.setText("Sắp xếp");
        BtnArrange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnArrangeMouseClicked(evt);
            }
        });
        BtnArrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnArrangeActionPerformed(evt);
            }
        });

        ChkArrangeByName.setText("Theo tên");

        ChkArrangeByPrice.setText("Theo giá");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnArrange)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(ChkArrangeByName, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChkArrangeByPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChkArrangeByName)
                    .addComponent(ChkArrangeByPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnArrange)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        lbImg.setBackground(new java.awt.Color(255, 51, 51));
        lbImg.setMaximumSize(new java.awt.Dimension(150, 150));
        lbImg.setMinimumSize(new java.awt.Dimension(120, 120));

        jLabel27.setText("Xuất xứ ");

        jLabel30.setText("Đơn vị");

        txtGiaNhap.setMaximumSize(new java.awt.Dimension(144, 2147483647));

        txtGiaBan.setMaximumSize(new java.awt.Dimension(144, 2147483647));

        jLabel9.setText("Giá nhập");

        jLabel6.setText("Giá bán");

        jLabel4.setText("Mã sản phẩm");

        jLabel5.setText("Tên sản phẩm");

        jLabel8.setText("Số lượng");

        txtMaSP.setMaximumSize(new java.awt.Dimension(144, 200));

        txtTenSP.setMaximumSize(new java.awt.Dimension(144, 144));
        txtTenSP.setMinimumSize(new java.awt.Dimension(144, 144));

        txtSoLuongSP.setMaximumSize(new java.awt.Dimension(144, 2147483647));

        txtNhaCC.setMaximumSize(new java.awt.Dimension(144, 144));

        jLabel7.setText("Nhà cung cấp");

        jLabel1.setText("Mã nhóm hàng");

        cbbMaNhomHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chăm sóc thú cưng", "Đồ dùng gia đình", "Vệ sinh nhà cửa", "Sản phẩm cho mẹ và bé", "Chăm sóc cá nhân", "Bánh kẹo các loại", "Sữa các loại", "Bia, nước các loại", "Gạo, bột, đồ khô", "Mì, miến, cháo, phở", "Kem, thực phẩm đông mát", "Dầu ăn, nước chấm, gia vị" }));

        jLabel3.setText("Mã nhà cung cấp");

        cbbMaNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhà cung cấp cho CH" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel30))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbMaNhomHang, 0, 1, Short.MAX_VALUE)
                    .addComponent(cbbMaNCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(cbbMaNhomHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(cbbMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtSoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setText("Xóa SP");

        jButton3.setText("Clear");

        jButton4.setText("Sửa TTSP");

        jButton5.setText("Tìm kiếm SP");

        jButton1.setText("Thêm SP mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("Nhập Excel");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(34, 34, 34)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton6)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnArrangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnArrangeMouseClicked
        // TODO add your handling code here:
        if (ChkArrangeByName.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) TableProducts.getModel();
            model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng
            ArrayList<HangHoa_DTO> danhSachSanPham = hhd.ReadHangHoa();
            // Sắp xếp danh sách theo tenSP bằng cách sử dụng Comparator
            Collections.sort(danhSachSanPham, new Comparator<HangHoa_DTO>() {
                @Override
                public int compare(HangHoa_DTO sp1, HangHoa_DTO sp2) {
                    return sp1.getTenSP().compareTo(sp2.getTenSP());
                }
            });
            int soLuongSP = danhSachSanPham.size();
            for (int i = 0; i < soLuongSP; i++) {
                HangHoa_DTO sanPham = danhSachSanPham.get(i);
                String maSP = sanPham.getMaSP();
                String tenSP = sanPham.getTenSP();
                int soLuong = sanPham.getSoLuong();
                double giaNhap = sanPham.getGiaNhap();
                double giaBan = sanPham.getGiaBan();
                String tenNCC = nccb.timTenNCC(sanPham.getMaNCC());
                String xuatXu = sanPham.getXuatXu();
                String donVi = sanPham.getDonVi();
                boolean tt = sanPham.isTonTai();
                String tinhTrang = "";
                if (tt = true) {
                    tinhTrang = "Đang bán";
                } else {
                    tinhTrang = "Ngưng bán";
                }
                model.addRow(new Object[]{i + 1, maSP, tenSP, soLuong, giaNhap, giaBan, tenNCC, xuatXu, donVi, tinhTrang});
            }
        }
        if (ChkArrangeByPrice.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) TableProducts.getModel();
            model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng
            ArrayList<HangHoa_DTO> danhSachSanPham = hhd.ReadHangHoa();
// Sắp xếp danh sách theo giaBan bằng cách sử dụng Comparator
            Collections.sort(danhSachSanPham, new Comparator<HangHoa_DTO>() {
                @Override
                public int compare(HangHoa_DTO sp1, HangHoa_DTO sp2) {
                    double giaBan1 = sp1.getGiaBan();
                    double giaBan2 = sp2.getGiaBan();
                    return Double.compare(giaBan1, giaBan2);
                }
            });

            int soLuongSP = danhSachSanPham.size();
            for (int i = 0; i < soLuongSP; i++) {
                HangHoa_DTO sanPham = danhSachSanPham.get(i);
                String maSP = sanPham.getMaSP();
                String tenSP = sanPham.getTenSP();
                int soLuong = sanPham.getSoLuong();
                double giaNhap = sanPham.getGiaNhap();
                double giaBan = sanPham.getGiaBan();
                String tenNCC = nccb.timTenNCC(sanPham.getMaNCC());
                String xuatXu = sanPham.getXuatXu();
                String donVi = sanPham.getDonVi();
                boolean tt = sanPham.isTonTai();
                String tinhTrang = "";
                if (tt = true) {
                    tinhTrang = "Đang bán";
                } else {
                    tinhTrang = "Ngưng bán";
                }
                model.addRow(new Object[]{i + 1, maSP, tenSP, soLuong, giaNhap, giaBan, tenNCC, xuatXu, donVi, tinhTrang});
            }

        }
    }//GEN-LAST:event_BtnArrangeMouseClicked

    private void TableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductsMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
            int selectedRow = TableProducts.getSelectedRow();
            if (selectedRow != -1) {
                String maSP = (String) TableProducts.getValueAt(selectedRow, 1);
                ArrayList<HangHoa_DTO> danhSachHangHoa = hhd.ReadHangHoa();
                int soLuongHH = danhSachHangHoa.size();
                for (int i = 0; i < soLuongHH; i++) {
                    HangHoa_DTO sanPham = danhSachHangHoa.get(i);
                    if (maSP.equals(sanPham.getMaSP())) {
                        String Path = sanPham.getAnhSP();
                        txtMaSP.setText((String) TableProducts.getValueAt(selectedRow, 1));
                        txtTenSP.setText((String) TableProducts.getValueAt(selectedRow, 2));
                        int soLuongSP = (int) TableProducts.getValueAt(selectedRow, 3);
                        txtSoLuongSP.setText(Integer.toString(soLuongSP));
                        double giaNhap = (double) TableProducts.getValueAt(selectedRow, 4);
                        txtGiaNhap.setText(Double.toString(giaNhap));
                        double giaBan = (double) TableProducts.getValueAt(selectedRow, 5);
                        txtGiaBan.setText(Double.toString(giaBan));
                       
                        txtNhaCC.setText((String) TableProducts.getValueAt(selectedRow, 6));
                        txtDonVi.setText((String) TableProducts.getValueAt(selectedRow, 7));
                        txtXuatXu.setText((String) TableProducts.getValueAt(selectedRow, 8));
                        lbImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Path))); // NOI18N
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_TableProductsMouseClicked

    private void BtnArrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnArrangeActionPerformed
        // TODO add your handling code here:
        if (ChkArrangeByName.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) TableProducts.getModel();
            model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng
            ArrayList<HangHoa_DTO> danhSachHangHoa = hhd.ReadHangHoa();

            // Sắp xếp danh sách theo tenSP bằng cách sử dụng Comparator
            Collections.sort(danhSachHangHoa, new Comparator<HangHoa_DTO>() {
                @Override
                public int compare(HangHoa_DTO sp1, HangHoa_DTO sp2) {
                    return sp1.getTenSP().compareTo(sp2.getTenSP());
                }
            });

            int soLuongSP = danhSachHangHoa.size();
            for (int i = 0; i < soLuongSP; i++) {
                HangHoa_DTO sanPham = danhSachHangHoa.get(i);
                String maSP = sanPham.getMaSP();
                String tenSP = sanPham.getTenSP();
                int soLuong = sanPham.getSoLuong();
                double giaNhap = sanPham.getGiaNhap();
                double giaBan = sanPham.getGiaBan();
                String tenNCC = "abc";
                String xuatXu = sanPham.getXuatXu();
                String donVi = sanPham.getDonVi();
                model.addRow(new Object[]{i + 1, maSP, tenSP, soLuong, giaNhap, giaBan, tenNCC, xuatXu, donVi});
            }
        }
        if (ChkArrangeByPrice.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) TableProducts.getModel();
            model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng
            ArrayList<HangHoa_DTO> danhSachHangHoa = hhd.ReadHangHoa();

// Sắp xếp danh sách theo giaBan bằng cách sử dụng Comparator
            Collections.sort(danhSachHangHoa, new Comparator<HangHoa_DTO>() {
                @Override
                public int compare(HangHoa_DTO sp1, HangHoa_DTO sp2) {
                    double giaBan1 = sp1.getGiaBan();
                    double giaBan2 = sp2.getGiaBan();
                    return Double.compare(giaBan1, giaBan2);
                }
            });

            int soLuongSP = danhSachHangHoa.size();
            for (int i = 0; i < soLuongSP; i++) {
                HangHoa_DTO sanPham = danhSachHangHoa.get(i);
                String maSP = sanPham.getMaSP();
                String tenSP = sanPham.getTenSP();
                int soLuong = sanPham.getSoLuong();
                double giaNhap = sanPham.getGiaNhap();
                double giaBan = sanPham.getGiaBan();
                String tenNCC = "abc";
                String xuatXu = sanPham.getXuatXu();
                String donVi = sanPham.getDonVi();
                model.addRow(new Object[]{i + 1, maSP, tenSP, soLuong, giaNhap, giaBan, tenNCC, xuatXu, donVi});
            }

        }
    }//GEN-LAST:event_BtnArrangeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//           themHH(String maSP, String tenSP, String maNH, String maNCC, String donVi, double giaNhap, double giaBan, int soLuong, String xuatXu, boolean tonTai)
        String maSP = txtMaSP.getText();
        String tenSP = txtTenSP.getText();
        String donVi = txtDonVi.getText();
        double giaNhap = Double.parseDouble(txtGiaNhap.getText());
        double giaBan = Double.parseDouble(txtGiaBan.getText());
        int soLuong = 0;
        String xuatXu = txtXuatXu.getText();
        String maNCC = "";
        int indexMaNCC = cbbMaNCC.getSelectedIndex();
        if(indexMaNCC == 0){
            maNCC= "NCCDYQN";
        }
        String maNH = "";
        int indexMaNH = cbbMaNhomHang.getSelectedIndex();
        if(indexMaNH == 0){
            maNH = "0000001";
        }
        if(indexMaNH == 1){
            maNH = "0000002";
        }
        if(indexMaNH == 2){
            maNH = "0000003";
        }
        if(indexMaNH == 3){
            maNH = "0000004";
        }
        if(indexMaNH == 4){
            maNH = "0000005";
        }
        if(indexMaNH == 5){
            maNH = "0000006";
        }
        if(indexMaNH == 6){
            maNH = "0000007";
        }
        if(indexMaNH == 7){
            maNH = "0000008";
        }
        if(indexMaNH == 8){
            maNH = "0000009";
        }
        if(indexMaNH == 9){
            maNH = "0000010";
        }
        if(indexMaNH == 10){
            maNH = "0000011";
        }
        if(indexMaNH == 11){
            maNH = "0000012";
        }
        try {
            hhBus.themHH(maSP, tenSP, maNH, maNCC, donVi, giaNhap, giaBan, soLuong, xuatXu, true);
             JOptionPane.showMessageDialog(null,
                        "Thêm hàng hóa thành công");
                
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,
                        "Thêm hàng thất bại");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnArrange;
    private javax.swing.JRadioButton ChkArrangeByName;
    private javax.swing.JRadioButton ChkArrangeByPrice;
    private javax.swing.JTable TableProducts;
    private javax.swing.JComboBox<String> cbbMaNCC;
    private javax.swing.JComboBox<String> cbbMaNhomHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImg;
    private javax.swing.JTextField txtDonVi;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNhaCC;
    private javax.swing.JTextField txtSoLuongSP;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}
