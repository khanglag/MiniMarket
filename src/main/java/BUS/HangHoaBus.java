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
    // Trả kiểu array list hàng hoá
    public ArrayList<HangHoa_DTO> itemData(){
        return dao.ReadHangHoa();
    }
    //Vào: mã hàng Trả: số lượng hàng hoá
    public int ktSoLuong(String maHang){
        ds= dao.searchHangHoa(maHang, null, 0, null);
        return ds.get(0).getSoLuong();
    }
}
