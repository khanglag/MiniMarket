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
        int thanhtien = 0;
        int mapx = 0;
        System.out.println("UPDATE `phieuxuat` SET "       
                        + " `TONGTIEN` = '" + thanhtien
                        + "' WHERE `MAPHIEUXUAT`='" + mapx + "'");

    }
}
