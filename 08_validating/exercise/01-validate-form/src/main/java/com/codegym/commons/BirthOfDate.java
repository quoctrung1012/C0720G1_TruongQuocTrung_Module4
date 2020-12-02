package com.codegym.commons;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = BirthDateValidate.class)
public @interface BirthOfDate {
    String message() default "Over 18 years old";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
