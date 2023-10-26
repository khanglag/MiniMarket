package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import DTO.PhieuXuat_DTO;
import DTO.ChiTietHoaDon_DTO;
import DTO.ChiTietPhieuNhap_DTO;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.NhaCungCap_DTO;
import DTO.PhanQuyen_DTO;
import DTO.PhieuChi_DTO;

public class test {
    public static void main(String[] args) {
        ChiTietPhieuNhapDAO chiTietPhieuNhapDAO = new ChiTietPhieuNhapDAO();
        // ChiTietPhieuNhap_DTO pq = new ChiTietPhieuNhap_DTO("0000002","8935162895621","Gạo thơm đặc sản Neptune ST25 túi 5kg",0.08,"Việt Nam",null,15,"túi",120000,120000*5,true);
        // boolean success = chiTietPhieuNhapDAO.updateCTPN(pq);
        // System.out.println("Succes" + success);
        // Search
        ArrayList <ChiTietPhieuNhap_DTO> searchResult = chiTietPhieuNhapDAO.searchCTPN(null,"8935162895621",null,null);
        System.out.println("Search Result:");
        for (ChiTietPhieuNhap_DTO product : searchResult) {
        System.out.println(product);
        }

    }
}
