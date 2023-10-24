/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class ChiTietPhieuXuat_DTO {
    private String maPhieuXuat;
    private String maHangXuat;
    private int soLuongYC;
    private int soLuongThucTe;
    private String donVi;
    private double donGia;
    private double thanhTien;
    private boolean tonTai;

    public ChiTietPhieuXuat_DTO() {
    }

    public ChiTietPhieuXuat_DTO(String maPhieuXuat, String maHangXuat, int soLuongYC, int soLuongThucTe, String donVi, double donGia, double thanhTien, boolean tonTai) {
        this.maPhieuXuat = maPhieuXuat;
        this.maHangXuat = maHangXuat;
        this.soLuongYC = soLuongYC;
        this.soLuongThucTe = soLuongThucTe;
        this.donVi = donVi;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.tonTai = tonTai;
    }

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public String getMaHangXuat() {
        return maHangXuat;
    }

    public void setMaHangXuat(String maHangXuat) {
        this.maHangXuat = maHangXuat;
    }

    public int getSoLuongYC() {
        return soLuongYC;
    }

    public void setSoLuongYC(int soLuongYC) {
        this.soLuongYC = soLuongYC;
    }

    public int getSoLuongThucTe() {
        return soLuongThucTe;
    }

    public void setSoLuongThucTe(int soLuongThucTe) {
        this.soLuongThucTe = soLuongThucTe;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuXuat_DTO{" + "maPhieuXuat=" + maPhieuXuat + ", maHangXuat=" + maHangXuat + ", soLuongYC=" + soLuongYC + ", soLuongThucTe=" + soLuongThucTe + ", donVi=" + donVi + ", donGia=" + donGia + ", thanhTien=" + thanhTien + ", tonTai=" + tonTai + '}';
    }
    
    
    
}
