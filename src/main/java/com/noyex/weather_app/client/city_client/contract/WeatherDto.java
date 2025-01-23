package com.noyex.weather_app.client.city_client.contract;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherDto(
        @JsonProperty("name") String cityName,
        @JsonProperty("lat") double latitude,
        @JsonProperty("lon") double longitude,
        @JsonProperty("country") String country,
        @JsonProperty("state") String state){
}
