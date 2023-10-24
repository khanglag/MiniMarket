/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Login.Service;

import GUI.Login.TaiKhoan;
import GUI.Login.DAO.TaiKhoanDAO;
import GUI.Login.DAO.TaiKhoanDAOImpl;

/**
 *
 * @author khang
 */
// chức năng login
public class TaiKhoanServiceImpl implements TaiKhoanService {

    private TaiKhoanDAO taiKhoanDAO = null;

    public TaiKhoanServiceImpl() {
        taiKhoanDAO = new TaiKhoanDAOImpl();
    }

    @Override
    public TaiKhoan login(String tenDangNhap, String matKhau) {
        return taiKhoanDAO.login(tenDangNhap, matKhau);
    }

}
