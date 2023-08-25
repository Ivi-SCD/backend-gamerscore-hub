package br.com.itcpn.gamescorehub.config.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ImageUrlValidator.class)
public @interface ValidImageURL {
    String message() default "URL de capa inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
