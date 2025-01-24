package com.noyex.weather_app.client.weather_client.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public record WeatherDto(
        @JsonProperty("weather") List<Weather> weather,
        @JsonProperty("main") Main main,
        @JsonProperty("wind") Wind wind,
        @JsonProperty("clouds") Clouds clouds,
        @JsonProperty("sys") Sys sys,
        @JsonProperty("name") String name,
        @JsonProperty("visibility") int visibility) {

    public record Weather(
            @JsonProperty("main") String Main,
            @JsonProperty("description") String Description) { }

    public record Main(
            @JsonProperty("temp") double Temp,
            @JsonProperty("feels_like") double FeelsLike,
            @JsonProperty("temp_min") double TempMin,
            @JsonProperty("temp_max") double TempMax,
            @JsonProperty("pressure") int Pressure,
            @JsonProperty("humidity") int Humidity){ }
    public record Wind(
            @JsonProperty("speed") double Speed) { }

    public record Clouds(
            @JsonProperty("all") int All) { }

    public record Sys(
            @JsonProperty("country") String Country,
            @JsonProperty("sunrise") int sunrise,
            @JsonProperty("sunset") int sunset) { }
}
