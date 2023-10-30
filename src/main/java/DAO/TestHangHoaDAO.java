package DAO;

import BUS.KhachHang_BUS;
import BUS.NhanVien_BUS;
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
        NhanVien_BUS bus=new NhanVien_BUS();
        System.out.println(bus.taoMaNV("0358808913", ""));
    }
}