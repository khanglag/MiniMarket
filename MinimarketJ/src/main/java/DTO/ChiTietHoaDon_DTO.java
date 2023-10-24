/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDon_DTO {
    private int soHD;
    private String maSP;
    private int soLuong;
    private boolean tonTai;

    public ChiTietHoaDon_DTO() {
    }

    public ChiTietHoaDon_DTO(int soHD, String maSP, int soLuong, boolean tonTai) {
        this.soHD = soHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.tonTai = tonTai;
    }

    public int getSoHD() {
        return soHD;
    }

    public void setSoHD(int soHD) {
        this.soHD = soHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int isTonTai() {
        if (tonTai==true) {
            return 1;
        }
        return 0;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon_DTO{" + "soHD=" + soHD + ", maSP=" + maSP + ", soLuong=" + soLuong + ", tonTai=" + tonTai + '}';
    }
    
    
    
}
