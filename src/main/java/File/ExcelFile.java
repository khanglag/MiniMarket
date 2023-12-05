/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import BUS.ChiTietPhieuNhapBus;

import BUS.ChiTietPhieuNhapBus;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import BUS.ChiTietPhieuXuatBus;
import BUS.HangHoaBus;
import BUS.NhanvienBus;
import BUS.PhieuXuatBus;
import DAO.HangHoaDAO;
import DTO.ChiTietKiemHang_DTO;
import DTO.ChiTietPhieuNhap_DTO;
import DTO.ChiTietPhieuXuat_DTO;
import DTO.HangHoa_DTO;
import DTO.PhieuXuat_DTO;
import Handle.Timeconvert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
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
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setAlignment(HorizontalAlignment.CENTER);
            Sheet sheet = workbook.createSheet("Hàng hoá");

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
             for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                sheet.autoSizeColumn(i);
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
        NhanvienBus nvbus = new NhanvienBus();
        // Tạo một workbook mới (đối với định dạng xlsx)
        try (Workbook workbook = new XSSFWorkbook()) {
            // Tạo một sheet trong workbook
            Sheet sheet = workbook.createSheet("ChiTietPhieuXuat Data");
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setAlignment(HorizontalAlignment.CENTER);
            // Tạo dòng tiêu đề
            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("CHI TIẾT PHIẾU XUẤT");

            // Gộp ô cho tiêu đề
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));

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
            Cell totalLabelCell = totalRow.createCell(6); // Giả sử "Thành Tiền" ở cột thứ 6 (chỉ số 5)
            totalLabelCell.setCellValue("Tổng cộng");
            PhieuXuatBus bus = new PhieuXuatBus();
            double totalThanhTien = bus.timPhieuXuat(maPX, null, null, null).get(0).getTongTien();
            Cell totalValueCell = totalRow.createCell(7); // Giả sử "Thành Tiền" ở cột thứ 7 (chỉ số 6)
            totalValueCell.setCellValue(totalThanhTien);
             for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                sheet.autoSizeColumn(i);
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

    public boolean xuatChiTietPhieuNhapEX(String maPN,LocalDate ngayDate,String maNV){
        ChiTietPhieuNhapBus bus= new ChiTietPhieuNhapBus();
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("ChiTietPhieuNhap Data");
            
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setAlignment(HorizontalAlignment.CENTER);
            // Tạo dòng tiêu đề
            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("CHI TIẾT PHIẾU NHẬP");
            // Merge ô cho tiêu đề
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));

            // Tạo dòng cho tiêu đề

            
            titleCell.setCellValue("Chi tiết phiếu nhập");
              // Tạo dòng cho thời gian và nhân viên
            Row infoRow = sheet.createRow(1);
            infoRow.createCell(0).setCellValue("Thời Gian:");
            infoRow.createCell(1).setCellValue(Timeconvert.convert(ngayDate));
            infoRow.createCell(8).setCellValue("Nhân Viên:");
            infoRow.createCell(9).setCellValue(maNV);

            // Tạo dòng cho tiêu đề cột
            Row headerRow = sheet.createRow(2);
            headerRow.createCell(0).setCellValue("Mã Phiếu Nhập");
            headerRow.createCell(1).setCellValue("Mã Hàng Nhập");
            headerRow.createCell(2).setCellValue("Tên Hàng Nhập");
            headerRow.createCell(3).setCellValue("Mã NCC");
            headerRow.createCell(4).setCellValue("VAT");
            headerRow.createCell(5).setCellValue("Xuất Xứ");
            headerRow.createCell(6).setCellValue("Số Lượng");
            headerRow.createCell(7).setCellValue("Đơn Vị");
            headerRow.createCell(8).setCellValue("Giá Nhập");
            headerRow.createCell(9).setCellValue("Tổng Tiền Nhập");

          

            // Đổ dữ liệu từ danh sách vào tệp Excel
            int rowNum = 3;
            for (ChiTietPhieuNhap_DTO chiTietPhieuNhap : bus.timCTPN(maPN, "", "", "")) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(chiTietPhieuNhap.getMaPhieuNhap());
                row.createCell(1).setCellValue(chiTietPhieuNhap.getMaHangNhap());
                row.createCell(2).setCellValue(chiTietPhieuNhap.getTenHangNhap());
                row.createCell(3).setCellValue(chiTietPhieuNhap.getMaNCC());
                row.createCell(4).setCellValue(chiTietPhieuNhap.getVAT());
                row.createCell(5).setCellValue(chiTietPhieuNhap.getXuatXu());
                row.createCell(6).setCellValue(chiTietPhieuNhap.getSoLuong());
                row.createCell(7).setCellValue(chiTietPhieuNhap.getDonVi());
                row.createCell(8).setCellValue(chiTietPhieuNhap.getGiaNhap());
                row.createCell(9).setCellValue(chiTietPhieuNhap.getTongTienNhap());
            }
            for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                sheet.autoSizeColumn(i);
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
            System.out.println("Xuất Excel thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<ChiTietKiemHang_DTO> nhapChiTietKiemHang() throws FileNotFoundException, IOException{
        String filePath=chooseFileString();
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên
        ArrayList<ChiTietKiemHang_DTO> temp=new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0||row.getRowNum()==1) {
                // Bỏ qua dòng tiêu đề
                continue;
            }

            Cell cell = row.getCell(0); // Mã Phiếu
            String maPhieu = getStringValue(cell);

            cell = row.getCell(1); // Mã Sản Phẩm
            String maSanPham = getStringValue(cell);

            cell = row.getCell(2); // Tên Sản Phẩm
            String tenSanPham = getStringValue(cell);

            cell = row.getCell(3); // Số Lượng
            int soLuong = getIntValue(cell);

            cell = row.getCell(4); // Đơn Vị
            String donVi = getStringValue(cell);

            cell = row.getCell(5); // Tình Trạng Sản Phẩm
            String tinhTrang = getStringValue(cell);

            // In thông tin từ file Excel
            System.out.println("Mã Phiếu: " + maPhieu);
            System.out.println("Mã Sản Phẩm: " + maSanPham);
            System.out.println("Tên Sản Phẩm: " + tenSanPham);
            System.out.println("Số Lượng: " + soLuong);
            System.out.println("Đơn Vị: " + donVi);
            System.out.println("Tình Trạng Sản Phẩm: " + tinhTrang);
            System.out.println("----------------------");  
        }

        fileInputStream.close();
        workbook.close();
        return temp;
    }
    
     private static String getStringValue(Cell cell) {
        return cell == null ? "" : cell.getStringCellValue();
    }

    private static int getIntValue(Cell cell) {
        return cell == null ? 0 : (int) cell.getNumericCellValue();
    }
    private static double getDoubleValue(Cell cell) {
        return cell == null ? 0 :  Double.parseDouble(cell.getStringCellValue());
    }
    public boolean xuatPDFPX(String maPX){
        Document document = new Document();
        ChiTietPhieuXuatBus bus=new ChiTietPhieuXuatBus();
        JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu file");
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Lấy đường dẫn đã chọn
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                try {
            // Ghi dữ liệu vào tệp PDF
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Tiêu đề hoá đơn
            document.add(new Paragraph("Hoá Đơn Chi Tiết Phiếu Xuất"));

            // Dòng trắng
            document.add(new Paragraph(" "));

            // Dữ liệu chi tiết phiếu xuất
            for (ChiTietPhieuXuat_DTO chiTietPhieuXuat :bus.timChiTietPhieuXuat(maPX, "")) {
                document.add(new Paragraph("Mã Phiếu Xuất: " + chiTietPhieuXuat.getMaPhieuXuat()));
                document.add(new Paragraph("Mã Hàng Xuất: " + chiTietPhieuXuat.getMaHangXuat()));
                document.add(new Paragraph("Số Lượng Yêu Cầu: " + chiTietPhieuXuat.getSoLuongYC()));
                document.add(new Paragraph("Số Lượng Thực Tế: " + chiTietPhieuXuat.getSoLuongThucTe()));
                document.add(new Paragraph("Đơn Vị: " + chiTietPhieuXuat.getDonVi()));
                document.add(new Paragraph("Đơn Giá: " + chiTietPhieuXuat.getDonGia()));
                document.add(new Paragraph("Thành Tiền: " + chiTietPhieuXuat.getThanhTien()));

                // Dòng trắng giữa các chi tiết
                document.add(new Paragraph(" "));
            }

            System.out.println("Xuất PDF thành công!");
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            document.close();
        }
                System.out.println("Tạo file Excel thành công!");
            } else {
                System.out.println("Người dùng đã hủy lựa chọn.");
                return false;
            }
    return true;
    }
    public ArrayList<ChiTietPhieuNhap_DTO> nhapFileExcelPN(String maPN) throws FileNotFoundException, IOException{
        String filePath=chooseFileString();
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        ArrayList<ChiTietPhieuNhap_DTO> ds=new ArrayList<>();
        HangHoaBus bus=new HangHoaBus();
        HangHoa_DTO dTO=new HangHoa_DTO();
        dTO.setMaSP(maPN);
        ChiTietPhieuNhap_DTO temp=new ChiTietPhieuNhap_DTO();
        Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên
         for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                // Bỏ qua dòng tiêu đề
                continue;
            }
            temp.setMaPhieuNhap(maPN);
            Cell cell = row.getCell(0); // Mã Phiếu
            temp.setMaHangNhap(getStringValue(cell));
            
            cell = row.getCell(1); // Mã Phiếu
            temp.setTenHangNhap(getStringValue(cell));
            
            cell = row.getCell(2); // Mã Phiếu
            temp.setMaNCC(getStringValue(cell));
            
            cell = row.getCell(3); // Mã Phiếu
            temp.setVAT(getDoubleValue(cell));
            
            cell = row.getCell(4); // Mã Phiếu
            temp.setXuatXu(getStringValue(cell));
            
            
            cell = row.getCell(5); // Số Lượng
            temp.setSoLuong(getIntValue(cell));

            cell = row.getCell(6); // Mã Phiếu
            temp.setDonVi(getStringValue(cell));
            
            cell = row.getCell(7); // Mã Phiếu
            temp.setGiaNhap(getIntValue(cell));
            
            cell = row.getCell(8); // Mã Phiếu
            temp.setTongTienNhap(getIntValue(cell));
             System.out.println(temp.toString());
            ds.add(temp);
         }
        fileInputStream.close();
        workbook.close();
        return ds;
    }
}
