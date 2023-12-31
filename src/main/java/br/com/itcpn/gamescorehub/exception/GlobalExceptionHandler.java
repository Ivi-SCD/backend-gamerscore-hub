package br.com.itcpn.gamescorehub.exception;

import br.com.itcpn.gamescorehub.exception.dto.ErrorResponse;
import br.com.itcpn.gamescorehub.exception.dto.ErrorResponseSimpleCause;
import br.com.itcpn.gamescorehub.exception.dto.ErrorResponseSpecificCause;
import br.com.itcpn.gamescorehub.exception.token.TokenErrorGenerationException;
import br.com.itcpn.gamescorehub.exception.token.TokenErrorInvalidOrExpiredException;
import br.com.itcpn.gamescorehub.exception.user.UserAlreadyHasPublicNoteOnGameException;
import br.com.itcpn.gamescorehub.exception.user.UserWithEmailOrNicknameAlreadyExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.sql.SQLIntegrityConstraintViolationException;
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
    public ResponseEntity<Object> handleNotReadableException(HttpMessageNotReadableException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponseSpecificCause errorResponse = new ErrorResponseSpecificCause(
                status.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                ex.getMostSpecificCause().getMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponseSpecificCause errorResponse = new ErrorResponseSpecificCause(
                status.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                ex.getLocalizedMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(UserAlreadyHasPublicNoteOnGameException.class)
    public ResponseEntity<Object> handleUserAlreadyHasPublicNoteOnGameException(UserAlreadyHasPublicNoteOnGameException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponseSimpleCause errorResponse = new ErrorResponseSimpleCause(
                status.value(),
                LocalDateTime.now(),
                ex.getMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(TokenErrorInvalidOrExpiredException.class)
    public ResponseEntity<Object> handleTokenErrorInvalidOrExpiredException(TokenErrorInvalidOrExpiredException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponseSimpleCause errorResponse = new ErrorResponseSimpleCause(
                status.value(),
                LocalDateTime.now(),
                ex.getMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(TokenErrorGenerationException.class)
    public ResponseEntity<Object> handleTokenErrorGenerationException(TokenErrorGenerationException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponseSimpleCause errorResponse = new ErrorResponseSimpleCause(
                status.value(),
                LocalDateTime.now(),
                ex.getMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponseSimpleCause errorResponse = new ErrorResponseSimpleCause(
                status.value(),
                LocalDateTime.now(),
                ex.getMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        ErrorResponseSimpleCause errorResponse = new ErrorResponseSimpleCause(
                status.value(),
                LocalDateTime.now(),
                ex.getMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(UserWithEmailOrNicknameAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserWithEmailOrNicknameAlreadyExistsException(UserWithEmailOrNicknameAlreadyExistsException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponseSimpleCause errorResponse = new ErrorResponseSimpleCause(
                status.value(),
                LocalDateTime.now(),
                ex.getMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentialsException() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponseSimpleCause errorResponse = new ErrorResponseSimpleCause(
                status.value(),
                LocalDateTime.now(),
                "Inexistent user or invalid password"
        );
        return ResponseEntity.status(status).body(errorResponse);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponseSimpleCause errorResponse = new ErrorResponseSimpleCause(
                status.value(),
                LocalDateTime.now(),
                "Entity not found. Value: " + ex.getMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(UnexpectedError.class)
    public ResponseEntity<Object> handleUnexpectedError(UnexpectedError ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponseSimpleCause errorResponse = new ErrorResponseSimpleCause(
                status.value(),
                LocalDateTime.now(),
                "Unexpected error: " + ex.getMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }
}

