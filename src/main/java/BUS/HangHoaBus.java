/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HangHoaDAO;
import DTO.HangHoa_DTO;
import File.ExcelFile;
import File.ImageChooserAndMover;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author pc
 */
public class HangHoaBus {
    public HangHoaBus() {
    }

    ArrayList<HangHoa_DTO> ds;
    HangHoaDAO dao = new HangHoaDAO();

    public ArrayList<HangHoa_DTO> itemData() {
        return dao.ReadHangHoa();
    }

    public int ktSoLuong(String maHang) {
        ds = dao.searchHangHoa(maHang, null, null, null);
        return ds.get(0).getSoLuong();
    }

    public double giaBanSP(String maHang) {
        ds = dao.searchHangHoa(maHang, null, null, null);
        return ds.get(0).getGiaBan();
    }
   

    public ArrayList<HangHoa_DTO> timHangHoa(String maHH, String tenSP, String maNH, double giaBan, String xuatXu) {
        return dao.searchHangHoa(maHH, tenSP, maNH, xuatXu);
    }

    public boolean themHH(String maSP, String tenSP, String maNH, String maNCC, String donVi, double giaNhap,
            double giaBan, int soLuong, String xuatXu, boolean tonTai) {
        if (dao.daTonTaiHH(maSP)) {
                           JOptionPane.showMessageDialog(null,
                    "Hàng hoá "+tenSP+" đã tồn tại");
            return false;
                    }
        String anhSP = ImageChooserAndMover.formatString(tenSP);
        if (!ImageChooserAndMover.chooseAndMoveImage(anhSP)) {
            return false;
        }
        
        anhSP = ImageChooserAndMover.formatStringFile(anhSP);
        return dao.add(maSP, tenSP, maNH, maNCC, donVi, giaNhap, giaBan, soLuong, xuatXu, anhSP, tonTai);
    }

    public boolean xoaHangHoa(String maHH) {
        try {
            dao.delete(maHH);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Xóa hàng hóa thất bại");
        }
        return true;
    }

    public ArrayList<HangHoa_DTO> timHangHoa(String maHH, String tenHangHoa, String maNH, String maNCC) {
        return dao.searchHangHoa(maHH, maNCC, maNH, maNCC);
    }

    public boolean suaHangHoa(String maSP, String tenSP, String maNCC, double giaNhap, double giaBan, String xuatXu) {
        return dao.update(maSP, tenSP, maNCC, giaNhap, giaBan, xuatXu);
    }

    public String timHangHoa(String maHH) {
        return dao.searchHangHoa(maHH);
    }

    public ArrayList<HangHoa_DTO> sortBySoLuong(ArrayList<HangHoa_DTO> list) {
        ArrayList<HangHoa_DTO>sortList=new ArrayList<>();
        sortList=list;
        Collections.sort(sortList, new Comparator<HangHoa_DTO>() {
            @Override
            public int compare(HangHoa_DTO hh1, HangHoa_DTO hh2) {
                // Sắp xếp theo số lượng tăng dần (từ bé đến lớn)
                return Integer.compare(hh1.getSoLuong(), hh2.getSoLuong());
            }
        });
        return sortList;
    }


    public boolean giamSLSP(String maSP, int soluong) {
        if (soluong <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Số lượng hàng hoá phải lớn hơn 0");
            return false;
        }
        HangHoa_DTO dTO = new HangHoa_DTO();
        dTO = dao.searchHangHoa(maSP, null, null, null).get(0);
        int soluongcon = dTO.getSoLuong();
        if (soluongcon >= soluong) {
            dao.giamSL(maSP, soluongcon - soluong);
            return true;
        }
        return false;
    }

    public boolean tangSLSP(String maSP, int soluong) {
        if (soluong <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Số lượng hàng hoá phải lớn hơn 0");
            return false;
        }
        HangHoa_DTO dTO = new HangHoa_DTO();
        dTO = dao.searchHangHoa(maSP, null, null, null).get(0);
        int soluongcon = dTO.getSoLuong();
        if (soluongcon >= soluong) {
            dao.giamSL(maSP, soluongcon + soluong);
            return true;
        }
        return false;
    }

    public boolean themSPEX() {
        ExcelFile e = new ExcelFile();
        int startRow = 3; // Hàng bắt đầu từ 4 (vị trí 0-based)
        int startColumn = 1; // Cột 2 (vị trí 0-based)
        String erorrString="";
        try (FileInputStream fis = new FileInputStream(new File(e.chooseFileString()));
                Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Chọn sheet (ở đây giả sử chọn sheet đầu tiên)

            // Lặp qua từng dòng từ hàng bắt đầu
            for (int rowIndex = startRow; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                // Kiểm tra nếu dòng không rỗng
                if (row != null) {
                    HangHoa_DTO hhdto = new HangHoa_DTO();
                    
                    Cell cell = row.getCell(1);
                    if (cell.getStringCellValue()=="") {
                        break;
                    }
                    hhdto.setMaSP(cell.getStringCellValue());
                    cell = row.getCell(2);
                    hhdto.setTenSP(cell.getStringCellValue());
                    cell = row.getCell(3);
                    hhdto.setMaNH(cell.getStringCellValue());
                    cell = row.getCell(4);
                    hhdto.setMaNCC(cell.getStringCellValue());
                    cell = row.getCell(5);
                    hhdto.setDonVi(cell.getStringCellValue());
                    cell = row.getCell(6);
                    hhdto.setGiaNhap(cell.getNumericCellValue());
                    cell = row.getCell(7);
                    hhdto.setGiaBan(cell.getNumericCellValue());
                    cell = row.getCell(8);
                    hhdto.setSoLuong((int) cell.getNumericCellValue());
                    cell = row.getCell(9);
                    hhdto.setXuatXu(cell.getStringCellValue());
                    cell = row.getCell(10);
                    hhdto.setAnhSP(cell.getStringCellValue());
                    System.out.println("Hang hoa" + hhdto.toString());
                    if (dao.daTonTaiHH(hhdto.getMaSP())) {
                            erorrString+="\nSản phẩm "+hhdto.getMaSP()+" "+hhdto.getTenSP()+"đã tồn tại ";
                    }
                    else {
                        dao.addS(hhdto.getMaSP(), hhdto.getTenSP(), hhdto.getMaNH(), hhdto.getMaNCC(), hhdto.getDonVi(), hhdto.getGiaNhap(), hhdto.getGiaBan(), hhdto.getSoLuong(), hhdto.getXuatXu(), hhdto.getAnhSP(), true);
                    }
                }

            }

        } catch (IOException | EncryptedDocumentException ep) {
            ep.printStackTrace();
            return false;
        }
        if (erorrString!="") {
            JOptionPane.showMessageDialog(null,erorrString);
        }
        return true;
    }
    public boolean xuatHHExcel(){
        ExcelFile e= new ExcelFile();
        return e.xuatFileExcelHH(dao.ReadHangHoa());
    }
}
