package BUS;

import DAO.PhieuXuatDAO;
import DTO.PhieuXuat_DTO;
import Handle.Convert;

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

    public boolean themPhieuXuat(String maNV, String maKH, double tongTien, String lyDo, String ghiChu) {
        // Kiểm tra null
        if (maNV == null || maKH == null || lyDo == null || ghiChu == null) {
            JOptionPane.showMessageDialog(null, "Thông tin không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Thêm Phiếu Xuất
        String maPhieuXuat = Convert.convertMa(pxDAO.laySoLuongPhieuXuat() + 1);
        PhieuXuat_DTO pxDTO = new PhieuXuat_DTO(maPhieuXuat, maNV, maKH, tongTien, lyDo, ghiChu, true);

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

    public boolean suaPhieuXuat(PhieuXuat_DTO px) {
        try {
            return pxDAO.update(px);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public ArrayList<PhieuXuat_DTO> timPhieuXuat(String maPhieuXuat, String maNV, String maKH) {
        try {
            return pxDAO.searchPhieuXuat(maPhieuXuat,maNV,maKH);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
}
