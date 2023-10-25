package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import DTO.PhieuXuat_DTO;
import DTO.ChiTietHoaDon_DTO;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.NhaCungCap_DTO;
import DTO.PhieuChi_DTO;

public class test {
    public static void main(String[] args) {
        PhieuChiDAO phieuChiDAO = new PhieuChiDAO();
        // PhieuChi_DTO pc = new PhieuChi_DTO("0000003",200000,"B041003",LocalDate.now(),"Chi tiền hàng lỗi","",true);
        // boolean success = phieuChiDAO.update(pc);
        // System.out.println("Succes" + success);
        // Search
        ArrayList <PhieuChi_DTO> searchResult = phieuChiDAO.searchPhieuChi("0000001",null);
        System.out.println("Search Result:");
        for (PhieuChi_DTO product : searchResult) {
        System.out.println(product);
        }

    }
}
