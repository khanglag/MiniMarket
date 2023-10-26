package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import DTO.ChiTietKiemHang_DTO;

public class ChiTietKiemHangDAO {
    public ChiTietKiemHangDAO() {
    }

    ArrayList<ChiTietKiemHang_DTO> readDB() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<ChiTietKiemHang_DTO> ds = new ArrayList<>();
        String qry = "SELECT * FROM `chitiet_kiemhang` WHERE TONTAI = 1";
        ResultSet rSet = null;
        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    ChiTietKiemHang_DTO ct = new ChiTietKiemHang_DTO(
                            rSet.getNString("MAPHIEU"),
                            rSet.getNString("MASP"),
                            rSet.getNString("TENSP"),
                            rSet.getInt("SOLUONG"),
                            rSet.getNString("DONVI"),
                            rSet.getNString("TINHTRANGSP"),
                            true);
                    ds.add(ct);
                }
            }
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return ds;
    }
    public boolean add(ChiTietKiemHang_DTO ct) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `chitiet_kiemhang`(`MAPHIEU`, `MASP`, `TENSP`, `SOLUONG`, `DONVI`, `TINHTRANGSP`, `TONTAI`) VALUES ("
                        + "'"+ct.getMaPhieu()+"',"
                        + "'"+ct.getMaSP()+"',"
                        + "'"+ct.getTenSP()+"',"
                        + "'"+ct.getSoLuong()+"',"
                        + "'"+ct.getDonVi()+"',"
                        + "'"+ct.getTinhTrangSP()+"',"
                        + "'1')");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(ChiTietKiemHang_DTO ct) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `chitiet_kiemhang` SET TONTAI = 0 WHERE MAPHIEU ='" + ct.getMaPhieu() + "' AND MASP='"+ct.getMaSP()+"");
        connectDB.closeConnect();
        return success;
    }

    public boolean update(ChiTietKiemHang_DTO ct) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `chitiet_kiemhang` SET "
                        + "`TENSP`='"+ct.getTenSP()+"',"
                        + "`SOLUONG`='"+ct.getSoLuong()+"',"
                        + "`DONVI`='"+ct.getDonVi()+"',"
                        + "`TINHTRANGSP`='"+ct.getTinhTrangSP()+"',"
                        + "`TONTAI`='1' "
                        + "WHERE `MAPHIEU`='"+ct.getMaPhieu()+"' "
                        + "AND "+ "`MASP`='"+ct.getMaSP()+"',");
        connectDB.closeConnect();
        return success;
    }

    public ArrayList<ChiTietKiemHang_DTO> searchHangHoa(String maPhieu, String maSP, String tenSP, int soLuong,
            String donVi, String tinhTrangSP, boolean tonTai) {
        ArrayList<ChiTietKiemHang_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();

        StringBuilder qry = new StringBuilder("SELECT * FROM `chitiet_kiemhang` WHERE TONTAI = 1");

        if (maPhieu != null && !maPhieu.isEmpty()) {
            qry.append(" AND `MAPHIEU` LIKE '%").append(maPhieu).append("%'");
        }
        if (maSP != null && !maSP.isEmpty()) {
            qry.append(" AND `MASP` LIKE '%").append(maSP).append("%'");
        }
        if (tenSP != null && !tenSP.isEmpty()) {
            qry.append(" AND `TENSP` LIKE '%").append(tenSP).append("%'");
        }
        ResultSet rSet = connectDB.sqlQuery(qry.toString());

        try {
            if (rSet != null) {
                while (rSet.next()) {
                    ChiTietKiemHang_DTO ct = new ChiTietKiemHang_DTO(
                            rSet.getNString("MAPHIEU"),
                            rSet.getNString("MASP"),
                            rSet.getNString("TENSP"),
                            rSet.getInt("SOLUONG"),
                            rSet.getNString("DONVI"),
                            rSet.getNString("TINHTRANGSP"),
                            true);
                    ds.add(ct);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }
}
