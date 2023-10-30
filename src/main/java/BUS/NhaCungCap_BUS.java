/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCap_DTO;

/**
 *
 * @author pc
 */
public class NhaCungCap_BUS {

    public NhaCungCap_BUS() {
    }
    
    NhaCungCapDAO dAO=new NhaCungCapDAO();
    
    public String timTenNCC(String maNCC){
        NhaCungCap_DTO dto= new NhaCungCap_DTO();
        dto=dAO.searchNCC(maNCC,null, null,null).get(0);
        return dto.getTenNCC();
    }
}
