package spring.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coord {
    @JsonProperty("lat")
    private double lat;
    @JsonProperty("lon")
    private double lon;
}
