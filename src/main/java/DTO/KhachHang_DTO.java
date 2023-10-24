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
public class KhachHang_DTO {
    private String maKH;
    private String tenKH;
    private LocalDate ngaySinh;
    private String sdt;
    private String diaChi;
    private boolean tonTai;

    public KhachHang_DTO() {
    }

    public KhachHang_DTO(String maKH, String tenKH, LocalDate ngaySinh, String sdt, String diaChi, boolean tonTai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.tonTai = tonTai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
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
        return "KhachHang_DTO{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", diaChi=" + diaChi + ", tonTai=" + tonTai + '}';
    }
    
    
    
}
