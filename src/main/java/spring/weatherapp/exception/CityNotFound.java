package spring.weatherapp.exception;

import org.springframework.http.HttpStatus;

public class CityNotFound extends ApiException {
    public CityNotFound() {
        super(HttpStatus.NOT_FOUND, "City not found!");
    }
}
