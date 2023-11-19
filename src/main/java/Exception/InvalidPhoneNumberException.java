/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author pc
 */
public class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String phoneNumber) {
        super("Số điện thoại không hợp lệ: ");
    }
}