package DAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import DAO.NhanVienDAO;
import DTO.ChiTietHoaDon_DTO;
import DTO.HoaDon_DTO;
import DTO.NhaCungCap_DTO;
import DTO.NhanVien_DTO;

public class TestHangHoaDAO {
    public static void main(String[] args) {
        KhachHangDAO dAO= new KhachHangDAO();
        System.out.println(dAO.searchKhachHang("0000002", "0358808913").toString());
    }
}