package com.noyex.weather_app.client;

import org.springframework.web.client.RestTemplate;

public class WeatherClient implements IWeatherClient {

    RestTemplate restTemplate;
    IWeatherClientUriBuilderProvider uriBuilderProvider;

    public WeatherClient(IWeatherClientUriBuilderProvider uriBuilderProvider) {
        this.uriBuilderProvider = uriBuilderProvider;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public String getWeatherForCity(String city) {
        String url = uriBuilderProvider.builder()
                .pathSegment("weather")
                .queryParam("units", "metric")
                .queryParam("q", city)
                .build()
                .toUriString();
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
