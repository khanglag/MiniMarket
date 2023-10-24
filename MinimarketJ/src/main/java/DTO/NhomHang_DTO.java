/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class NhomHang_DTO {
    private String maNH;
    private String tenNH;
    private boolean tonTai;

    public NhomHang_DTO() {
    }

    public NhomHang_DTO(String maNH, String tenNH, boolean tonTai) {
        this.maNH = maNH;
        this.tenNH = tenNH;
        this.tonTai = tonTai;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getTenNH() {
        return tenNH;
    }

    public void setTenNH(String tenNH) {
        this.tenNH = tenNH;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "NhomHang{" + "maNH=" + maNH + ", tenNH=" + tenNH + ", tonTai=" + tonTai + '}';
    }
    
    
    
    
    
}
