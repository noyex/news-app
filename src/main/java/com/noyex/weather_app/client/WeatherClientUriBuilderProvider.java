package com.noyex.weather_app.client;

import org.springframework.beans.factory.annotation.Value;

public record WeatherClientUriBuilderProvider(String apiKey, String host,
                                              double apiVersion) implements IWeatherClientUriBuilderProvider {
    public WeatherClientUriBuilderProvider(
            @Value("${api.key}") String apiKey,
            @Value("${api.host}") String host,
            @Value("${api.version}") double apiVersion) {
        this.apiVersion=apiVersion;
        this.apiKey = apiKey;
        this.host = host;
    }
}

