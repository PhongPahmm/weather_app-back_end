package spring.weatherapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.weatherapp.model.WeatherResponse;

@Service
public class WeatherService {
    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeatherResponseByCity(String city) {
        String url = apiUrl + "weather?q=" + city + "&units=metric&appid=" + apiKey;
        System.out.println(url);
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}