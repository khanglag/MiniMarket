/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author pc
 */
public class ExceptionInputData extends Exception {
    public class InvalidPhoneNumberException extends Exception {
        public InvalidPhoneNumberException() {
            super("Số điện thoại không hợp lệ.");
        }

        public InvalidPhoneNumberException(String message) {
            super(message);
        }
    }

    // Lớp ngoại lệ kiểm tra cho địa chỉ email không hợp lệ
    public class InvalidEmailFormatException extends Exception {
        public InvalidEmailFormatException() {
            super("Email không đúng định dạng.");
        }

        public InvalidEmailFormatException(String message) {
            super(message);
        }
    }

    // Lớp ngoại lệ không kiểm tra cho ngày sinh không hợp lệ
    public class InvalidDateOfBirthException extends RuntimeException {
        public InvalidDateOfBirthException() {
            super("Ngày sinh không hợp lệ.");
        }

        public InvalidDateOfBirthException(String message) {
            super(message);
        }
    }
}
