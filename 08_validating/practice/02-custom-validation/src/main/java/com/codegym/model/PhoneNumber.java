package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numberOfPhone;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number = phoneNumber.getNumberOfPhone();
        if (number.equals("")) {
            errors.rejectValue("numberOfPhone", "number.empty");
        }
        if (number.length()>11 || phoneNumber.numberOfPhone.length()<10){
            errors.rejectValue("numberOfPhone", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("numberOfPhone", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("numberOfPhone", "number.matches");
        }


//        String number = phoneNumber.getNumber();
//        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
//        if (number.length() > 11 || number.length() < 10) {
//            errors.rejectValue("number", "number.length");
//        }
//        if (!number.startsWith("0")) {
//            errors.rejectValue("number", "number.startsWith");
//        }
//        if (!number.matches("(^$|[0-9]*$)")) {
//            errors.rejectValue("number", "number.matches");
//        }
    }
}
