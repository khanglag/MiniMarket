
package BUS;

import BUS.PhieuXuatBus;
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
        HangHoaBus bus= new HangHoaBus();
        bus.xuatHHExcel();
    }
}
