package GUI.Login;

public class TaiKhoan {
    private String Ten_dn;
    private String Mat_khau;

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }
    private String Quyen;
    private boolean tontai;

    public TaiKhoan() {
    }

    public TaiKhoan(String Ten_dn, String Mat_khau,String Quyen, boolean tontai) {
        this.Ten_dn = Ten_dn;
        this.Mat_khau = Mat_khau;
        this.Quyen = Quyen;
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

    public TaiKhoan Ten_dn(String Ten_dn) {
        setTen_dn(Ten_dn);
        return this;
    }

    public TaiKhoan Mat_khau(String Mat_khau) {
        setMat_khau(Mat_khau);
        return this;
    }

    public TaiKhoan tontai(boolean tontai) {
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