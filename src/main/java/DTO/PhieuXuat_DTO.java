/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class PhieuXuat_DTO {
    private String maPhieuXuat;
    private String maNV;
    private String maKH;
    private double tongTien;
    private String lyDo;
    private String ghiChu;
    private boolean tonTai;

    public PhieuXuat_DTO() {
    }
    
    public PhieuXuat_DTO(String maNV, String maKH, double tongTien, String lyDo, String ghiChu) {
        
        this.maNV = maNV;
        this.maKH = maKH;
        this.tongTien = tongTien;
        this.lyDo = lyDo;
        this.ghiChu = ghiChu;
       
    }

    public PhieuXuat_DTO(String maPhieuXuat, String maNV, String maKH, double tongTien, String lyDo, String ghiChu, boolean tonTai) {
        this.maPhieuXuat = maPhieuXuat;
        this.maNV = maNV;
        this.maKH = maKH;
        this.tongTien = tongTien;
        this.lyDo = lyDo;
        this.ghiChu = ghiChu;
        this.tonTai = tonTai;
    }

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "PhieuXuat_DTO{" + "maPhieuXuat=" + maPhieuXuat + ", maNV=" + maNV + ", maKH=" + maKH + ", tongTien=" + tongTien + ", lyDo=" + lyDo + ", ghiChu=" + ghiChu + ", tonTai=" + tonTai + '}';
    }
    
    

}

   