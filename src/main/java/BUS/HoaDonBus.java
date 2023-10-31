/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import Controller.TaiKhoanController;
import DAO.HoaDonDAO;
import DTO.HangHoa_DTO;
import DTO.HoaDon_DTO;
import static Handle.Convert.convertMa;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class HoaDonBus {
    public HoaDonBus(){
    }
    HoaDonDAO dao =new HoaDonDAO();
    public ArrayList<HoaDon_DTO> dsHoaDon(){
        return dao.ReadHoadons();
    }
    public boolean taoHoaDon(String maKH){
        return dao.add(dao.demSoHoaDon()+1, "A070103", LocalDate.now(), "0000001", 0, 0, 0, true);
    }
}
