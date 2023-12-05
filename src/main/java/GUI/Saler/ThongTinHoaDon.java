/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Saler;

import BUS.ChiTietHoaDonBus;
import DAO.HoaDonDAO;
import DTO.HangHoa_DTO;
import DTO.HoaDon_DTO;
import static GUI.Saler.BanHang.hhb;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Window;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author acer
 */
public class ThongTinHoaDon extends javax.swing.JPanel {

    HoaDonDAO hdDAO = new HoaDonDAO();
    BanHang bh = new BanHang();
    double tong;
    ChiTietHoaDonBus cthdBUS = new ChiTietHoaDonBus();

    public ThongTinHoaDon() {
        initComponents();
        showProductInTable();
        showInfoBill();

    }

    public void showInfoBill() {
        int soHD = hdDAO.demSoHoaDon();
        ArrayList<HoaDon_DTO> hoaDon = hdDAO.searchHoaDon(soHD, null);

        txtMaHoaDon.setText(soHD + "");
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTimeString = currentDateTime.format(formatter);
        txtTime.setText("Ngày " + dateTimeString);
        txtKhachDua.setText(String.valueOf(hoaDon.get(0).getTienKhachDua()));
        txtTienThua.setText(String.valueOf(hoaDon.get(0).getTienTraKhach()));
        txtTongHoaDon.setText(String.valueOf(hoaDon.get(0).getThanhTien()));
        System.out.println(hoaDon);
    }

    public void showProductInTable() {
        tableGioHang.removeAll();
        ArrayList<HangHoa_DTO> gioHang = item.gioHang;
        DefaultTableModel model = (DefaultTableModel) tableGioHang.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng       
        int soLuongTrongGioHang = gioHang.size();
        double total = 0;
        for (int i = 0; i < soLuongTrongGioHang; i++) {
            HangHoa_DTO sanPham = gioHang.get(i);
            String tenSP = sanPham.getTenSP();
            int soLuong = sanPham.getSoLuong();
            double thanhTien = sanPham.getGiaBan();
            total += thanhTien;
            String giaban = String.valueOf(hhb.giaBanSP(sanPham.getMaSP()));
            model.addRow(new Object[]{tenSP, soLuong, giaban, thanhTien});
        }
        tong = total;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitle = new javax.swing.JLabel();
        txtSoHD = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JLabel();
        txtTongHD = new javax.swing.JLabel();
        txtTongHoaDon = new javax.swing.JLabel();
        txtTKD = new javax.swing.JLabel();
        txtKhachDua = new javax.swing.JLabel();
        txtThoiGian = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtChaoMung = new javax.swing.JLabel();
        txtGach = new javax.swing.JLabel();
        txtTT = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JLabel();
        btnXuatHDPDF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGioHang = new javax.swing.JTable();

        txtTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(35, 82, 151));
        txtTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitle.setText("MR.FRESH");

        txtSoHD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSoHD.setText("Số hóa đơn: ");

        txtMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaHoaDon.setText("jLabel3");

        txtTongHD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTongHD.setText("Tổng hóa đơn:");

        txtTongHoaDon.setText("jLabel5");

        txtTKD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTKD.setText("Tiền khách đưa:");

        txtKhachDua.setText("jLabel5");

        txtThoiGian.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtThoiGian.setText("Thời gian:");

        txtTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTime.setText("jLabel3");

        txtChaoMung.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtChaoMung.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtChaoMung.setText("RẤT VUI KHI ĐƯỢC PHỤC VỤ QUÝ KHÁCH");

        txtGach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGach.setText("_______________________________________________________________________________________________");

        txtTT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTT.setText("Tiền thừa:");

        txtTienThua.setText("jLabel5");

        btnXuatHDPDF.setBackground(new java.awt.Color(67, 138, 174));
        btnXuatHDPDF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuatHDPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatHDPDF.setText("Xuất hóa đơn PDF");
        btnXuatHDPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHDPDFActionPerformed(evt);
            }
        });

        tableGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableGioHang.setRowHeight(35);
        tableGioHang.setSelectionBackground(new java.awt.Color(176, 206, 221));
        tableGioHang.setShowGrid(false);
        tableGioHang.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tableGioHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                    .addComponent(txtChaoMung, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTKD)
                            .addComponent(txtTT)
                            .addComponent(txtTongHD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtKhachDua)
                            .addComponent(txtTongHoaDon)
                            .addComponent(txtTienThua))
                        .addContainerGap(392, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSoHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtThoiGian)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTime)
                        .addGap(97, 97, 97))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXuatHDPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtChaoMung, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGach)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoHD)
                    .addComponent(txtMaHoaDon)
                    .addComponent(txtThoiGian)
                    .addComponent(txtTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongHD)
                    .addComponent(txtTongHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTKD)
                    .addComponent(txtKhachDua))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTT)
                    .addComponent(txtTienThua))
                .addGap(18, 18, 18)
                .addComponent(btnXuatHDPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatHDPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHDPDFActionPerformed
        // TODO add your handling code here:
        String path = "";
        String pathHandle = "xuatHD" + txtMaHoaDon.getText().trim() + ".pdf";
        System.out.println(pathHandle);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
            Document doc = new Document();
            try {
                BaseFont unicodeFont = BaseFont.createFont("../MiniMarket/Roboto/Roboto-Thin.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                com.itextpdf.text.Font vietnameseFont = new com.itextpdf.text.Font(unicodeFont, 12);
                com.itextpdf.text.Font boldFont = new com.itextpdf.text.Font(vietnameseFont.getBaseFont(), 18, com.itextpdf.text.Font.BOLD);
                PdfWriter.getInstance(doc, new FileOutputStream(path + pathHandle));
                doc.open();
                Paragraph info = new Paragraph("Thông tin hóa đơn", boldFont);
                info.setAlignment(Element.ALIGN_CENTER); // Căn giữa đoạn văn bản
                doc.add(info);
                String title = "Cửa hàng: " + txtTitle.getText() + " " + txtChaoMung.getText();
                doc.add(new Paragraph(title, vietnameseFont));
                String infoBill = txtSoHD.getText() + txtMaHoaDon.getText() + "              " + txtThoiGian.getText() + " " + txtTime.getText();
                doc.add(new Paragraph(infoBill, vietnameseFont));
                doc.add(new Paragraph(" "));
                PdfPTable pdfTable = new PdfPTable(tableGioHang.getColumnCount());
                // Add header row vào bảng PDF
                for (int i = 0; i < tableGioHang.getColumnCount(); i++) {
                    String header = tableGioHang.getColumnName(i); // Lấy tiêu đề cột từ jTable

                    // Chuyển sang in hoa và loại bỏ dấu tiếng Việt
//                header = StringUtils.upperCase(header); // Chuyển sang in hoa
//                header = StringUtils.stripAccents(header); // Loại bỏ dấu
                    // Tạo một ô mới và thiết lập font cho tiêu đề cột
                    PdfPCell cell = new PdfPCell(new Phrase(header, vietnameseFont));
                    pdfTable.addCell(cell);
//                pdfTable.addCell(header);
                }

                // Add content rows vào bảng PDF
                for (int rows = 0; rows < tableGioHang.getRowCount(); rows++) {
                    for (int cols = 0; cols < tableGioHang.getColumnCount(); cols++) {
                        Object cellValue = tableGioHang.getModel().getValueAt(rows, cols);
                        String cellText = (cellValue != null) ? cellValue.toString() : "";
                        PdfPCell cell = new PdfPCell(new Phrase(cellText, vietnameseFont));
                        pdfTable.addCell(cell);
                    }
                }
                doc.add(pdfTable);
                String tonghd = txtTongHD.getText() + " " + txtTongHoaDon.getText() + " VNĐ";
                doc.add(new Paragraph(tonghd, vietnameseFont));
                String tienkd = txtTKD.getText() + " " + txtKhachDua.getText() + " VNĐ";
                doc.add(new Paragraph(tienkd, vietnameseFont));
                String tienthua = txtTT.getText() + " " + txtTienThua.getText() + " VNĐ";
                doc.add(new Paragraph(tienthua, vietnameseFont));
                JOptionPane.showMessageDialog(this, "In hóa đơn thành công!");
                doc.close();
            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }
        } else if (x == JFileChooser.CANCEL_OPTION || x == JFileChooser.ERROR_OPTION) {
            JOptionPane.showMessageDialog(this, "Hủy in hóa đơn!");
        }

        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
    }//GEN-LAST:event_btnXuatHDPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXuatHDPDF;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableGioHang;
    private javax.swing.JLabel txtChaoMung;
    private javax.swing.JLabel txtGach;
    private javax.swing.JLabel txtKhachDua;
    private javax.swing.JLabel txtMaHoaDon;
    private javax.swing.JLabel txtSoHD;
    private javax.swing.JLabel txtTKD;
    private javax.swing.JLabel txtTT;
    private javax.swing.JLabel txtThoiGian;
    private javax.swing.JLabel txtTienThua;
    private javax.swing.JLabel txtTime;
    private javax.swing.JLabel txtTitle;
    private javax.swing.JLabel txtTongHD;
    private javax.swing.JLabel txtTongHoaDon;
    // End of variables declaration//GEN-END:variables
}
