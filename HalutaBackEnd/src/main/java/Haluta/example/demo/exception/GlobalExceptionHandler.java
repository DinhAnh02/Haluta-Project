package Haluta.example.demo.exception;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@ComponentScan
@ControllerAdvice(basePackages = "Haluta.example.demo.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        assert ex.getBindingResult() != null;
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
