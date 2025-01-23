package com.noyex.weather_app.client.city_client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CityClient implements ICityClient {

    RestTemplate restTemplate;
    ICityClientUriBuilderProvider uriBuilderProvider;

    public CityClient(ICityClientUriBuilderProvider uriBuilderProvider) {
        this.uriBuilderProvider = uriBuilderProvider;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public String fetchCity(String city) {
        String url = uriBuilderProvider.builder()
                .pathSegment("direct")
                .queryParam("units", "metric")
                .queryParam("q", city)
                .build()
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }
}
