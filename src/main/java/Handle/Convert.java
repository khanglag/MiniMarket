/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handle;

/**
 *
 * @author pc
 */
public class Convert {
    public static boolean inttobool(int a){
        if (a==1) return true;
        else return false;
    }
    public static boolean stringtobool(String str){
        if(str.equals("1")) return true;
        else return false;
    }
    public static String convertMa(int number) {
        // Sử dụng String.format để định dạng số thành chuỗi đủ 7 ký tự
        // %07d nghĩa là dùng số nguyên với độ rộng 7 ký tự, thêm số 0 vào phía trước nếu cần
        return String.format("%07d", number);
    }

}
