/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handle;

import java.text.DecimalFormat;

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
        return String.format("%07d", number);
    }
    public static String convertTien(String tien){
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return (formatter.format(tien)+" VNĐ");
    }
}
