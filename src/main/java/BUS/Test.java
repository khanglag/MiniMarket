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
        HangHoaBus bus =new HangHoaBus();
        bus.timHangHoa("", null, null, 0, null);
        KhachHangBus bus=new KhachHangBus();
        bus.themKhanhHang("Lê Duy Khang", LocalDate.now(), "0673735351", "277 Âu Dương Lân", true);
    }
}
