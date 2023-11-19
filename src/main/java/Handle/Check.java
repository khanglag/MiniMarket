/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handle;

/**
 *
 * @author khang
 */
public class Check {
    public static boolean isNumeric(String str) {
        // Sử dụng biểu thức chính quy để kiểm tra
        return str.matches("-?\\d+(\\.\\d+)?");  
        // Biểu thức này sẽ kiểm tra chuỗi có thể là số nguyên hoặc số thực
    }
    
}
