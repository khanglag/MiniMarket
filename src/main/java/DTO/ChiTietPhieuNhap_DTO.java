/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class ChiTietPhieuNhap_DTO {
    private String maPhieuNhap;
    private String maHangNhap;
    private String tenHangNhap;
    private String maNCC;
    private double VAT;
    private String xuatXu;
    private int soLuong;
    private String donVi;
    private double giaNhap;
    private double tongTienNhap;
    private boolean tonTai;

    public ChiTietPhieuNhap_DTO() {
    }

    public ChiTietPhieuNhap_DTO(String maPhieuNhap, String maHangNhap, String tenHangNhap,String maNCC, double VAT,
            String xuatXu, int soLuong, String donVi, double giaNhap, double tongTienNhap, boolean tonTai) {
        this.maPhieuNhap = maPhieuNhap;
        this.maHangNhap = maHangNhap;
        this.tenHangNhap = tenHangNhap;
        this.maNCC = maNCC;
        this.VAT = VAT;
        this.xuatXu = xuatXu;
        this.soLuong = soLuong;
        this.donVi = donVi;
        this.giaNhap = giaNhap;
        this.tongTienNhap = tongTienNhap;
        this.tonTai = tonTai;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaHangNhap() {
        return maHangNhap;
    }

    public void setMaHangNhap(String maHangNhap) {
        this.maHangNhap = maHangNhap;
    }

    public String getTenHangNhap() {
        return tenHangNhap;
    }

    public void setTenHangNhap(String tenHangNhap) {
        this.tenHangNhap = tenHangNhap;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
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

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getTongTienNhap() {
        return tongTienNhap;
    }

    public void setTongTienNhap(double tongTienNhap) {
        this.tongTienNhap = tongTienNhap;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuNhap_DTO{" + "maPhieuNhap=" + maPhieuNhap + ", maHangNhap=" + maHangNhap + ", tenHangNhap=" + tenHangNhap + ", maNCC=" + maNCC + ", VAT=" + VAT + ", xuatXu=" + xuatXu + ", soLuong=" + soLuong + ", donVi=" + donVi + ", giaNhap=" + giaNhap + ", tongTienNhap=" + tongTienNhap + ", tonTai=" + tonTai + '}';
    }

    
    
    
    
}
