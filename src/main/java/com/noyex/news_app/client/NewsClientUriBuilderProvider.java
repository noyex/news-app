package com.noyex.news_app.client;

import org.springframework.beans.factory.annotation.Value;

public record NewsClientUriBuilderProvider(
        String apiKey,
        String host,
        String version) implements INewsClientUriBuilderProvider {
    public NewsClientUriBuilderProvider(
            @Value("${news.api.key}") String apiKey,
            @Value("${news.api.host}") String host,
            @Value("${news.api.version}") String version) {
        this.version = version;
        this.apiKey = apiKey;
        this.host = host;
    }
}
