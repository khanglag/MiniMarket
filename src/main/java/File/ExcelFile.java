/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import DAO.HangHoaDAO;
import DTO.HangHoa_DTO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author pc
 */
public class ExcelFile {
    public String chooseFileString() {
        JFileChooser fileChooser = new JFileChooser();

        // Chỉ định kiểu file cho phép chọn (ở đây là XLSX)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(filter);

        // Mở hộp thoại chọn file
        int result = fileChooser.showOpenDialog(null);

        // Kiểm tra xem người dùng đã chọn file hay chưa
        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn của file được chọn
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // In đường dẫn của file
            System.out.println("Selected file: " + filePath);

            // Bạn có thể truyền đường dẫn này cho hàm đọc file Excel ở phần trước
            // Ví dụ: Workbook workbook = readExcelFile(filePath);
            return filePath;
        } else {
            System.out.println("No file selected.");
        }
        return null;
    };

    public boolean xuatFileExcelHH(ArrayList<HangHoa_DTO> arrayList) {
        // Tạo danh sách đối tượng mẫu
        ArrayList<HangHoa_DTO> productList = new ArrayList<>();
        productList = arrayList;
        // Tạo một workbook mới (đối với định dạng xlsx)
        try (Workbook workbook = new XSSFWorkbook()) {
            // Tạo một sheet trong workbook
            Sheet sheet = workbook.createSheet("Product Data");

            // Tạo dòng tiêu đề
            Row headerRow = sheet.createRow(0);
            String[] headers = { "Mã SP", "Tên SP", "Mã NH", "Mã NCC", "Đơn vị", "Giá Nhập", "Giá Bán", "Số Lượng",
                    "Xuất Xứ", "Ảnh SP" };
            for (int col = 0; col < headers.length; col++) {
                Cell headerCell = headerRow.createCell(col);
                headerCell.setCellValue(headers[col]);
            }

            // Duyệt qua danh sách đối tượng và ghi dữ liệu vào sheet
            int rowNum = 1;
            for (HangHoa_DTO product : productList) {
                Row row = sheet.createRow(rowNum++);

                Cell cellMaSP = row.createCell(0);
                cellMaSP.setCellValue(product.getMaSP());

                // Tương tự, ghi dữ liệu từ các thuộc tính khác vào các cột tương ứng
                Cell cellTenSP = row.createCell(1);
                cellTenSP.setCellValue(product.getTenSP());

                Cell cellMaNH = row.createCell(2);
                cellMaNH.setCellValue(product.getMaNH());

                Cell cellMaNCC = row.createCell(3);
                cellMaNCC.setCellValue(product.getMaNCC());

                Cell cellDonVi = row.createCell(4);
                cellDonVi.setCellValue(product.getDonVi());

                Cell cellGiaNhap = row.createCell(5);
                cellGiaNhap.setCellValue(product.getGiaNhap());

                Cell cellGiaBan = row.createCell(6);
                cellGiaBan.setCellValue(product.getGiaBan());

                Cell cellSoLuong = row.createCell(7);
                cellSoLuong.setCellValue(product.getSoLuong());

                Cell cellXuatXu = row.createCell(8);
                cellXuatXu.setCellValue(product.getXuatXu());

                Cell cellAnhSP = row.createCell(9);
                cellAnhSP.setCellValue(product.getAnhSP());
            }

            // Sử dụng JFileChooser để chọn nơi lưu file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu file");
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Lấy đường dẫn đã chọn
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                // Ghi workbook vào file
                try (FileOutputStream fileOut = new FileOutputStream(filePath + ".xlsx")) {
                    workbook.write(fileOut);
                }

                System.out.println("Tạo file Excel thành công!");
            } else {
                System.out.println("Người dùng đã hủy lựa chọn.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
