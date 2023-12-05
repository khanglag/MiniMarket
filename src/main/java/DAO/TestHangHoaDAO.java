package DAO;

import BUS.PhieuYeuCauNhapBus;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import DAO.NhanVienDAO;
import DTO.ChiTietHoaDon_DTO;
import DTO.HoaDon_DTO;
import DTO.NhaCungCap_DTO;
import DTO.NhanVien_DTO;
import java.io.IOException;

public class TestHangHoaDAO {
    public static void main(String[] args) throws IOException {
        PhieuYeuCauNhapBus bus=new PhieuYeuCauNhapBus();
        bus.nhapPN("0000003");
    }
}