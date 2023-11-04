
package DAO;

import ConnectDB.ConnectDB;
import DTO.TaiKhoan_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                            rSet.getNString("MAPQ"),
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

    public boolean add(TaiKhoan_DTO taiKhoan) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                " INSERT INTO `taikhoan` (`MANV` , `MATKHAU`, `MAPQ`, `TONTAI`) VALUES "
                        + "( '" + taiKhoan.getMaNV()
                        + "','" + taiKhoan.getMatKhau()
                        + "','" + taiKhoan.getMaPQ()
                        + "','1')");
        connectDB.closeConnect();
        return success;
    }
    public boolean doiMatKhau(String maNV, String matKhau) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = false;
        String updateQuery = "UPDATE `taikhoan` SET `MATKHAU` = '" + matKhau + "' WHERE `MANV` = '" + maNV + "'";
        success = connectDB.sqlUpdate(updateQuery);
        connectDB.closeConnect();

        return success;
    }

    public boolean delete(TaiKhoan_DTO taiKhoan) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB
                .sqlUpdate(" UPDATE `taikhoan`  SET `TONTAI` = 0 WHERE `MANV` = '" + taiKhoan.getMaNV() + "'");
        connectDB.closeConnect();
        return success;

    }
    
    public boolean isTaiKhoanExisted(String maNV){
        ConnectDB connectDB = new ConnectDB();
        String qry = "SELECT 1 FROM `taikhoan` WHERE `MANV` = '" + maNV  + "' AND `TONTAI` = 1";
         ResultSet rSet = connectDB.sqlQuery(qry);
         if( rSet != null) {
            try {
                return rSet.next();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
         }
         return false;
    } 
    public TaiKhoan_DTO Account(String manv) {
        ConnectDB connectDB = new ConnectDB();
        TaiKhoan_DTO tk = null;
        String qry = "SELECT * FROM `taikhoan` WHERE TONTAI = 1 and MANV = '" + manv +"'";
        ResultSet rSet = null;

        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    tk = new TaiKhoan_DTO(
                            rSet.getNString("MANV"),
                            rSet.getNString("MATKHAU"),
                            rSet.getNString("MAPQ"),
                            rSet.getBoolean("TONTAI"));
                    return tk;

                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return tk;
    }
    public TaiKhoan_DTO searchTaiKhoan(String manv) {
        ConnectDB connectDB = new ConnectDB();
        TaiKhoan_DTO tk = null;
        String qry = "SELECT * FROM `taikhoan` WHERE MANV = '" + manv +"'";
        ResultSet rSet = null;

        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    tk = new TaiKhoan_DTO(
                            rSet.getNString("MANV"),
                            rSet.getNString("MATKHAU"),
                            rSet.getNString("MAPQ"),
                            rSet.getBoolean("TONTAI"));
                    return tk;

                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return tk;
    }
}
