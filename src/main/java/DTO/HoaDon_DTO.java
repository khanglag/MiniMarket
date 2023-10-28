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
public class HoaDon_DTO {
    private int soHD;
    private String maNV;
    private LocalDate thoiGianLap;
    private String maKH;
    private double thanhTien;
    private double tienKhachDua;
    private double tienTraKhach;
    private boolean tonTai;

    public HoaDon_DTO() {
    }

    public HoaDon_DTO(int soHD, String maNV, LocalDate thoiGianLap, String maKH, double thanhTien, double tienKhachDua, double tienTraKhach, boolean tonTai) {
        this.soHD = soHD;
        this.maNV = maNV;
        this.thoiGianLap = thoiGianLap;
        this.maKH = maKH;
        this.thanhTien = thanhTien;
        this.tienKhachDua = tienKhachDua;
        this.tienTraKhach = tienTraKhach;
        this.tonTai = tonTai;
    }

    public int getSoHD() {
        return soHD;
    }

    public void setSoHD(int soHD) {
        this.soHD = soHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public LocalDate getThoiGianLap() {
        return thoiGianLap;
    }

    public void setThoiGianLap(LocalDate thoiGianLap) {
        this.thoiGianLap = thoiGianLap;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public double getTienTraKhach() {
        return tienTraKhach;
    }

    public void setTienTraKhach(double tienTraKhach) {
        this.tienTraKhach = tienTraKhach;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "HoaDon_DTO{" + "soHD=" + soHD + ", maNV=" + maNV + ", thoiGianLap=" + thoiGianLap + ", maKH=" + maKH + ", thanhTien=" + thanhTien + ", tienKhachDua=" + tienKhachDua + ", tienTraKhach=" + tienTraKhach + ", tonTai=" + tonTai + '}';
    }


}
