/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Login.Service;

import GUI.Login.TaiKhoan;

/**
 *
 * @author khang
 */
// chức năng login
public interface TaiKhoanService {
    public TaiKhoan login(String tenDangNhap, String matKhau);
}
