package com.noyex.weather_app.client.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeatherDto(
        @JsonProperty("main") MainData main,
        @JsonProperty("name") String cityName,
        @JsonProperty("wind") WindData wind,
        @JsonProperty("clouds") CloudsData clouds) {

    public record MainData(
            @JsonProperty("temp") double temperature,
            @JsonProperty("feels_like") double feelsLike,
            @JsonProperty("temp_min") double minTemperature,
            @JsonProperty("temp_max") double maxTemperature,
            @JsonProperty("pressure") int pressure,
            @JsonProperty("humidity") int humidity) {
    }

    public record WindData(
            @JsonProperty("speed") double speed) {
    }

    public record CloudsData(
            @JsonProperty("all") int cloudiness) {
    }
}
