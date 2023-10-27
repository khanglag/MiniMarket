/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author pc
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class DateOfBirthValidator {
    public void validateDateOfBirth(LocalDate dateOfBirth) throws InvalidDateOfBirthException {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();

        if (age >= 100) {
            throw new InvalidDateOfBirthException("Ngày sinh không hợp lệ: Tuổi không được vượt quá 100.");
        }
        if (dateOfBirth.isAfter(currentDate)) {
            throw new InvalidDateOfBirthException("Ngày sinh không hợp lệ: phải trước ngày hiện tại.");
        }
    }
}