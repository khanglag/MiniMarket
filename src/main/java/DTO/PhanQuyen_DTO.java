/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class PhanQuyen_DTO {
    private String maQuyen;
    private String tenQuyen;
    private boolean tonTai;

    public PhanQuyen_DTO() {
    }

    public PhanQuyen_DTO(String maQuyen, String tenQuyen, boolean tonTai) {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
        this.tonTai = tonTai;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    public boolean isTonTai() {
        return tonTai;
    }

    public void setTonTai(boolean tonTai) {
        this.tonTai = tonTai;
    }

    @Override
    public String toString() {
        return "PhanQuyen_DTO{" + "maQuyen=" + maQuyen + ", tenQuyen=" + tenQuyen + ", tonTai=" + tonTai + '}';
    }
    
    
    
}
