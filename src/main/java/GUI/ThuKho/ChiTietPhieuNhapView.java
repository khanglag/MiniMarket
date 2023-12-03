/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.ThuKho;

import BUS.ChiTietPhieuNhapBus;
import BUS.NhanvienBus;
import BUS.PhieuNhapBus;
import BUS.PhieuYeuCauNhapBus;
import Controller.TaiKhoanController;
import DAO.NhanVienDAO;
import DTO.ChiTietPhieuNhap_DTO;
import DTO.NhanVien_DTO;
import DTO.PhieuNhap_DTO;
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
public final class ChiTietPhieuNhapView extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietPhieuNhapView
     */
    double tt = 0;
    PhieuYeuCauNhapBus phieuYeuCauNhapBus = new PhieuYeuCauNhapBus();
    ChiTietPhieuNhapBus chiTietPhieuNhapBus = new ChiTietPhieuNhapBus();
    PhieuNhapBus phieuNhapBus = new PhieuNhapBus();
    NhanvienBus nv = new NhanvienBus();
    NhanVienDAO nvDAO = new NhanVienDAO();
    DefaultTableModel model;
    ArrayList<ChiTietPhieuNhap_DTO> list = new ArrayList<ChiTietPhieuNhap_DTO>();
    double thanhtien = 0;
    int somathang = 0;
    String trangthai;

    public ChiTietPhieuNhapView(String ma, String trangthai) {
        initComponents();

        this.trangthai = trangthai;
        System.out.print(trangthai);

        setButton(trangthai);
        LoadData(ma);
    }

    public void setButton(String trangthai) {
        if (trangthai.toUpperCase().equals("DA DUYET") || trangthai.toUpperCase().equals("ĐÃ DUYỆT")) {
            btnNhapHang.setVisible(true);
        } else {
            btnNhapHang.setVisible(false);
        }

    }

    public void LoadData(String ma) {
        thanhtien = 0;
        model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        list = phieuYeuCauNhapBus.timCTPN(ma, null, null, null);
        int i = 0;
        while (i <= list.size() - 1) {
            ChiTietPhieuNhap_DTO px = list.get(i);
            model.addRow(new Object[]{
                px.getMaPhieuNhap(), px.getMaHangNhap(), px.getTenHangNhap(), px.getMaNCC(), px.getVAT(), px.getXuatXu(), px.getSoLuong(), px.getDonVi(), px.getGiaNhap(), px.getTongTienNhap()
            });
            jTable.setModel(model);
            ++i;
            somathang++;
            thanhtien += px.getTongTienNhap();
        }
        model.addRow(new Object[]{
            null, null, null, null, null, null, null
        });
        jTable.setModel(model);
        model.addRow(new Object[]{
            null, null, null, null, null, null, null, null, "Tổng tiền: ", Handle.Convert.soqualon(thanhtien)
        });
        String numberString = Handle.Convert.soqualon(thanhtien);
// Xóa dấu phẩy từ chuỗi số
        numberString = numberString.replace(",", "");
        tt = Double.parseDouble(numberString);
        jTable.setModel(model);
        System.out.println(somathang);
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
        jPanel36 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jtfMaPhieuNhap = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jtfMaHangNhap = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jtfTenHangNhap = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfMaNCC = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jtfVAT = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfXuatXu = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jtfSoLuong = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jtfDonVi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfGiaNhap = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jtfThanhTien = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnDong = new javax.swing.JButton();
        btnNhapHang = new javax.swing.JButton();
        btnXuatPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel36.setLayout(new java.awt.GridLayout(5, 2, 0, 5));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel36.setText("Mã phiếu nhập");
        jPanel36.add(jLabel36);

        jtfMaPhieuNhap.setEditable(false);
        jPanel36.add(jtfMaPhieuNhap);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel37.setText("Mã hàng nhập");
        jPanel36.add(jLabel37);

        jtfMaHangNhap.setEditable(false);
        jPanel36.add(jtfMaHangNhap);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel38.setText("Tên hàng nhập");
        jPanel36.add(jLabel38);

        jtfTenHangNhap.setEditable(false);
        jPanel36.add(jtfTenHangNhap);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Mã nhà cung cấp");
        jPanel36.add(jLabel1);

        jtfMaNCC.setEditable(false);
        jPanel36.add(jtfMaNCC);

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel39.setText("VAT");
        jPanel36.add(jLabel39);

        jtfVAT.setEditable(false);
        jPanel36.add(jtfVAT);

        jPanel1.add(jPanel36);

        jPanel37.setLayout(new java.awt.GridLayout(5, 2, 0, 5));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Xuất sứ");
        jPanel37.add(jLabel2);

        jtfXuatXu.setEditable(false);
        jPanel37.add(jtfXuatXu);

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel41.setText("Số lượng");
        jPanel37.add(jLabel41);

        jtfSoLuong.setEditable(false);
        jPanel37.add(jtfSoLuong);

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel40.setText("Đơn vị");
        jPanel37.add(jLabel40);

        jtfDonVi.setEditable(false);
        jtfDonVi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfDonViMouseClicked(evt);
            }
        });
        jPanel37.add(jtfDonVi);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Giá nhập");
        jPanel37.add(jLabel3);

        jtfGiaNhap.setEditable(false);
        jPanel37.add(jtfGiaNhap);

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel42.setText("Thành tiền");
        jPanel37.add(jLabel42);

        jtfThanhTien.setEditable(false);
        jPanel37.add(jtfThanhTien);

        jPanel1.add(jPanel37);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu nhập", "Mã hàng nhập", "Tên hàng nhập", "Mã nhà cung cấp", "VAT", "Xuất sứ", "Số lượng", "Đơn vị", "Giá nhập", "Tổng tiền nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable);

        btnDong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        btnNhapHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/import.png"))); // NOI18N
        btnNhapHang.setText("NHẬP HÀNG");
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        btnXuatPDF.setText("Xuất PDF");
        btnXuatPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXuatPDF)
                        .addGap(63, 63, 63)
                        .addComponent(btnNhapHang)
                        .addGap(58, 58, 58)
                        .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 190, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhapHang)
                    .addComponent(btnDong)
                    .addComponent(btnXuatPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(323, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDonViMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfDonViMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDonViMouseClicked

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int i = jTable.getSelectedRow();
        if (i >= 0) {
            jtfMaPhieuNhap.setText(jTable.getModel().getValueAt(i, 0).toString());
            jtfMaHangNhap.setText(jTable.getModel().getValueAt(i, 1).toString());
            jtfTenHangNhap.setText(jTable.getModel().getValueAt(i, 2).toString());
            jtfMaNCC.setText(jTable.getModel().getValueAt(i, 3).toString());
            jtfVAT.setText(jTable.getModel().getValueAt(i, 4).toString());
            jtfXuatXu.setText(jTable.getModel().getValueAt(i, 5).toString());
            jtfSoLuong.setText(jTable.getModel().getValueAt(i, 6).toString());
            jtfDonVi.setText(jTable.getModel().getValueAt(i, 7).toString());
            jtfGiaNhap.setText(jTable.getModel().getValueAt(i, 8).toString());
            jtfThanhTien.setText(jTable.getModel().getValueAt(i, 9).toString());

        }
    }//GEN-LAST:event_jTableMouseClicked

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        // TODO add your handling code here:
        boolean flag = false;
        System.out.println(list.size());
        for (ChiTietPhieuNhap_DTO ctpn : list) {
            if (chiTietPhieuNhapBus.themCTPN(ctpn)) {
                flag = true;
            } else {
                flag = false;
            }
        }

        if (flag) {
            JOptionPane.showMessageDialog(this, "Nhập hàng thành công");
            phieuNhapBus.suaPhieuNhap(jTable.getModel().getValueAt(0, 0).toString(), 0.08, somathang, thanhtien, "DA NHAP");
            this.dispose();
        }
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void btnXuatPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatPDFActionPerformed
        // TODO add your handling code here:
        String path = "";

        String maPN = jTable.getValueAt(1, 0).toString();
        String pathHandle = "xuatPhieuNhap" + maPN + ".pdf";

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
                Paragraph info = new Paragraph("Thông tin phiếu nhập hàng", boldFont);
                info.setAlignment(Element.ALIGN_CENTER); // Căn giữa đoạn văn bản
                doc.add(info);
                String maphieunhap = "Mã phiếu nhập: " + maPN;
                ArrayList<PhieuNhap_DTO> phieuNhap = phieuNhapBus.timPhieuNhap(maPN, null, null, null);
                ArrayList<NhanVien_DTO> nhanVien = nvDAO.searchNhanVien(phieuNhap.get(0).getMaNV(), null, null);
                String nameStaff = "Tên nhân viên phụ trách nhập hàng: " + nhanVien.get(0).getTenNV();
                doc.add(new Paragraph(nameStaff, vietnameseFont));
                doc.add(new Paragraph(maphieunhap, vietnameseFont));
                String time = "Thời gian lập: " + String.valueOf(phieuNhap.get(0).getThoiGianLap());
                doc.add(new Paragraph(time, vietnameseFont));
                doc.add(new Paragraph(" "));
                PdfPTable pdfTable = new PdfPTable(jTable.getColumnCount());
// Add header row vào bảng PDF
                for (int i = 0; i < jTable.getColumnCount(); i++) {
                    String header = jTable.getColumnName(i); // Lấy tiêu đề cột từ jTable

                    // Chuyển sang in hoa và loại bỏ dấu tiếng Việt
//                header = StringUtils.upperCase(header); // Chuyển sang in hoa
//                header = StringUtils.stripAccents(header); // Loại bỏ dấu
                    PdfPCell cell = new PdfPCell(new Phrase(header, vietnameseFont));
                    pdfTable.addCell(cell);
                    // pdfTable.addCell(header); // Thêm tiêu đề đã chỉnh sửa vào bảng PDF
                }

                // Add content rows vào bảng PDF
                for (int rows = 0; rows < jTable.getRowCount() - 1; rows++) {
                    for (int cols = 0; cols < jTable.getColumnCount(); cols++) {
                        Object cellValue = jTable.getModel().getValueAt(rows, cols);
                        String cellText = (cellValue != null) ? cellValue.toString() : "";
                        PdfPCell cell = new PdfPCell(new Phrase(cellText, vietnameseFont));
                        pdfTable.addCell(cell);

                    }
                }

                doc.add(pdfTable);
                //String thanhTien = "Tổng tiền: " + String.valueOf(Handle.Convert.soqualon(tt));
                Paragraph thanhTien = new Paragraph("Tổng tiền: " + String.valueOf(Handle.Convert.soqualon(tt)) + " VNĐ", boldFont);
                thanhTien.setAlignment(Element.ALIGN_RIGHT); // Căn giữa đoạn văn bản
                doc.add(thanhTien);
                JOptionPane.showMessageDialog(this, "In phiếu nhập thành công!");
                doc.close();
            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }
        } else if (x == JFileChooser.CANCEL_OPTION || x == JFileChooser.ERROR_OPTION) {
            JOptionPane.showMessageDialog(this, "Hủy in phiếu nhập!");
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
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnXuatPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jtfDonVi;
    private javax.swing.JTextField jtfGiaNhap;
    private javax.swing.JTextField jtfMaHangNhap;
    private javax.swing.JTextField jtfMaNCC;
    private javax.swing.JTextField jtfMaPhieuNhap;
    private javax.swing.JTextField jtfSoLuong;
    private javax.swing.JTextField jtfTenHangNhap;
    private javax.swing.JTextField jtfThanhTien;
    private javax.swing.JTextField jtfVAT;
    private javax.swing.JTextField jtfXuatXu;
    // End of variables declaration//GEN-END:variables
}
