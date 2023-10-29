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
import DTO.PhieuNhap_DTO;

public class test {
    public static void main(String[] args) {
//        PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
//        PhieuNhap_DTO pq = new PhieuNhap_DTO("0000003","A038645","NCCLADY",LocalDate.now(),0.08,15,15,"da duyet",true);
//        boolean success = phieuNhapDAO.add(pq);
//        System.out.println("Succes" + success);
        // Search
        // ArrayList <PhieuNhap_DTO> searchResult = phieuNhapDAO.searchPhieuNhap(null,null,null,null,"da duyet");
        // System.out.println("Search Result:");
        // for (PhieuNhap_DTO product : searchResult) {
        // System.out.println(product);
        // }
        KhachHangDAO dAO=new KhachHangDAO();
        dAO.update("0358808913", "244 Âu Dương Lân");
    }
}
