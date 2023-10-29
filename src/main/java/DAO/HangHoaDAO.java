package DAO;

import DTO.HangHoa_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnectDB.ConnectDB;

public class HangHoaDAO {
    public HangHoaDAO() {
    }

    public ArrayList<HangHoa_DTO> ReadHangHoa() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<HangHoa_DTO> hhArrayList = new ArrayList<>();
        String qry = "SELECT * FROM `hanghoa` WHERE TONTAI = 1";
        ResultSet rSet = null;

        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    HangHoa_DTO hanghoa = new HangHoa_DTO(
                            rSet.getString("MASP"),
                            rSet.getNString("TENSP"),
                            rSet.getString("MANH"),
                            rSet.getString("MANCC"),
                            rSet.getNString("DONVI"),
                            rSet.getDouble("GIANHAP"),
                            rSet.getDouble("GIABAN"),
                            rSet.getInt("SOLUONG"),
                            rSet.getNString("XUATXU"),
                            rSet.getString("ANHSP"),
                            rSet.getBoolean("TONTAI"));
                    hhArrayList.add(hanghoa);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn hàng hóa");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return hhArrayList;
    }

    public boolean add(HangHoa_DTO hh) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `hanghoa` (`MASP`, `TENSP`, `MANH`, `MANCC`, `DONVI`, `GIANHAP`, `GIABAN`, `SOLUONG`, `XUATXU`, `ANHSP`, `TONTAI`) VALUES ("
                        + "'" + hh.getMaSP()
                        + "','" + hh.getTenSP()
                        + "','" + hh.getMaNH()
                        + "','" + hh.getMaNCC()
                        + "','" + hh.getDonVi()
                        + "','" + hh.getGiaNhap()
                        + "','" + hh.getGiaBan()
                        + "','" + hh.getSoLuong()
                        + "','" + hh.getXuatXu()
                        + "','" + hh.getAnhSP()
                        + "', 1)");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(String maSP) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        String sql = "UPDATE `hanghoa` SET TONTAI = 0 WHERE `MASP` = " + maSP;
        success = connectDB.sqlUpdate(sql);
        connectDB.closeConnect();
        return success;
    }

    public boolean update(HangHoa_DTO hangHoa) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        String sql = "UPDATE `hanghoa` SET "
                + " `GIANHAP` = " + hangHoa.getGiaNhap() + ","
                + " `GIABAN` = " + hangHoa.getGiaBan() + ","
                + " `SOLUONG` = " + hangHoa.getSoLuong() + ","
                + " `XUATXU` = '" + hangHoa.getXuatXu() + "',"
                + " `ANHSP` = '" + hangHoa.getAnhSP() + "'"
                + " WHERE `MASP` = '" + hangHoa.getMaSP() + "'";

        success = connectDB.sqlUpdate(sql);
        connectDB.closeConnect();

        return success;
    }

    public ArrayList<HangHoa_DTO> searchHangHoa(String maHH,String tenSP, String maNH, double giaBan, String xuatXu) {
        ArrayList<HangHoa_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();

        StringBuilder qry = new StringBuilder("SELECT * FROM `hanghoa` WHERE TONTAI = 1");
        
        if (maHH != null || !maHH.isEmpty()) {
            qry.append(" AND `MASP` LIKE '%" + maHH + "%'");
        }
        if (tenSP != null && !tenSP.isEmpty()) {
            qry.append(" AND `TENSP` LIKE '%" + tenSP + "%'");
        }

        if (maNH != null && !maNH.isEmpty()) {
            qry.append(" AND `MANH` = '" + maNH + "'");
        }

        if (giaBan > 0) {
            qry.append(" AND `GIABAN` = " + giaBan);
        }

        if (xuatXu != null && !xuatXu.isEmpty()) {
            qry.append(" AND `XUATXU` LIKE '%" + xuatXu + "%'");
        }

        ResultSet rSet = connectDB.sqlQuery(qry.toString());

        try {
            if (rSet != null) {
                while (rSet.next()) {
                    HangHoa_DTO hanghoa = new HangHoa_DTO(
                            rSet.getString("MASP"),
                            rSet.getNString("TENSP"),
                            rSet.getString("MANH"),
                            rSet.getString("MANCC"),
                            rSet.getNString("DONVI"),
                            rSet.getDouble("GIANHAP"),
                            rSet.getDouble("GIABAN"),
                            rSet.getInt("SOLUONG"),
                            rSet.getNString("XUATXU"),
                            rSet.getString("ANHSP"),
                            rSet.getBoolean("TONTAI"));

                    ds.add(hanghoa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
}