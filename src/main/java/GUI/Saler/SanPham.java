/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Saler;

import BUS.HangHoaBus;
import DAO.HangHoaDAO;
import DTO.HangHoa_DTO;
import DTO.KhachHang_DTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ButtonGroup;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author acer
 */
public class SanPham extends javax.swing.JPanel {

    HangHoaDAO hhd = new HangHoaDAO();
    HangHoaBus hhBUS = new HangHoaBus();
    public SanPham() {
        initComponents();
        createButtonGroup();
        //hiển thị sản phẩm vào table
        showProductsInTable();
    }

    public void showProductsInTable() {
        DefaultTableModel model = (DefaultTableModel) TableProducts.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng
        ArrayList<HangHoa_DTO> danhSachHangHoa = hhBUS.itemData();
        int soLuongSP = danhSachHangHoa.size();
        for (int i = 0; i < soLuongSP; i++) {
            HangHoa_DTO sanPham = danhSachHangHoa.get(i);
            String maSP = sanPham.getMaSP();
            String tenSP = sanPham.getTenSP();
            int soLuong = sanPham.getSoLuong();
            double giaBan = sanPham.getGiaBan();
            String xuatXu = sanPham.getXuatXu();
            String donVi = sanPham.getDonVi();
            model.addRow(new Object[]{maSP, tenSP, soLuong, giaBan, xuatXu, donVi});
        }
    }

    public void createButtonGroup() {
        ButtonGroup arrangeGroup = new ButtonGroup();
        arrangeGroup.add(ChkArrangeByName);
        arrangeGroup.add(ChkArrangeByPrice);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbImg = new javax.swing.JLabel();
        BtnArrange = new javax.swing.JButton();
        ChkArrangeByName = new javax.swing.JRadioButton();
        ChkArrangeByPrice = new javax.swing.JRadioButton();
        txtFindByName = new javax.swing.JTextField();
        btnFindByName = new javax.swing.JButton();
        btnOffFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProducts = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("XEM SẢN PHẨM");

        jPanel1.setBackground(new java.awt.Color(176, 206, 221));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lbImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btt.jpg"))); // NOI18N

        BtnArrange.setBackground(new java.awt.Color(67, 138, 174));
        BtnArrange.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BtnArrange.setForeground(new java.awt.Color(255, 255, 255));
        BtnArrange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sorting.png"))); // NOI18N
        BtnArrange.setText("SẮP XẾP");
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

        ChkArrangeByName.setBackground(new java.awt.Color(176, 206, 221));
        ChkArrangeByName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ChkArrangeByName.setText("Theo tên sản phẩm");
        ChkArrangeByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkArrangeByNameActionPerformed(evt);
            }
        });

        ChkArrangeByPrice.setBackground(new java.awt.Color(176, 206, 221));
        ChkArrangeByPrice.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ChkArrangeByPrice.setText("Theo giá sản phẩm");
        ChkArrangeByPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkArrangeByPriceActionPerformed(evt);
            }
        });

        btnFindByName.setBackground(new java.awt.Color(67, 138, 174));
        btnFindByName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnFindByName.setForeground(new java.awt.Color(255, 255, 255));
        btnFindByName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btnFindByName.setText("TÌM KIẾM");
        btnFindByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindByNameActionPerformed(evt);
            }
        });

        btnOffFind.setBackground(new java.awt.Color(67, 138, 174));
        btnOffFind.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnOffFind.setForeground(new java.awt.Color(255, 255, 255));
        btnOffFind.setText("TẮT TÌM KIẾM");
        btnOffFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOffFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(txtFindByName, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFindByName)
                    .addComponent(btnOffFind))
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnArrange)
                    .addComponent(ChkArrangeByName, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(ChkArrangeByPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnArrange)
                            .addComponent(txtFindByName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFindByName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOffFind, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChkArrangeByName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChkArrangeByPrice)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        TableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá", "Xuất xứ", "Đơn vị"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableProducts.setRowHeight(35);
        TableProducts.setSelectionBackground(new java.awt.Color(176, 206, 221));
        TableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProducts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1167, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ChkArrangeByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkArrangeByNameActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_ChkArrangeByNameActionPerformed

    private void ChkArrangeByPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkArrangeByPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChkArrangeByPriceActionPerformed

    private void BtnArrangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnArrangeMouseClicked
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

                double giaBan = sanPham.getGiaBan();
                String xuatXu = sanPham.getXuatXu();
                String donVi = sanPham.getDonVi();
                model.addRow(new Object[]{maSP, tenSP, soLuong, giaBan, xuatXu, donVi});
            }
        }
        if (ChkArrangeByPrice.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) TableProducts.getModel();
            model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng
            ArrayList<HangHoa_DTO> danhSachHangHoa = hhBUS.itemData();

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
                double giaBan = sanPham.getGiaBan();
                String xuatXu = sanPham.getXuatXu();
                String donVi = sanPham.getDonVi();
                model.addRow(new Object[]{maSP, tenSP, soLuong, giaBan, xuatXu, donVi});
            }

        }
    }//GEN-LAST:event_BtnArrangeMouseClicked

    private void TableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductsMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
            int selectedRow = TableProducts.getSelectedRow();
            if (selectedRow != -1) {
                String maSP = (String) TableProducts.getValueAt(selectedRow, 0);
                ArrayList<HangHoa_DTO> danhSachHangHoa = hhBUS.itemData();
                int soLuongHH = danhSachHangHoa.size();
                for (int i = 0; i < soLuongHH; i++) {
                    HangHoa_DTO sanPham = danhSachHangHoa.get(i);
                    if (maSP.equals(sanPham.getMaSP())) {
                        String Path = sanPham.getAnhSP();
                        lbImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Path))); // NOI18N
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_TableProductsMouseClicked

    private void btnFindByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindByNameActionPerformed

        String itemName = txtFindByName.getText().toLowerCase().trim();
        ArrayList<HangHoa_DTO> danhSachHangHoa = hhBUS.itemData();
        int soLuongHH = danhSachHangHoa.size();
        DefaultTableModel model = (DefaultTableModel) TableProducts.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng 
        for (int i = 0; i < soLuongHH; i++) {
            HangHoa_DTO hangHoa = danhSachHangHoa.get(i);
            if (hangHoa.getTenSP().toLowerCase().contains(itemName)) {
                
                String maSP = hangHoa.getMaSP();
                String tenSP = hangHoa.getTenSP();
                int soLuong = hangHoa.getSoLuong();
                double giaBan = hangHoa.getGiaBan();
                String xuatXu = hangHoa.getXuatXu();
                String donVi = hangHoa.getDonVi();
                model.addRow(new Object[]{maSP, tenSP, soLuong, giaBan, xuatXu, donVi});
            }
        }
    }//GEN-LAST:event_btnFindByNameActionPerformed

    private void btnOffFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOffFindActionPerformed
       showProductsInTable();
    }//GEN-LAST:event_btnOffFindActionPerformed

    private void BtnArrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnArrangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnArrangeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnArrange;
    private javax.swing.JRadioButton ChkArrangeByName;
    private javax.swing.JRadioButton ChkArrangeByPrice;
    private javax.swing.JTable TableProducts;
    private javax.swing.JButton btnFindByName;
    private javax.swing.JButton btnOffFind;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImg;
    private javax.swing.JTextField txtFindByName;
    // End of variables declaration//GEN-END:variables
}
