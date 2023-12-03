/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.QuanLy;

import BUS.ChiTietHoaDonBus;
import BUS.ChiTietPhieuXuatBus;
import BUS.HoaDonBus;
import BUS.PhieuNhapBus;
import BUS.PhieuXuatBus;
import DAO.HangHoaDAO;
import DTO.ChiTietHoaDon_DTO;
import DTO.HangHoa_DTO;
import DTO.HoaDon_DTO;
import DTO.PhieuNhap_DTO;
import DTO.PhieuXuat_DTO;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class ThongKe extends javax.swing.JPanel {

    HoaDonBus hdBUS = new HoaDonBus();
    ArrayList<HoaDon_DTO> danhSachHoaDon = hdBUS.dsHoaDon();

    ChiTietHoaDonBus cthdBUS = new ChiTietHoaDonBus();
    PhieuXuatBus pxBUS = new PhieuXuatBus();
    ArrayList<PhieuXuat_DTO> phieuXuats = pxBUS.readPhieuXuat_DTOs();

    HangHoaDAO hhd = new HangHoaDAO();
    ArrayList<HangHoa_DTO> dsHangHoa = hhd.ReadHangHoa();

    PhieuNhapBus pnBUS = new PhieuNhapBus();
    ArrayList<PhieuNhap_DTO> phieuNhaps = pnBUS.rPhieuNhap_DTOs();

    ChiTietPhieuXuatBus ctpx = new ChiTietPhieuXuatBus();
    DefaultTableModel originalModel;

    public ThongKe() {
        initComponents();
        showBillStatistics(null, null);
    }

    public void showBillStatistics(LocalDate dayPrev, LocalDate dayNext) {
        originalModel = (DefaultTableModel) tableStatistical.getModel();
        DefaultTableModel model = (DefaultTableModel) tableStatistical.getModel();
        model.setRowCount(0);
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        double total = 0;
        double tongDoanhThu = 0;
        if (dayPrev == null || dayNext == null) {
            for (int i = 0; i < danhSachHoaDon.size(); i++) {
                HoaDon_DTO hoaDon = danhSachHoaDon.get(i);
                ArrayList<ChiTietHoaDon_DTO> cthds = cthdBUS.dsHD(hoaDon.getSoHD());
                double giaGoc = 0;
                double doanhThu = 0;
                for (int j = 0; j < cthds.size(); j++) {
                    ChiTietHoaDon_DTO cthd = cthds.get(j);
                    double giaNhap = getGiaNhap(cthd.getMaSP());
                    giaGoc += cthd.getSoLuong() * giaNhap;
                }
                doanhThu = hoaDon.getThanhTien() - giaGoc;
                total += hoaDon.getThanhTien();
                model.addRow(new Object[]{hoaDon.getSoHD(), hoaDon.getMaNV(), hoaDon.getMaKH(), hoaDon.getThoiGianLap(), hoaDon.getThanhTien(), hoaDon.getTienKhachDua(), hoaDon.getTienTraKhach(), doanhThu});
                tongDoanhThu += doanhThu;
            }
        } else {
            ArrayList<HoaDon_DTO> hoaDonByDate = new ArrayList<>();
            for (int i = 0; i < danhSachHoaDon.size(); i++) {
                HoaDon_DTO hoaDon = danhSachHoaDon.get(i);
                if ((hoaDon.getThoiGianLap().isAfter(dayPrev) || hoaDon.getThoiGianLap().isEqual(dayPrev))
                        && (hoaDon.getThoiGianLap().isBefore(dayNext) || hoaDon.getThoiGianLap().isEqual(dayNext))) {
                    hoaDonByDate.add(hoaDon);
                }
            }
            for (int i = 0; i < hoaDonByDate.size(); i++) {
                HoaDon_DTO hoaDon = hoaDonByDate.get(i);
                ArrayList<ChiTietHoaDon_DTO> cthds = cthdBUS.dsHD(hoaDon.getSoHD());
                double giaGoc = 0;
                double doanhThu = 0;
                for (int j = 0; j < cthds.size(); j++) {
                    ChiTietHoaDon_DTO cthd = cthds.get(j);
                    double giaNhap = getGiaNhap(cthd.getMaSP());
                    giaGoc += cthd.getSoLuong() * giaNhap;
                }
                doanhThu = hoaDon.getThanhTien() - giaGoc;
                total += hoaDon.getThanhTien();
                model.addRow(new Object[]{hoaDon.getSoHD(), hoaDon.getMaNV(), hoaDon.getMaKH(), hoaDon.getThoiGianLap(), hoaDon.getThanhTien(), hoaDon.getTienKhachDua(), hoaDon.getTienTraKhach(), doanhThu});
                tongDoanhThu += doanhThu;
            }
        }
        model.addRow(new Object[]{null, null, null, "Tổng thu nhập : ", total, null, null, tongDoanhThu});
        txtDoanhThu.setVisible(true);
        jLabel4.setVisible(true);
        txtDoanhThu.setText(decimalFormat.format(tongDoanhThu) + " VNĐ");
    }

    public void showImportBill(LocalDate dayPrev, LocalDate dayNext) {
        DefaultTableModel model = (DefaultTableModel) tableStatistical.getModel();
        model.setRowCount(0);
        String[] columnNames = {"Mã phiếu nhập", "MANV", "Thời gian lập", "VAT", "Số mặt hàng", "Tổng tiền", "Trạng thái"};
        DefaultTableModel newModel = new DefaultTableModel(columnNames, 0);
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        double total = 0;
        if (dayPrev == null || dayNext == null) {
            for (int i = 0; i < phieuNhaps.size(); i++) {
                PhieuNhap_DTO pn = phieuNhaps.get(i);
                String tongTien = decimalFormat.format(pn.getTongTien());
                newModel.addRow(new Object[]{pn.getMaPhieuNhap(), pn.getMaNV(), pn.getThoiGianLap(), pn.getVAT(), pn.getSoMatHang(), tongTien, pn.getTrangThai()});
                if (pn.getTrangThai().equals("DA DUYET")) {
                    total += pn.getTongTien();
                }
            }
        } else {
            ArrayList<PhieuNhap_DTO> phieuNhapByDate = new ArrayList<>();
            for (int i = 0; i < phieuNhaps.size(); i++) {
                PhieuNhap_DTO phieuNhap = phieuNhaps.get(i);
                if ((phieuNhap.getThoiGianLap().isAfter(dayPrev) || phieuNhap.getThoiGianLap().isEqual(dayPrev))
                        && (phieuNhap.getThoiGianLap().isBefore(dayNext) || phieuNhap.getThoiGianLap().isEqual(dayNext))) {
                    phieuNhapByDate.add(phieuNhap);
                }
            }
            for (int i = 0; i < phieuNhapByDate.size(); i++) {
                PhieuNhap_DTO pn = phieuNhapByDate.get(i);
                String tongTien = decimalFormat.format(pn.getTongTien());
                newModel.addRow(new Object[]{pn.getMaPhieuNhap(), pn.getMaNV(), pn.getThoiGianLap(), pn.getVAT(), pn.getSoMatHang(), tongTien, pn.getTrangThai()});
                if (pn.getTrangThai().equals("DA DUYET")) {
                    total += pn.getTongTien();
                }
            }
        }
        String tongTiens = decimalFormat.format(total);
        newModel.addRow(new Object[]{null, null, null, null, "Tổng", tongTiens, null});
        tableStatistical.setModel(newModel);
        txtDoanhThu.setVisible(false);
        jLabel4.setVisible(false);
    }

    public void showExportBill(LocalDate dayPrev, LocalDate dayNext) {
        DefaultTableModel model = (DefaultTableModel) tableStatistical.getModel();
        model.setRowCount(0);
        String[] columnNames = {"Mã phiếu xuất", "Mã nhân viên", "Mã khách hàng", "Thời gian xuất", "Lý do", "Ghi chú", "Tổng tiền", "Tiền lãi"};
        DefaultTableModel newModel = new DefaultTableModel(columnNames, 0);
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        double total = 0;
        double tongDoanhThu = 0;
        if (dayPrev == null || dayNext == null) {
            for (int i = 0; i < phieuXuats.size(); i++) {
                PhieuXuat_DTO px = phieuXuats.get(i);
                newModel.addRow(new Object[]{px.getMaPhieuXuat(), px.getMaNV(), px.getMaKH(), px.getThoiGianXuat(), px.getLyDo(), px.getGhiChu(), decimalFormat.format(px.getTongTien()), decimalFormat.format(ctpx.doanhThuPhieuXuat(px.getMaPhieuXuat()))});
                total += px.getTongTien();
                tongDoanhThu += ctpx.doanhThuPhieuXuat(px.getMaPhieuXuat());
            }
        } else {
            ArrayList<PhieuXuat_DTO> phieuXuatByDate = new ArrayList<>();
            for (int i = 0; i < phieuXuats.size(); i++) {
                PhieuXuat_DTO phieuXuat = phieuXuats.get(i);
                if ((phieuXuat.getThoiGianXuat().isAfter(dayPrev) || phieuXuat.getThoiGianXuat().isEqual(dayPrev))
                        && (phieuXuat.getThoiGianXuat().isBefore(dayNext) || phieuXuat.getThoiGianXuat().isEqual(dayNext))) {
                    phieuXuatByDate.add(phieuXuat);
                }
            }
            for (int i = 0; i < phieuXuatByDate.size(); i++) {
                PhieuXuat_DTO px = phieuXuatByDate.get(i);
                newModel.addRow(new Object[]{px.getMaPhieuXuat(), px.getMaNV(), px.getMaKH(), px.getThoiGianXuat(), px.getLyDo(), px.getGhiChu(), decimalFormat.format(px.getTongTien()), decimalFormat.format(ctpx.doanhThuPhieuXuat(px.getMaPhieuXuat()))});
                total += px.getTongTien();
                tongDoanhThu += ctpx.doanhThuPhieuXuat(px.getMaPhieuXuat());
            }
        }
        String tongTiens = decimalFormat.format(total);
        newModel.addRow(new Object[]{null, null, null, null, null, "Tổng", tongTiens, decimalFormat.format(tongDoanhThu)});
        tableStatistical.setModel(newModel);
        txtDoanhThu.setVisible(true);
        jLabel4.setVisible(true);
        txtDoanhThu.setText(decimalFormat.format(tongDoanhThu) + " VNĐ");

    }

    public void showProductBestSaler() {
        DefaultTableModel model = (DefaultTableModel) tableStatistical.getModel();
        model.setRowCount(0);
        String[] columnNames = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng đã bán"};
        DefaultTableModel newModel = new DefaultTableModel(columnNames, 0);
    }

    public double getGiaNhap(String MaSP) {
        for (int i = 0; i < dsHangHoa.size(); i++) {
            if (dsHangHoa.get(i).getMaSP().equals(MaSP)) {
                return dsHangHoa.get(i).getGiaNhap();

            }
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        chiTietHoaDon = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStatistical = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ngayTruoc = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        datePrev = new com.toedter.calendar.JDateChooser();
        dateNext = new com.toedter.calendar.JDateChooser();
        btnThongKe = new javax.swing.JButton();
        cbbTypeStatistic = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDoanhThu = new javax.swing.JLabel();

        chiTietHoaDon.setText("Xem chi tiết");
        chiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chiTietHoaDonActionPerformed(evt);
            }
        });
        popupMenu.add(chiTietHoaDon);

        setBackground(new java.awt.Color(176, 206, 221));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THỐNG KÊ");

        tableStatistical.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        tableStatistical.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Số hóa đơn", "MANV", "MAKH", "Thời gian lập", "Thành tiền", "Tiền khách đưa", "Tiền trả khách", "Tiền lãi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableStatistical.setRowHeight(35);
        tableStatistical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStatisticalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableStatistical);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Thống kê từ ngày:");

        ngayTruoc.setBackground(new java.awt.Color(176, 206, 221));

        jLabel3.setBackground(new java.awt.Color(176, 206, 221));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Đến ngày:");

        javax.swing.GroupLayout ngayTruocLayout = new javax.swing.GroupLayout(ngayTruoc);
        ngayTruoc.setLayout(ngayTruocLayout);
        ngayTruocLayout.setHorizontalGroup(
            ngayTruocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ngayTruocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ngayTruocLayout.setVerticalGroup(
            ngayTruocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ngayTruocLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        datePrev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        datePrev.setToolTipText("Calander");
        datePrev.setDateFormatString("dd/MM/yyyy");

        dateNext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dateNext.setToolTipText("Calander");
        dateNext.setDateFormatString("dd/MM/yyyy");

        btnThongKe.setBackground(new java.awt.Color(67, 138, 174));
        btnThongKe.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ThongKe.png"))); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        cbbTypeStatistic.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê hóa đơn", "Thống kê phiếu nhập", "Thống kê phiếu xuất" }));
        cbbTypeStatistic.setBorder(javax.swing.BorderFactory.createTitledBorder("Tùy chọn loại thống kê"));

        jButton1.setBackground(new java.awt.Color(67, 138, 174));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/broom.png"))); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Doanh thu:");

        txtDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDoanhThu.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datePrev, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(ngayTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateNext, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbbTypeStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnThongKe)
                        .addGap(55, 55, 55)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDoanhThu)
                .addGap(0, 221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(ngayTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtDoanhThu))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThongKe)
                        .addComponent(cbbTypeStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        java.util.Date dayPrev = datePrev.getDate();
        java.util.Date dayNext = dateNext.getDate();
        if (dayPrev == null && dayNext == null) {
            if (cbbTypeStatistic.getSelectedIndex() == 0) {
                tableStatistical.setModel(originalModel);
                showBillStatistics(null, null);
                return;
            }
            if (cbbTypeStatistic.getSelectedIndex() == 1) {
                showImportBill(null, null);
                return;
            }
            if (cbbTypeStatistic.getSelectedIndex() == 2) {
                showExportBill(null, null);
                return;
            }

        }
        if (dayPrev == null || dayNext == null) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng chọn đầy đủ ngày trước và ngày sau");
            return;
        }

        Instant instant1 = dayPrev.toInstant();
        LocalDate localDate1 = instant1.atZone(ZoneId.systemDefault()).toLocalDate();
        Instant instant2 = dayNext.toInstant();
        LocalDate localDate2 = instant2.atZone(ZoneId.systemDefault()).toLocalDate();
        if (localDate1.isBefore(localDate2)) {
            if (cbbTypeStatistic.getSelectedIndex() == 0) {
                tableStatistical.setModel(originalModel);
                showBillStatistics(localDate1, localDate2);
                return;
            }
            if (cbbTypeStatistic.getSelectedIndex() == 1) {
                showImportBill(localDate1, localDate2);
                return;
            }
            if (cbbTypeStatistic.getSelectedIndex() == 2) {
                showExportBill(localDate1, localDate2);
                return;
            }

        } else {
            JOptionPane.showMessageDialog(null,
                    "Chọn ngày không hợp lệ ngày trước phải nhỏ hơn ngày sau");
            return;
        }
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        datePrev.setDate(null);
        dateNext.setDate(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableStatisticalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStatisticalMouseClicked
        // TODO add your handling code here:
        int i = tableStatistical.getSelectedRow();
        if (i >= 0) {
            if (cbbTypeStatistic.getSelectedIndex() == 0) {
                popupMenu.show(tableStatistical, evt.getX(), evt.getY());
            }

        }

    }//GEN-LAST:event_tableStatisticalMouseClicked

    private void chiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chiTietHoaDonActionPerformed
        // TODO add your handling code here:
        int i = tableStatistical.getSelectedRow();
        JFrame frame = new JFrame("Chi tiết hóa đơn");
        ChiTietHoaDon cthd = new ChiTietHoaDon(Integer.parseInt(tableStatistical.getModel().getValueAt(i, 0).toString()));
        frame.add(cthd);
        frame.setSize(450, 421);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }//GEN-LAST:event_chiTietHoaDonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThongKe;
    private javax.swing.JComboBox<String> cbbTypeStatistic;
    private javax.swing.JMenuItem chiTietHoaDon;
    private com.toedter.calendar.JDateChooser dateNext;
    private com.toedter.calendar.JDateChooser datePrev;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel ngayTruoc;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JTable tableStatistical;
    private javax.swing.JLabel txtDoanhThu;
    // End of variables declaration//GEN-END:variables
}
