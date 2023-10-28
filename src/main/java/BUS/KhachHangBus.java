/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHang_DTO;

import Exception.DateOfBirthValidator;
import Exception.InvalidDateOfBirthException;

import Exception.InvalidPhoneNumberException;
import Exception.PhoneNumberValidator;
import Handle.Convert;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class KhachHangBus {
    public KhachHangBus() {
    }

    KhachHangDAO dAO = new KhachHangDAO();

    public boolean themKhanhHang(String tenKH, LocalDate ngaySinh, String sdt, String diaChi, boolean tonTai) {
        PhoneNumberValidator validator = new PhoneNumberValidator();
        //Ngoại lệ số điện thoại
       try {
            validator.validatePhoneNumber(sdt);
            if (dAO.ttKhachHang(sdt)) {
                //Kiểm tra có khác hàng sử dụng số điện thoại đó chưa
                JOptionPane.showMessageDialog(null,
                        "Đã có khách hàng sử dụng số điện thoại: " + sdt + ". Vui lòng sử dụng số khách");
                return false;
            } else {
                DateOfBirthValidator dateOfBirthValidator = new DateOfBirthValidator();
                //Kiểu tra ngày sinh
                try {
                    dateOfBirthValidator.validateDateOfBirth(ngaySinh);
                    String maKH = Convert.convertMa(dAO.demKhachHang() + 1);
                    //Điếm số tự động để lấy mã khác hàng
                    KhachHang_DTO kh = new KhachHang_DTO(maKH, tenKH, ngaySinh, sdt, diaChi, tonTai);
                    //Tạo đối tượng khách hàng
                    dAO.add(kh);
                    //thêm đối tượng khách hàng
                } catch (InvalidDateOfBirthException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }

            }
        } catch (InvalidPhoneNumberException e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return true;
    }
    public KhachHang_DTO timKhachHang(String sdt){
        //Kiểm tra định dạng số điẹn thoại
        return dAO.searchKhachHang(sdt);
    }
    public boolean xoaKhachHang(String sdt){
        return dAO.delete(sdt);
    }
    public boolean suaKhachHang(String sdt, String diaChi){
        return dAO.update(sdt, diaChi);
    }
}
