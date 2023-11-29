/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Login.DAO;

import ConnectDB.ConnectDB;
import GUI.Login.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author khang
 */
// chức năng login
public class TaiKhoanDAOImpl implements TaiKhoanDAO {

    @Override
    public TaiKhoan login(String tenDangNhap, String matKhau) {
        ConnectDB conn = new ConnectDB();
        Connection cons = ConnectDB.getConnection();
        String sql = "SELECT taikhoan.MANV,MATKHAU,MAQUYEN, taikhoan.TONTAI FROM `taikhoan` INNER JOIN `nhanvien` ON taikhoan.MANV= nhanvien.MANV WHERE taikhoan.MANV LIKE ?";
        
        TaiKhoan taiKhoan = null;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taiKhoan = new TaiKhoan();

                taiKhoan.setTen_dn(rs.getString("MANV"));
                taiKhoan.setMat_khau(rs.getString("MATKHAU"));
                taiKhoan.setQuyen(rs.getString("MAQUYEN"));
                taiKhoan.setTontai(rs.getBoolean("TONTAI"));

            }
            ps.close();
            cons.close();
            return taiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
