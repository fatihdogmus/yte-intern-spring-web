package yte.intern.springweb.exceptionhandling;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String handleValidationErrors(MethodArgumentNotValidException exception) {
       return exception.getFieldErrors()
               .stream()
               .map(error -> error.getDefaultMessage())
               .collect(Collectors.joining("\n"));
    }
}
