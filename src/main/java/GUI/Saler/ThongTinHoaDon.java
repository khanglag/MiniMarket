/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Saler;

import BUS.ChiTietHoaDonBus;
import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import DTO.HangHoa_DTO;
import DTO.HoaDon_DTO;
import static GUI.Saler.BanHang.hhb;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
//import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

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

        txtTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitle.setText("SIEU THI MINI");

        txtSoHD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSoHD.setText("SO HOA DON: ");

        txtMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaHoaDon.setText("jLabel3");

        txtTongHD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTongHD.setText("TONG HOA DON: ");

        txtTongHoaDon.setText("jLabel5");

        txtTKD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTKD.setText("TIEN KHACH DUA: ");

        txtKhachDua.setText("jLabel5");

        txtThoiGian.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtThoiGian.setText("THOI GIAN: ");

        txtTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTime.setText("jLabel3");

        txtChaoMung.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtChaoMung.setForeground(new java.awt.Color(255, 51, 51));
        txtChaoMung.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtChaoMung.setText("RAT VUI KHI DUOC PHUC VU QUY KHACH");

        txtGach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGach.setText("_______________________________________________________________________________________________");

        txtTT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTT.setText("TIEN THUA:");

        txtTienThua.setText("jLabel5");

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
                "TEN SP", "SO LUONG", "GIA BAN", "THANH TIEN"
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtSoHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaHoaDon)
                        .addGap(111, 111, 111)
                        .addComponent(txtThoiGian)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTime))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTKD)
                            .addComponent(txtTT)
                            .addComponent(txtTongHD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtKhachDua)
                            .addComponent(txtTongHoaDon)
                            .addComponent(txtTienThua))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXuatHDPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
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
                .addComponent(btnXuatHDPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatHDPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHDPDFActionPerformed
        // TODO add your handling code here:
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();
        try {

            PdfWriter.getInstance(doc, new FileOutputStream(path + "xuatHD.pdf"));
            doc.open();
            BaseFont unicodeFont = BaseFont.createFont("C:/Users/acer/OneDrive/Documents/NetBeansProjects/MiniMarket/Open_Sans/OpenSans-VariableFont_wdth,wght.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            com.itextpdf.text.Font font = FontFactory.getFont("C:/Users/acer/OneDrive/Documents/NetBeansProjects/MiniMarket/Open_Sans/OpenSans-VariableFont_wdth,wght.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 12);
            doc.add(new Paragraph("THONG TIN HOA DON"));
            doc.add(new Paragraph("CUA HANG: " + txtTitle.getText() + " " + txtChaoMung.getText()));
            doc.add(new Paragraph(txtSoHD.getText() + txtMaHoaDon.getText() + "              " + txtThoiGian.getText() + txtTime.getText()));
            doc.add(new Paragraph(" "));
            PdfPTable pdfTable = new PdfPTable(tableGioHang.getColumnCount());
            // Add header row vào bảng PDF
            for (int i = 0; i < tableGioHang.getColumnCount(); i++) {
                pdfTable.addCell(tableGioHang.getColumnName(i));
            }

            // Add content rows vào bảng PDF
            for (int rows = 0; rows < tableGioHang.getRowCount(); rows++) {
                for (int cols = 0; cols < tableGioHang.getColumnCount(); cols++) {
                    pdfTable.addCell(tableGioHang.getModel().getValueAt(rows, cols).toString());
                }
            }

            doc.add(pdfTable);
            doc.add(new Paragraph(txtTongHD.getText()+" " + txtTongHoaDon.getText()));
            doc.add(new Paragraph(txtTKD.getText() + txtKhachDua.getText()));
            doc.add(new Paragraph(txtTT.getText()+"       " + txtTienThua.getText()));
            JOptionPane.showMessageDialog(this, "Xuất hóa đơn PDF thành công!");
            doc.close();
          

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
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
