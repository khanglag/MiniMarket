/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.HoaDon_DTO;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class HoaDonDAO {
    public HoaDonDAO() {
    }

    public ArrayList<HoaDon_DTO> ReadHoadons() {
        ArrayList<HoaDon_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        String qry = "SELECT * FROM `hoadon` WHERE TONTAI = 1";
        ResultSet rset = connectDB.sqlQuery(qry);
        try {
            if (rset != null) {
                while (rset.next()) {
                    HoaDon_DTO hoaDon = new HoaDon_DTO(
                            rset.getInt("SOHD"),
                            rset.getString("MANV"),
                            rset.getDate("THOIGIANLAP").toLocalDate(),
                            rset.getNString("MAKH"),
                            rset.getDouble("TIENKHACHDUA"),
                            rset.getDouble("TIENTRAKHACH"),
                            rset.getDouble("THANHTIEN"),
                            rset.getBoolean("TONTAI"));
                    ds.add(hoaDon);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public boolean add(int soHD, String maNV, LocalDate thoiGianLap, String maKH, double thanhTien, double tienKhachDua, double tienTraKhach, boolean tonTai) {
        boolean success = false;
        HoaDon_DTO hd=new HoaDon_DTO(soHD, maNV, thoiGianLap, maKH, thanhTien, tienKhachDua, tienTraKhach, tonTai);
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `hoadon`(`SOHD`, `MANV`, `THOIGIANLAP`, `MAKH`, `THANHTIEN`, `TIENKHACHDUA`, `TIENTRAKHACH`, `TONTAI`) VALUES ("
                        + "'"+hd.getSoHD()+"',"
                        + "'"+hd.getMaNV()+"',"
                        + "'"+hd.getThoiGianLap()+"',"
                        + "'"+hd.getMaKH()+"',"
                        + "'"+hd.getThanhTien()+"',"
                        + "'"+hd.getTienKhachDua()+"',"
                        + "'"+hd.getTienTraKhach()+"',"
                        + "'1')");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(HoaDon_DTO hoaDon) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE HOADON SET TONTAI = 0 WHERE SOHD ='" + hoaDon.getSoHD() + "'");
        connectDB.closeConnect();
        return success;
    }

    public boolean update(HoaDon_DTO hoaDon) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `hoadon` SET "
                        + "`THANHTIEN`='" + hoaDon.getThanhTien()
                        + "',`TIENKHACHDUA`='" + hoaDon.getTienKhachDua()
                        + "',`TIENTRAKHACH`='" + hoaDon.getTienTraKhach()
                        + "' WHERE `SOHD`='" + hoaDon.getSoHD() + "'");
        connectDB.closeConnect();
        return success;
    }

    public ArrayList<HoaDon_DTO> searchHoaDon(int soHD, LocalDate thoiGianLap) {
        ArrayList<HoaDon_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();

        StringBuilder qry = new StringBuilder("SELECT * FROM `hoadon` WHERE TONTAI = 1");

        if (soHD > 0) {
            qry.append(" AND `SOHD` = ").append(soHD);
        }
        if (thoiGianLap != null) {
            qry.append(" AND `THOIGIANLAP` = '").append(Date.valueOf(thoiGianLap)).append("'");
        }

        ResultSet rset = connectDB.sqlQuery(qry.toString());

        try {
            if (rset != null) {
                while (rset.next()) {
                    HoaDon_DTO hoadon = new HoaDon_DTO(
                            rset.getInt("SOHD"),
                            rset.getString("MANV"),
                            rset.getDate("THOIGIANLAP").toLocalDate(),
                            rset.getNString("MAKH"),
                            rset.getDouble("THANHTIEN"),
                            rset.getDouble("TIENKHACHDUA"),
                            rset.getDouble("TIENTRAKHACH"),
                            rset.getBoolean("TONTAI"));

                    ds.add(hoadon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
    public int demSoHoaDon(){
        int n=0;
        ConnectDB connectDB=new ConnectDB();
        String sql = "SELECT COUNT(*) FROM `hoadon`";
        ResultSet rSet = connectDB.sqlQuery(sql);
        try {
            if(rSet.next()){
                n=rSet.getInt(1);
            }
        } catch (Exception e) {
        }
        connectDB.closeConnect();
        return n;
    }
}