package BUS;

import DAO.PhieuXuatDAO;
import DTO.PhieuXuat_DTO;
import Handle.Convert;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class PhieuXuatBus {
    private final PhieuXuatDAO pxDAO;

    public PhieuXuatBus() {
        pxDAO = new PhieuXuatDAO();
    }

    public ArrayList<PhieuXuat_DTO> readPhieuXuat_DTOs() {
        try {
            return pxDAO.ReadPhieuXuat();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi đọc dữ liệu Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public boolean themPhieuXuat(PhieuXuat_DTO px) {
        // Kiểm tra null
        if (px.getMaNV() == null || px.getMaKH() == null || px.getThoiGianXuat() == null || px.getLyDo() == null) {
            JOptionPane.showMessageDialog(null, "Thông tin không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Thêm Phiếu Xuất
        String maPhieuXuat = Convert.convertMa(pxDAO.laySoLuongPhieuXuat() + 1);
        System.out.print(maPhieuXuat);
        PhieuXuat_DTO pxDTO = new PhieuXuat_DTO(maPhieuXuat, px.getMaNV(), px.getMaKH(), 0, px.getThoiGianXuat(),
                px.getLyDo(), px.getGhiChu(), true);
        System.out.print(px);
        if (pxDAO.add(pxDTO)) {
            JOptionPane.showMessageDialog(null, "Thêm Phiếu Xuất thành công");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Thêm Phiếu Xuất thất bại", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    }

    public boolean xoaPhieuXuat(PhieuXuat_DTO px) {
        try {
            return pxDAO.delete(px);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean suaPhieuXuat(String mapx, double thanhtien,LocalDate time) {
        try {
            return pxDAO.update(mapx, thanhtien,time);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean checkExist(String mapx) {
        return pxDAO.checkExist(mapx);
    }

    public ArrayList<PhieuXuat_DTO> timPhieuXuat(String maPhieuXuat, String maNV, String maKH, LocalDate thoiGianXuat) {
        try {
            return pxDAO.searchPhieuXuat(maPhieuXuat, maNV, maKH, thoiGianXuat);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
}
