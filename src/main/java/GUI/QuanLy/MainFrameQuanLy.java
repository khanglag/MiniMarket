/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.QuanLy;

import BUS.NhanvienBus;
import Controller.TaiKhoanController;
import GUI.Login.LoginForm;
import GUI.Saler.ThongTinNhanVien;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class MainFrameQuanLy extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    Color DefaultColor, ClickedColor;
    NhanvienBus nv = new NhanvienBus();

    public MainFrameQuanLy() {
        initComponents();
//         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setExtendedState(JFrame.MAXIMIZED_BOTH); // Hiển thị full màn hình
//        setResizable(false); // Không cho phép chỉnh sửa kích thước

        dashboardControl();
        txtUserName.setText(nv.tenNV(TaiKhoanController.getTendnString()));
        this.setLocationRelativeTo(null);
    }

    public void dashboardControl() {
        mainScreen.setLayout(new BorderLayout());
        mainScreen.add(new QuanLyNhanVien());
        DefaultColor = new Color(67,138,174);
        ClickedColor = new Color(38,84,108);
        panelnv.setBackground(ClickedColor);
        panelkh.setBackground(DefaultColor);
        panelsp.setBackground(DefaultColor);
        paneltk.setBackground(DefaultColor);
        panelct.setBackground(DefaultColor);
        paneldx.setBackground(DefaultColor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        panelnv = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelkh = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        paneltk = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelsp = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelct = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        paneldx = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        mainScreen = new javax.swing.JPanel();
        title = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtUserName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ");
        setBackground(new java.awt.Color(255, 192, 203));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        sideBar.setBackground(new java.awt.Color(160, 191, 213));

        panelnv.setBackground(new java.awt.Color(67, 138, 174));
        panelnv.setForeground(new java.awt.Color(255, 255, 255));
        panelnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelnvMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staff_.png"))); // NOI18N
        jLabel1.setText("NHÂN VIÊN");

        javax.swing.GroupLayout panelnvLayout = new javax.swing.GroupLayout(panelnv);
        panelnv.setLayout(panelnvLayout);
        panelnvLayout.setHorizontalGroup(
            panelnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelnvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelnvLayout.setVerticalGroup(
            panelnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelnvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        panelkh.setBackground(new java.awt.Color(67, 138, 174));
        panelkh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelkhMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer.png"))); // NOI18N
        jLabel3.setText("KHÁCH HÀNG");

        javax.swing.GroupLayout panelkhLayout = new javax.swing.GroupLayout(panelkh);
        panelkh.setLayout(panelkhLayout);
        panelkhLayout.setHorizontalGroup(
            panelkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelkhLayout.setVerticalGroup(
            panelkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        paneltk.setBackground(new java.awt.Color(67, 138, 174));
        paneltk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneltkMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analyst.png"))); // NOI18N
        jLabel4.setText("THỐNG KÊ");

        javax.swing.GroupLayout paneltkLayout = new javax.swing.GroupLayout(paneltk);
        paneltk.setLayout(paneltkLayout);
        paneltkLayout.setHorizontalGroup(
            paneltkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneltkLayout.setVerticalGroup(
            paneltkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelsp.setBackground(new java.awt.Color(67, 138, 174));
        panelsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelspMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product.png"))); // NOI18N
        jLabel5.setText("SẢN PHẨM");

        javax.swing.GroupLayout panelspLayout = new javax.swing.GroupLayout(panelsp);
        panelsp.setLayout(panelspLayout);
        panelspLayout.setHorizontalGroup(
            panelspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelspLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelspLayout.setVerticalGroup(
            panelspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelspLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelct.setBackground(new java.awt.Color(67, 138, 174));
        panelct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelctMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bill.png"))); // NOI18N
        jLabel6.setText("QUẢN LÝ PHIẾU NHẬP");

        javax.swing.GroupLayout panelctLayout = new javax.swing.GroupLayout(panelct);
        panelct.setLayout(panelctLayout);
        panelctLayout.setHorizontalGroup(
            panelctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelctLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        panelctLayout.setVerticalGroup(
            panelctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelctLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        paneldx.setBackground(new java.awt.Color(67, 138, 174));
        paneldx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneldxMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logout.png"))); // NOI18N
        jLabel7.setText("ĐĂNG XUẤT");

        javax.swing.GroupLayout paneldxLayout = new javax.swing.GroupLayout(paneldx);
        paneldx.setLayout(paneldxLayout);
        paneldxLayout.setHorizontalGroup(
            paneldxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        paneldxLayout.setVerticalGroup(
            paneldxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelkh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneltk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneldx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneltk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneldx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainScreen.setBackground(new java.awt.Color(160, 191, 213));

        javax.swing.GroupLayout mainScreenLayout = new javax.swing.GroupLayout(mainScreen);
        mainScreen.setLayout(mainScreenLayout);
        mainScreenLayout.setHorizontalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainScreenLayout.setVerticalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        title.setBackground(new java.awt.Color(160, 191, 213));

        jLabel2.setBackground(new java.awt.Color(160, 191, 213));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 82, 151));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MÀN HÌNH QUẢN LÝ");

        jPanel1.setBackground(new java.awt.Color(160, 191, 213));

        txtUserName.setBackground(new java.awt.Color(160, 191, 213));
        txtUserName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUserName.setText("jLabel8");
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserNameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleLayout.createSequentialGroup()
                .addGroup(titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelnvMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelnvMousePressed
        // TODO add your handling code here:
        panelnv.setBackground(ClickedColor);
        panelkh.setBackground(DefaultColor);
        panelsp.setBackground(DefaultColor);
        paneltk.setBackground(DefaultColor);
        panelct.setBackground(DefaultColor);
        paneldx.setBackground(DefaultColor);
        QuanLyNhanVien qlnv = new QuanLyNhanVien();
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();
        mainScreen.add(qlnv).setVisible(true);
    }//GEN-LAST:event_panelnvMousePressed

    private void panelkhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelkhMousePressed
        // TODO add your handling code here:
        panelnv.setBackground(DefaultColor);
        panelkh.setBackground(ClickedColor);
        panelsp.setBackground(DefaultColor);
        paneltk.setBackground(DefaultColor);
        panelct.setBackground(DefaultColor);
        paneldx.setBackground(DefaultColor);
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();
        mainScreen.add(qlkh).setVisible(true);
    }//GEN-LAST:event_panelkhMousePressed

    private void panelspMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelspMousePressed
        // TODO add your handling code here:
        panelnv.setBackground(DefaultColor);
        panelkh.setBackground(DefaultColor);
        panelsp.setBackground(ClickedColor);
        paneltk.setBackground(DefaultColor);
        panelct.setBackground(DefaultColor);
        paneldx.setBackground(DefaultColor);
        QuanLySanPham qlsp = new QuanLySanPham();
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();
        mainScreen.add(qlsp).setVisible(true);
    }//GEN-LAST:event_panelspMousePressed

    private void paneltkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltkMousePressed
        // TODO add your handling code here:
        panelnv.setBackground(DefaultColor);
        panelkh.setBackground(DefaultColor);
        panelsp.setBackground(DefaultColor);
        paneltk.setBackground(ClickedColor);
        panelct.setBackground(DefaultColor);
        paneldx.setBackground(DefaultColor);
        ThongKe tk = new ThongKe();
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();
        mainScreen.add(tk).setVisible(true);
    }//GEN-LAST:event_paneltkMousePressed

    private void panelctMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelctMousePressed
        // TODO add your handling code here:
        panelnv.setBackground(DefaultColor);
        panelkh.setBackground(DefaultColor);
        panelsp.setBackground(DefaultColor);
        paneltk.setBackground(DefaultColor);
        panelct.setBackground(ClickedColor);
        paneldx.setBackground(DefaultColor);
        QuanLyPhieuNhap qlct = new QuanLyPhieuNhap();
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();
        mainScreen.add(qlct).setVisible(true);
    }//GEN-LAST:event_panelctMousePressed

    private void paneldxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneldxMousePressed
        // TODO add your handling code here:
        panelnv.setBackground(DefaultColor);
        panelkh.setBackground(DefaultColor);
        panelsp.setBackground(DefaultColor);
        paneltk.setBackground(DefaultColor);
        panelct.setBackground(DefaultColor);
        paneldx.setBackground(ClickedColor);
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            LoginForm lg = new LoginForm();
            this.dispose();
            lg.setVisible(true);
            lg.setLocationRelativeTo(null);

        } else {
            return;
        }
    }//GEN-LAST:event_paneldxMousePressed

    private void txtUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseClicked
        // TODO add your handling code here:
            ThongTinNhanVien ttnv = new ThongTinNhanVien();
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();
        mainScreen.add(ttnv).setVisible(true);
    }//GEN-LAST:event_txtUserNameMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameQuanLy().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainScreen;
    private javax.swing.JPanel panelct;
    private javax.swing.JPanel paneldx;
    private javax.swing.JPanel panelkh;
    private javax.swing.JPanel panelnv;
    private javax.swing.JPanel panelsp;
    private javax.swing.JPanel paneltk;
    private javax.swing.JPanel sideBar;
    private javax.swing.JPanel title;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables
}
