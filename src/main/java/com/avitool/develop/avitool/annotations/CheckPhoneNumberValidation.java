package com.avitool.develop.avitool.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CheckPhoneNumberValidation implements ConstraintValidator<CheckPhoneNumber, String> {
    private static final String regex = "^[^+]\\d{10}$";

    @Override
    public void initialize(CheckPhoneNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.compile(regex).matcher(s).matches();
    }
}
