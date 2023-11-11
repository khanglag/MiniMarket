/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.ThuKho;

import BUS.HangHoaBus;
import DTO.HangHoa_DTO;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khang
 */
public class HangHoa extends JDialog {
    private HangHoa_DTO chonHangHoa;
    public HangHoa_DTO getSelectedHangHoa(){
        return chonHangHoa;
    }

    /**
     * Creates new form HangHoa
     */
    HangHoaBus hangHoaBus = new HangHoaBus();
    DefaultTableModel model;
    ArrayList<HangHoa_DTO> list = new ArrayList<HangHoa_DTO>();
    int number;
    public HangHoa(Frame owner, int number) {
        super(owner, "Select Product", true);
        setSize(300, 200);
        this.number=number;
        initComponents();
        LoadData(number);
        
    }
     public void LoadData(int number){
        model = (DefaultTableModel) jTableHangHoa.getModel();
        model.setRowCount(0);
        list = hangHoaBus.itemData();
//        if(number ==1)
//            list = hangHoaBus.sapXep(list);
        int soLuongSP = list.size();
        double giaBan;
        for (int i = 0; i < soLuongSP; i++) {
            HangHoa_DTO sanPham = list.get(i);
            String maSP = sanPham.getMaSP();
            String tenSP = sanPham.getTenSP();
            String mancc = sanPham.getMaNCC();
            int soLuong = sanPham.getSoLuong();
            if(number ==0){
                giaBan = sanPham.getGiaBan();
            }else
                giaBan = sanPham.getGiaNhap();
            
            String xuatXu = sanPham.getXuatXu();
            String donVi = sanPham.getDonVi();
            model.addRow(new Object[]{maSP, tenSP,mancc, soLuong, giaBan, xuatXu, donVi});
            jTableHangHoa.setModel(model);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnChon = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHangHoa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Chọn sản phẩm");

        jtfTim.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm"));

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        btnHuy.setText("Huỷ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jTableHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Mã nhà cung cấp", "Số lượng", "Giá", "Xuất xứ", "Đơn vị"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHangHoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHangHoa);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHuy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChon))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTim)
                                .addGap(18, 18, 18)
                                .addComponent(btnLamMoi)))
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim)
                    .addComponent(btnLamMoi))
                .addGap(261, 261, 261)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChon)
                    .addComponent(btnHuy))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        ArrayList<HangHoa_DTO> listS = new ArrayList<HangHoa_DTO>();
        listS = hangHoaBus.timHangHoa(jtfTim.getText(),null,null, null);
        model = (DefaultTableModel) jTableHangHoa.getModel();
        model.setRowCount(0);
        int i = 0;
        double giaBan;
        while (i <= listS.size() - 1) {
            HangHoa_DTO sanPham = listS.get(i);
            String maSP = sanPham.getMaSP();
            String tenSP = sanPham.getTenSP();
            String mancc = sanPham.getMaNCC();
            int soLuong = sanPham.getSoLuong();
            if(number ==0){
                giaBan = sanPham.getGiaBan();
            }else
                giaBan = sanPham.getGiaNhap();
            
            String xuatXu = sanPham.getXuatXu();
            String donVi = sanPham.getDonVi();
            model.addRow(new Object[]{maSP, tenSP,mancc, soLuong, giaBan, xuatXu, donVi});
            jTableHangHoa.setModel(model);
            ++i;
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        refreshData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    public void refreshData(){
        hangHoaBus = new HangHoaBus();
        LoadData(number);
    }
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:

        int i = jTableHangHoa.getSelectedRow();
        if (i >= 0) {
            String masp = jTableHangHoa.getModel().getValueAt(i, 0).toString();
            String tensp = jTableHangHoa.getModel().getValueAt(i, 1).toString();
            String mancc =jTableHangHoa.getModel().getValueAt(i, 2).toString();
            String xuatxu =jTableHangHoa.getModel().getValueAt(i, 2).toString();
            String donvi = jTableHangHoa.getModel().getValueAt(i, 6).toString();
         
            double giaban = Double.parseDouble(jTableHangHoa.getModel().getValueAt(i, 4).toString());
            chonHangHoa = new HangHoa_DTO(masp,tensp,mancc,donvi,giaban,xuatxu);
        }
        
        this.dispose();
    }//GEN-LAST:event_btnChonActionPerformed

    private void jTableHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHangHoaMouseClicked

    }//GEN-LAST:event_jTableHangHoaMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableHangHoa;
    private javax.swing.JTextField jtfTim;
    // End of variables declaration//GEN-END:variables
}
