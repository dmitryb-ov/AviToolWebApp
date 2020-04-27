package com.avitool.develop.avitool.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPhoneNumberValidation.class)
@Documented
public @interface CheckPhoneNumber {
    public String message() default "Некорректный номер телефона";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
