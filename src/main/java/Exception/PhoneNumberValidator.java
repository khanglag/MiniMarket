/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pc
 */
public class PhoneNumberValidator {
    private static final String phoneNumberRegex = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";

    public void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        if (!isValidPhoneNumberFormat(phoneNumber)) {
            throw new InvalidPhoneNumberException(phoneNumber);
        }
    }

    private boolean isValidPhoneNumberFormat(String phoneNumber) {
        Pattern pattern = Pattern.compile(phoneNumberRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}