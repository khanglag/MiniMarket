/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.PhieuChi_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class PhieuChiDAO {
    public PhieuChiDAO() {
    }

    /**
     * @return
     */
    public ArrayList<PhieuChi_DTO> ReadPhieuChi() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<PhieuChi_DTO> pcArrayList = new ArrayList<>();
        String qry = "SELECT * FROM `phieuchi` WHERE TONTAI = 1";
        ResultSet rSet = null;

        try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    PhieuChi_DTO pc = new PhieuChi_DTO(
                            rSet.getString("MAPHIEUCHI"),
                            rSet.getDouble("SOTIEN"),
                            rSet.getString("MANV"),
                            rSet.getDate("THOIGIANCHI").toLocalDate(),
                            rSet.getNString("LYDO"),
                            rSet.getNString("GHICHU"),
                            rSet.getBoolean("TONTAI"));
                    pcArrayList.add(pc);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return pcArrayList;
    }

    public boolean add(PhieuChi_DTO pc) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `phieuchi`(`MAPHIEUCHI`, `SOTIEN`, `MANV`, `THOIGIANCHI`,`LYDO`,`GHICHU`, `TONTAI`) VALUES "
                        + "('" + pc.getMaPhieuChi()
                        + "','" + pc.getSoTien()
                        + "','" + pc.getMaNV()
                        + "','" + pc.getThoiGianChi()
                        + "','" + pc.getLyDo()
                        + "','" + pc.getGhiChu()
                        + "',1)");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(PhieuChi_DTO pc) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        String sql = "UPDATE `phieuchi` SET TONTAI = 0 WHERE `MAPHIEUCHI` = '" + pc.getMaPhieuChi() + "'";
        success = connectDB.sqlUpdate(sql);
        connectDB.closeConnect();
        return success;
    }

    public boolean update(PhieuChi_DTO pc) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `phieuchi` SET "
                        + " `SOTIEN` = " + pc.getSoTien() + ","
                        + " `LYDO` = '" + pc.getLyDo()
                        + "' WHERE `MAPHIEUCHI` = '" + pc.getMaPhieuChi() + "'");
        connectDB.closeConnect();
        return success;
    }
    public ArrayList<PhieuChi_DTO> searchPhieuChi(String maPhieuChi, LocalDate thoiGianChi) {
        ArrayList<PhieuChi_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        StringBuilder qry = new StringBuilder("SELECT * FROM `phieuchi` WHERE TONTAI = 1");

        if (maPhieuChi != null && !maPhieuChi.isEmpty()) {
            qry.append(" AND `MAPHIEUCHI` =  '" + maPhieuChi + "'");
        }

        if (thoiGianChi != null) {
            qry.append(" AND DATE(`THOIGIANCHI`) = '" + thoiGianChi + "'");
        }
        

        ResultSet rSet = connectDB.sqlQuery(qry.toString());

        try {
            if (rSet != null) {
                while (rSet.next()) {
                    PhieuChi_DTO pc = new PhieuChi_DTO(
                            rSet.getString("MAPHIEUCHI"),
                            rSet.getDouble("SOTIEN"),
                            rSet.getString("MANV"),
                            rSet.getDate("THOIGIANCHI").toLocalDate(),
                            rSet.getNString("LYDO"),
                            rSet.getNString("GHICHU"),
                            rSet.getBoolean("TONTAI"));
                    ds.add(pc);
                }
                
            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
    
}
