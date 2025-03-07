package spring.weatherapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String, Object>> handleCityNotFoundException(ApiException e) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("code", e.getCode());
        errorResponse.put("message", e.getMessage());
        return ResponseEntity.status(e.getCode()).body(errorResponse);
    }
}
