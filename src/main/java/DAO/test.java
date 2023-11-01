package DAO;

import BUS.KhachHangBus;
import java.time.LocalDate;
import java.util.ArrayList;
import DTO.PhieuXuat_DTO;
import DTO.ChiTietHoaDon_DTO;
import DTO.ChiTietPhieuNhap_DTO;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.KhachHang_DTO;
import DTO.NhaCungCap_DTO;
import DTO.PhanQuyen_DTO;
import DTO.PhieuChi_DTO;
import DTO.PhieuNhap_DTO;
import java.sql.ResultSet;

public class test {
    public static void main(String[] args) {
// <<<<<<< lag
//         String maPhieuXuat="000001";
//         String maNV="A03856";
//         String maKH="000001";
//         StringBuilder qry = new StringBuilder("SELECT * FROM `phieuxuat` WHERE TONTAI = 1");

//         if (maPhieuXuat != null && !maPhieuXuat.isEmpty()) {
//             qry.append(" or `MAPHIEUXUAT` =  '" + maPhieuXuat + "'");
//         }
//         if (maNV != null && !maNV.isEmpty()) {
//             qry.append(" or `MANV` LIKE '%" + maNV + "%'");
//         }

//         if (maKH != null && !maKH.isEmpty())
//             qry.append(" or `MAKH` = '" + maKH + "'");

//         System.out.println(qry.toString());

       
// =======
        HangHoaDAO dAO=new HangHoaDAO();
        dAO.add("4902430556782", "Biển vô cực","0000004", "NCCDYQN", "gói", 0, 0, 0,"VietNam", "/images/bienvocuc.jpg", true);
// >>>>>>> main
    }
}
