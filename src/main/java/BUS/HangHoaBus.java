/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HangHoaDAO;
import DTO.HangHoa_DTO;
import File.ImageChooserAndMover;
import java.util.Collections;
import java.util.Comparator;
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
        ds= dao.searchHangHoa(maHang, null, null, null);
        return ds.get(0).getSoLuong();
    }
    public double giaBanSP(String maHang){
        ds= dao.searchHangHoa(maHang, null, null, null);
        return ds.get(0).getGiaBan();
    }
    public ArrayList<HangHoa_DTO> timHangHoa(String maHH,String tenSP, String maNH, double giaBan, String xuatXu){
        return dao.searchHangHoa(maHH, tenSP, maNH, xuatXu);
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
    public ArrayList<HangHoa_DTO> timHangHoa(String maHH, String tenHangHoa,String maNH,String maNCC){
        return dao.searchHangHoa(maHH, maNCC, maNH, maNCC);
    }
    public boolean suaHangHoa(String maSP,String tenSP, String maNCC, double giaNhap, double giaBan, String xuatXu){
        return dao.update(maSP, tenSP, maNCC, giaNhap, giaBan, xuatXu);
    }
     public String timHangHoa(String maHH){
        return dao.searchHangHoa(maHH);
    }
     public ArrayList<HangHoa_DTO> sapXep(ArrayList<HangHoa_DTO> dto){
         Collections.sort(dto,new Comparator<HangHoa_DTO>() {
             @Override
             public int compare(HangHoa_DTO o1, HangHoa_DTO o2) {
                 throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
             }
         });
         return dto;
     }
}
