/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author pc
 */
public class CCCDValidator {
    public void validateCCCD(String cccd) throws InvalidCCCDException{
        String cccdPattern = "\\d{15}";

        // Tạo đối tượng Pattern
        Pattern pattern = Pattern.compile(cccdPattern);

        // Sử dụng Matcher để kiểm tra chuỗi CCCD
        Matcher matcher = pattern.matcher(cccd);

        // Kiểm tra xem CCCD có khớp với mẫu không
        if (!matcher.matches()) {
            throw new InvalidCCCDException("Sai mẫu căn cước công dân");
        }
    }
}
