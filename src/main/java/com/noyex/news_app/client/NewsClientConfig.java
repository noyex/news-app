package com.noyex.news_app.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewsClientConfig {

    @Bean
    public INewsClientUriBuilderProvider newsClientUriBuilderProvider(
            @Value("${news.api.key}") String apiKey,
            @Value("${news.api.host}") String host,
            @Value("${news.api.version}") String newsApiVersion){
        return new NewsClientUriBuilderProvider(apiKey, host, newsApiVersion);
    }

    @Bean
    public NewsClient newsClient(INewsClientUriBuilderProvider uriBuilderProvider) {
        return new NewsClient(uriBuilderProvider);
    }
}

