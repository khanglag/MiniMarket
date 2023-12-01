/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.ThuKho;

import BUS.ChiTietPhieuXuatBus;
import BUS.KhachHangBus;
import BUS.PhieuXuatBus;
import DAO.NhanVienDAO;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.KhachHang_DTO;
import DTO.NhanVien_DTO;
import DTO.PhieuXuat_DTO;
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
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author khang
 */
public class ChiTietPhieuXuatView extends javax.swing.JFrame {

    ChiTietPhieuXuatBus chitiet = new ChiTietPhieuXuatBus();
    DefaultTableModel model;
    ArrayList<ChiTietPhieuXuat_DTO> list = new ArrayList<ChiTietPhieuXuat_DTO>();
    KhachHangBus kh = new KhachHangBus();
    PhieuXuatBus pxBUS = new PhieuXuatBus();
    double tt = 0;
    NhanVienDAO nvDAO = new NhanVienDAO();

    /**
     * Creates new form ChiTietPhieuNhapView
     */
    public ChiTietPhieuXuatView(String maPhieuXuat, String maKH) {
        initComponents();
        jtfMaPhieuXuat.setText(maPhieuXuat);
        jtfMaKH.setText(maKH);
        KhachHang_DTO khD = kh.timKhachHangMaKH(maKH);
        jtfTenKhachHang.setText(khD.getTenKH());
        LoadData(maPhieuXuat);
    }

    public void LoadData(String maPhieuXuat) {
        double tongTien = 0;
        model = (DefaultTableModel) jTableChiTietPhieuXuat.getModel();
        model.setRowCount(0);
        list = chitiet.timChiTietPhieuXuat(maPhieuXuat, null);
        int i = 0;
        for (ChiTietPhieuXuat_DTO px : list) {
            model.addRow(new Object[]{
                px.getMaPhieuXuat(), px.getMaHangXuat(), px.getSoLuongYC(), px.getSoLuongThucTe(), px.getDonVi(), px.getDonGia(), px.getThanhTien()
            });
            tongTien += px.getThanhTien();
            jTableChiTietPhieuXuat.setModel(model);
        }

        model.addRow(new Object[]{
            null, null, null, null, null, null, null
        });
        jTableChiTietPhieuXuat.setModel(model);
        model.addRow(new Object[]{
            null, null, null, null, null, "Tổng tiền: ", tongTien
        });
        String numberString = Handle.Convert.soqualon(tongTien);
// Xóa dấu phẩy từ chuỗi số
        numberString = numberString.replace(",", "");
        tt = Double.parseDouble(numberString);
        jTableChiTietPhieuXuat.setModel(model);
//        model.setValueAt("Tổng tiền: ", list.size(), 5);
//        model.setValueAt(tongTien, list.size(), 6);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfMaKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfMaPhieuXuat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableChiTietPhieuXuat = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jtfTenKhachHang = new javax.swing.JTextField();
        btnDong = new javax.swing.JButton();
        btnXuatPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(176, 206, 221));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Mã khách hàng");

        jtfMaKH.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Mã phiếu xuất");

        jtfMaPhieuXuat.setEditable(false);

        jTableChiTietPhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu xuất", "Mã hàng xuất", "Số lượng yêu cầu", "Số lượng thực xuất", "Đơn vị", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableChiTietPhieuXuat);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Tên khách hàng");

        jtfTenKhachHang.setEditable(false);

        btnDong.setBackground(new java.awt.Color(67, 138, 174));
        btnDong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDong.setForeground(new java.awt.Color(255, 255, 255));
        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        btnDong.setText("ĐÓNG");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        btnXuatPDF.setBackground(new java.awt.Color(67, 138, 174));
        btnXuatPDF.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXuatPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatPDF.setText("Xuất PDF");
        btnXuatPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfMaPhieuXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addComponent(jtfMaKH)))
                .addContainerGap(365, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXuatPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnDong)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfMaPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jtfTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDong))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnXuatPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatPDFActionPerformed
        // TODO add your handling code here:
        String path = "";

        String maPX = jTableChiTietPhieuXuat.getValueAt(1, 0).toString();
        String pathHandle = "xuatPhieuXuat" + maPX + ".pdf";
        String txtMaKh = jtfMaKH.getText();
        String txtTenKh = jtfTenKhachHang.getText();
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
                Paragraph info = new Paragraph("Thông tin phiếu xuất hàng", boldFont);
                info.setAlignment(Element.ALIGN_CENTER); // Căn giữa đoạn văn bản
                doc.add(info);

                ArrayList<PhieuXuat_DTO> pxDTO = pxBUS.timPhieuXuat(maPX, null, null, null);
                doc.add(new Paragraph("Mã phiếu xuất: " + maPX + " - Thời gian lập: " + pxDTO.get(0).getThoiGianXuat(), vietnameseFont));
                ArrayList<NhanVien_DTO> nhanVien = nvDAO.searchNhanVien(pxDTO.get(0).getMaNV(), null, null);
                String nameStaff = "Tên nhân viên phụ trách xuất hàng: " + nhanVien.get(0).getTenNV();
                doc.add(new Paragraph(nameStaff, vietnameseFont));
                doc.add(new Paragraph("Mã khách hàng: " + txtMaKh, vietnameseFont));
                doc.add(new Paragraph("Họ và tên khách hàng: " + txtTenKh, vietnameseFont));
                doc.add(new Paragraph(" "));
                PdfPTable pdfTable = new PdfPTable(jTableChiTietPhieuXuat.getColumnCount());
// Add header row vào bảng PDF
                for (int i = 0; i < jTableChiTietPhieuXuat.getColumnCount(); i++) {
                    String header = jTableChiTietPhieuXuat.getColumnName(i); // Lấy tiêu đề cột từ jTable
                    PdfPCell cell = new PdfPCell(new Phrase(header, vietnameseFont));
                    pdfTable.addCell(cell);
                }

                // Add content rows vào bảng PDF
                for (int rows = 0; rows < jTableChiTietPhieuXuat.getRowCount() - 1; rows++) {
                    for (int cols = 0; cols < jTableChiTietPhieuXuat.getColumnCount(); cols++) {
                        Object cellValue = jTableChiTietPhieuXuat.getModel().getValueAt(rows, cols);
                        String cellText = (cellValue != null) ? cellValue.toString() : "";
                        PdfPCell cell = new PdfPCell(new Phrase(cellText, vietnameseFont));
                        pdfTable.addCell(cell);
                    }
                }
                doc.add(pdfTable);
                Paragraph thanhTien = new Paragraph("Tổng tiền: " + String.valueOf(Handle.Convert.soqualon(tt)) + " VNĐ", boldFont);
                thanhTien.setAlignment(Element.ALIGN_RIGHT); // Căn giữa đoạn văn bản
                doc.add(thanhTien);
                doc.close();
                JOptionPane.showMessageDialog(this, "In phiếu xuất thành công");
            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }
        } else if (x == JFileChooser.CANCEL_OPTION || x == JFileChooser.ERROR_OPTION) {
            JOptionPane.showMessageDialog(this, "Hủy in phiếu xuất");
        }

        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
    }//GEN-LAST:event_btnXuatPDFActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnXuatPDF;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableChiTietPhieuXuat;
    private javax.swing.JTextField jtfMaKH;
    private javax.swing.JTextField jtfMaPhieuXuat;
    private javax.swing.JTextField jtfTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
