package spring.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseDaily {
    @JsonProperty("cod")
    private String cod;

    @JsonProperty("message")
    private String message;
    @JsonProperty("list")
    private List<Daily> list;
}
