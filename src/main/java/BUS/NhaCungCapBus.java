/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCap_DTO;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class NhaCungCapBus {

    public NhaCungCapBus() {
    }
    
    NhaCungCapDAO dAO=new NhaCungCapDAO();
    public ArrayList<NhaCungCap_DTO> dsNCC(){
        return dAO.ReadNhaCungCap();
    }
    public String timTenNCC(String maNCC){
        NhaCungCap_DTO dto= new NhaCungCap_DTO();
        dto=dAO.searchNCC(maNCC,null, null,null).get(0);
        return dto.getTenNCC();
    }
    public ArrayList<NhaCungCap_DTO> timNCC(String maNCC){
        
        return dAO.searchNCC(maNCC,null, null,null);
    }
}
