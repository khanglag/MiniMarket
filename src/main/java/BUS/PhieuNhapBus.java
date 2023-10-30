package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhap_DTO;
import Handle.Convert;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;

public class PhieuNhapBus {
    private final PhieuNhapDAO pnDAO;

    public PhieuNhapBus() {
        pnDAO = new PhieuNhapDAO();
    }

    public ArrayList<PhieuNhap_DTO> rPhieuNhap_DTOs() {
        try {
            return pnDAO.ReadPhieuNhap();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi đọc dữ liệu Phiếu Nhập !!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public boolean themPhieuNhap(PhieuNhap_DTO pn) {
        if (pn.getMaPhieuNhap() == null || pn.getMaNV() == null || pn.getMaNCC() == null || pn.getThoiGianLap() == null || pn.getVAT() < 0 || pn.getSoMatHang() < 0 || pn.getTongTien() < 0 || pn.getTrangThai() == null) {
            JOptionPane.showMessageDialog(null, "Thông tin không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (pnDAO.isMaPhieuExisted(pn.getMaPhieuNhap())) {
            JOptionPane.showMessageDialog(null, "Mã phiếu đã tồn tại", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else {
            String maPhieu = Convert.convertMa(pnDAO.laySoLuongPhieuNhap() + 1);

            PhieuNhap_DTO pnDTO = new PhieuNhap_DTO(maPhieu, pn.getMaNV(), pn.getMaNCC(), pn.getThoiGianLap(),pn.getVAT(),pn.getSoMatHang(),0,pn.getTrangThai(),true);
            if (pnDAO.add(pnDTO)) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

    }

    public boolean xoaPhieuNhap(PhieuNhap_DTO pn) {
        try {
            if (pnDAO.isMaPhieuExisted(pn.getMaPhieuNhap())) {
                return pnDAO.delete(pn);
            } else {
                JOptionPane.showMessageDialog(null, "Phiếu không tồn tại.", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa Phiếu .", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean suaPhieuNhap(PhieuNhap_DTO pn) {
    try {
        if (pnDAO.isMaPhieuExisted(pn.getMaPhieuNhap())) {
            return pnDAO.update(pn);
        } else {
            JOptionPane.showMessageDialog(null, "Phiếu không tồn tại.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi sửa Phiếu !!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

    public ArrayList<PhieuNhap_DTO> timPhieuNhap(String maPhieuNhap, String maNV, String maNCC, LocalDate thoiGianLap, String trangThai) {
        try {
            return pnDAO.searchPhieuNhap(maPhieuNhap, maNV, maNCC,thoiGianLap,trangThai);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm !!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
}
