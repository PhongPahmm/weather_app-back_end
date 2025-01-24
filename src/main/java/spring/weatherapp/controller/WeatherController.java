package spring.weatherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.weatherapp.model.WeatherResponse;
import spring.weatherapp.service.WeatherService;


@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    WeatherService weatherService;

    @GetMapping("/forecast/{city}")
    public WeatherResponse getWeatherForecast(@PathVariable String city) {
        return weatherService.getWeatherResponseByCity(city);
    }
}
