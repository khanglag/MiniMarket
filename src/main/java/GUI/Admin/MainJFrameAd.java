/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Admin;

import BEAN.DanhMucBean;
import BUS.NhanvienBus;
import Controller.AdminController;
import Controller.TaiKhoanController;
import GUI.Login.LoginForm;
import static GUI.Login.LoginForm.login;
import GUI.Saler.ThongTinNhanVien;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author khang
 */
public class MainJFrameAd extends javax.swing.JFrame {

    /**
     * Creates new form MainJFramAd
     */
    NhanvienBus nv = new NhanvienBus();
    public MainJFrameAd() {
        initComponents();
        jlbTen.setText(nv.tenNV(TaiKhoanController.getTendnString()));
        ThongTinNhanVien ttnv = new ThongTinNhanVien();
        jpnView.removeAll();
        jpnView.revalidate();
        jpnView.repaint();
        jpnView.add(ttnv).setVisible(true);
        TrinhDieuKhien();
    }
private void TrinhDieuKhien() {
        AdminController controller = new AdminController(jpnView);
        controller.setView(panelQuanLyUser, jLabelQuanLyUser);
        
        List<DanhMucBean> listItem = new ArrayList<>();
        //listItem.add(new DanhMucBean("TrangChinh",jpnTrangChu,jlbTrangChu));
        //listItem.add(new DanhMucBean("PhieuNhapHang",panelPhieuNhap,jLabelPhieuNhap));
        listItem.add(new DanhMucBean("QuanLyUser",panelQuanLyUser,jLabelQuanLyUser));
        listItem.add(new DanhMucBean("DangXuat",jPanelDangXuat,jLabelDangXuat));

        controller.setEvent(listItem);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();
        panelQuanLyUser = new javax.swing.JPanel();
        jLabelQuanLyUser = new javax.swing.JLabel();
        jPanelDangXuat = new javax.swing.JPanel();
        jLabelDangXuat = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlbTen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(160, 191, 213));

        jpnRoot.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane10.setBackground(new java.awt.Color(160, 191, 213));
        jScrollPane10.setForeground(new java.awt.Color(189, 205, 214));
        jScrollPane10.setHorizontalScrollBar(null);

        panelMenu.setBackground(new java.awt.Color(160, 191, 213));

        panelQuanLyUser.setBackground(new java.awt.Color(67, 138, 174));

        jLabelQuanLyUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelQuanLyUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelQuanLyUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQuanLyUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/management.png"))); // NOI18N
        jLabelQuanLyUser.setText("QUẢN LÝ USER");

        javax.swing.GroupLayout panelQuanLyUserLayout = new javax.swing.GroupLayout(panelQuanLyUser);
        panelQuanLyUser.setLayout(panelQuanLyUserLayout);
        panelQuanLyUserLayout.setHorizontalGroup(
            panelQuanLyUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLyUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelQuanLyUser, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelQuanLyUserLayout.setVerticalGroup(
            panelQuanLyUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLyUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelQuanLyUser, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelDangXuat.setBackground(new java.awt.Color(67, 138, 174));
        jPanelDangXuat.setForeground(new java.awt.Color(255, 255, 255));

        jLabelDangXuat.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDangXuat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logout.png"))); // NOI18N
        jLabelDangXuat.setText("ĐĂNG XUẤT");
        jLabelDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDangXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelDangXuatLayout = new javax.swing.GroupLayout(jPanelDangXuat);
        jPanelDangXuat.setLayout(jPanelDangXuatLayout);
        jPanelDangXuatLayout.setHorizontalGroup(
            jPanelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDangXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelDangXuatLayout.setVerticalGroup(
            jPanelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDangXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelQuanLyUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(panelQuanLyUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 158, Short.MAX_VALUE))
        );

        jScrollPane10.setViewportView(panelMenu);

        jpnView.setBackground(new java.awt.Color(160, 191, 213));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(160, 191, 213));

        jPanel1.setBackground(new java.awt.Color(144, 144, 144));

        jlbTen.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlbTen.setForeground(new java.awt.Color(255, 255, 255));
        jlbTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTen.setText("jLabel1");
        jlbTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbTenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTen, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTen, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnRootLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlbTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbTenMouseClicked
        // TODO add your handling code here:
        panelQuanLyUser.setBackground(new Color(67,138,174));
        ThongTinNhanVien ttnv = new ThongTinNhanVien();
        jpnView.removeAll();
        jpnView.revalidate();
        jpnView.repaint();
        jpnView.add(ttnv).setVisible(true);
    }//GEN-LAST:event_jlbTenMouseClicked

    private void jLabelDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDangXuatMouseClicked
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            LoginForm lg = new LoginForm();
            this.dispose();
            lg.setVisible(true);
            lg.setLocationRelativeTo(null);

        } else {
            return;
        }
    }//GEN-LAST:event_jLabelDangXuatMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDangXuat;
    private javax.swing.JLabel jLabelQuanLyUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelDangXuat;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JLabel jlbTen;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnView;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelQuanLyUser;
    // End of variables declaration//GEN-END:variables
}
