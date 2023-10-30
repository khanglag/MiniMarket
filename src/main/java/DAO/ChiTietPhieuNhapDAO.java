/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import java.util.ArrayList;
import DTO.ChiTietPhieuNhap_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ChiTietPhieuNhapDAO {
    public ChiTietPhieuNhapDAO() {

    }

    public ArrayList<ChiTietPhieuNhap_DTO> readBD() {
        ConnectDB connectBD = new ConnectDB();
        ArrayList<ChiTietPhieuNhap_DTO> chiTietPhieuNhap_DTOs = new ArrayList<>();
        String qry = "SELECT * FROM `chitiet_phieunhap` WHERE TONTAI = 1";
        ResultSet rs = null;
        try {
            rs = connectBD.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    ChiTietPhieuNhap_DTO ctpn = new ChiTietPhieuNhap_DTO(
                            rs.getNString("MAPHIEUNHAP"),
                            rs.getNString("MAHANGNHAP"),
                            rs.getNString("TENHANGNHAP"),
                            rs.getDouble("VAT"),
                            rs.getNString("XUATXU"),
                            rs.getNString("ANHSP"),
                            rs.getInt("SOLUONG"),
                            rs.getNString("DONVI"),
                            rs.getDouble("GIANHAP"),
                            rs.getDouble("TONGTIENNHAP"),
                            rs.getBoolean("TONTAI"));
                    chiTietPhieuNhap_DTOs.add(ctpn);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!");
            e.printStackTrace();
        }
        return chiTietPhieuNhap_DTOs;
    }

    public boolean addCTPN(ChiTietPhieuNhap_DTO ctpn) {
        boolean kq = false;
        ConnectDB connectBD = new ConnectDB();
        kq = connectBD.sqlUpdate(""
                + "INSERT INTO `chitiet_phieunhap` (`MAPHIEUNHAP`, `MAHANGNHAP`, `TENHANGNHAP`, `VAT`, `XUATXU`, `ANHSP`, `SOLUONG`, `DONVI`, `GIANHAP`, `TONGTIENNHAP`, `TONTAI`) VALUES ("
                + "'" + ctpn.getMaPhieuNhap() + "',"
                + "'" + ctpn.getMaHangNhap() + "',"
                + "'" + ctpn.getTenHangNhap() + "',"
                + "'" + ctpn.getVAT() + "',"
                + "'" + ctpn.getXuatXu() + "',"
                + "'" + ctpn.getAnhSP() + "',"
                + "'" + ctpn.getSoLuong() + "',"
                + "'" + ctpn.getDonVi() + "',"
                + "'" + ctpn.getGiaNhap() + "',"
                + "'" + ctpn.getTongTienNhap() + "',"
                + "'1')");
        connectBD.closeConnect();
        return kq;
    }

    public boolean deleteCTPN(ChiTietPhieuNhap_DTO ctpn) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        String sql = "UPDATE `chitiet_phieunhap` SET TONTAI = 0 WHERE `MAPHIEUNHAP` = '" + ctpn.getMaPhieuNhap()
                + "' AND `MAHANGNHAP` = '" + ctpn.getMaHangNhap() + "'";
        success = connectDB.sqlUpdate(sql);
        connectDB.closeConnect();
        return success;
    }

    public boolean updateCTPN(ChiTietPhieuNhap_DTO ctpn) {
        ConnectDB connectDB = new ConnectDB();
        boolean kq = connectDB.sqlUpdate("UPDATE `chitiet_phieunhap` SET"
                + " TENHANGNHAP = '" + ctpn.getTenHangNhap() + "',"
                + " XUATXU = '" + ctpn.getXuatXu() + "',"
                + " ANHSP = '" + ctpn.getAnhSP() + "',"
                + " SOLUONG = '" + ctpn.getSoLuong() + "',"
                + " GIANHAP = '" + ctpn.getGiaNhap() + "',"
                + " TONGTIENNHAP = '" + ctpn.getTongTienNhap() + "'"
                + " WHERE `MAPHIEUNHAP` = '" + ctpn.getMaPhieuNhap() + "' AND `MAHANGNHAP` = '" + ctpn.getMaHangNhap()
                + "'");
        connectDB.closeConnect();
        return kq;
    }

    public ArrayList<ChiTietPhieuNhap_DTO> searchCTPN(String maPhieuNhap, String maHangNhap, String tenHangNhap,String xuatXu) {
        ArrayList<ChiTietPhieuNhap_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        StringBuilder qry = new StringBuilder("SELECT * FROM `chitiet_phieunhap` WHERE TONTAI = 1");

        if (maPhieuNhap != null && !maPhieuNhap.isEmpty()) {
            qry.append(" AND `MAPHIEUNHAP` =  '" + maPhieuNhap + "'");
        }

        if (maHangNhap != null && !maHangNhap.isEmpty()) {
            qry.append(" AND `MAHANGNHAP` =  '" + maHangNhap + "'");
        }

        if (tenHangNhap != null && !tenHangNhap.isEmpty()) {
            qry.append(" AND `TENHANGNHAP` LIKE '%" + tenHangNhap + "%'");
        }
        if (xuatXu != null && !xuatXu.isEmpty()) {
            qry.append(" AND `XUATXU` LIKE '%" + xuatXu + "%'");
        }

        ResultSet rs = connectDB.sqlQuery(qry.toString());

        try {
            if (rs != null) {
                while (rs.next()) {
                    ChiTietPhieuNhap_DTO ctpn = new ChiTietPhieuNhap_DTO(
                            rs.getNString("MAPHIEUNHAP"),
                            rs.getNString("MAHANGNHAP"),
                            rs.getNString("TENHANGNHAP"),
                            rs.getDouble("VAT"),
                            rs.getNString("XUATXU"),
                            rs.getNString("ANHSP"),
                            rs.getInt("SOLUONG"),
                            rs.getNString("DONVI"),
                            rs.getDouble("GIANHAP"),
                            rs.getDouble("TONGTIENNHAP"),
                            rs.getBoolean("TONTAI"));

                    ds.add(ctpn);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;

    }
    public boolean isCTPN_Existed(String maPhieu, String maSP) {
        ConnectDB connectDB = new ConnectDB();
        String qry = "SELECT 1 FROM `chitiet_phieunhap` WHERE `MAPHIEUNHAP` = '" + maPhieu + "' AND `MAHANGNHAP` = '" + maSP + "'";
        
        ResultSet rSet = connectDB.sqlQuery(qry);
        
        if (rSet != null) {
            try {
                return rSet.next(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return false; 
    }

}
