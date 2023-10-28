package BUS;

import BUS.PhieuXuatBus;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.PhieuXuat_DTO;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
<<<<<<< Updated upstream
        KhachHangBus bus=new KhachHangBus();
        bus.themKhanhHang("Lê Duy Khang", LocalDate.now(), "099999999", "277 Âu Dương Lân", true);
=======
        ChiTietPhieuXuatBus phieuXuatBus = new ChiTietPhieuXuatBus();

        // Đọc danh sách Phiếu Xuất
        ArrayList<ChiTietPhieuXuat_DTO> danhSachPhieuXuat = phieuXuatBus.readChiTietPhieuXuat_DTOs();
        if (danhSachPhieuXuat.size() > 0) {
            System.out.println("Danh sách Phiếu Xuất:");
            for (ChiTietPhieuXuat_DTO phieuXuat : danhSachPhieuXuat) {
                System.out.println("Mã Phiếu Xuất: " + phieuXuat.getMaPhieuXuat());
            }
        } else {
            System.out.println("Danh sách Phiếu Xuất trống.");
        }

        // Thêm Phiếu Xuất
        // boolean themPhieuXuatResult = phieuXuatBus.themChiTietPhieuXuat("0000002","8936021003321",20,15,"cái",27000,27000*5);
        // if (themPhieuXuatResult) {
        //     System.out.println("Thêm Phiếu Xuất thành công.");
        // } else {
        //     System.out.println("Thêm Phiếu Xuất thất bại.");
        // }

        // Tìm Phiếu Xuất
        ArrayList<ChiTietPhieuXuat_DTO> ketQuaTimKiem = phieuXuatBus.timChiTietPhieuXuat("0000000",null);
        if (ketQuaTimKiem.size() > 0) {
            System.out.println("Kết quả tìm kiếm:");
            for (ChiTietPhieuXuat_DTO phieuXuat : ketQuaTimKiem) {
                System.out.println("Mã Phiếu Xuất: " + phieuXuat.getMaPhieuXuat());
            }
        } else {
            System.out.println("Không tìm thấy Phiếu Xuất.");
        }

       // Xóa Phiếu Xuất
    //    PhieuXuat_DTO phieu = null; 
    //    String maPhieuCanXoa = "0000001"; 
    //    for (PhieuXuat_DTO phieuXuat : danhSachPhieuXuat) {
    //        if (phieuXuat.getMaPhieuXuat().equals(maPhieuCanXoa)) {
    //            phieu = phieuXuat; 
    //            break;
    //        }
    //    }
    //     boolean xoaPhieuXuatResult = phieuXuatBus.xoaPhieuXuat(phieu);
    //     if (xoaPhieuXuatResult) {
    //         System.out.println("Xóa Phiếu Xuất thành công.");
    //     } else {
    //         System.out.println("Xóa Phiếu Xuất thất bại.");
    //     }

    // Sửa Phiếu Xuất
    // Lấy đối tượng PhieuXuat_DTO cần sửa bằng cách tìm kiếm theo mã Phiếu Xuất
        // String maPhieuXuatCanSua = "0000002"; // Thay thế bằng mã Phiếu Xuất cụ thể
        // PhieuXuat_DTO phieuCanSua = null;

        // // Tìm Phiếu Xuất trong danh sách hoặc tìm kiếm
        // for (PhieuXuat_DTO phieu : danhSachPhieuXuat) {
        //     if (phieu.getMaPhieuXuat().equals(maPhieuXuatCanSua)) {
        //         phieuCanSua = phieu;
        //         break; // Dừng khi tìm thấy Phiếu Xuất cần sửa
        //     }
        // }

        // // Kiểm tra xem phieuCanSua có tồn tại hay không
        // if (phieuCanSua != null) {
        //     // Thực hiện sửa thông tin
        //     phieuCanSua.setTongTien(200.0); // Sửa thông tin tổng tiền

        //     // Gọi hàm sửa từ lớp PhieuXuatBus
        //     boolean suaPhieuXuatResult = phieuXuatBus.suaPhieuXuat(phieuCanSua);

        //     if (suaPhieuXuatResult) {
        //         System.out.println("Sửa Phiếu Xuất thành công.");
        //     } else {
        //         System.out.println("Sửa Phiếu Xuất thất bại.");
        //     }
        // } else {
        //     System.out.println("Không tìm thấy Phiếu Xuất cần sửa.");
        // }


>>>>>>> Stashed changes
    }
}
