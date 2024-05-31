package edu.domnikova.crossplatform.myBooks;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotExistingBookValidator.class)
public @interface NotExistingBook {

    String message() default "{BookAlreadyExisting}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
