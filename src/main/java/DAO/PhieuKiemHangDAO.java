/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.PhieuKiemHang_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class PhieuKiemHangDAO {
    public PhieuKiemHangDAO() {
    }

    /**
     * @return
     */
    public ArrayList<PhieuKiemHang_DTO> ReadPhieuKiemHang() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<PhieuKiemHang_DTO> pkhArrayList = new ArrayList<>();
        String qry = "SELECT * FROM phieukiemhang WHERE TONTAI = 1";
        ResultSet rSet = null;

        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    PhieuKiemHang_DTO pkh = new PhieuKiemHang_DTO(
                            rSet.getString("MAPHIEU"),
                            rSet.getString("MANV"),
                            rSet.getDate("THOIGIANKIEMHANG").toLocalDate(),
                            rSet.getBoolean("TONTAI"));
                    pkhArrayList.add(pkh);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return pkhArrayList;
    }

    public boolean add(PhieuKiemHang_DTO pkh) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `phieukiemhang`(`MAPHIEU`,`MANV`, `THOIGIANKIEMHANG`, `TONTAI`) VALUES "
                        + "('" + pkh.getMaPhieu()
                        + "','" + pkh.getMaNV()
                        + "','" + pkh.getThoiGianKiemHang()
                        + "',1)");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(PhieuKiemHang_DTO pkh) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE PHIEUKIEMHANG SET TONTAI = 0 WHERE MAPHIEU ='" + pkh.getMaPhieu() + "'");
        connectDB.closeConnect();
        return success;
    }

    public ArrayList<PhieuKiemHang_DTO> searchPhieuKiemHang(String maPhieu, String maNV, LocalDate thoiGianKiemHang) {
        ArrayList<PhieuKiemHang_DTO> phieukiemhang = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        StringBuilder qry = new StringBuilder("SELECT * FROM `phieukiemhang` WHERE TONTAI = 1");

        if (maPhieu != null && !maPhieu.isEmpty()) {
            qry.append(" AND `MAPHIEU` = '" + maPhieu + "'");
        }

        if (maNV != null && !maNV.isEmpty()) {
            qry.append(" AND `MANV` = '" + maNV + "'");
        }

        if (thoiGianKiemHang != null) {
            qry.append(" AND `THOIGIANKIEMHANG` = '" + thoiGianKiemHang + "'");
        }

        ResultSet rSet = connectDB.sqlQuery(qry.toString());

        try {
            if (rSet != null) {
                while (rSet.next()) {
                    PhieuKiemHang_DTO phieuKiemHang = new PhieuKiemHang_DTO(
                            rSet.getString("MAPHIEU"),
                            rSet.getString("MANV"),
                            rSet.getDate("THOIGIANKIEMHANG").toLocalDate(),
                            rSet.getBoolean("TONTAI"));
                    phieukiemhang.add(phieuKiemHang);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieukiemhang;
    }
    public int laySoLuongPhieu() {
        ConnectDB connectDB = new ConnectDB();
        int soLuong = 0;
        String qry = "SELECT COUNT(*) FROM `phieukiemhang` WHERE TONTAI = 1";
        ResultSet rSet = null;
    
        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null && rSet.next()) {
                soLuong = rSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn số lượng Phiếu !!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return soLuong;
    }
    public boolean isMaPhieuExisted(String maPhieu) {
        ConnectDB connectDB = new ConnectDB();
        String qry = "SELECT 1 FROM `phieukiemhang` WHERE `MAPHIEU` = '" + maPhieu + "' AND `TONTAI` = 1";
        ResultSet rSet = connectDB.sqlQuery(qry);
        if (rSet != null) {
            try {
                System.out.println(rSet);
                return rSet.next(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return false; 
    }
    public boolean CheckExistedCT(String maPhieu) {
        ConnectDB connectDB = new ConnectDB();
        String qry = "SELECT 1 FROM `chitiet_kiemhang` WHERE `MAPHIEU` = '" + maPhieu + "' AND `TONTAI` = 1";
        ResultSet rSet = connectDB.sqlQuery(qry);
        if (rSet != null) {
            try {
                System.out.println(rSet);
                return rSet.next(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return false; 
    }

    
}


