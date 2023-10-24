package DAO;

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
        String qry = "SELECT * FROM nhacungcap WHERE TONTAI = 1"; 
        ResultSet rSet = null;

        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    NhaCungCap_DTO ncc = new NhaCungCap_DTO(
                            rSet.getString("MANCC"),
                            rSet.getNString("TENNCC"),
                            rSet.getString("SDT"),
                            rSet.getString("DIACHI"),
                            rSet.getBoolean("TONTAI"));
                    nccArrayList.add(ncc);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return nccArrayList;
    }
    public boolean add(NhaCungCap_DTO ncc) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `nhacungcap`(`MANCC`, `TENNCC`, `SDT`, `DIACHI`, `TONTAI`) VALUES "
                        + "('" + ncc.getMaNCC()
                        + "','" + ncc.getTenNCC()
                        + "','" + ncc.getSdt()
                        + "','" + ncc.getDiaChi()
                        + "','1')"
        );
        connectDB.closeConnect();
        return success;
    }
    public boolean delete(NhaCungCap_DTO ncc) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE NHACUNGCAP SET TONTAI = 0 WHERE MANCC ='" + ncc.getMaNCC() + "'");
        connectDB.closeConnect();
        return success;
    }
    public boolean update(NhaCungCap_DTO ncc) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `nhacungcap` SET "
                        + "`TENNCC`='" + ncc.getTenNCC()
                        + "','SDT ='" + ncc.getSdt()
                        + "',`DIACHI`='" + ncc.getDiaChi()
                        + "' WHERE `MANCC`='" + ncc.getMaNCC() + "'");
        connectDB.closeConnect();
        return success;
    }
    public ArrayList<NhaCungCap_DTO> searchNCC(String tenNCC, String diaChi) {
        ArrayList<NhaCungCap_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
    
        StringBuilder qry = new StringBuilder("SELECT * FROM `nhacungcap` WHERE TONTAI = 1");
    
        if (tenNCC != null && !tenNCC.isEmpty()) {
            qry.append(" AND `TENNCC` LIKE '%").append(tenNCC).append("%'");
        }
    
        if (diaChi != null && !diaChi.isEmpty()) {
            qry.append(" AND `DIACHI` LIKE '%").append(diaChi).append("%'");
        }
    
    
        ResultSet rset = connectDB.sqlQuery(qry.toString());
    
        try {
            if (rset != null) {
                while (rset.next()) {
                    NhaCungCap_DTO ncc = new NhaCungCap_DTO(
                        rset.getString("MANCC"),
                        rset.getNString("TENNCC"),
                            rset.getString("SDT"),
                            rset.getString("DIACHI"),
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