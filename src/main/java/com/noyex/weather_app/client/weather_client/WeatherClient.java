package com.noyex.weather_app.client.weather_client;

import com.noyex.weather_app.client.city_client.ICityClientUriBuilderProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient implements IWeatherClient{

    RestTemplate restTemplate;
    IWeatherClientUriBuilderProvider uriBuilderProvider;

    public WeatherClient(IWeatherClientUriBuilderProvider uriBuilderProvider) {
        this.uriBuilderProvider = uriBuilderProvider;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public String fetchCurrentWeather(double lat, double lon) {
        String url = uriBuilderProvider.builder()
                .pathSegment("weather")
                .queryParam("units", "metric")
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .build()
                .toUriString();
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
