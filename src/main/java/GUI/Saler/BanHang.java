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
import GUI.Login.TaiKhoan;
import javax.swing.JLabel;
import static GUI.Saler.item.gioHang;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
        //tableGioHang.removeAll();
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
//        model.fireTableDataChanged();
//        tableGioHang.revalidate();
//        tableGioHang.repaint();
    }

    public void resetUI() {
        showItemCartInTable();
        txtTienKhachDua.setText("0");
        txtTienThua.setText("0");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGioHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtSoLuong = new javax.swing.JTextField();
        btnSuaSoLuong = new javax.swing.JButton();
        btnDeleteItem = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnTimKhachHang = new javax.swing.JButton();
        cbbTypeCustomer = new javax.swing.JComboBox<>();
        txtSDT = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtFindNameItem = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        btnOffFind = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        btnPayment = new javax.swing.JButton();
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

        txtSoLuong.setToolTipText("");
        txtSoLuong.setBorder(javax.swing.BorderFactory.createTitledBorder("Số lượng"));
        txtSoLuong.setPreferredSize(new java.awt.Dimension(64, 64));

        btnSuaSoLuong.setBackground(new java.awt.Color(51, 255, 0));
        btnSuaSoLuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSuaSoLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/updated.png"))); // NOI18N
        btnSuaSoLuong.setText("SỬA SỐ LƯỢNG");
        btnSuaSoLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaSoLuongMouseClicked(evt);
            }
        });
        btnSuaSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSoLuongActionPerformed(evt);
            }
        });

        btnDeleteItem.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteItem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDeleteItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bin.png"))); // NOI18N
        btnDeleteItem.setText("XÓA SẢN PHẨM");
        btnDeleteItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteItemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaSoLuong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteItem)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteItem))
                .addContainerGap())
        );

        btnTimKhachHang.setBackground(new java.awt.Color(255, 255, 0));
        btnTimKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTimKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FindCustomer.png"))); // NOI18N
        btnTimKhachHang.setText("TÌM KHÁCH HÀNG");
        btnTimKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKhachHangActionPerformed(evt);
            }
        });

        cbbTypeCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách vãng lai", "Khách đã đăng kí trên hệ thống" }));
        cbbTypeCustomer.setEnabled(false);

        txtSDT.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập SĐT"));

        txtTenKH.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên khách hàng"));
        txtTenKH.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTypeCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnTimKhachHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(txtTenKH)))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbTypeCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtFindNameItem.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập tên SP"));

        btnFind.setBackground(new java.awt.Color(255, 255, 0));
        btnFind.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btnFind.setText("TÌM KIẾM");
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

        btnOffFind.setBackground(new java.awt.Color(255, 51, 0));
        btnOffFind.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnOffFind.setText("TẮT TÌM KIẾM");
        btnOffFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOffFindMouseClicked(evt);
            }
        });
        btnOffFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOffFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFindNameItem, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOffFind, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOffFind, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFindNameItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtTienKhachDua.setText("0");
        txtTienKhachDua.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập tiền khách đưa"));
        txtTienKhachDua.setPreferredSize(new java.awt.Dimension(64, 50));
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        txtTienThua.setText("0");
        txtTienThua.setBorder(javax.swing.BorderFactory.createTitledBorder("Tiền trả khách"));
        txtTienThua.setPreferredSize(new java.awt.Dimension(64, 50));

        btnPayment.setBackground(new java.awt.Color(0, 51, 255));
        btnPayment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pay.png"))); // NOI18N
        btnPayment.setText("THANH TOÁN");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGap(0, 691, Short.MAX_VALUE)
        );

        ScrollPaneItems.setViewportView(PanelItems);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPaneItems, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPaneItems, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        jLabel2.setBackground(new java.awt.Color(0, 255, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
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
                .addGap(0, 0, 0)
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
        try {
            int number = Integer.parseInt(soLuong);
            // Kiểm tra nếu chuyển đổi thành công, số nhập vào là một số nguyên
            // Có thể tiếp tục xử lý ở đây
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên");
            return;
        }
        if (Integer.parseInt(soLuong) < 1) {
            JOptionPane.showMessageDialog(null,
                    "Số lượng >= 1");
            return;
        }
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
            JOptionPane.showMessageDialog(null,
                    "Vui lòng click vào sản phẩm cần xóa để xóa!");
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
                for (int i = 0; i < gioHang.size(); i++) {
                    HangHoa_DTO hh = gioHang.get(i);
                    cthdBUS.themCTHD(hoaDonDAO.demSoHoaDon(), hh.getMaSP(), hh.getSoLuong());
                    hhb.giamSLSP(hh.getMaSP(), hh.getSoLuong());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e);
                return;
            }
            JFrame frame = new JFrame("In hóa đơn");
            ThongTinHoaDon tthd = new ThongTinHoaDon();
            frame.add(tthd);
            frame.setSize(548, 536);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        resetUI();
                        gioHang.clear();
                        showItemCartInTable();
                    });
                }
            });

        } else {
            return;
        }

        resetUI();
        showItemCartInTable();
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnTimKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKhachHangActionPerformed
        // TODO add your handling code here:
        String sdt = txtSDT.getText();
        if (sdt.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng nhập SĐT!");
            return;
        }
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

    private void btnOffFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOffFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOffFindActionPerformed

    private void btnSuaSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaSoLuongActionPerformed


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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
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
