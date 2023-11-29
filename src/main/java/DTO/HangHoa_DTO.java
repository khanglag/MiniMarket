/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class HangHoa_DTO {
    private String maSP;
    private String tenSP;
    private String maNH;
    private String maNCC;
    private String donVi;
    private double giaNhap;
    private double giaBan;
    private int soLuong;
    private String xuatXu;
    private String anhSP;
    private boolean tonTai;

    public HangHoa_DTO() {
    }

    public HangHoa_DTO(String maSP, String tenSP, String maNH, String maNCC, String donVi, double giaNhap, double giaBan, int soLuong, String xuatXu, String anhSP, boolean tonTai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maNH = maNH;
        this.maNCC = maNCC;
        this.donVi = donVi;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.xuatXu = xuatXu;
        this.anhSP = anhSP;
        this.tonTai = tonTai;
    }
    public HangHoa_DTO(String maSP, String tenSP, Integer sol, String maNCC,String donVi, double giaBan,String xuatXu) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = sol;
        this.maNCC = maNCC;
        this.donVi = donVi;
        this.giaBan = giaBan;
        this.xuatXu = xuatXu;
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

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
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

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getAnhSP() {
        return anhSP;
    }

    public void setAnhSP(String anhSP) {
        this.anhSP = anhSP;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "HangHoa_DTO{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", maNH=" + maNH + ", maNCC=" + maNCC + ", donVi=" + donVi + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", xuatXu=" + xuatXu + ", anhSP=" + anhSP + ", tonTai=" + tonTai + '}';
    }
    
    
    
}
