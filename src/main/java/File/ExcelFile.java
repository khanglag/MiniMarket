/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import BUS.ChiTietPhieuXuatBus;
import BUS.HangHoaBus;
import BUS.PhieuXuatBus;
import DAO.HangHoaDAO;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.HangHoa_DTO;
import DTO.PhieuXuat_DTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
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

    public boolean xuatPhieuXuatEX(String maPX) {
        ArrayList<ChiTietPhieuXuat_DTO> chiTietPhieuXuatList = new ArrayList<>();
        ChiTietPhieuXuatBus busCt = new ChiTietPhieuXuatBus();
        chiTietPhieuXuatList = busCt.timChiTietPhieuXuat(maPX, null);
        // Tạo một workbook mới (đối với định dạng xlsx)
        try (Workbook workbook = new XSSFWorkbook()) {
            // Tạo một sheet trong workbook
            Sheet sheet = workbook.createSheet("ChiTietPhieuXuat Data");

            // Tạo dòng tiêu đề
            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("CHI TIẾT PHIẾU XUẤT");

            // Gộp ô cho tiêu đề
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));

            // Tạo dòng tiêu đề cho dữ liệu
            Row headerRow = sheet.createRow(1);
            String[] headers = { "Mã Phiếu Xuất", "Mã Hàng Xuất", "Tên Hàng Hóa", "Số Lượng Yêu Cầu",
                    "Số Lượng Thực Tế", "Đơn Vị", "Đơn Giá", "Thành Tiền" };
            for (int col = 0; col < headers.length; col++) {
                Cell headerCell = headerRow.createCell(col);
                headerCell.setCellValue(headers[col]);
            }
            HangHoaBus bushh = new HangHoaBus();
            ;
            // Duyệt qua danh sách đối tượng và ghi dữ liệu vào sheet
            int rowNum = 2; // Bắt đầu từ dòng thứ 3 để tránh ghi đè dòng tiêu đề
            for (ChiTietPhieuXuat_DTO chiTietPhieuXuat : chiTietPhieuXuatList) {
                Row row = sheet.createRow(rowNum++); // Tạo một dòng mới

                // Ghi dữ liệu từ thuộc tính maPhieuXuat vào cột đầu tiên (cột 0)
                Cell cellMaPhieuXuat = row.createCell(0);
                cellMaPhieuXuat.setCellValue(chiTietPhieuXuat.getMaPhieuXuat());

                // Tương tự, ghi dữ liệu từ các thuộc tính khác vào các cột tương ứng
                Cell cellMaHangXuat = row.createCell(1);
                cellMaHangXuat.setCellValue(chiTietPhieuXuat.getMaHangXuat());

                // Thêm cột "Tên Hàng Hóa"
                Cell cellTenHangHoa = row.createCell(2);
                cellTenHangHoa.setCellValue(
                        bushh.timHangHoa(chiTietPhieuXuat.getMaHangXuat(), null, null, null).get(0).getTenSP());

                Cell cellSoLuongYC = row.createCell(3);
                cellSoLuongYC.setCellValue(chiTietPhieuXuat.getSoLuongYC());

                Cell cellSoLuongThucTe = row.createCell(4);
                cellSoLuongThucTe.setCellValue(chiTietPhieuXuat.getSoLuongThucTe());

                Cell cellDonVi = row.createCell(5);
                cellDonVi.setCellValue(chiTietPhieuXuat.getDonVi());

                Cell cellDonGia = row.createCell(6);
                cellDonGia.setCellValue(chiTietPhieuXuat.getDonGia());

                Cell cellThanhTien = row.createCell(7);
                cellThanhTien.setCellValue(chiTietPhieuXuat.getThanhTien());
            }
            Row totalRow = sheet.createRow(rowNum++);
            Cell totalLabelCell = totalRow.createCell(5); // Giả sử "Thành Tiền" ở cột thứ 6 (chỉ số 5)
            totalLabelCell.setCellValue("Tổng cộng");
            PhieuXuatBus bus = new PhieuXuatBus();
            double totalThanhTien = bus.timPhieuXuat(maPX, null, null, null).get(0).getTongTien();
            Cell totalValueCell = totalRow.createCell(6); // Giả sử "Thành Tiền" ở cột thứ 7 (chỉ số 6)
            totalValueCell.setCellValue(totalThanhTien);

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

    public ArrayList<ChiTietPhieuXuat_DTO> nhapFileExcelPX() {
        ArrayList<ChiTietPhieuXuat_DTO> arrayList = new ArrayList<>();
        int startRow = 3; // Hàng bắt đầu từ 4 (vị trí 0-based)
        int startColumn = 1;
        try (FileInputStream excelFile = new FileInputStream(chooseFileString());
                Workbook workbook = WorkbookFactory.create(excelFile)) {

            // Chọn sheet đầu tiên (index 0)
            Sheet sheet = workbook.getSheetAt(0);

            // Lặp qua từng dòng từ hàng bắt đầu
            for (int rowIndex = startRow; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                // Kiểm tra nếu dòng không rỗng
                if (row != null) {
                    ChiTietPhieuXuat_DTO hangXuatDTO=new ChiTietPhieuXuat_DTO();

                    Cell cell = row.getCell(1);
                    if (cell.getStringCellValue() == "") {
                        break;
                    }
                    hangXuatDTO.setMaHangXuat(cell.getStringCellValue());
                    cell = row.getCell(2);
                    hangXuatDTO.setSoLuongYC((int) cell.getNumericCellValue());
                    cell = row.getCell(3);
                    hangXuatDTO.setSoLuongThucTe((int) cell.getNumericCellValue());
                    cell = row.getCell(4);
                    hangXuatDTO.setDonVi(cell.getStringCellValue());
                    cell = row.getCell(5);
                    hangXuatDTO.setDonGia(cell.getNumericCellValue());
                    cell = row.getCell(6);
                    hangXuatDTO.setThanhTien(cell.getNumericCellValue());
                    arrayList.add(hangXuatDTO);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
