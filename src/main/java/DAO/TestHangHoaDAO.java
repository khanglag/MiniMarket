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
        HoaDonDAO hoaDonDAO = new HoaDonDAO();
        ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
        HoaDon_DTO hoaDon_DTO = new HoaDon_DTO(2, "A000003", LocalDate.now(), "0000001", 8000, 8000, 9000, 1000, true);
        boolean succes = hoaDonDAO.add(hoaDon_DTO);
        // Create a test ChiTietHoaDon_DTO object with sample data
        // ChiTietHoaDon_DTO testChiTiet = new ChiTietHoaDon_DTO(2, "8809541033891", 1, true);

        // // Attempt to add the testChiTiet to the database
        // boolean success = chiTietHoaDonDAO.add(testChiTiet);

        // Check if the addition was successful
        if (succes) {
            System.out.println("ChiTietHoaDon_DTO added successfully.");
        } else {
            System.out.println("Failed to add ChiTietHoaDon_DTO.");
        }
    }
}