/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDon_DTO;
import DTO.HoaDon_DTO;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class ChiTietHoaDonBus {

    public ChiTietHoaDonBus() {
    }
    
    ChiTietHoaDonDAO dao =new ChiTietHoaDonDAO();
    public ArrayList<ChiTietHoaDon_DTO> dsHD(){
        return dao.readBD();
    }
    public ArrayList<ChiTietHoaDon_DTO> dsHD(String maHD){
        return dao.readBD();
    }
    public boolean themCTHD(int soHD, String maSP,int soluong){
        ChiTietHoaDon_DTO dto =new ChiTietHoaDon_DTO(soHD, maSP, soluong, true);
        return dao.add(dto);
    }
}
