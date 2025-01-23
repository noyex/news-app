package com.noyex.weatherclient.weather_client;

import org.springframework.beans.factory.annotation.Value;

public record WeatherClientUriBuilderProvider(String apiKey, String host,
                                           double dataApiVersion) implements IWeatherClientUriBuilderProvider {
    public WeatherClientUriBuilderProvider(
            @Value("${api.key}") String apiKey,
            @Value("${api.host}") String host,
            @Value("${data.api.version}") double dataApiVersion) {
        this.dataApiVersion= dataApiVersion;
        this.apiKey = apiKey;
        this.host = host;

    }
}
