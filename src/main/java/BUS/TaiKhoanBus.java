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
    public boolean moTK(TaiKhoan_DTO tk) {
        return tkDAO.unKhoa(tk);
    }
    public boolean doiMatKhau(String maNV, String matKhau) {
        if(tkDAO.isTaiKhoanExisted(maNV))
            return tkDAO.doiMatKhau(maNV, matKhau);
        return false;
    }
    public TaiKhoan_DTO checkPass(String maNV){
        return tkDAO.Account(maNV);
        
    }
    public TaiKhoan_DTO tim(String maNV){
        return tkDAO.searchTaiKhoan(maNV);
        
    }
    public String kiemtraTK(String maNV) {
        TaiKhoan_DTO dto = new TaiKhoan_DTO();
        dto = tkDAO.searchTaiKhoan(maNV);
        if (dto == null) {
            return "Chưa có tài khoản";
        }
        if (dto.isTonTai() == true) {
            return "Đã có tài khoản";
        } else if (dto.isTonTai() == false) {
            return "Tài khoản bị khoá";
        }
        return "Lỗi truy xuất";
    }
}
