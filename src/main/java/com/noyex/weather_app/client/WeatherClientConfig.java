package com.noyex.weather_app.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherClientConfig {

    @Bean
    public IWeatherClientUriBuilderProvider weatherClientUriBuilderProvider(
            @Value("${api.key}") String apiKey,
            @Value("${api.host}") String host,
            @Value("${api.version}") double apiVersion){
        return new WeatherClientUriBuilderProvider(apiKey, host, apiVersion);
    }

    @Bean
    public WeatherClient weatherClient(IWeatherClientUriBuilderProvider uriBuilderProvider) {
        return new WeatherClient(uriBuilderProvider);
    }
}

