/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVien_DTO;
import Exception.DateOfBirthValidator;
import static Exception.EmailValidator.isEmailValid;
import Exception.InvalidDateOfBirthException;
import Exception.InvalidPhoneNumberException;
import Exception.PhoneNumberValidator;
import GUI.Login.TaiKhoan;
import static Handle.Convert.convertMa;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAO.TaiKhoanDAO;
/**
 *
 * @author pc
 */
public class NhanvienBus {

    public NhanvienBus() {
    }

    NhanVienDAO dAO = new NhanVienDAO();

    public ArrayList<NhanVien_DTO> dsNhanVien() {
        return dAO.ReadNhanviens();
    }

    public boolean xoaNhanVien(String maNV) {
        return dAO.delete(maNV);
    }

    public boolean suaNhanVien(String maNV, String sdt, String diaChi, String maPQ, String email) {
        PhoneNumberValidator phoneNumberValidator=new PhoneNumberValidator();
        try {
            phoneNumberValidator.validatePhoneNumber(sdt);
            try {
                if (isEmailValid(email)) {
                    return dAO.update(maNV, sdt, diaChi, maPQ, email);
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        } catch (InvalidPhoneNumberException e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        return false;
    }
    public boolean suaNhanVien(String maNV, String maPQ) {
       
        return dAO.update(maNV, maPQ);
                
    }
    
    public ArrayList<NhanVien_DTO> timNhanVien(String tenNV){
        return dAO.searchNhanVien(null, tenNV, null);
    }

    public boolean themNhanVien(String tenNV, LocalDate ngaySinh, String gioiTinh, String sdt, String cccd,
            String email, String diaChi, String maPQ) {
        PhoneNumberValidator phoneNumberValidator=new PhoneNumberValidator();
        try {
            phoneNumberValidator.validatePhoneNumber(sdt);
            try {
                if (isEmailValid(email)) {
                    try {
                     DateOfBirthValidator dateOfBirthValidator = new DateOfBirthValidator();
                    dateOfBirthValidator.validateDateOfBirth(ngaySinh);
                         NhanVien_DTO dTO = new NhanVien_DTO(taoMaNV(sdt, maPQ), tenNV, ngaySinh, gioiTinh, cccd, sdt, email, diaChi,
                maPQ, true);
                         return dAO.add(dTO);
                    } catch (InvalidDateOfBirthException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        } catch (InvalidPhoneNumberException e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        return false;
       
    }

    public String taoMaNV(String sdt, String maPQ) {
        int startIndex = sdt.length() - 6;
        String ma = "";
        String subsdt = sdt.substring(startIndex);
        switch (maPQ) {
            case "NVBH203":
            case "NVTK203":
                ma += "A";
                break;
            default:
                ma += "B";
        }
        while (dAO.ttMaNV(ma + subsdt) == true) {
            subsdt = convertMa(Integer.parseInt(subsdt) + 1);
            subsdt = subsdt.substring(1);
            System.out.println("sub sdt" + subsdt);
        }
        return (ma += subsdt);
    }
    public String tenNV(String manv){
        return dAO.TenNV(manv);
    }
    public String kiemtraTK(String maNV){
        TaiKhoanDAO dAO= new TaiKhoanDAO();
        TaiKhoan dto=new TaiKhoan();
//        dto=dAO.searchTaiKhoan(maNV);
        if (dto.isTontai()==true) {
            return "Đã có tài khoản";
        }else if (dto.getTontai()==false) {
            return "Tài khoản bị khoá";
        }
        return "Chưa có tài khoản";
    }
}
