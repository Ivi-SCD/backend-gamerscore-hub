package br.com.itcpn.gamescorehub.config.validations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ImageUrlValidator implements ConstraintValidator<ValidImageURL, String> {

    private static final String IMAGE_URL_PATTERN =
            "^(https?|ftp)://.*(jpeg|jpg|png|gif|bmp)$";


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }

        return s.matches(IMAGE_URL_PATTERN);
    }
}

