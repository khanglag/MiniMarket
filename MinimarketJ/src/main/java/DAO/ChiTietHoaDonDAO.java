/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.ConnectDB;
import java.util.ArrayList;
import DTO.ChiTietHoaDon_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author pc
 */
public class ChiTietHoaDonDAO {
    public ChiTietHoaDonDAO(){
    }
    public ArrayList<ChiTietHoaDon_DTO> readBD(){
        ConnectDB connectDB = new ConnectDB();
        ArrayList<ChiTietHoaDon_DTO> chiTietHoaDon_DTOs = new ArrayList<>();
        String qry = "SELECT * FROM `chitiet_hoadon` WHERE TONTAI = 1"; 
        ResultSet rSet = null;
        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    ChiTietHoaDon_DTO cthddto = new ChiTietHoaDon_DTO(
                    rSet.getInt("SOHD"),
                    rSet.getNString("MASP"),
                    rSet.getInt("SOLUONG"),
                    rSet.getBoolean("TONTAI"));
                    chiTietHoaDon_DTOs.add(cthddto);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn hàng hóa");
            e.printStackTrace();
        }
        return  chiTietHoaDon_DTOs;
    }
    
    public boolean add(ChiTietHoaDon_DTO ct) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(""
                + "INSERT INTO `chitiet_hoadon`(`SOHD`, `MASP`, `SOLUONG`, `TONTAI`) VALUES ("
                + "'"+ct.getMaSP()+"',"
                + "'"+ct.getMaSP()+"',"
                + "'"+ct.getSoLuong()+"',"
                + "'"+ct.isTonTai()+"')"
        );
        connectDB.closeConnect();
        return success;
    }
    public boolean delete(ChiTietHoaDon_DTO ct) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `chitiet_hoadon` SET TONTAI = 0 WHERE `SOHD`=" + ct.getSoHD() + "'");
        connectDB.closeConnect();
        return success;
    }
    public boolean update(ChiTietHoaDon_DTO ct) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `chitiet_hoadon` SET `SOHD`='"+ct.getSoHD()+"',`MASP`='"+ct.getMaSP()+"',`SOLUONG`='"+ct.getSoLuong()+"',`TONTAI`='"+ct.isTonTai()+"'");
        connectDB.closeConnect();
        return success;
    }
    public ArrayList<ChiTietHoaDon_DTO> searchHangHoa(int soHD, String maSP, int soLuong, boolean tonTai) {
        ArrayList<ChiTietHoaDon_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();

        StringBuilder qry = new StringBuilder("SELECT * FROM `chitiet_hoadon` WHERE TONTAI = 1");

        if (soHD >=0) {
            qry.append(" AND `SOHD` LIKE '%").append(soHD).append("%'");
        }

        if (maSP != null && !maSP.isEmpty()) {
            qry.append(" AND `MASP` = '").append(maSP).append("'");
        }

        if (soLuong > 0) {
            qry.append(" AND `SOLUONG` = ").append(soLuong);
        }

        ResultSet rSet = connectDB.sqlQuery(qry.toString());

        try {
            if (rSet != null) {
                while (rSet.next()) {
                    ChiTietHoaDon_DTO cthddto = new ChiTietHoaDon_DTO(
                    rSet.getInt("SOHD"),
                    rSet.getNString("MASP"),
                    rSet.getInt("SOLUONG"),
                    rSet.getBoolean("TONTAI"));
                    ds.add(cthddto);

                    ds.add(cthddto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
}
