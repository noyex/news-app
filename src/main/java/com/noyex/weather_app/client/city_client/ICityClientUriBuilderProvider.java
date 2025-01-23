package com.noyex.weather_app.client.city_client;

import org.springframework.web.util.UriComponentsBuilder;

public interface ICityClientUriBuilderProvider {
    String apiKey();
    String host();
    double geoApiVersion();

    default UriComponentsBuilder builder(){
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(host())
                .pathSegment("geo/"+geoApiVersion()+"")
                .queryParam("appid", apiKey());
    }
}
