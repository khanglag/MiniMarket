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
import javax.swing.JOptionPane;
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
        super(owner, "Hàng hoá", true);
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 82, 151));
        jLabel1.setText("CHỌN SẢN PHẨM");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnChon)
                .addGap(31, 31, 31)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim)
                    .addComponent(btnLamMoi))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChon)
                    .addComponent(btnHuy))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 89, Short.MAX_VALUE))
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
            Integer sol = Integer.parseInt(jTableHangHoa.getModel().getValueAt(i, 3).toString());
            String xuatxu =jTableHangHoa.getModel().getValueAt(i, 5).toString();
            String donvi = jTableHangHoa.getModel().getValueAt(i, 6).toString();
         
            double giaban = Double.parseDouble(jTableHangHoa.getModel().getValueAt(i, 4).toString());
            chonHangHoa = new HangHoa_DTO(masp,tensp, sol, mancc,donvi,giaban,xuatxu);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm");
        }
        
        
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
