/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HangHoa_DTO;
import static Handle.Convert.convertMa;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class HoaDon_BUS {
    public HoaDon_BUS(){
    }
    HoaDonDAO dao =new HoaDonDAO();
    public String maHoaDonMoi(){
        return convertMa(dao.demSoHoaDon()+1);
    }
}
