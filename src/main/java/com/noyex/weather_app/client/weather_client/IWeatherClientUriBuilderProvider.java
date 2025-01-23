package com.noyex.weather_app.client.weather_client;

import org.springframework.web.util.UriComponentsBuilder;

public interface IWeatherClientUriBuilderProvider {
    String apiKey();
    String host();
    double dataApiVersion();

    default UriComponentsBuilder builder(){
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(host())
                .pathSegment("data/"+dataApiVersion()+"")
                .queryParam("appid", apiKey());
    }
}
