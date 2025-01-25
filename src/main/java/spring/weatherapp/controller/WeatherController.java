package spring.weatherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.weatherapp.model.WeatherResponseCurrent;
import spring.weatherapp.model.WeatherResponseDaily;
import spring.weatherapp.service.WeatherService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/")
public class WeatherController {
    @Autowired
    WeatherService weatherService;

    @GetMapping("weather/{city}")
    public WeatherResponseCurrent getWeatherCurrent(@PathVariable String city) {
        return weatherService.getWeatherResponseCurrent(city);
    }

    @GetMapping("forecast/{city}")
    public WeatherResponseDaily getWeatherDaily(@PathVariable String city) {
        return weatherService.getWeatherResponseDaily(city);
    }
}
