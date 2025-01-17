package com.noyex.weather_app.client;

import org.springframework.web.util.UriComponentsBuilder;

public interface IWeatherClientUriBuilderProvider {
    String apiKey();
    String host();
    double apiVersion();

    default UriComponentsBuilder builder(){
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(host())
                .pathSegment(apiVersion()+"")
                .queryParam("appid", apiKey());
    }
}
