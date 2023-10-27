/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.time.LocalDate;

/**
 *
 * @author pc
 */
public class Test {
    public static void main(String[] args) {
        KhachHangBus bus=new KhachHangBus();
        bus.themKhanhHang("Lê Duy Khang", LocalDate.MIN, "0358808912", "277 Âu Dương Lân", true);
    }
}
