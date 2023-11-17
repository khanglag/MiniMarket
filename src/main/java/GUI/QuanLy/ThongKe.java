/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.QuanLy;

import BUS.ChiTietHoaDonBus;
import BUS.HangHoaBus;
import BUS.HoaDonBus;
import DAO.HangHoaDAO;
import DTO.ChiTietHoaDon_DTO;
import DTO.HangHoa_DTO;
import DTO.HoaDon_DTO;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class ThongKe extends javax.swing.JPanel {

    HoaDonBus hdBUS = new HoaDonBus();
    ChiTietHoaDonBus cthdBUS = new ChiTietHoaDonBus();
    HangHoaBus hhBUS = new HangHoaBus();
    HangHoaDAO hhd = new HangHoaDAO();
    ArrayList<HangHoa_DTO> dsHangHoa = hhd.ReadHangHoa();
    public ThongKe(JDateChooser dateNext, JDateChooser datePrev, JButton jButton1, JComboBox<String> jComboBox1, JLabel jLabel1, JLabel jLabel2, JLabel jLabel3, JScrollPane jScrollPane1, JPanel ngayTruoc, JTable tableStatistical) {
        this.dateNext = dateNext;
        this.datePrev = datePrev;
        this.jButton1 = jButton1;
        this.jComboBox1 = jComboBox1;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jLabel3 = jLabel3;
        this.jScrollPane1 = jScrollPane1;
        this.ngayTruoc = ngayTruoc;
        this.tableStatistical = tableStatistical;
    }

    public ThongKe() {
        initComponents();
        showBillStatistics(LocalDate.now(), LocalDate.now());
    }

    public void showBillStatistics(LocalDate dayPrevDate, LocalDate dayNext) {
        DefaultTableModel model = (DefaultTableModel) tableStatistical.getModel();
        model.setRowCount(0);
        ArrayList<HoaDon_DTO> danhSachHoaDon = hdBUS.dsHoaDon();
        double total = 0;
        double doanhThu = 0;
        for (int i = 0; i < danhSachHoaDon.size(); i++) {
            HoaDon_DTO hoaDon = danhSachHoaDon.get(i);
            ArrayList<ChiTietHoaDon_DTO> cthds = cthdBUS.dsHD(hoaDon.getSoHD());
            double giaGoc = 0;
            for (int j = 0; j < cthds.size(); j++) {
                ChiTietHoaDon_DTO cthd = cthds.get(j);
                double giaNhap = getGiaNhap(cthd.getMaSP());
                giaGoc += cthd.getSoLuong() * giaNhap;
                
            }
            System.out.println("hóa đơn thứ "+i+1+": thanh tien: "+hoaDon.getThanhTien());
            System.out.println("hóa đơn thứ "+i+1+": giá goc: "+giaGoc);
           // double tienLai = hoaDon.getThanhTien() - giaGoc;
           // total += hoaDon.getThanhTien();
            model.addRow(new Object[]{hoaDon.getSoHD(), hoaDon.getMaNV(), hoaDon.getMaKH(), hoaDon.getThoiGianLap(), hoaDon.getThanhTien(), hoaDon.getTienKhachDua(), hoaDon.getTienTraKhach(),1});
        }
    }
    public double getGiaNhap(String MaSP){
        for(int i = 0;i<dsHangHoa.size();i++){
            if(dsHangHoa.get(i).getMaSP().equals(MaSP)){
                return dsHangHoa.get(i).getGiaNhap();
                
            }
        }
        return 0;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStatistical = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ngayTruoc = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        datePrev = new com.toedter.calendar.JDateChooser();
        dateNext = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(173, 187, 198));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THỐNG KÊ");

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
        tableStatistical.setRowHeight(30);
        jScrollPane1.setViewportView(tableStatistical);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Thống kê từ ngày:");

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

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ThongKe.png"))); // NOI18N
        jButton1.setText("THỐNG KÊ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê hóa đơn", "Thống kê phiếu nhập", "Thống kê phiếu xuất", "Thống kê sản phẩm bán chạy" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tùy chọn loại thống kê"));

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
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(0, 520, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        java.util.Date dayPrev = datePrev.getDate();
        java.util.Date dayNext = dateNext.getDate();
        if (dayPrev != null && dayNext != null) {
            Instant instant1 = dayPrev.toInstant();
            LocalDate localDate1 = instant1.atZone(ZoneId.systemDefault()).toLocalDate();

            Instant instant2 = dayNext.toInstant();
            LocalDate localDate2 = instant2.atZone(ZoneId.systemDefault()).toLocalDate();

            // So sánh hai LocalDate
            if (localDate1.isEqual(localDate2)) {
                System.out.println("Hai ngày bằng nhau.");
                System.out.println("Day prev ->" + localDate1 + "-----Day next -> " + localDate2);
            } else if (localDate1.isBefore(localDate2)) {
                System.out.println("Ngày -> " + localDate1 + "nhỏ hơn ngày -> " + localDate2);
            } else {
                System.out.println("Ngày -> " + localDate1 + "lớn hơn ngày -> " + localDate2);
            }
        } else {
            System.out.println("Một hoặc cả hai ngày chưa được chọn.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateNext;
    private com.toedter.calendar.JDateChooser datePrev;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel ngayTruoc;
    private javax.swing.JTable tableStatistical;
    // End of variables declaration//GEN-END:variables
}
