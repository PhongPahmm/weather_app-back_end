package spring.weatherapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import spring.weatherapp.exception.CityNotFound;
import spring.weatherapp.model.WeatherResponseCurrent;
import spring.weatherapp.model.WeatherResponseDaily;

@Service
public class WeatherService {
    @Value("${openweather.api.key2}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponseCurrent getWeatherResponseCurrent(String city) {
        String url = apiUrl + "weather?q=" + city + "&units=metric&appid=" + apiKey;
        try {
            return restTemplate.getForObject(url, WeatherResponseCurrent.class);
        }catch (HttpClientErrorException e) {
            if(e.getStatusCode().value() == 404){
                throw new CityNotFound();
            }
            throw e;
        }
    }

    public WeatherResponseDaily getWeatherResponseDaily(String city) {
        String url = apiUrl + "forecast?q=" + city + "&units=metric&cnt=40&appid=" + apiKey;
        try{
            return restTemplate.getForObject(url, WeatherResponseDaily.class);
        }catch (HttpClientErrorException e) {
            if(e.getStatusCode().value() == 404){
                throw new CityNotFound();
            }
            throw e;
        }

    }
}