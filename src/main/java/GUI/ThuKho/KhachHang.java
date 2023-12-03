/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.ThuKho;

import BUS.KhachHangBus;
import DTO.KhachHang_DTO;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khang
 */
public class KhachHang extends JDialog {

    private String maKH;
    KhachHangBus khachHangBus = new KhachHangBus();
    DefaultTableModel model;
    ArrayList<KhachHang_DTO> list = new ArrayList<KhachHang_DTO>();
    public void setMaKH(String maKH){
        this.maKH = maKH;
    }
    public String getMaKH(){
        return maKH;
    }
    /**
     * Creates new form KhachHang
     * @param owner
     */
    public KhachHang(Frame owner) {
        super(owner, "Khách hàng", true);
        setSize(300, 200);
        initComponents();
        LoadData();
    }
    public void LoadData(){
        model = (DefaultTableModel) jTableKhachHang.getModel();
        model.setRowCount(0);
        list = khachHangBus.dsKhachHang();
        int soLuongSP = list.size();
        for (int i = 0; i < soLuongSP; i++) {
            KhachHang_DTO kh = list.get(i);
            
            model.addRow(new Object[]{kh.getMaKH(),kh.getTenKH(),kh.getNgaySinh(),kh.getSdt(),kh.getDiaChi()});
            jTableKhachHang.setModel(model);
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

        jtfTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnChon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKhachHang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(176, 206, 221));

        jtfTim.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm"));

        btnTim.setBackground(new java.awt.Color(67, 138, 174));
        btnTim.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        btnTim.setText("TÌM KIẾM");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(67, 138, 174));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync.png"))); // NOI18N
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(67, 138, 174));
        btnHuy.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        btnHuy.setText("HỦY");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnChon.setBackground(new java.awt.Color(67, 138, 174));
        btnChon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnChon.setForeground(new java.awt.Color(255, 255, 255));
        btnChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SELECT.png"))); // NOI18N
        btnChon.setText("CHỌN");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 82, 151));
        jLabel1.setText("CHỌN KHÁCH HÀNG");

        jTableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Ngày sinh", "Số điện thoại", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableKhachHang.setSelectionBackground(new java.awt.Color(176, 206, 221));
        jScrollPane1.setViewportView(jTableKhachHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnChon)
                        .addGap(40, 40, 40)
                        .addComponent(btnHuy)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTim)
                        .addGap(35, 35, 35)
                        .addComponent(btnLamMoi)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTim)
                    .addComponent(btnLamMoi)
                    .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChon)
                    .addComponent(btnHuy))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        KhachHang_DTO kh = new KhachHang_DTO();
        kh = khachHangBus.timKhachHang(null, jtfTim.getText());
        model = (DefaultTableModel) jTableKhachHang.getModel();
        model.setRowCount(0);
        model.addRow(new Object[]{kh.getMaKH(),kh.getTenKH(),kh.getNgaySinh(),kh.getSdt(),kh.getDiaChi()});
        jTableKhachHang.setModel(model);
        

        
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        refreshData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    public void refreshData(){
        khachHangBus = new KhachHangBus();
        LoadData();
    }
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:

        int i = jTableKhachHang.getSelectedRow();
        if (i >= 0) {
            setMaKH(jTableKhachHang.getModel().getValueAt(i, 0).toString());
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn khách hàng!");
        }

        
    }//GEN-LAST:event_btnChonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableKhachHang;
    private javax.swing.JTextField jtfTim;
    // End of variables declaration//GEN-END:variables
}
