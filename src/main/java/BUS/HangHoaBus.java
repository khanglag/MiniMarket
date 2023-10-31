/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HangHoaDAO;
import DTO.HangHoa_DTO;
import File.ImageChooserAndMover;
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
        ds= dao.searchHangHoa(maHang, null, null, 0, null);
        return ds.get(0).getSoLuong();
    }
    public ArrayList<HangHoa_DTO> timHangHoa(String maHH,String tenSP, String maNH, double giaBan, String xuatXu){
        return dao.searchHangHoa(maHH, tenSP, maNH, giaBan, xuatXu);
    }
    public boolean themHH(String maSP, String tenSP, String maNH, String maNCC, String donVi, double giaNhap, double giaBan, int soLuong, String xuatXu, boolean tonTai){
        String anhSP=ImageChooserAndMover.formatString(tenSP);
        if (!ImageChooserAndMover.chooseAndMoveImage(anhSP)) {
            return false;
        }
        anhSP=ImageChooserAndMover.formatStringFile(anhSP);
        return dao.add(maSP, tenSP, maNH, maNCC, donVi, giaNhap, giaBan, soLuong, xuatXu, anhSP, tonTai);
    }
    public boolean xoaHangHoa(String maHH){
        return dao.delete(maHH);
    }
}
