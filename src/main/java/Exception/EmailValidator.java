/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author pc
 */
public class EmailValidator {

    // Hàm kiểm tra định dạng email và sử dụng throws
    public static boolean isEmailValid(String email) throws IllegalArgumentException {
        // Kiểm tra xem email có null hoặc rỗng không
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email không được null hoặc rỗng.");
        }

        // Kiểm tra xem email có chứa dấu @ không
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email phải chứa dấu @.");
        }

        // Kiểm tra xem email có dấu @ ở vị trí đầu hoặc cuối không
        if (email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException("Dấu @ không được ở đầu hoặc cuối email.");
        }

        return true; // Email hợp lệ
    }
}
