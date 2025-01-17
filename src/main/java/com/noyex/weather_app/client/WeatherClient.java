package com.noyex.weather_app.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient implements IWeatherClient {

    RestTemplate restTemplate;
    IWeatherClientUriBuilderProvider uriBuilderProvider;

    public WeatherClient(IWeatherClientUriBuilderProvider uriBuilderProvider) {
        this.uriBuilderProvider = uriBuilderProvider;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public String fetchWeatherForCity(String city) {
        String url = uriBuilderProvider.builder()
                .pathSegment("weather")
                .queryParam("units", "metric")
                .queryParam("q", city)
                .build()
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }
}
