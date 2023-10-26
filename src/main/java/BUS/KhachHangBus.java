/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHang_DTO;

import Handle.Convert;
import PhoneException.InvalidPhoneNumberException;
import PhoneException.PhoneNumberValidator;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class KhachHangBus {
    public KhachHangBus(){}
    KhachHangDAO dAO=new KhachHangDAO();
    public boolean themKhanhHang( String tenKH, LocalDate ngaySinh, String sdt, String diaChi, boolean tonTai){
        PhoneNumberValidator validator = new PhoneNumberValidator();
        try {
            validator.validatePhoneNumber(sdt);
            if (dAO.ttKhachHang(sdt)) {
            JOptionPane.showMessageDialog(null,
                    "Đã có khách hàng sử dụng số điện thoại: "+sdt+". Vui lòng sử dụng số khách");
            return false;
        }
        else{
            String maKH=Convert.convertMa(dAO.demKhachHang()+1);
            KhachHang_DTO kh=new KhachHang_DTO(maKH, tenKH, ngaySinh, sdt, diaChi, tonTai);
            dAO.add(kh);
        }
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return true;
    }
}
