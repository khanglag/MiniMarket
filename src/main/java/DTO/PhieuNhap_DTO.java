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
public class PhieuNhap_DTO {
    private String maPhieuNhap;
    private String maNV;
    private String maNCC;
    private LocalDate thoiGianLap;
    private double VAT;
    private int soMatHang;
    private double tongTien;
    private String trangThai;
    private boolean tonTai;

    public PhieuNhap_DTO() {
    }

    public PhieuNhap_DTO(String maPhieuNhap, String maNV, String maNCC, LocalDate thoiGianLap, double VAT, int soMatHang, double tongTien, String trangThai, boolean tonTai) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.thoiGianLap = thoiGianLap;
        this.VAT = VAT;
        this.soMatHang = soMatHang;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.tonTai = tonTai;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public LocalDate getThoiGianLap() {
        return thoiGianLap;
    }

    public void setThoiGianLap(LocalDate thoiGianLap) {
        this.thoiGianLap = thoiGianLap;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public int getSoMatHang() {
        return soMatHang;
    }

    public void setSoMatHang(int soMatHang) {
        this.soMatHang = soMatHang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "PhieuNhap_DTO{" + "maPhieuNhap=" + maPhieuNhap + ", maNV=" + maNV + ", maNCC=" + maNCC
                + ", thoiGianLap=" + thoiGianLap + ", VAT=" + VAT + ", soMatHang=" + soMatHang + ", tongTien="
                + tongTien + ", trangThai=" + trangThai + ", tonTai=" + tonTai + '}';
    }

}
