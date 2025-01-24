package com.noyex.news_app.client;

import org.springframework.web.util.UriComponentsBuilder;

public interface INewsClientUriBuilderProvider {
    String apiKey();
    String host();
    String version();

    default UriComponentsBuilder builder(){
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(host())
                .pathSegment(version())
                .queryParam("apiKey", apiKey());
    }
}
