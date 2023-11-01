package DTO;
 public class TaiKhoan_DTO {
    private String maNV;
    private String matKhau;
    private String maPQ;
    private boolean tonTai;

    public TaiKhoan_DTO() {
    }

    public TaiKhoan_DTO(String maNV, String matKhau, String maPQ, boolean tonTai) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.maPQ = maPQ;
        this.tonTai = tonTai;
    }

    public String getMaNV() {
        return this.maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return this.matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaPQ() {
        return this.maPQ;
    }

    public void setMaPQ(String maPQ) {
        this.maPQ = maPQ;
    }

    public boolean isTonTai() {
        return this.tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "{" +
            " maNV='" + getMaNV() + "'" +
            ", matKhau='" + getMatKhau() + "'" +
            ", maPQ='" + getMaPQ() + "'" +
            ", tonTai='" + isTonTai() + "'" +
            "}";
    }

   

 }