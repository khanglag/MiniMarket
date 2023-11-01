/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.ThuKho;

import BEAN.DanhMucBean;
import BUS.NhanvienBus;
import Controller.TaiKhoanController;
import Controller.ThuKhoController;
import GUI.Admin.DoiMatKhau;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author khang
 */
public class MainFrameThuKho extends javax.swing.JFrame {

    /**
     * Creates new form MainFrameThuKho
     */
    NhanvienBus nv = new NhanvienBus();
    public MainFrameThuKho() {

        initComponents();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(new QuanLyPhieuNhap());
        jLabelTen.setText(nv.tenNV(TaiKhoanController.getTendnString()));
        TrinhDieuKhien();
        

    }

    private void TrinhDieuKhien() {
        ThuKhoController controller = new ThuKhoController(jpnView);
        //controller.setView(panelTrangChu, jLabelTrangChu);
        
        List<DanhMucBean> listItem = new ArrayList<>();
        //listItem.add(new DanhMucBean("TrangChinh",jpnTrangChu,jlbTrangChu));
        //listItem.add(new DanhMucBean("PhieuNhapHang",panelPhieuNhap,jLabelPhieuNhap));
        listItem.add(new DanhMucBean("QuanLyPhieuNhap",panelQuanLyPhieuNhap,jLabelQuanLyPhieuNhap));
        listItem.add(new DanhMucBean("QuanLyKiemHang",panelPhieuKiemHang,jLabelPhieuKiemHang));
        listItem.add(new DanhMucBean("QuanLyPhieuXuat",panelQuanLyPhieuXuat,jLabelQuanLyPhieuXuat));
        listItem.add(new DanhMucBean("DangXuat",panelDangXuat,jLabelDangXuat));
  
        System.out.println("hang44");
        controller.setEvent(listItem);
        System.out.println("hang46");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenuI = new javax.swing.JPanel();
        panelDoiMatKhau = new javax.swing.JPanel();
        jLabelDoiMatKhau = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        jLabelLogout = new javax.swing.JLabel();
        panelThoat = new javax.swing.JPanel();
        jLabelThoat = new javax.swing.JLabel();
        jpnRoot = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();
        panelPhieuKiemHang = new javax.swing.JPanel();
        jLabelPhieuKiemHang = new javax.swing.JLabel();
        panelQuanLyPhieuXuat = new javax.swing.JPanel();
        jLabelQuanLyPhieuXuat = new javax.swing.JLabel();
        panelQuanLyPhieuNhap = new javax.swing.JPanel();
        jLabelQuanLyPhieuNhap = new javax.swing.JLabel();
        panelDangXuat = new javax.swing.JPanel();
        jLabelDangXuat = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanelTen = new javax.swing.JPanel();
        jLabelTen = new javax.swing.JLabel();

        panelMenuI.setPreferredSize(new java.awt.Dimension(110, 110));
        panelMenuI.setLayout(new java.awt.GridLayout(3, 0));

        jLabelDoiMatKhau.setText("Đổi mật khẩu");

        javax.swing.GroupLayout panelDoiMatKhauLayout = new javax.swing.GroupLayout(panelDoiMatKhau);
        panelDoiMatKhau.setLayout(panelDoiMatKhauLayout);
        panelDoiMatKhauLayout.setHorizontalGroup(
            panelDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDoiMatKhauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDoiMatKhauLayout.setVerticalGroup(
            panelDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDoiMatKhauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDoiMatKhau)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelMenuI.add(panelDoiMatKhau);

        jLabelLogout.setText("Logout");

        javax.swing.GroupLayout panelLogoutLayout = new javax.swing.GroupLayout(panelLogout);
        panelLogout.setLayout(panelLogoutLayout);
        panelLogoutLayout.setHorizontalGroup(
            panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLogoutLayout.setVerticalGroup(
            panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogout)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelMenuI.add(panelLogout);

        jLabelThoat.setText("Thoát");

        javax.swing.GroupLayout panelThoatLayout = new javax.swing.GroupLayout(panelThoat);
        panelThoat.setLayout(panelThoatLayout);
        panelThoatLayout.setHorizontalGroup(
            panelThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThoatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelThoatLayout.setVerticalGroup(
            panelThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThoatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelThoat)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelMenuI.add(panelThoat);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnRoot.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane10.setBackground(new java.awt.Color(189, 205, 214));
        jScrollPane10.setForeground(new java.awt.Color(189, 205, 214));
        jScrollPane10.setHorizontalScrollBar(null);

        panelMenu.setBackground(new java.awt.Color(189, 205, 214));

        jLabelPhieuKiemHang.setText("Quản lý kiểm hàng");

        javax.swing.GroupLayout panelPhieuKiemHangLayout = new javax.swing.GroupLayout(panelPhieuKiemHang);
        panelPhieuKiemHang.setLayout(panelPhieuKiemHangLayout);
        panelPhieuKiemHangLayout.setHorizontalGroup(
            panelPhieuKiemHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPhieuKiemHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPhieuKiemHang, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPhieuKiemHangLayout.setVerticalGroup(
            panelPhieuKiemHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPhieuKiemHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPhieuKiemHang, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelQuanLyPhieuXuat.setText("Quản lý phiếu xuất");

        javax.swing.GroupLayout panelQuanLyPhieuXuatLayout = new javax.swing.GroupLayout(panelQuanLyPhieuXuat);
        panelQuanLyPhieuXuat.setLayout(panelQuanLyPhieuXuatLayout);
        panelQuanLyPhieuXuatLayout.setHorizontalGroup(
            panelQuanLyPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuanLyPhieuXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelQuanLyPhieuXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelQuanLyPhieuXuatLayout.setVerticalGroup(
            panelQuanLyPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLyPhieuXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelQuanLyPhieuXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelQuanLyPhieuNhap.setText("Quản lý phiếu nhập");

        javax.swing.GroupLayout panelQuanLyPhieuNhapLayout = new javax.swing.GroupLayout(panelQuanLyPhieuNhap);
        panelQuanLyPhieuNhap.setLayout(panelQuanLyPhieuNhapLayout);
        panelQuanLyPhieuNhapLayout.setHorizontalGroup(
            panelQuanLyPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLyPhieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelQuanLyPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelQuanLyPhieuNhapLayout.setVerticalGroup(
            panelQuanLyPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLyPhieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelQuanLyPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelDangXuat.setText("Đăng xuất");

        javax.swing.GroupLayout panelDangXuatLayout = new javax.swing.GroupLayout(panelDangXuat);
        panelDangXuat.setLayout(panelDangXuatLayout);
        panelDangXuatLayout.setHorizontalGroup(
            panelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDangXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDangXuatLayout.setVerticalGroup(
            panelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDangXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelQuanLyPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPhieuKiemHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelQuanLyPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPhieuKiemHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelQuanLyPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelQuanLyPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 77, Short.MAX_VALUE))
        );

        jScrollPane10.setViewportView(panelMenu);

        jpnView.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(147, 166, 174));

        jLabelTen.setText("jLabel1");
        jLabelTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTenLayout = new javax.swing.GroupLayout(jPanelTen);
        jPanelTen.setLayout(jPanelTenLayout);
        jPanelTenLayout.setHorizontalGroup(
            jPanelTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTen, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTenLayout.setVerticalGroup(
            jPanelTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTen, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(18, 18, 18))
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
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTenMouseClicked
        // TODO add your handling code here:
        new DoiMatKhau(TaiKhoanController.getTendnString()).setVisible(true);
    }//GEN-LAST:event_jLabelTenMouseClicked
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrameThuKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrameThuKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrameThuKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrameThuKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameThuKho().setVisible(true);
            }
        });
    }

  

    //mở menu
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDangXuat;
    private javax.swing.JLabel jLabelDoiMatKhau;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelPhieuKiemHang;
    private javax.swing.JLabel jLabelQuanLyPhieuNhap;
    private javax.swing.JLabel jLabelQuanLyPhieuXuat;
    private javax.swing.JLabel jLabelTen;
    private javax.swing.JLabel jLabelThoat;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelTen;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnView;
    private javax.swing.JPanel panelDangXuat;
    private javax.swing.JPanel panelDoiMatKhau;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMenuI;
    private javax.swing.JPanel panelPhieuKiemHang;
    private javax.swing.JPanel panelQuanLyPhieuNhap;
    private javax.swing.JPanel panelQuanLyPhieuXuat;
    private javax.swing.JPanel panelThoat;
    // End of variables declaration//GEN-END:variables
}
