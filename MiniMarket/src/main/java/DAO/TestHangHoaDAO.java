package DAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import DAO.NhanVienDAO;
import DTO.ChiTietHoaDon_DTO;
import DTO.NhanVien_DTO;

public class TestHangHoaDAO {
    public static void main(String[] args) {
        ChiTietHoaDonDAO cthddto=new ChiTietHoaDonDAO();
        ArrayList<ChiTietHoaDon_DTO> A;
        A=cthddto.readBD();
        ChiTietHoaDon_DTO temp= new ChiTietHoaDon_DTO(1, "4902430556781", 1, true);
        
        cthddto.update(temp);
        for (ChiTietHoaDon_DTO chiTietHoaDon_DTO : A) {
            System.out.println(chiTietHoaDon_DTO.toString());
        }
    }
}