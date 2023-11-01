package DAO;

import ConnectDB.ConnectDB;
import DTO.PhieuNhap_DTO;
import DTO.TaiKhoan_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class TaiKhoanDAO {
    public TaiKhoanDAO() {
    }
    public ArrayList<TaiKhoan_DTO> ReadTaiKhoan() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<TaiKhoan_DTO> tkArrayList = new ArrayList<>();
        String qry = "SELECT * FROM `taikhoan` WHERE TONTAI = 1";
        ResultSet rSet = null;

        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    TaiKhoan_DTO tk = new TaiKhoan_DTO(
                        rSet.getNString("MANV"),
                        rSet.getNString("MATKHAU"),
                        rSet.getNString("PHANQUYEN"),
                        rSet.getBoolean("TONTAI"));
                tkArrayList.add(tk);
                    
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return tkArrayList;
    }


}
