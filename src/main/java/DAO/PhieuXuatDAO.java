package DAO;

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
        String qry = "SELECT * FROM `phieuxuat` WHERE TONTAI = 1";
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
            System.out.println("Lỗi truy vấn phiếu xuất !!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return pxArrayList;
    }

    public boolean add(PhieuXuat_DTO px) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `phieuxuat` (`MAPHIEUXUAT`, `MANV`, `MAKH`, `TONGTIEN`, `LYDO` ,`GHICHU`, `TONTAI`) VALUES "
                        + "('" + px.getMaPhieuXuat()
                        + "','" + px.getMaNV()
                        + "','" + px.getMaKH()
                        + "'," + px.getTongTien()
                        + ",'" + px.getLyDo()
                        + "','" + px.getGhiChu()
                        + "','1')");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(PhieuXuat_DTO px) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `phieuxuat` SET TONTAI = 0 WHERE `MAPHIEUXUAT` = '" + px.getMaPhieuXuat() + "'");
        connectDB.closeConnect();
        return success;
    }


    public boolean update(String mapx,double thanhtien) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `phieuxuat` SET "       
                        + " `TONGTIEN` = '" + thanhtien
                        + "' WHERE `MAPHIEUXUAT`='" + mapx + "'");
        connectDB.closeConnect();
        return success;
    }

    public ArrayList<PhieuXuat_DTO> searchPhieuXuat(String maPhieuXuat, String maNV, String maKH) {
        ArrayList<PhieuXuat_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();

        StringBuilder qry = new StringBuilder("SELECT * FROM `phieuxuat` WHERE TONTAI = 1");

        if (maPhieuXuat != null && !maPhieuXuat.isEmpty()) {
            qry.append(" AND `MAPHIEUXUAT` =  '" + maPhieuXuat + "'");
        }
        if (maNV != null && !maNV.isEmpty()) {
            qry.append(" AND `MANV` LIKE '%" + maNV + "%'");
        }

        if (maKH != null && !maKH.isEmpty())
            qry.append(" AND `MAKH` = '" + maKH + "'");

        ResultSet rSet = connectDB.sqlQuery(qry.toString());

        try {
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
                    ds.add(px);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
    public int laySoLuongPhieuXuat() {
        ConnectDB connectDB = new ConnectDB();
        int soLuong = 0;
        String qry = "SELECT COUNT(*) FROM `phieuxuat` WHERE TONTAI = 1";
        ResultSet rSet = null;
    
        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null && rSet.next()) {
                soLuong = rSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn số lượng Phiếu Xuất!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return soLuong;
    }
    public boolean checkExist(String mapx) {
        ConnectDB connectDB = new ConnectDB();
        boolean flag = true;
        int count = 0;
        String qry = "SELECT COUNT(*) FROM `chitiet_phieuxuat` WHERE TONTAI = 1 AND MAPHIEUXUAT = '" + mapx +"'";
        ResultSet rSet = null;
    
        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null && rSet.next()) {
                count = rSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn số lượng Phiếu Xuất!!!");
            e.printStackTrace();
        }
        if(count != 0)
            flag = false;
        connectDB.closeConnect();
        System.out.println(flag);
        return flag;
    }
    
}
