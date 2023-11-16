package BUS;

import DAO.PhieuNhapDAO;
import DAO.PhieuYeuCauNhapDAO;
import DTO.ChiTietPhieuNhap_DTO;
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
        if (pn.getMaNV() == null || pn.getThoiGianLap() == null || pn.getVAT() < 0 || pn.getSoMatHang() < 0 || pn.getTongTien() < 0 || pn.getTrangThai() == null) {
            JOptionPane.showMessageDialog(null, "Thông tin không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String maPhieu = Convert.convertMa(pnDAO.laySoLuongPhieuNhap() + 1);

        PhieuNhap_DTO pnDTO = new PhieuNhap_DTO(maPhieu, pn.getMaNV(), pn.getThoiGianLap(), pn.getVAT(), pn.getSoMatHang(), 0, pn.getTrangThai(), true);
        if (pnDAO.add(pnDTO)) {
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
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

    public boolean suaPhieuNhap(String maPhieuNhap, double VAT, int soMatHang, double tongTien, String trangThai) {
        String str = "UPDATE `phieunhap` SET "
                + " `VAT ` = " + VAT
                + " ,`SOMATHANG ` = " + soMatHang
                + ", `TONGTIEN` = " + tongTien
                + ",`TRANGTHAI` ='" + trangThai
                + "' WHERE `MAPHIEUNHAP`='" + maPhieuNhap + "'";
        System.out.println(str);
        try {
            if (pnDAO.isMaPhieuExisted(maPhieuNhap)) {
                return pnDAO.update(maPhieuNhap, VAT, soMatHang, tongTien, trangThai);
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

    public ArrayList<PhieuNhap_DTO> timPhieuNhap(String maPhieuNhap, String maNV, LocalDate thoiGianLap, String trangThai) {
        try {
            return pnDAO.searchPhieuNhap(maPhieuNhap, maNV, thoiGianLap, trangThai);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm !!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public boolean suaTongtien(String maPN, double tongTien) {
        return pnDAO.update(maPN, tongTien);
    }

    public boolean suaTrangThai(String maPN, String trangThai) {
        return pnDAO.update(maPN, trangThai);
    }

    public boolean capNhatPhieuNhap(String maPN, String trangThai) {
        if (trangThai == "DA DUYET") {
            PhieuYeuCauNhapDAO ycDao = new PhieuYeuCauNhapDAO();
            for (ChiTietPhieuNhap_DTO temp : ycDao.searchCTPN(maPN, null, null, null)) {
                //temp= yeu cau phieu nhap
                String maSP = temp.getMaHangNhap();
                int soluong = temp.getSoLuong();
                HangHoaBus hhbus = new HangHoaBus();
                hhbus.tangSLSP(maSP, soluong);
            };
            return true;
        }
        return false;
    }
}
