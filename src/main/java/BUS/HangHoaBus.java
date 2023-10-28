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
public class HangHoaBus {
    public HangHoaBus(){
    }
    ArrayList<HangHoa_DTO> ds;
    HangHoaDAO dao= new HangHoaDAO();
    public ArrayList<HangHoa_DTO> itemData(){
        return dao.ReadHangHoa();
    }
    public int ktSoLuong(String maHang){
        ds= dao.searchHangHoa(null, maHang, 0, null);
        return ds.get(0).getSoLuong();
    }
    public ArrayList<HangHoa_DTO> timHangHoa(String tenSP, String maNH, double giaBan, String xuatXu){
        return dao.searchHangHoa(tenSP, maNH, giaBan, xuatXu);
    }
    public boolean xoaHangHoa(String maHH){
        return dao.delete(maHH);
    }
}
