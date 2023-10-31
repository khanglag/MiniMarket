/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhomHangDAO;
import DTO.NhomHang_DTO;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class NhomHangBus {

    public NhomHangBus() {
    }
    
    NhomHangDAO dAO=new NhomHangDAO();
    public ArrayList<NhomHang_DTO> dsNhomHang(){
        return dAO.readBD();
    }
    public boolean themNH(String maNH,String tenNH){
        return dAO.add(maNH, tenNH, true);
    }
    public boolean 
}
