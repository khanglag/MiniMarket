/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QuanLy;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhap_DTO;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author acer
 */
public class TableActionCellEditor extends DefaultCellEditor {

    private TableActionEvent event;
    PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction action = new PanelAction();
        String MaPN = table.getValueAt(row, 1).toString(); // Lấy trạng thái từ cột 7
        action.initEvent(event, row, MaPN);
        action.setBackground(table.getSelectionBackground());
        String trangThai = "";
        ArrayList<PhieuNhap_DTO> thongTinPhieuNhap = pnDAO.searchPhieuNhap(MaPN, null, null, null);
        for (int i = 0; i < thongTinPhieuNhap.size(); i++) {
            PhieuNhap_DTO pn = thongTinPhieuNhap.get(i);
            trangThai = pn.getTrangThai();
        }
        switch (trangThai) {
            case "KHONG DUYET":
                action.updateStatusButton("RED", "Không duyệt", false);
              
                break;
            case "DA DUYET":
                action.updateStatusButton("GREEN", "Đã duyệt", false);

                break;
             case "DA NHAP":
               action.updateStatusButton("GREEN", "Đã nhập",false);
             
                break;
            case "CHO":
                action.updateStatusButton("YELLOW", "Chờ", true);
                break;
            default:
                // Nếu không phải trạng thái nào trong danh sách, bạn có thể đặt màu mặc định ở đây.
                action.setBackground(Color.WHITE);
                break;
        }
        return action;
    }

}
