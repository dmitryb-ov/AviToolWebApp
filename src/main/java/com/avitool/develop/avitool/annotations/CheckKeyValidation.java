package com.avitool.develop.avitool.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckKeyValidation implements ConstraintValidator<CheckKey, String> {
    private static final String KEY = "mykey";

    @Override
    public void initialize(CheckKey constraintAnnotation) {

    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        return str.equals(KEY);
    }
}
