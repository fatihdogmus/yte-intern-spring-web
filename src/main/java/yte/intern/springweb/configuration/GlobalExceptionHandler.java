package yte.intern.springweb.configuration;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public List<String> handleValidationException(MethodArgumentNotValidException exception) {
        return exception.getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();
    }
}
