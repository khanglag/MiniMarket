/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDon_DTO;
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
}
