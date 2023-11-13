
package BUS;

import BUS.PhieuXuatBus;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.NhanVien_DTO;
import DTO.PhieuXuat_DTO;
import Handle.Timeconvert;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        HangHoaBus bus= new HangHoaBus();
        bus.suaHangHoa("8936021003321", "Bánh trung thu Kinh Đô Heo Vàng nhân phô mai 20g", "NCCLADY", 30000, 40800, "Trung quoc");
    
    }
}
