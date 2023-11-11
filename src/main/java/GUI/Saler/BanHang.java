/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Saler;

import BUS.ChiTietHoaDonBus;
import BUS.HangHoaBus;
import BUS.KhachHangBus;
import DAO.ChiTietHoaDonDAO;
import DAO.HangHoaDAO;
import DAO.HoaDonDAO;
import DTO.HangHoa_DTO;
import DTO.KhachHang_DTO;
import GUI.Login.TaiKhoan;
import javax.swing.JLabel;
import static GUI.Saler.item.gioHang;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JFrame;

/**
 *
 * @author acer
 */
public class BanHang extends javax.swing.JPanel {

    public JLabel LbImg;
    HangHoaDAO hhd = new HangHoaDAO();
    private String masp = "";
    static HangHoaBus hhb = new HangHoaBus();
    HoaDonDAO hoaDonDAO = new HoaDonDAO();
    ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
    TaiKhoan tk = new TaiKhoan();
    KhachHangBus khBUS = new KhachHangBus();
     ChiTietHoaDonBus cthdBUS = new ChiTietHoaDonBus();
    String makh = "";

    public BanHang() {
        initComponents();
        showItems();
        showItemCartInTable();
        txtTienThua.setEnabled(false);
       
    }

    public void showItems() {
        PanelItems.removeAll();
        ArrayList<HangHoa_DTO> danhSachSanPham = hhd.ReadHangHoa();
        int soLuongSP = danhSachSanPham.size();
        PanelItems.setLayout(new GridLayout(0, 2));
        for (int i = 0; i < soLuongSP; i++) {
            HangHoa_DTO sanPham = danhSachSanPham.get(i);
            String path = sanPham.getAnhSP();
            String MaSP = sanPham.getMaSP();
            int soLuong = sanPham.getSoLuong();
            item it = new item();
            it.setLbImgIcon(path);
            it.MaSP(MaSP);
            if (soLuong == 0) {
                it.setDisabledBtnAdd(true);
            } else {
                it.setDisabledBtnAdd(false);
            }
            PanelItems.add(it);
        }
        PanelItems.revalidate();
        PanelItems.repaint();
    }

    public static void showItemCartInTable() {
        tableGioHang.removeAll();
        ArrayList<HangHoa_DTO> gioHang = item.gioHang;
        DefaultTableModel model = (DefaultTableModel) tableGioHang.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng       
        int soLuongTrongGioHang = gioHang.size();
        double total = 0;
        for (int i = 0; i < soLuongTrongGioHang; i++) {
            HangHoa_DTO sanPham = gioHang.get(i);
            String maSP = sanPham.getMaSP();
            String tenSP = sanPham.getTenSP();
            int soLuong = sanPham.getSoLuong();
            double thanhTien = sanPham.getGiaBan();
            total += thanhTien;
            String giaban = String.valueOf(hhb.giaBanSP(sanPham.getMaSP()));
            model.addRow(new Object[]{maSP, tenSP, soLuong, giaban, thanhTien});
        }
        model.addRow(new Object[]{"", "", "", "Tổng:", total});
        txtTienThua.setText(String.valueOf(Double.parseDouble(txtTienKhachDua.getText()) - total));
        txtTienKhachDua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;
                for (HangHoa_DTO sanPham : gioHang) {
                    total += sanPham.getGiaBan();
                }
                String tienKhachDua = txtTienKhachDua.getText();
                txtTienThua.setText(String.valueOf(Double.parseDouble(tienKhachDua) - total));
            }
        });
        tableGioHang.revalidate();
        tableGioHang.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGioHang = new javax.swing.JTable();
        txtFindNameItem = new javax.swing.JTextField();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        btnPayment = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        btnOffFind = new javax.swing.JButton();
        btnDeleteItem = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        btnSuaSoLuong = new javax.swing.JButton();
        cbbTypeCustomer = new javax.swing.JComboBox<>();
        txtSDT = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        btnTimKhachHang = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ScrollPaneItems = new javax.swing.JScrollPane();
        PanelItems = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tableGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
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
        tableGioHang.setRowHeight(40);
        tableGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGioHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableGioHang);

        txtTienKhachDua.setText("0");
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        txtTienThua.setText("0");

        btnPayment.setText("Thanh toán");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        jLabel4.setText("Tiền thừa");

        jLabel5.setText("Tiền khách đưa");

        btnFind.setText("Tìm kiếm");
        btnFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFindMouseClicked(evt);
            }
        });
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnOffFind.setText("Tắt tìm kiếm");
        btnOffFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOffFindMouseClicked(evt);
            }
        });

        btnDeleteItem.setText("Xóa sản phẩm");
        btnDeleteItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteItemMouseClicked(evt);
            }
        });

        txtSoLuong.setToolTipText("");
        txtSoLuong.setBorder(javax.swing.BorderFactory.createTitledBorder("Số lượng"));
        txtSoLuong.setPreferredSize(new java.awt.Dimension(64, 64));

        btnSuaSoLuong.setText("Sửa SL");
        btnSuaSoLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaSoLuongMouseClicked(evt);
            }
        });

        cbbTypeCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách vãng lai", "Khách đã đăng kí trên hệ thống" }));

        txtSDT.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập SĐT"));

        txtTenKH.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên khách hàng"));

        btnTimKhachHang.setText("Tìm khách hàng");
        btnTimKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaSoLuong)
                .addGap(106, 106, 106)
                .addComponent(btnDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(48, 48, 48)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTimKhachHang)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienThua)
                            .addComponent(txtTenKH)
                            .addComponent(txtSDT)
                            .addComponent(cbbTypeCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTienKhachDua)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOffFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFindNameItem, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFindNameItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFind))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOffFind))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbbTypeCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSDT)
                            .addComponent(btnTimKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ScrollPaneItems.setHorizontalScrollBar(null);
        ScrollPaneItems.setInheritsPopupMenu(true);

        javax.swing.GroupLayout PanelItemsLayout = new javax.swing.GroupLayout(PanelItems);
        PanelItems.setLayout(PanelItemsLayout);
        PanelItemsLayout.setHorizontalGroup(
            PanelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );
        PanelItemsLayout.setVerticalGroup(
            PanelItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        ScrollPaneItems.setViewportView(PanelItems);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(ScrollPaneItems, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(ScrollPaneItems)
                .addGap(0, 0, 0))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        jLabel2.setBackground(new java.awt.Color(0, 255, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(173, 187, 198));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BÁN HÀNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void btnFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFindMouseClicked
        // TODO add your handling code here:
        PanelItems.removeAll();
        String nameItem = txtFindNameItem.getText().toLowerCase();
        ArrayList<HangHoa_DTO> danhSachSanPhamTimKiem = new ArrayList<>();
        ArrayList<HangHoa_DTO> danhSachSanPham = hhd.ReadHangHoa();
        int soLuongSP = danhSachSanPham.size();
        PanelItems.setLayout(new GridLayout(0, 2));
        for (int i = 0; i < soLuongSP; i++) {
            HangHoa_DTO sanPham = danhSachSanPham.get(i);
            if (sanPham.getTenSP().toLowerCase().contains(nameItem)) {
                danhSachSanPhamTimKiem.add(sanPham);
            }
        }
        for (int i = 0; i < danhSachSanPhamTimKiem.size(); i++) {
            HangHoa_DTO sanPham = danhSachSanPhamTimKiem.get(i);
            String path = sanPham.getAnhSP();
            String MaSP = sanPham.getMaSP();
            item it = new item();
            it.setLbImgIcon(path);
            it.MaSP(MaSP);
            PanelItems.add(it);
        }
        PanelItems.revalidate();
        PanelItems.repaint();
    }//GEN-LAST:event_btnFindMouseClicked

    private void btnOffFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOffFindMouseClicked
        // TODO add your handling code here:
        showItems();
    }//GEN-LAST:event_btnOffFindMouseClicked

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFindActionPerformed

    private void tableGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGioHangMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            int selectedRow = tableGioHang.getSelectedRow();
            if (selectedRow != -1) {
                int soLuong = (int) tableGioHang.getValueAt(selectedRow, 2);
                txtSoLuong.setText(String.valueOf(soLuong));
                this.masp = (String) tableGioHang.getValueAt(selectedRow, 0);
            }
        }
    }//GEN-LAST:event_tableGioHangMouseClicked

    private void btnSuaSoLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaSoLuongMouseClicked
        // TODO add your handling code here:
        String soLuong = txtSoLuong.getText();
        for (HangHoa_DTO sanPham : gioHang) {
            if (sanPham.getMaSP().equals(masp)) {
                int soLuongTrenDB = hhb.ktSoLuong(sanPham.getMaSP());
                if (Integer.parseInt(soLuong) > soLuongTrenDB) {
                    JOptionPane.showMessageDialog(null,
                            "Số lượng đã vượt quá số lượng trên kệ \n" + "Trên kệ hiện tại còn (" + soLuongTrenDB + ") sản phẩm");
                    return;
                }
                sanPham.setSoLuong(Integer.parseInt(soLuong));
                double giaBan = Integer.parseInt(soLuong) * hhb.giaBanSP(sanPham.getMaSP());
                sanPham.setGiaBan(giaBan);
                break;
            }
        }
        showItemCartInTable();
    }//GEN-LAST:event_btnSuaSoLuongMouseClicked

    private void btnDeleteItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteItemMouseClicked
        // TODO add your handling code here:
        if (gioHang.size() == 0) {
            return;
        }
        if (masp.equals("")) {
            return;
        }
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa sản phẩm này", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            for (HangHoa_DTO sanPham : gioHang) {
                if (sanPham.getMaSP().equals(masp)) {
                    gioHang.remove(sanPham);
                    break;
                }
            }
            masp = "";
            showItemCartInTable();
        } else {
            return;
        }
    }//GEN-LAST:event_btnDeleteItemMouseClicked

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        // TODO add your handling code here:
        double tienThua = Double.parseDouble(txtTienThua.getText());
        double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
        double total = 0;
        int viTri = cbbTypeCustomer.getSelectedIndex();
        if (gioHang.size() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng thêm sản phẩm vào giỏ để thanh toán");
            
            return;
        }
        for (int i = 0; i < gioHang.size(); i++) {
            HangHoa_DTO hh = gioHang.get(i);
            total += hh.getGiaBan();
        }
        if (tienThua < 0) {
            JOptionPane.showMessageDialog(null,
                    "Khách chưa đưa đủ tiền vui lòng nhập lại!");
            
            return;
        }

        if (viTri == 0) {
            makh = "KHACHVL";
        }
        int dialogResult = JOptionPane.showConfirmDialog(null, "Xác nhận thanh toán?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                hoaDonDAO.add(hoaDonDAO.demSoHoaDon() + 1, tk.getTen_dn(), LocalDate.now(), makh, total, tienKhachDua, tienThua, true);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e);
                return;
            }
            for (int i = 0; i < gioHang.size(); i++) {
                HangHoa_DTO hh = gioHang.get(i);
                cthdBUS.themCTHD(hoaDonDAO.demSoHoaDon(), hh.getMaSP(), hh.getSoLuong());
                hhb.giamSLSP(hh.getMaSP(), hh.getSoLuong());
            }
            JFrame frame = new JFrame("In hóa đơn");
            ThongTinHoaDon tthd = new ThongTinHoaDon();
            frame.add(tthd);
            frame.setSize(500, 700);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            gioHang.clear();
        } else {
            return;
        }      
        
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnTimKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKhachHangActionPerformed
        // TODO add your handling code here:
        String sdt = txtSDT.getText();
        khBUS.timKhachHang(null, sdt);
        if (khBUS.timKhachHang(null, sdt) == null) {
            JOptionPane.showMessageDialog(null,
                    "Khách hàng chưa đăng kí trên hệ thống");
            return;
        } else {
            cbbTypeCustomer.setSelectedIndex(1);
            makh = khBUS.timKhachHang(null, sdt).getMaKH();
            txtTenKH.setText(khBUS.timKhachHang(null, sdt).getTenKH());
        }
    }//GEN-LAST:event_btnTimKhachHangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelItems;
    private javax.swing.JScrollPane ScrollPaneItems;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnOffFind;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnSuaSoLuong;
    private javax.swing.JButton btnTimKhachHang;
    private javax.swing.JComboBox<String> cbbTypeCustomer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tableGioHang;
    private javax.swing.JTextField txtFindNameItem;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKH;
    private static javax.swing.JTextField txtTienKhachDua;
    private static javax.swing.JTextField txtTienThua;
    // End of variables declaration//GEN-END:variables
}
