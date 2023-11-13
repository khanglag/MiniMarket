package DAO;

import BUS.KhachHangBus;
import java.time.LocalDate;
import java.util.ArrayList;
import DTO.PhieuXuat_DTO;
import DTO.TaiKhoan_DTO;
import DTO.ChiTietHoaDon_DTO;
import DTO.ChiTietPhieuNhap_DTO;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.KhachHang_DTO;
import DTO.NhaCungCap_DTO;
import DTO.NhanVien_DTO;
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
        // NhanVienDAO nv = new NhanVienDAO();
        // NhanVien_DTO d = new NhanVien_DTO("A000004","Ke",LocalDate.now(),"nam","068000000011","0339708977","cuong@gmail.com","Tan son","NVTK203",true);
        // nv.add(d);
//        TaiKhoanDAO tk = new TaiKhoanDAO();
//        String maNV = "A038645";
//        String mk = "051203";
//        TaiKhoan_DTO  dto = new TaiKhoan_DTO(maNV,mk ,null, true);
//        tk.add(dto);
// >>>>>>> main
        PhieuYeuCauNhapDAO pyc = new PhieuYeuCauNhapDAO();
        System.out.println(        pyc.searchCTPN("0000001", "8657882990341", "Nước giặt Downy vườn hoa thơm ngát túi 3.05kg", "Việt Nam"));
    }
}
