/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

/**
 *
 * @author pc
 */
import org.apache.commons.lang3.StringUtils;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
public class ImageChooserAndMover {

    public static boolean chooseAndMoveImage( String newFileName) {
        // Tạo cửa sổ JFileChooser
        String sourceFolderPath = "path/to/source/folder"; 
        String destinationFolderPath="C:/Users/acer/OneDrive/Documents/NetBeansProjects/MiniMarket/src/main/java/images";
        String destinationFolderPath_1 = "C:/Users/acer/OneDrive/Documents/NetBeansProjects/MiniMarket/src/main/resources/images"; // Đường dẫn đến thư mục đích
        JFileChooser fileChooser = new JFileChooser(sourceFolderPath);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

        // Mở cửa sổ chọn tệp
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String sourceFilePath = selectedFile.getAbsolutePath();
            String fileName = selectedFile.getName();

            // Đường dẫn tới tệp đích
            String destinationFilePath = destinationFolderPath + File.separator + newFileName;
            String destinationFilePath_1=destinationFolderPath_1+File.separator+newFileName;
            try {
                // Di chuyển tệp ảnh đến thư mục đích
                Files.copy(selectedFile.toPath(), new File(destinationFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                Files.copy(selectedFile.toPath(), new File(destinationFilePath_1).toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Đã di chuyển tệp ảnh thành công.");

                // Lưu tên mới của ảnh vào biến dạng String
                String newImageNameAsString = newFileName;
                System.out.println("Tên ảnh mới dưới dạng String: " + newImageNameAsString);

                return true; // Trả về thành công
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false; // Trả về không thành công
    }
    public static String formatString(String parameter) {
         parameter=parameter.toLowerCase();
         parameter=StringUtils.stripAccents(parameter);
    
         parameter=parameter.replaceAll("\\s", "");
        return parameter+".jpg";
    }
    public static String formatStringFile(String file){
         String input = "/images/%s";
         System.out.println(String.format(input, file));
        return StringUtils.stripAccents(String.format(input, file));
    }
   
}
