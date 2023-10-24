/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class NhaCungCap_DTO {
    private String maNCC;
    private String tenNCC;
    private String sdt;
    private String diaChi;
    private boolean tonTai;

    public NhaCungCap_DTO() {
    }

    public NhaCungCap_DTO(String maNCC, String tenNCC, String sdt, String diaChi, boolean tonTai) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.tonTai = tonTai;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "NhaCungCap_DTO{" + "maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", sdt=" + sdt + ", diaChi=" + diaChi + ", tonTai=" + tonTai + '}';
    }
    
    
    
    
}
