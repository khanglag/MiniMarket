/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.QuanLy;

import BUS.PhieuNhapBus;
import DTO.PhieuNhap_DTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractCellEditor;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;

public class QuanLyPhieuNhap extends javax.swing.JPanel {

    PhieuNhapBus pnBus = new PhieuNhapBus();

    public QuanLyPhieuNhap() {
        initComponents();
        showReceiptInTable();
    }

    public void showReceiptInTable() {
        try {
            TableActionEvent event = new TableActionEvent() {
                @Override
                public void onStatus(int row, String MaPhieuNhap) {

                    JFrame frame = new JFrame("Trạng thái kiểm duyệt");
                    TrangThaiPhieuNhap ttpn = new TrangThaiPhieuNhap(MaPhieuNhap);
                    frame.add(ttpn);
                    frame.setSize(400, 300);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    
                    frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            showReceiptInTable();
                            
                        }
                    });
                
                }

                @Override
                public void onRead(int row, String MaPhieuNhap) {
                    JFrame frame = new JFrame("Thông tin phiếu yêu cầu nhập hàng");
                    ReadPhieuYeuCauNhap read = new ReadPhieuYeuCauNhap(MaPhieuNhap);            
                    frame.add(read); 
                    frame.setSize(800, 600); 
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);           
                     frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            showReceiptInTable();                     
                        }
                    });
                }
            };

            ArrayList<PhieuNhap_DTO> danhSachPhieuNhap = pnBus.rPhieuNhap_DTOs();
            int soLuongPhieuNhap = danhSachPhieuNhap.size();
            DefaultTableModel model = (DefaultTableModel) tablePhieuNhap.getModel();
            model.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong bảng
            for (int i = 0; i < soLuongPhieuNhap; i++) {
                PhieuNhap_DTO phieuNhap = danhSachPhieuNhap.get(i);
                String maPN = phieuNhap.getMaPhieuNhap();
                String maNV = phieuNhap.getMaNV();
                LocalDate tgNhap = phieuNhap.getThoiGianLap();
                double VAT = phieuNhap.getVAT();
                int soMH = phieuNhap.getSoMatHang();
                double tongTien = phieuNhap.getTongTien();
                String tt = phieuNhap.getTrangThai();
                tablePhieuNhap.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
                tablePhieuNhap.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
                model.addRow(new Object[]{i + 1, maPN, maNV, tgNhap, VAT, soMH, tongTien});
                tablePhieuNhap.getColumnModel().getColumn(7).setPreferredWidth(130);
            }
             model.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi đọc dữ liệu Phiếu Nhập !!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

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
        tablePhieuNhap = new javax.swing.JTable();

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ PHIẾU NHẬP");

        tablePhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu nhập", "Mã nhân viên", "Thời gian lập ", "VAT", "Số mặt hàng", "Tổng tiền", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablePhieuNhap.setRowHeight(50);
        tablePhieuNhap.setRowMargin(10);
        tablePhieuNhap.setSelectionBackground(new java.awt.Color(176, 206, 221));
        jScrollPane1.setViewportView(tablePhieuNhap);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePhieuNhap;
    // End of variables declaration//GEN-END:variables
}

class ButtonRenderer extends DefaultTableCellRenderer {

    private JButton button;
    private String buttonName;

    public ButtonRenderer(Color color, String name) {
        button = new JButton(name);
        button.setOpaque(true);
        button.setBackground(color);
        buttonName = name;

        // Thêm ActionListener cho nút
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clickedxxxx: " + buttonName);
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return button;
    }
}

class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

    private JButton button;
    private String buttonName;

    public ButtonEditor(Color color, String name) {
        button = new JButton(name);
        button.setOpaque(true);
        button.setBackground(color);
        buttonName = name;

        // Thêm ActionListener cho nút
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clickedaaaa: " + buttonName);
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return buttonName;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return button;
    }
}
