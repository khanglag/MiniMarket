/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handle;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Timeconvert {
    public static LocalDate convert(String dateString) {
        if (dateString!="") {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = null;
        try {
            localDate = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            // Xử lý ngoại lệ nếu chuỗi không hợp lệ
            JOptionPane.showMessageDialog(null, "Không thể chuyển đổi chuổi thành LoacalDate" + e.getMessage()
                    + "\n Chuỗi phải ở dạng: dd-MM-yyyy");
        }
        return localDate;
        }
        return null;
    }

    public static String convert(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if(date==null){
             date = LocalDate.ofEpochDay(0);
        }
        String str= date.format(formatter);
        return str;
    }
    public static LocalDate convert(java.sql.Date date) {
        LocalDate d;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        ZoneId defaultZoneId = ZoneId.systemDefault();
        if (date == null)
            return LocalDate.ofEpochDay(0);
        else
            d = date.toInstant().atZone(defaultZoneId).toLocalDate();
        return d;
    } 
    public static int TruDate(LocalDate date1, LocalDate date2) {
        long diffDays = ChronoUnit.DAYS.between(date1, date2);
        int diffDaysInt = (int) diffDays;
        return diffDaysInt;
    }
     public static String FormatString(String str) {
        if (str.equals(""))
            str = "0";
        int n = Integer.parseInt(str);
        n = n + 1;
        str = String.format("%06d", n);
        return str;
    }
      public static String DatetoString(LocalDate d){
          if (d!=null) {
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return  d.format(formatter);
          }
        return null;
      }
}
