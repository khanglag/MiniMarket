package DAO;

import DTO.KhachHang_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnectDB.ConnectDB;

public class KhachHangDAO {
    public KhachHangDAO() {
    }

    public ArrayList<KhachHang_DTO> ReadKhachHang() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<KhachHang_DTO> khArrayList = new ArrayList<>();
        String qry = "SELECT * FROM khachhang"; 
        ResultSet rSet = null;

        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    KhachHang_DTO khachHang = new KhachHang_DTO(
                            rSet.getString("MAKH"),
                            rSet.getNString("TENKH"),
                            rSet.getDate("NGAYSINH").toLocalDate(),
                            rSet.getString("SDT"),
                            rSet.getNString("DIACHI"),
                            rSet.getBoolean("TONTAI"));
                    khArrayList.add(khachHang);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return khArrayList;
    }
    public boolean add(KhachHang_DTO khachHang) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `khachhang`(`MAKH`, `TENKH`, `NGAYSINH`, `SDT`, `DIACHI`, `TONTAI`) VALUES "
                        + "('" + khachHang.getMaKH()
                        + "','" + khachHang.getTenKH()
                        + "','" + khachHang.getNgaySinh()
                        + "','" + khachHang.getSdt()
                        + "','" + khachHang.getDiaChi()
                        + "','1')"
        );
        connectDB.closeConnect();
        return success;
    }
    public boolean delete(KhachHang_DTO khachHang) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE KHACHHANG SET TONTAI = 0 WHERE MAKH ='" + khachHang.getMaKH() + "'");
        connectDB.closeConnect();
        return success;
    }
    public boolean update(KhachHang_DTO khachHang) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `khachhang` SET "
                        + "','TENKH ='" + khachHang.getTenKH()
                        + "',`SDT`='" + khachHang.getSdt()
                        + "',`DIACHI`='" + khachHang.getDiaChi()
                        + "' WHERE `MAKH`='" + khachHang.getMaKH() + "'");
        connectDB.closeConnect();
        return success;
    }
    public KhachHang_DTO searchKhachHang(String sdt) {
        KhachHang_DTO khachHang = null;
        String qry = "SELECT * FROM `khachhang` WHERE TONTAI= 1 AND `SDT`= ? '";
        ConnectDB connectDB = new ConnectDB();
        ResultSet rSet = connectDB.sqlQuery(qry);
        try {
            if (rSet != null) {
                while (rSet.next()) {
                    khachHang = new KhachHang_DTO(
                    rSet.getString("MAKH"),
                    rSet.getNString("TENKH"),
                    rSet.getDate("NGAYSINH").toLocalDate(),
                    rSet.getString("SDT"),
                    rSet.getNString("DIACHI"),
                    rSet.getBoolean("TONTAI"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHang;
    }
}
