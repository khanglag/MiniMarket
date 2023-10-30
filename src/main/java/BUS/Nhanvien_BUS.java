 /*
  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
  */
 package BUS;
import DAO.NhanVienDAO;
import DTO.NhanVien_DTO;
import java.time.LocalDate;
 import java.util.ArrayList;
 /**
  *
  * @author pc
  */
 public class NhanVien_BUS {

    public NhanVien_BUS() {
    }
     NhanVienDAO dAO=new NhanVienDAO();
    public ArrayList<NhanVien_DTO> dsNhanVien(){
        return dAO.ReadNhanviens();
    }
//    public boolean themNhanVien(String tenNV, LocalDate ngaySinh, String gioiTinh,String sdt,String email, String diaChi,String maPQ){
//        
//    }
    public String taoMaNV(String sdt,String maPQ){
        int startIndex = sdt.length()-6;
        return sdt.substring(startIndex);
    }
    public boolean xoaNhanVien(String maNV){
        return dAO.delete(maNV);
    }
    public boolean suaNhanVien(String maNV,String sdt,String diaChi, String maPQ,String email){
         return dAO.update(maNV, sdt, diaChi, maPQ, email);
    }
 }
