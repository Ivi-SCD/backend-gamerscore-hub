package br.com.itcpn.gamescorehub.config.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ImageURLValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidImageURL {
    String message() default "URL de imagem inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
