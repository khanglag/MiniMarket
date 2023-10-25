package DAO;

import DTO.ChiTietHoaDon_DTO;
import DTO.HangHoa_DTO;
import DTO.NhaCungCap_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnectDB.ConnectDB;

public class NhaCungCapDAO {
    public NhaCungCapDAO() {
    }

    public ArrayList<NhaCungCap_DTO> ReadNhaCungCap() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<NhaCungCap_DTO> nccArrayList = new ArrayList<>();
        String qry = "SELECT * FROM 'nhacungcap' WHERE TONTAI = 1";
        ResultSet rSet = null;
        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    NhaCungCap_DTO ncc = new NhaCungCap_DTO(
                            rSet.getString("MANCC"),
                            rSet.getNString("TENNCC"),
                            rSet.getString("SDT"),
                            rSet.getNString("DIACHI"),
                            rSet.getBoolean("TONTAI"));
                    nccArrayList.add(ncc);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn  nhà cung cấp !!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return nccArrayList;
    }

    public boolean add(NhaCungCap_DTO ncc) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `nhacungcap` (`MANCC`, `TENNCC`, `SDT`, `DIACHI`, `TONTAI`) VALUES "
                        + "('" + ncc.getMaNCC()
                        + "','" + ncc.getTenNCC()
                        + "','" + ncc.getSdt()
                        + "','" + ncc.getDiaChi()
                        + "','1')");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(NhaCungCap_DTO ncc) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        String sql = "UPDATE `nhacungcap` SET TONTAI = 0 WHERE `MANCC` = '" + ncc.getMaNCC() + "'";
        success = connectDB.sqlUpdate(sql);
        connectDB.closeConnect();
        return success;
    }

    public boolean update(NhaCungCap_DTO ncc) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        String sql = " UPDATE `nhacungcap` SET "
                + " `SDT` =  '" + ncc.getSdt() + "',"
                + " `DIACHI` =  '" + ncc.getDiaChi() + "'"
                + " WHERE  `MANCC` = '" + ncc.getMaNCC() + "'";
        success = connectDB.sqlUpdate(sql);
        connectDB.closeConnect();

        return success;
    }

    public ArrayList<NhaCungCap_DTO> searchNCC(String tenNCC, String sdt, String diaChi) {
        ArrayList<NhaCungCap_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();

        StringBuilder qry = new StringBuilder("SELECT * FROM `nhacungcap` WHERE TONTAI = 1");

        if (tenNCC != null && !tenNCC.isEmpty()) {
            qry.append(" AND `TENNCC` LIKE '%" + tenNCC + "%'");
        }
        if (sdt != null && !sdt.isEmpty())
            qry.append(" AND `SDT` = '" + sdt + "'");

        if (diaChi != null && !diaChi.isEmpty()) {
            qry.append(" AND `DIACHI` LIKE '%" + diaChi + "%'");
        }

        ResultSet rset = connectDB.sqlQuery(qry.toString());

        try {
            if (rset != null) {
                while (rset.next()) {
                    NhaCungCap_DTO ncc = new NhaCungCap_DTO(
                            rset.getString("MANCC"),
                            rset.getNString("TENNCC"),
                            rset.getString("SDT"),
                            rset.getNString("DIACHI"),
                            rset.getBoolean("TONTAI"));
                    ds.add(ncc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
}