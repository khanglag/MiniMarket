/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pc
 */
public class ExcelFile {
    public String chooseFileString(){
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
}
