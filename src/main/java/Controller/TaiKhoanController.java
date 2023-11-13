/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import GUI.Admin.MainJFrameAd;
import GUI.Login.Service.TaiKhoanService;
import GUI.Login.Service.TaiKhoanServiceImpl;
import GUI.Login.TaiKhoan;
import GUI.QuanLy.MainFrameQuanLy;
import GUI.ThuKho.MainFrameThuKho;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author khang
 */
// chức năng login
public class TaiKhoanController {

    private JFrame dialog;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JPasswordField jtfMatKhau;

    static String tendnString = null;
    static int ngdn;

    private JFrame frame = null;
    private TaiKhoanService taiKhoanService = null;

    public TaiKhoanController(JFrame dialog, JButton btnSubmit, JTextField jtfTenDangNhap, JPasswordField jtfMatKhau) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jtfMatKhau = jtfMatKhau;

        taiKhoanService = new TaiKhoanServiceImpl();
    }

    public static void setNgdn(int ngdn) {
        TaiKhoanController.ngdn = ngdn;
    }
    public static void setTendnString(String n) {
        TaiKhoanController.tendnString=n;
    }

    public static String getTendnString() {
        return tendnString;
    }

    public static int getNgdn() {
        return ngdn;
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if (jtfTenDangNhap.getText().equals("Username") && jtfMatKhau.getText().equals("Password")) {

                    JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập và mật khẩu.");
                } else if(jtfTenDangNhap.getText().equals("Username")){
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập.");

                } else if(jtfMatKhau.getText().equals("Password")){
                     JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu.");
                }
                else {
                    
                    TaiKhoan taiKhoan = taiKhoanService.login(jtfTenDangNhap.getText(), jtfMatKhau.getText());
                    if (taiKhoan == null) {
                        JOptionPane.showMessageDialog(null, "Tên đăng nhập không chính xác!");

                    } else if(!taiKhoan.getMat_khau().equals(jtfMatKhau.getText())){
                        JOptionPane.showMessageDialog(null, "Mật khẩu không chính xác!");
                    } else{
                        if (!taiKhoan.isTontai()) {
                            JOptionPane.showMessageDialog(null, "Tài khoản bị khoá!");

                        } else {
                            tendnString = jtfTenDangNhap.getText();
                            JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");

                            if (taiKhoan.getQuyen().contains("QL")) {
                                setNgdn(0);
                                dialog.dispose();
                                frame = new GUI.QuanLy.MainFrameQuanLy();
                                frame.setLocationRelativeTo(null);
                                frame.setTitle("Quản lý siêu thị mini");
                                frame.setExtendedState(JFrame.ABORT);
                                frame.setVisible(true);

                            } else if (taiKhoan.getQuyen().contains("NVBH")) {
                                setNgdn(0);
                                dialog.dispose();
                                frame = new GUI.Saler.MainFrameSaler();
                                frame.setLocationRelativeTo(null);
                                frame.setTitle("Quản lý siêu thị mini");
                                frame.setExtendedState(JFrame.ABORT);
                                frame.setVisible(true);
                            } else if (taiKhoan.getQuyen().contains("NVTK")) {
                                setNgdn(1);
                                dialog.dispose();
                                frame = new MainFrameThuKho();
                                frame.setLocationRelativeTo(null);
                                frame.setTitle("Quản lý siêu thị mini");
                                frame.setExtendedState(JFrame.ABORT);
                                frame.setVisible(true);
                            } else {
                                setNgdn(1);
                                dialog.dispose();
                                frame = new MainJFrameAd();
                                frame.setLocationRelativeTo(null);
                                frame.setTitle("Quản lý siêu thị mini");
                                frame.setExtendedState(JFrame.ABORT);
                                frame.setVisible(true);
                            }

                        }
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
