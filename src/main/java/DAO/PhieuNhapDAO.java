/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.PhieuNhap_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class PhieuNhapDAO {
    public PhieuNhapDAO() {
    }

    /**
     * @return
     */
    public ArrayList<PhieuNhap_DTO> ReadPhieuNhap() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<PhieuNhap_DTO> pnArrayList = new ArrayList<>();
        String qry = "SELECT * FROM phieunhap WHERE TONTAI = 1";
        ResultSet rSet = null;

        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    PhieuNhap_DTO pn = new PhieuNhap_DTO(
                            rSet.getString("MAPHIEUNHAP"),
                            rSet.getString("MANV"),
                            rSet.getDate("THOIGIANLAP").toLocalDate(),
                            rSet.getDouble("VAT"),
                            rSet.getInt("SOMATHANG"),
                            rSet.getDouble("TONGTIEN"),
                            rSet.getNString("TRANGTHAI"),
                            rSet.getBoolean("TONTAI"));
                    pnArrayList.add(pn);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return pnArrayList;
    }

    public boolean add(PhieuNhap_DTO pn) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `phieunhap`(`MAPHIEUNHAP`, `MANV`,`THOIGIANLAP`,`VAT`,`SOMATHANG`,`TONGTIEN`,`TRANGTHAI`, `TONTAI`) VALUES "
                        + "('" + pn.getMaPhieuNhap()
                        + "','" + pn.getMaNV()
                        + "','" + pn.getThoiGianLap()
                        + "','" + pn.getVAT()
                        + "','" + pn.getSoMatHang()
                        + "','" + pn.getTongTien()
                        + "','" + pn.getTrangThai()
                        + "',1)");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(PhieuNhap_DTO pn) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE PHIEUNHAP SET TONTAI = 0 WHERE MAPHIEUNHAP ='" + pn.getMaPhieuNhap() + "'");
        connectDB.closeConnect();
        return success;
    }


    public boolean update(String maPhieuNhap,int soMatHang, double tongTien, String trangThai) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB.sqlUpdate("UPDATE `phieunhap` SET "
            + " `SOMATHANG ` = " + soMatHang
            + ", `TONGTIEN` = " + tongTien
            + ",`TRANGTHAI` ='" + trangThai
            + "' WHERE `MAPHIEUNHAP`='" + maPhieuNhap + "'");
        connectDB.closeConnect();
        return success;
    }
    

    public ArrayList<PhieuNhap_DTO> searchPhieuNhap(String maPhieuNhap, String maNV, LocalDate thoiGianLap,String trangThai) {

        ArrayList<PhieuNhap_DTO> phieunhap = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        StringBuilder qry = new StringBuilder("SELECT * FROM `phieunhap` WHERE TONTAI = 1");

        if (maPhieuNhap != null && !maPhieuNhap.isEmpty()) {
            qry.append(" AND `MAPHIEUNHAP` = '" + maPhieuNhap + "'");
        }

        if (maNV != null) {
            qry.append(" AND `MANV` = '" + maNV + "'");
        }


        if (thoiGianLap != null) {
            qry.append(" AND `THOIGIANLAP` = '" + thoiGianLap + "'");
        }

        if (trangThai != null && !trangThai.isEmpty()) {
            qry.append(" AND `TRANGTHAI ` LIKE '%" + trangThai + "%'");
        }

        ResultSet rSet = connectDB.sqlQuery(qry.toString());
        try {
            if (rSet != null) {
                while (rSet.next()) {
                    PhieuNhap_DTO phieuNhap = new PhieuNhap_DTO(
                            rSet.getString("MAPHIEUNHAP"),
                            rSet.getString("MANV"),
                            rSet.getDate("THOIGIANLAP").toLocalDate(),
                            rSet.getDouble("VAT"),
                            rSet.getInt("SOMATHANG"),
                            rSet.getDouble("TONGTIEN"),
                            rSet.getNString("TRANGTHAI"),
                            rSet.getBoolean("TONTAI"));

                    phieunhap.add(phieuNhap);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieunhap;
    }

    public int laySoLuongPhieuNhap() {
        ConnectDB connectDB = new ConnectDB();
        int soLuong = 0;
        String qry = "SELECT COUNT(*) FROM `phieunhap` WHERE TONTAI = 1";
        ResultSet rSet = null;
    
        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null && rSet.next()) {
                soLuong = rSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn số lượng Phiếu Nhập!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return soLuong;
    }
    public boolean isMaPhieuExisted(String maPhieu) {
        ConnectDB connectDB = new ConnectDB();
        String qry = "SELECT 1 FROM `phieunhap` WHERE `MAPHIEUNHAP` = '" + maPhieu + "' AND `TONTAI` = 1";
        
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