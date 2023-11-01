package BUS;

import DAO.ChiTietPhieuXuatDAO;
import DTO.ChiTietPhieuXuat_DTO;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ChiTietPhieuXuatBus {
    private final ChiTietPhieuXuatDAO ctpxDAO;

    public ChiTietPhieuXuatBus() {
        ctpxDAO = new ChiTietPhieuXuatDAO();
    }

    public ArrayList<ChiTietPhieuXuat_DTO> readChiTietPhieuXuat_DTOs() {
        try {
            return ctpxDAO.readBD();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi đọc dữ liệu Chi Tiết Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public boolean themChiTietPhieuXuat(String maPhieuXuat, String maHangXuat, int soLuongYC, int soLuongThucTe, String donVi, double donGia, double thanhTien) {
        try {
            if (maPhieuXuat == null || maHangXuat == null || donVi == null || soLuongYC < 0 || soLuongThucTe < 0 || donGia < 0 || thanhTien < 0) {
                throw new IllegalArgumentException("Dữ liệu không hợp lệ");
            }

            ChiTietPhieuXuat_DTO ctpxDTO = new ChiTietPhieuXuat_DTO(maPhieuXuat, maHangXuat, soLuongYC, soLuongThucTe, donVi, donGia, thanhTien, true);

            if (ctpxDAO.add(ctpxDTO)) {
                return true;
            } else {
                throw new Exception("Thêm Chi Tiết Phiếu Xuất thất bại");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm Chi Tiết Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean themChiTietPhieuXuat(ChiTietPhieuXuat_DTO ctpx) {
        try {
            if (ctpx.getMaPhieuXuat() == null ||ctpx.getMaHangXuat() == null || ctpx.getDonVi() == null || ctpx.getSoLuongYC() < 0 || ctpx.getSoLuongThucTe() < 0 || ctpx.getDonGia() < 0 || ctpx.getThanhTien() < 0) {
                throw new IllegalArgumentException("Dữ liệu không hợp lệ");
            }
            if (ctpxDAO.add(ctpx)) {
                JOptionPane.showMessageDialog(null, "Thêm Chi Tiết Phiếu Xuất thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                throw new Exception("Thêm Chi Tiết Phiếu Xuất thất bại");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm Chi Tiết Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public boolean xoaChiTietPhieuXuat(ChiTietPhieuXuat_DTO ctpx) {
        try {
            return ctpxDAO.delete(ctpx);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa Chi Tiết Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean suaChiTietPhieuXuat(ChiTietPhieuXuat_DTO ctpx) {
        try {
            return ctpxDAO.update(ctpx);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa Chi Tiết Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public ArrayList<ChiTietPhieuXuat_DTO> timChiTietPhieuXuat(String maPhieuXuat,String maHangXuat) {
        try {
            return ctpxDAO.search(maPhieuXuat,maHangXuat);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm Kiếm Chi Tiết Phiếu Xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
}
