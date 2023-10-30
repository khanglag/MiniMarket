/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HangHoaDAO;
import DTO.HangHoa_DTO;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class HangHoa_BUS {
    public HangHoa_BUS(){
    }
    ArrayList<HangHoa_DTO> ds;
    HangHoaDAO dao= new HangHoaDAO();
    public ArrayList<HangHoa_DTO> itemData(){
        return dao.ReadHangHoa();
    }
    public int ktSoLuong(String maHang){
        ds= dao.searchHangHoa(maHang, null, null, 0, null);
        return ds.get(0).getSoLuong();
    }
    public ArrayList<HangHoa_DTO> timHangHoa(String maHH,String tenSP, String maNH, double giaBan, String xuatXu){
        return dao.searchHangHoa(maHH, tenSP, maNH, giaBan, xuatXu);
    }
    public boolean xoaHangHoa(String maHH){
        return dao.delete(maHH);
    }
}
