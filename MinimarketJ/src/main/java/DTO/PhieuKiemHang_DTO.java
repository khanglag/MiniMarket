/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
 import java.time.LocalDate;
/**
 *
 * @author Admin
 */
public class PhieuKiemHang_DTO {
    private String maPhieu;
    private String maNV;
    private LocalDate thoiGianKiemHang;
    private boolean tonTai;

    public PhieuKiemHang_DTO() {
    }

    public PhieuKiemHang_DTO(String maPhieu, String maNV, LocalDate thoiGianKiemHang, boolean tonTai) {
        this.maPhieu = maPhieu;
        this.maNV = maNV;
        this.thoiGianKiemHang = thoiGianKiemHang;
        this.tonTai = tonTai;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public LocalDate getThoiGianKiemHang() {
        return thoiGianKiemHang;
    }

    public void setThoiGianKiemHang(LocalDate thoiGianKiemHang) {
        this.thoiGianKiemHang = thoiGianKiemHang;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "PhieuKiemHang_DTO{" + "maPhieu=" + maPhieu + ", maNV=" + maNV + ", thoiGianKiemHang=" + thoiGianKiemHang + ", tonTai=" + tonTai + '}';
    }
    
    
    
}
