/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVien_DTO;
import static Handle.Convert.convertMa;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class NhanvienBus {

    public NhanvienBus() {
    }

    NhanVienDAO dAO = new NhanVienDAO();

    public ArrayList<NhanVien_DTO> dsNhanVien() {
        return dAO.ReadNhanviens();
    }

    public boolean xoaNhanVien(String maNV) {
        return dAO.delete(maNV);
    }

    public boolean suaNhanVien(String maNV, String sdt, String diaChi, String maPQ, String email) {
        return dAO.update(maNV, sdt, diaChi, maPQ, email);
    }
    
    public ArrayList<NhanVien_DTO> timNhanVien(String tenNV){
        return dAO.searchNhanVien(null, tenNV, null);
    }

    public boolean themNhanVien(String tenNV, LocalDate ngaySinh, String gioiTinh, String sdt, String cccd,
            String email, String diaChi, String maPQ) {
        NhanVien_DTO dTO = new NhanVien_DTO(taoMaNV(sdt, maPQ), tenNV, ngaySinh, gioiTinh, cccd, sdt, email, diaChi,
                maPQ, true);
        return dAO.add(dTO);
    }

    public String taoMaNV(String sdt, String maPQ) {
        int startIndex = sdt.length() - 6;
        String ma = "";
        String subsdt = sdt.substring(startIndex);
        switch (maPQ) {
            case "NVBH203":
            case "NVTK203":
                ma += "A";
                break;
            default:
                ma += "B";
        }
        while (dAO.ttMaNV(ma + subsdt) == true) {
            subsdt = convertMa(Integer.parseInt(subsdt) + 1);
            subsdt = subsdt.substring(1);
            System.out.println("sub sdt" + subsdt);
        }
        return (ma += subsdt);
    }
}
