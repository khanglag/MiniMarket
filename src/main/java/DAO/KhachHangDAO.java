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
        String qry = "SELECT * FROM khachhang WHERE TONTAI = 1"; 
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
    public boolean delete(String sdt) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE KHACHHANG SET TONTAI = 0 WHERE SDT ='" + sdt + "'");
        connectDB.closeConnect();
        return success;
    }
    public boolean update(String sdt, String diaChi) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `khachhang` SET "
                        + "'`DIACHI`='" + diaChi
                        + "' WHERE `SDT`='" + sdt + "'");
        connectDB.closeConnect();
        return success;
    }
    public KhachHang_DTO searchKhachHang(String sdt) {
        KhachHang_DTO khachHang = null;
        String qry = "SELECT * FROM `khachhang` WHERE TONTAI= 1 AND `SDT`="+sdt;
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
    public int demKhachHang(){
        int n=0;
        ConnectDB connectDB=new ConnectDB();
        String sql = "SELECT COUNT(*) FROM `khachhang`";
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
//    Kiểm tra khách hàng có tồn tại chưa
    public boolean ttKhachHang(String sdt){
        if (searchKhachHang(sdt)==null) {
            return false;
        }
        return true;
    }
}
