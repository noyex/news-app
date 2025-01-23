package com.noyex.weathercore.contracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CityDetailsDto(
        @JsonProperty("name") String cityName,
        @JsonProperty("lat") double latitude,
        @JsonProperty("lon") double longitude,
        @JsonProperty("country") String country,
        @JsonProperty("state") String state){
}
