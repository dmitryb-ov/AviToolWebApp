package com.avitool.develop.avitool.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckKeyValidation.class)
@Documented
public @interface CheckKey {
    public String message() default "Ключи не совпадают";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
