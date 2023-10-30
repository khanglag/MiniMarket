package BUS;

import DAO.PhieuKiemHangDAO;
import DTO.PhieuKiemHang_DTO;
import Handle.Convert;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;

public class PhieuKiemHangBus {
    private final PhieuKiemHangDAO pDAO;

    public PhieuKiemHangBus() {
        pDAO = new PhieuKiemHangDAO();
    }

    public ArrayList<PhieuKiemHang_DTO> rKiemHang_DTOs() {
        try {
            return pDAO.ReadPhieuKiemHang();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi đọc dữ liệu Phiếu !!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public boolean themPhieu(PhieuKiemHang_DTO pkh) {
        if ( pkh.getMaNV() == null || pkh.getThoiGianKiemHang() == null) {
            JOptionPane.showMessageDialog(null, "Thông tin không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        else {
            String maPhieu = Convert.convertMa(pDAO.laySoLuongPhieu() + 1);

            PhieuKiemHang_DTO pkhDTO = new PhieuKiemHang_DTO(maPhieu, pkh.getMaNV(), pkh.getThoiGianKiemHang(), true);
            if (pDAO.add(pkhDTO)) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

    }

    public boolean xoaPhieu(PhieuKiemHang_DTO pkh) {
        try {
            if (pDAO.isMaPhieuExisted(pkh.getMaPhieu())) {
                return pDAO.delete(pkh);
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
    
    public ArrayList<PhieuKiemHang_DTO> timPhieu(String maPhieuNhap, String maNV, LocalDate thoiGianLap) {
        try {
            return pDAO.searchPhieuKiemHang(maPhieuNhap, maNV, thoiGianLap);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm !!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
    public boolean checkExist(String mapx){
        return pDAO.CheckExistedCT(mapx);
    }
}
