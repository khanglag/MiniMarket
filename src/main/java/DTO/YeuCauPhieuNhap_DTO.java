/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pc
 */
public class YeuCauPhieuNhap_DTO {
    private String maPN;
    private String maHN;
    private String tenHN;
    private String maNCC;
    private double VAT;
    private String xuatXu;
    private int soLuong;
    private String donVi;
    private double giaNhap;
    private double tongTien;
    private boolean tonTai;
    public YeuCauPhieuNhap_DTO() {
    }

    public YeuCauPhieuNhap_DTO(String maPN, String maHN, String tenHN, String maNCC, double VAT, String xuatXu, int soLuong, String donVi, double giaNhap, double tongTien, boolean tonTai) {
        this.maPN = maPN;
        this.maHN = maHN;
        this.tenHN = tenHN;
        this.maNCC = maNCC;
        this.VAT = VAT;
        this.xuatXu = xuatXu;
        this.soLuong = soLuong;
        this.donVi = donVi;
        this.giaNhap = giaNhap;
        this.tongTien = tongTien;
        this.tonTai = tonTai;
    }

    public String getMaPN() {
        return this.maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaHN() {
        return this.maHN;
    }

    public void setMaHN(String maHN) {
        this.maHN = maHN;
    }

    public String getTenHN() {
        return this.tenHN;
    }

    public void setTenHN(String tenHN) {
        this.tenHN = tenHN;
    }

    public String getMaNCC() {
        return this.maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public double getVAT() {
        return this.VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public String getXuatXu() {
        return this.xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonVi() {
        return this.donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public double getGiaNhap() {
        return this.giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getTongTien() {
        return this.tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isTonTai() {
        return this.tonTai;
    }

    public boolean getTonTai() {
        return this.tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    public YeuCauPhieuNhap_DTO maPN(String maPN) {
        setMaPN(maPN);
        return this;
    }

    public YeuCauPhieuNhap_DTO maHN(String maHN) {
        setMaHN(maHN);
        return this;
    }

    public YeuCauPhieuNhap_DTO tenHN(String tenHN) {
        setTenHN(tenHN);
        return this;
    }

    public YeuCauPhieuNhap_DTO maNCC(String maNCC) {
        setMaNCC(maNCC);
        return this;
    }

    public YeuCauPhieuNhap_DTO VAT(double VAT) {
        setVAT(VAT);
        return this;
    }

    public YeuCauPhieuNhap_DTO xuatXu(String xuatXu) {
        setXuatXu(xuatXu);
        return this;
    }

    public YeuCauPhieuNhap_DTO soLuong(int soLuong) {
        setSoLuong(soLuong);
        return this;
    }

    public YeuCauPhieuNhap_DTO donVi(String donVi) {
        setDonVi(donVi);
        return this;
    }

    public YeuCauPhieuNhap_DTO giaNhap(double giaNhap) {
        setGiaNhap(giaNhap);
        return this;
    }

    public YeuCauPhieuNhap_DTO tongTien(double tongTien) {
        setTongTien(tongTien);
        return this;
    }

    public YeuCauPhieuNhap_DTO tonTai(boolean tonTai) {
        setTonTai(tonTai);
        return this;
    }
    @Override
    public String toString() {
        return "{" +
            " maPN='" + getMaPN() + "'" +
            ", maHN='" + getMaHN() + "'" +
            ", tenHN='" + getTenHN() + "'" +
            ", maNCC='" + getMaNCC() + "'" +
            ", VAT='" + getVAT() + "'" +
            ", xuatXu='" + getXuatXu() + "'" +
            ", soLuong='" + getSoLuong() + "'" +
            ", donVi='" + getDonVi() + "'" +
            ", giaNhap='" + getGiaNhap() + "'" +
            ", tongTien='" + getTongTien() + "'" +
            ", tonTai='" + isTonTai() + "'" +
            "}";
    }
}
