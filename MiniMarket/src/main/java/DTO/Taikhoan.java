/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pc
 */
class Taikhoan {
    private String Ten_dn;
    private String Mat_khau;
    private boolean tontai;

    public Taikhoan() {
    }

    public Taikhoan(String Ten_dn, String Mat_khau, boolean tontai) {
        this.Ten_dn = Ten_dn;
        this.Mat_khau = Mat_khau;
        this.tontai = tontai;
    }

    public String getTen_dn() {
        return this.Ten_dn;
    }

    public void setTen_dn(String Ten_dn) {
        this.Ten_dn = Ten_dn;
    }

    public String getMat_khau() {
        return this.Mat_khau;
    }

    public void setMat_khau(String Mat_khau) {
        this.Mat_khau = Mat_khau;
    }

    public boolean isTontai() {
        return this.tontai;
    }

    public boolean getTontai() {
        return this.tontai;
    }

    public void setTontai(boolean tontai) {
        this.tontai = tontai;
    }

    public Taikhoan Ten_dn(String Ten_dn) {
        setTen_dn(Ten_dn);
        return this;
    }

    public Taikhoan Mat_khau(String Mat_khau) {
        setMat_khau(Mat_khau);
        return this;
    }

    public Taikhoan tontai(boolean tontai) {
        setTontai(tontai);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " Ten_dn='" + getTen_dn() + "'" +
                ", Mat_khau='" + getMat_khau() + "'" +
                ", tontai='" + isTontai() + "'" +
                "}";
    }
}

