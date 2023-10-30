package BUS;

import BUS.PhieuXuatBus;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.NhanVien_DTO;
import DTO.PhieuXuat_DTO;
import Handle.Timeconvert;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.DateUtil;

public class Test {
    public static void main(String[] args) {
        NhanvienBus bus = new NhanvienBus();
        bus.themNhanVien("Le Duy Khang",Timeconvert.convert("04-10-2003"), "nam", "0358808913", "091203002454","lehasdhqwdjabwsdha@com", "277 âu dương lân", "NVTK203");
        ChiTietPhieuXuatBus phieuXuatBus = new ChiTietPhieuXuatBus();
    }
}
