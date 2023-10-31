/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.NhomHang_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class NhomHangDAO {
    public NhomHangDAO() {
    }

    public ArrayList<NhomHang_DTO> readBD() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<NhomHang_DTO> dsnh = new ArrayList<>();
        String qry = "SELECT * FROM `nhomhang` WHERE TONTAI = 1";
        ResultSet rSet = null;
        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    NhomHang_DTO nh = new NhomHang_DTO(
                            rSet.getNString("MANH"),
                            rSet.getNString("TENNH"),
                            rSet.getBoolean("TONTAI"));
                    dsnh.add(nh);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn hàng hóa");
            e.printStackTrace();
        }
        return dsnh;
    }

    public boolean add(String maNH, String tenNH, boolean tonTai) {
        NhomHang_DTO nh=new NhomHang_DTO(maNH, tenNH, tonTai);
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(""
                + "INSERT INTO `nhomhang`(`MANH`, `TENNH`, `TONTAI`) VALUES ('"
                + "" + nh.getMaNH() + "',"
                + "'" + nh.getTenNH() + "',"
                + "'1')");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(String getMaNH) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `nhomhang` SET TONTAI = 0 WHERE `MANH`='" + getMaNH + "'");
        connectDB.closeConnect();
        return success;
    }

    public boolean update(String maNH, String tenNH) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `nhomhang` SET `TENNH`='" + nh.getTenNH() + "' WHERE `MANH`='" + nh.getMaNH() + "'");
        connectDB.closeConnect();
        return success;
    }

    public ArrayList<NhomHang_DTO> searchHangHoa(String maNH, String tenNH, boolean tonTai) {
        ArrayList<NhomHang_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();

        StringBuilder qry = new StringBuilder("SELECT * FROM `nhomhang` WHERE TONTAI = 1");

        if (maNH != null && !maNH.isEmpty()) {
            qry.append(" AND `MANH` = '").append(maNH).append("'");
        }

        if (tenNH != null && !tenNH.isEmpty()) {
            qry.append(" AND `TENNH` = '").append(tenNH).append("'");
        }

        ResultSet rSet = connectDB.sqlQuery(qry.toString());
        try {
            if (rSet != null) {
                while (rSet.next()) {
                    NhomHang_DTO nh = new NhomHang_DTO(
                            rSet.getNString("MANH"),
                            rSet.getNString("TENNH"),
                            rSet.getBoolean("TONTAI"));
                    ds.add(nh);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
}
