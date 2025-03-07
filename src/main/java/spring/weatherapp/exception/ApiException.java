package spring.weatherapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
    private int code;
    private String message;

    public ApiException() {}

    public ApiException(HttpStatus status, String message) {
        this.code = status.value();
        this.message = message;
    }
}
