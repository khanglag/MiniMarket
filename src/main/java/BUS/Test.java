
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
//        HoaDonBus bus= new HoaDonBus();
//        bus.taoHoaDon("0000001");
          KhachHangBus bus =new KhachHangBus();
//          bus.themKhanhHang("Lee Duy Khang", Timeconvert.convert("04-10-2003"), "0358808913", "hehee", true);
          bus.suaKhachHang("0000005","0358808913", "277 Âu Dương Lân");
    }
}

