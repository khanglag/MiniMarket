
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
        bus.themHH("4902430556782", "Biển vô cực", "0000004","NCCDYQN", "gói", 20000, 30000, 400, "Việt Nam", true);
    }
}
