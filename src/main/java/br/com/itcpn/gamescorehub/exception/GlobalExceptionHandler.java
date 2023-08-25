package br.com.itcpn.gamescorehub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = new ErrorResponse(
                status.value(),
                LocalDateTime.now(),
                "Bad Request",
                ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage(),
                ex.getBindingResult().getFieldErrors().get(0).getField()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleNotReadableException (HttpMessageNotReadableException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponseSpecificCause errorResponse = new ErrorResponseSpecificCause(
                status.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                ex.getMostSpecificCause().getMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }
}
