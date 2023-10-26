/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import java.util.ArrayList;
import DTO.ChiTietPhieuXuat_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class ChiTietPhieuXuatDAO {
    public ChiTietPhieuXuatDAO() {
    }

    public ArrayList<ChiTietPhieuXuat_DTO> readBD() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<ChiTietPhieuXuat_DTO> chiTietPhieuXuat_DTOs = new ArrayList<>();
        String qry = "SELECT * FROM `chitiet_phieuxuat` WHERE TONTAI = 1";
        ResultSet rSet = null;
        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    ChiTietPhieuXuat_DTO ctpxdto = new ChiTietPhieuXuat_DTO(
                            rSet.getString("MAPHIEUXUAT"),
                            rSet.getString("MAHANGXUAT"),
                            rSet.getInt("SOLUONGYEUCAU"),
                            rSet.getInt("SOLUONGTHUCXUAT"),
                            rSet.getNString("DONVI"),
                            rSet.getDouble("DONGIA"),
                            rSet.getDouble("THANHTIEN"),
                            rSet.getBoolean("TONTAI"));
                    chiTietPhieuXuat_DTOs.add(ctpxdto);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!");
            e.printStackTrace();
        }
        return chiTietPhieuXuat_DTOs;
    }

    public boolean add(ChiTietPhieuXuat_DTO ctpx) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(""
                + "INSERT INTO `chitiet_phieuxuat` (`MAPHIEUXUAT`, `MAHANGXUAT`, `SOLUONGYEUCAU`, `SOLUONGTHUCXUAT` , `DONVI` , `DONGIA` , `THANHTIEN` , `TONTAI`) VALUES ("
                + "'" + ctpx.getMaPhieuXuat()
                + "','" + ctpx.getMaHangXuat()
                + "'," + ctpx.getSoLuongYC()
                + "," + ctpx.getSoLuongThucTe()
                + ",'" + ctpx.getDonVi()
                + "'," + ctpx.getDonGia()
                + "," + ctpx.getThanhTien()
                + ",'1')");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(ChiTietPhieuXuat_DTO ctpx) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        String sql = "UPDATE `chitiet_phieuxuat` SET TONTAI = 0 WHERE `MAPHIEUXUAT` = '" + ctpx.getMaPhieuXuat()
                + "' AND `MAHANGXUAT` = '" + ctpx.getMaHangXuat() + "'";
        success = connectDB.sqlUpdate(sql);
        connectDB.closeConnect();
        return success;
    }

    public boolean update(ChiTietPhieuXuat_DTO ctpx) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        String sql = "UPDATE `chitiet_phieuxuat` SET "
                + " `SOLUONGYEUCAU` = " + ctpx.getSoLuongYC() + ","
                + " `SOLUONGTHUCXUAT` = " + ctpx.getSoLuongThucTe() + ","
                + " `DONGIA` = " + ctpx.getDonGia() + ","
                + " `THANHTIEN` = " + ctpx.getThanhTien() + ""
                + " WHERE `MAPHIEUXUAT` = '" + ctpx.getMaPhieuXuat() + "' AND `MAHANGXUAT` = '" + ctpx.getMaHangXuat()
                + "'";
        success = connectDB.sqlUpdate(sql);
        connectDB.closeConnect();
        return success;
    }

    public ArrayList<ChiTietPhieuXuat_DTO> search(String maHangXuat, int soLuongYC) {
        ArrayList<ChiTietPhieuXuat_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        StringBuilder qry = new StringBuilder("SELECT * FROM `chitiet_phieuxuat` WHERE TONTAI = 1");

        if (maHangXuat != null && !maHangXuat.isEmpty()) {
            qry.append(" AND `MAHANGXUAT` =  '" + maHangXuat + "'");
        }

        if (soLuongYC >= 0) {
            qry.append(" AND `SOLUONGYEUCAU` = " + soLuongYC);
        }

        ResultSet rSet = connectDB.sqlQuery(qry.toString());

        try {
            if (rSet != null) {
                while (rSet.next()) {
                    ChiTietPhieuXuat_DTO ctpxdto = new ChiTietPhieuXuat_DTO(
                            rSet.getString("MAPHIEUXUAT"),
                            rSet.getString("MAHANGXUAT"),
                            rSet.getInt("SOLUONGYEUCAU"),
                            rSet.getInt("SOLUONGTHUCXUAT"),
                            rSet.getNString("DONVI"),
                            rSet.getDouble("DONGIA"),
                            rSet.getDouble("THANHTIEN"),
                            rSet.getBoolean("TONTAI"));
                    ds.add(ctpxdto);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
}
