package BUS;

import BUS.PhieuXuatBus;
import DAO.PhieuYeuCauNhapDAO;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.NhanVien_DTO;
import DTO.PhieuXuat_DTO;
import Handle.Timeconvert;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws IOException {
//        HangHoaBus bus= new HangHoaBus();
//        bus.xuatHHExcel();
        ChiTietPhieuXuatBus ctpx = new ChiTietPhieuXuatBus();
        System.out.println(ctpx.timChiTietPhieuXuat("0000001", null));
    }
}
