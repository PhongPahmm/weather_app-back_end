package spring.weatherapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.weatherapp.model.WeatherResponseCurrent;
import spring.weatherapp.model.WeatherResponseDaily;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WeatherService {
    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponseCurrent getWeatherResponseCurrent(String city) {
        String url = apiUrl + "weather?q=" + city + "&units=metric&appid=" + apiKey;
        System.out.println(url);
        return restTemplate.getForObject(url, WeatherResponseCurrent.class);
    }

    // Lấy dữ liệu dự báo 7 ngày và chuyển đổi ngày trong tuần
    public WeatherResponseDaily
    getWeatherResponseDaily(String city) {
        String url = apiUrl + "forecast?q=" + city + "&units=metric&cnt=81&appid=" + apiKey;
        System.out.println(url);
        return restTemplate.getForObject(url, WeatherResponseDaily.class);
    }
}