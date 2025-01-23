package com.noyex.weather_app.client.city_client;

import org.springframework.beans.factory.annotation.Value;

public record CityClientUriBuilderProvider(String apiKey, String host,
                                           double geoApiVersion) implements ICityClientUriBuilderProvider {
    public CityClientUriBuilderProvider(
            @Value("${api.key}") String apiKey,
            @Value("${api.host}") String host,
            @Value("${geo.api.version}") double geoApiVersion) {
        this.geoApiVersion= geoApiVersion;
        this.apiKey = apiKey;
        this.host = host;

    }
}

