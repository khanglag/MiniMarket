/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import java.util.ArrayList;
import DTO.PhanQuyen_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class PhanQuyenDAO {
    public PhanQuyenDAO() {

    }

    public ArrayList<PhanQuyen_DTO> readBD() {
        ConnectDB connectDB = new ConnectDB();
        ArrayList<PhanQuyen_DTO> List_pq = new ArrayList<>();
        String qry = "SELECT *FROM `phanquyen` WHERE TONTAI = 1";
        ResultSet rs = null;
        try {
            rs = connectDB.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    PhanQuyen_DTO qp = new PhanQuyen_DTO(
                            rs.getNString("MAQUYEN"),
                            rs.getNString("TENQUYEN"),
                            rs.getBoolean("TONTAI"));
                    List_pq.add(qp);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn !!!");
            e.printStackTrace();
        }
        return List_pq;
    }

    public boolean add(PhanQuyen_DTO pq) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(""
                + "INSERT INTO `phanquyen`(`MAQUYEN`, `TENQUYEN`, `TONTAI`) VALUES ("
                + "'" + pq.getMaQuyen() + "',"
                + "'" + pq.getTenQuyen() + "',"
                + "'1')");
        connectDB.closeConnect();
        return success;

    }

    public boolean delete(PhanQuyen_DTO pq) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate(" UPDATE `phanquyen` SET TONTAI = 0 WHERE `MAQUYEN` =  '" + pq.getMaQuyen() + "'");
        connectDB.closeConnect();
        return success;
    }

    public boolean update(PhanQuyen_DTO pq) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate(" UPDATE `phanquyen` SET "
                        + " TENQUYEN = '" + pq.getTenQuyen()
                        + "' WHERE `MAQUYEN` = '" + pq.getMaQuyen() + "'");
        connectDB.closeConnect();
        return success;
    }

    public ArrayList<PhanQuyen_DTO> search(String maQuyen, String tenQuyen) {
        ArrayList<PhanQuyen_DTO> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        StringBuilder qry = new StringBuilder("SELECT * FROM `phanquyen` WHERE TONTAI = 1");

        if (maQuyen != null && !maQuyen.isEmpty()) {
            qry.append(" AND `MAQUYEN` = '" + maQuyen + "'");
        }

        if (tenQuyen != null && !tenQuyen.isEmpty()) {
            qry.append(" AND `TENQUYEN` LIKE '%" + tenQuyen + "%'");
        }

        ResultSet rs = connectDB.sqlQuery(qry.toString());

        try {
            if (rs != null) {
                while (rs.next()) {
                    PhanQuyen_DTO pq = new PhanQuyen_DTO(
                            rs.getNString("MAQUYEN"),
                            rs.getNString("TENQUYEN"),
                            rs.getBoolean("TONTAI"));
                    ds.add(pq);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }

}
