/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class ChiTietKiemHang_DTO {
    private String maPhieu;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private String donVi;
    private String tinhTrangSP;
    private boolean tonTai;

    public ChiTietKiemHang_DTO() {
    }

    public ChiTietKiemHang_DTO(String maPhieu, String maSP, String tenSP, int soLuong, String donVi, String tinhTrangSP, boolean tonTai) {
        this.maPhieu = maPhieu;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donVi = donVi;
        this.tinhTrangSP = tinhTrangSP;
        this.tonTai = tonTai;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getTinhTrangSP() {
        return tinhTrangSP;
    }

    public void setTinhTrangSP(String tinhTrangSP) {
        this.tinhTrangSP = tinhTrangSP;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "ChiTietKiemHang_DTO{" + "maPhieu=" + maPhieu + ", maSP=" + maSP + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", donVi=" + donVi + ", tinhTrangSP=" + tinhTrangSP + ", tonTai=" + tonTai + '}';
    }
    
    
    
    
}
