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
public class NhanVien_DTO {
    private String maNV;
    private String tenNV;
    private LocalDate ngaySinh;
    private String gioiTinh;
    private String cccd;
    private String sdt;
    private String email;
    private String diaChi;
    private String maQuyen;
    private boolean tonTai;

    public NhanVien_DTO() {
    }

    public NhanVien_DTO(String maNV, String tenNV, LocalDate ngaySinh, String gioiTinh, String cccd, String sdt, String email, String diaChi, String maQuyen, boolean tonTai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cccd = cccd;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.maQuyen = maQuyen;
        this.tonTai = tonTai;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "NhanVien_DTO{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", cccd=" + cccd + ", sdt=" + sdt + ", email=" + email + ", diaChi=" + diaChi + ", maQuyen=" + maQuyen + ", tonTai=" + tonTai + '}';
    }
    
    
    
}
