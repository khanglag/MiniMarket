/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.ConnectDB;
import GUI.Login.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class TaiKhoanDAO {

    public TaiKhoanDAO() {
    }
    
    public ArrayList<TaiKhoan> readBD(){
        ConnectDB connectDB = new ConnectDB();
        ArrayList<TaiKhoan> tkArrayList = new ArrayList<>();
        String qry = "SELECT * FROM `taikhoan` WHERE TONTAI = 1";
        ResultSet rSet = null;
         try {
            rSet = connectDB.sqlQuery(qry);
            if (rSet != null) {
                while (rSet.next()) {
                    TaiKhoan tk = new TaiKhoan(
                            rSet.getString("MANV"),
                            rSet.getString("MATKHAU"),
                            rSet.getString("MAPQ"),
                            rSet.getBoolean("TONTAI"));
                    tkArrayList.add(tk);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn tài khoản !!!!");
            e.printStackTrace();
        }
        connectDB.closeConnect();
        return tkArrayList;
    }

    public boolean add(TaiKhoan tk) {
        boolean success = false;
        ConnectDB connectDB = new ConnectDB();
        success = connectDB.sqlUpdate(
                "INSERT INTO `taikhoan`(`MANV`, `MATKHAU`, `MAPQ`, `TONTAI`) VALUES ("
                        + "'"+tk.getTen_dn()+"',"
                        + "'"+tk.getMat_khau()+"',"
                        + "'"+tk.getQuyen()+"',"
                        + "'1')");
        connectDB.closeConnect();
        return success;
    }

    public boolean delete(TaiKhoan tk) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `phieuxuat` SET TONTAI = 0 WHERE `MANV`= '" + tk.getTen_dn() + "'");
        connectDB.closeConnect();
        return success;
    }

    public boolean update(TaiKhoan tk) {
        ConnectDB connectDB = new ConnectDB();
        boolean success = connectDB
                .sqlUpdate("UPDATE `taikhoan` SET "
                        + "`MATKHAU`='"+tk.getMat_khau()+"',"
                        + "`MAPQ`='"+tk.getQuyen()+"',"
                        + " WHERE `MANV`='"+tk.getTen_dn()+"'");
        connectDB.closeConnect();
        return success;
    }


    public ArrayList<TaiKhoan> searchTaiKhoan(TaiKhoan tk) {
        ArrayList<TaiKhoan> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();

        StringBuilder qry = new StringBuilder("SELECT * FROM `taikhoan` WHERE TONTAI = 1");

        if (tk.getTen_dn() != null && !tk.getTen_dn().isEmpty()) {
            qry.append(" AND `MANV` =  '" + tk.getTen_dn() + "'");
        }
        if (tk.getMat_khau() != null && !tk.getMat_khau().isEmpty()) {
            qry.append(" AND `MATKHAU` LIKE '%" + tk.getMat_khau() + "%'");
        }

        if (tk.getQuyen() != null && !tk.getMat_khau().isEmpty())
            qry.append(" AND `MAPQ` = '" + tk.getMat_khau() + "'");

        ResultSet rSet = connectDB.sqlQuery(qry.toString());

        try {
            if (rSet != null) {
                while (rSet.next()) {
                    TaiKhoan tkt = new TaiKhoan(
                            rSet.getString("MANV"),
                            rSet.getString("MATKHAU"),
                            rSet.getString("MAPQ"),
                            rSet.getBoolean("TONTAI"));
                    ds.add(tkt);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }
    public TaiKhoan searchTaiKhoan(String tenDN) {
        ArrayList<TaiKhoan> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();

        StringBuilder qry = new StringBuilder("SELECT * FROM `taikhoan` ");

        if (tenDN != null && !tenDN.isEmpty()) {
            qry.append(" AND `MANV` =  '" + tenDN + "'");
        }
        ResultSet rSet = connectDB.sqlQuery(qry.toString());
        TaiKhoan tkt = new TaiKhoan();
        try {
            if (rSet != null) {
                while (rSet.next()) {
                            tkt = new TaiKhoan(
                            rSet.getString("MANV"),
                            rSet.getString("MATKHAU"),
                            rSet.getString("MAPQ"),
                            rSet.getBoolean("TONTAI"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tkt;
    }
}
