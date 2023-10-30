package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhap_DTO;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ChiTietPhieuNhapBus {
    private final ChiTietPhieuNhapDAO ctnDAO;

    public ChiTietPhieuNhapBus() {
        ctnDAO = new ChiTietPhieuNhapDAO();
    }

    public ArrayList<ChiTietPhieuNhap_DTO> rChiTietPhieuNhap_DTOs() {
        try {
            return ctnDAO.readBD();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi đọc dữ liệu !!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public boolean themCTPN(ChiTietPhieuNhap_DTO ctn) {
        try {
            if (ctn.getMaPhieuNhap() == null || ctn.getMaHangNhap() == null || ctn.getTenHangNhap() == null || ctn.getVAT() < 0 || ctn.getXuatXu() == null || ctn.getAnhSP() == null || ctn.getSoLuong() < 0 || ctn.getDonVi() == null || ctn.getGiaNhap() < 0 || ctn.getTongTienNhap() < 0) {
                throw new IllegalArgumentException("Dữ liệu không hợp lệ");
            }
    
            if (ctnDAO.isCTPN_Existed(ctn.getMaPhieuNhap(), ctn.getMaHangNhap())) {
                JOptionPane.showMessageDialog(null, "Sản phẩm đã tồn tại trong phiếu", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
    
            ChiTietPhieuNhap_DTO ct = new ChiTietPhieuNhap_DTO(ctn.getMaPhieuNhap(), ctn.getMaHangNhap(),ctn.getTenHangNhap(),ctn.getVAT(),ctn.getXuatXu(),ctn.getAnhSP(),ctn.getSoLuong(),ctn.getDonVi(),ctn.getGiaNhap(),ctn.getTongTienNhap(),true);
    
            if (ctnDAO.addCTPN(ct)) {
                JOptionPane.showMessageDialog(null, "Thêm Chi Tiết Phiếu Nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                throw new Exception("Thêm Chi Tiết Phiếu Nhập thất bại");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm Chi Tiết Phiếu Nhập!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
   


    public boolean xoaCTPN(ChiTietPhieuNhap_DTO ct) {
        try {
            if (ctnDAO.isCTPN_Existed(ct.getMaPhieuNhap(), ct.getMaHangNhap())) {
                return ctnDAO.deleteCTPN(ct);
            } else {
                JOptionPane.showMessageDialog(null, "Sản phẩm này không tồn tại trong phiếu", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa Phiếu!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean suaCTPN(ChiTietPhieuNhap_DTO ct) {
        try {
             if (ctnDAO.isCTPN_Existed(ct.getMaPhieuNhap(), ct.getMaHangNhap())) {
                return ctnDAO.updateCTPN(ct);
            } else {
                JOptionPane.showMessageDialog(null, "Sản phẩm này không tồn tại trong phiếu", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa thông tin Phiếu!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public ArrayList<ChiTietPhieuNhap_DTO> timCTPN(String maPhieuNhap,String maHangNhap, String tenHangNhap, String xuatXu) {
        try {
            return ctnDAO.searchCTPN(maPhieuNhap, maHangNhap, tenHangNhap, xuatXu);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm Kiếm Phiếu !!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
}
