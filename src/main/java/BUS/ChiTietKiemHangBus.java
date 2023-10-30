package BUS;

import DAO.ChiTietKiemHangDAO;
import DTO.ChiTietKiemHang_DTO;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ChiTietKiemHangBus {
    private final ChiTietKiemHangDAO ctDAO;

    public ChiTietKiemHangBus() {
        ctDAO = new ChiTietKiemHangDAO();
    }

    public ArrayList<ChiTietKiemHang_DTO> rKiemHang_DTOs() {
        try {
            return ctDAO.readDB();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi đọc dữ liệu !!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public boolean themCTKH(ChiTietKiemHang_DTO ct) {
        try {
            if (ct.getMaPhieu() == null || ct.getMaSP() == null || ct.getTenSP() == null || ct.getSoLuong() < 0 || ct.getDonVi() == null || ct.getTinhTrangSP() == null) {
                throw new IllegalArgumentException("Dữ liệu không hợp lệ");
            }
    
            if (ctDAO.isCTKHExisted(ct.getMaPhieu(), ct.getMaSP())) {
                JOptionPane.showMessageDialog(null, "Sản phẩm đã tồn tại trong phiếu", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
    
            ChiTietKiemHang_DTO ctDTO = new ChiTietKiemHang_DTO(ct.getMaPhieu(), ct.getMaSP(), ct.getTenSP(), ct.getSoLuong(), ct.getDonVi(), ct.getTinhTrangSP(), true);
    
            if (ctDAO.add(ctDTO)) {
                JOptionPane.showMessageDialog(null, "Thêm Chi Tiết Phiếu Kiểm Hàng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                throw new Exception("Thêm Chi Tiết Phiếu Kiểm Hàng thất bại");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm Chi Tiết Phiếu Kiểm Hàng!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
   


    public boolean xoaCTKH(ChiTietKiemHang_DTO ctkh) {
        try {
            if (ctDAO.isCTKHExisted(ctkh.getMaPhieu(), ctkh.getMaSP())) {
                return ctDAO.delete(ctkh);
            } else {
                JOptionPane.showMessageDialog(null, "Sản phẩm này không tồn tại trong phiếu", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa Chi Phiếu!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean suaCTKH(ChiTietKiemHang_DTO ctkh) {
        try {
            if (ctDAO.isCTKHExisted(ctkh.getMaPhieu(), ctkh.getMaSP())) {
                return ctDAO.update(ctkh);
            } else {
                JOptionPane.showMessageDialog(null, "Record không tồn tại.", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa Phiếu !!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public ArrayList<ChiTietKiemHang_DTO> timCTKH(String maPhieu,String maSP, String tenSP, String tinhTrang) {
        try {
            return ctDAO.search(maPhieu, maSP, tenSP, tinhTrang);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm Kiếm Phiếu !!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
}
