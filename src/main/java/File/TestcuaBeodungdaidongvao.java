/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import DTO.ChiTietKiemHang_DTO;
import java.io.IOException;

/**
 *
 * @author pc
 */
public class TestcuaBeodungdaidongvao {
    public static void main(String[] args) throws IOException {
        ExcelFile file=new ExcelFile();
        for(ChiTietKiemHang_DTO tempChiTietKiemHang_DTO: file.nhapChiTietKiemHang())
        {
            System.out.println(tempChiTietKiemHang_DTO.toString());
        }
    }
}
