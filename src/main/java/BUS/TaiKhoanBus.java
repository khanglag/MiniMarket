package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoan_DTO;

public class TaiKhoanBus {
    private final TaiKhoanDAO tkDAO;

    public TaiKhoanBus() {
        tkDAO = new TaiKhoanDAO();
    }

    public ArrayList<TaiKhoan_DTO> rKhoan_DTOs() {
        try {
            return tkDAO.ReadTaiKhoan();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi đọc dữ liệu !!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public boolean themTaiKhoan(TaiKhoan_DTO tk) {
        if (tk.getMaNV() == null || tk.getMatKhau() == null || tk.getMaPQ() == null) {
            JOptionPane.showMessageDialog(null, "Thông tin không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;

        }
        if (tkDAO.isTaiKhoanExisted(tk.getMaNV())) {
            JOptionPane.showMessageDialog(null, "Nhân viên này đã có tài khoản", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            TaiKhoan_DTO taiKhoan = new TaiKhoan_DTO(tk.getMaNV(), tk.getMatKhau(), tk.getMaPQ(), true);
            if (tkDAO.add(taiKhoan)) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
    }

    public boolean xoaTaiKhoan(TaiKhoan_DTO tk) {
        try {
            if (tkDAO.isTaiKhoanExisted(tk.getMaNV())) {
                return tkDAO.delete(tk);
            } else {
                JOptionPane.showMessageDialog(null, "Tài khoản này không tồn tại.", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean doiMatKhau(String maNV, String matKhau) {
        if(tkDAO.isTaiKhoanExisted(maNV))
            return tkDAO.doiMatKhau(maNV, matKhau);
        return false;
    }
    public TaiKhoan_DTO checkPass(String maNV, String matkhau){
        return tkDAO.Account(maNV, matkhau);
        
    }
}
