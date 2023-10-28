/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonDAO;

/**
 *
 * @author pc
 */
public class HoaDonBus {
    public HoaDonBus(){
    }
    HoaDonDAO dao =new HoaDonDAO();
    public int maHoaDonMoi(){
        return dao.demSoHoaDon()+1;
    }
}
