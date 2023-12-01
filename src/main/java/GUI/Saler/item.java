/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Saler;

import BUS.HangHoaBus;
import DAO.HangHoaDAO;
import DTO.HangHoa_DTO;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author acer
 */
public class item extends javax.swing.JPanel {

    private String MaSP;
    private static int soLuong;
    HangHoaDAO hhd = new HangHoaDAO();
    static HangHoaBus hhb = new HangHoaBus();
    public static ArrayList<HangHoa_DTO> gioHang = new ArrayList<>();

    public item() {
        initComponents();
    }

    public void setLbImgIcon(String path) {
        LbImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(path)));
    }

    public String MaSP(String masp) {
        return MaSP = masp;
    }

    public void setDisabledBtnAdd(boolean flag) {
        if (flag == true) {
            BtnAddProduct.setEnabled(false);
        } else {
            BtnAddProduct.setEnabled(true);
        }
    }

    public static void openPopup(JFrame parentFrame, String MaSP) {
        JDialog popup = new JDialog(parentFrame, "Popup", true);
        JLabel label = new JLabel("Số lượng:");
        JTextField txtSoLuong = new JTextField(10);
        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sl = Integer.parseInt(txtSoLuong.getText().trim());
                if ( sl<= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Số lượng phải lớn hơn 0");
                    return;
                }
               
                int soLuongTrenDB = hhb.ktSoLuong(MaSP);
                int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
                if (soLuong > soLuongTrenDB) {
                    JOptionPane.showMessageDialog(null,
                            "Số lượng đã vượt quá số lượng trên kệ \n" + "Trên kệ hiện tại còn (" + soLuongTrenDB + ") sản phẩm");
                    return;
                }
                item it = new item();
                it.soLuongSP(soLuong);
                popup.dispose();
            }
        });
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label);
        panel.add(txtSoLuong);
        panel.add(okButton);

        popup.add(panel);
        popup.setLocationRelativeTo(parentFrame);
        popup.setSize(300, 100);
        popup.setVisible(true);
    }

    public int soLuongSP(int sl) {
        return soLuong = sl;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbImg = new javax.swing.JLabel();
        BtnAddProduct = new javax.swing.JButton();

        LbImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gao.jpg"))); // NOI18N

        BtnAddProduct.setBackground(new java.awt.Color(67, 138, 174));
        BtnAddProduct.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BtnAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        BtnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gioHang.png"))); // NOI18N
        BtnAddProduct.setText("THÊM VÀO GIỎ HÀNG");
        BtnAddProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAddProductMouseClicked(evt);
            }
        });
        BtnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(LbImg))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAddProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAddProductMouseClicked

    }//GEN-LAST:event_BtnAddProductMouseClicked

    private void BtnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddProductActionPerformed
        // TODO add your handling code here:  
      
        ArrayList<HangHoa_DTO> danhSachSanPham = hhd.ReadHangHoa();
        //JFrame frame = new JFrame("Số lượng");
        //openPopup(frame, MaSP);
//        if(soLuong<=0){
//            return;
//        }
        boolean daTonTai = false;
        for (HangHoa_DTO sanPham : gioHang) {
            if (MaSP.equals(sanPham.getMaSP())) {
                daTonTai = true;
                break;
            }
        }
        int sl  = 1;
        if (!daTonTai) {
            // Nếu sản phẩm chưa tồn tại trong gioHang, thêm nó vào gioHang
            for (int i = 0; i < danhSachSanPham.size(); i++) {
                HangHoa_DTO sanPham = danhSachSanPham.get(i);
                if (MaSP.equals(sanPham.getMaSP())) {
                    sanPham.setSoLuong(sl);
                    double price = sl * hhb.giaBanSP(sanPham.getMaSP());
                    sanPham.setGiaBan(price);
                    gioHang.add(sanPham);
                    break; // Thêm sản phẩm và thoát khỏi vòng lặp
                }
            }
        }
        BanHang.showItemCartInTable();
    }//GEN-LAST:event_BtnAddProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddProduct;
    private javax.swing.JLabel LbImg;
    // End of variables declaration//GEN-END:variables
}
