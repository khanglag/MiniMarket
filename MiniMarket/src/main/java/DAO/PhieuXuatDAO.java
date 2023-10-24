package DAO;

import DTO.KhachHang_DTO;
import DTO.PhieuXuat_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnectDB.ConnectDB;

public class PhieuXuatDAO {
    public PhieuXuatDAO() {
    }

    /**
     * @return
     */
    public ArrayList<PhieuXuat_DTO> ReadPhieuXuat() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<PhieuXuat_DTO> pxArrayList = new ArrayList<>();
        String qry = "SELECT * FROM phieuxuat WHERE TONTAI = 1";
        ResultSet rSet = null;

        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    PhieuXuat_DTO px = new PhieuXuat_DTO(
                            rSet.getString("MAPHIEUXUAT"),
                            rSet.getString("MANV"),
                            rSet.getString("MAKH"),
                            rSet.getDouble("TONGTIEN"),
                            rSet.getNString("LYDO"),
                            rSet.getNString("GHICHU"),
                            rSet.getBoolean("TONTAI"));
                    pxArrayList.add(px);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return pxArrayList;
    }

    public boolean add(PhieuXuat_DTO px) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `phieuxuat`(`MAPHIEUXUAT`, `MANV`, `MAKH`, `TONGTIEN`,'LYDO','GHICHU', `TONTAI`) VALUES "
                        + "('" + px.getMaPhieuXuat()
                        + "','" + px.getMaNV()
                        + "','" + px.getMaKH()
                        + "','" + px.getTongTien()
                        + "','" + px.getLyDo()
                        + "','" + px.getGhiChu()
                        + "','1')");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(PhieuXuat_DTO px) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE PHIEUXUAT SET TONTAI = 0 WHERE MAPHIEUXUAT ='" + px.getMaPhieuXuat() + "'");
        connectDB.closeConnect();
        return success;
    }

    public boolean update(PhieuXuat_DTO px) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `phieuxuat` SET "
                        + "`TONGTIEN`='" + px.getTongTien()
                        + "','LYDO ='" + px.getLyDo()
                        + "' WHERE `MAPHIEUXUAT`='" + px.getMaPhieuXuat() + "'");
        connectDB.closeConnect();
        return success;
    }

    public PhieuXuat_DTO searchPhieuXuat(String maPhieuXuat) {
        PhieuXuat_DTO phieuxuat = null;
        String qry = "SELECT * FROM `phieuxuat` WHERE TONTAI = 1 AND MAPHIEUXUAT = '" + maPhieuXuat + "'";
        ConnectDB connectDB = new ConnectDB();
        ResultSet rSet = connectDB.sqlQuery(qry);
        try {
            if (rSet != null) {
                while (rSet.next()) {
                    phieuxuat = new PhieuXuat_DTO(
                            rSet.getString("MAPHIEUXUAT"),
                            rSet.getString("MANV"),
                            rSet.getString("MAKH"),
                            rSet.getDouble("TONGTIEN"),
                            rSet.getNString("LYDO"),
                            rSet.getNString("GHICHU"),
                            rSet.getBoolean("TONTAI"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuxuat;
    }
}