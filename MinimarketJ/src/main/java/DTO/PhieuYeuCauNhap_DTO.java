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
public class PhieuYeuCauNhap_DTO {
    private String maPhieu;
    private String maSP;
    private String tenSP;
    private int soLuongTonKho;
    private String lyDo;
    private LocalDate thoiGianYC;
    private boolean trangThai;

    public PhieuYeuCauNhap_DTO() {
    }

    public PhieuYeuCauNhap_DTO(String maPhieu, String maSP, String tenSP, int soLuongTonKho, String lyDo, LocalDate thoiGianYC, boolean trangThai) {
        this.maPhieu = maPhieu;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuongTonKho = soLuongTonKho;
        this.lyDo = lyDo;
        this.thoiGianYC = thoiGianYC;
        this.trangThai = trangThai;
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

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public LocalDate getThoiGianYC() {
        return thoiGianYC;
    }

    public void setThoiGianYC(LocalDate thoiGianYC) {
        this.thoiGianYC = thoiGianYC;
    }

    

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhieuYeuCauNhap{" + "maPhieu=" + maPhieu + ", maSP=" + maSP + ", tenSP=" + tenSP + ", soLuongTonKho=" + soLuongTonKho + ", lyDo=" + lyDo + ", thoiGianYC=" + thoiGianYC + ", trangThai=" + trangThai + '}';
    }
    
    
    
    
    
}
