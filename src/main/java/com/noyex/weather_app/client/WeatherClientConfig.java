package com.noyex.weather_app.client;

import com.noyex.weather_app.client.city_client.CityClient;
import com.noyex.weather_app.client.city_client.CityClientUriBuilderProvider;
import com.noyex.weather_app.client.city_client.ICityClientUriBuilderProvider;
import com.noyex.weather_app.client.weather_client.IWeatherClientUriBuilderProvider;
import com.noyex.weather_app.client.weather_client.WeatherClient;
import com.noyex.weather_app.client.weather_client.WeatherClientUriBuilderProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherClientConfig {

    @Bean
    public ICityClientUriBuilderProvider cityClientUriBuilderProvider(
            @Value("${api.key}") String apiKey,
            @Value("${api.host}") String host,
            @Value("${geo.api.version}") double geoApiVersion){
        return new CityClientUriBuilderProvider(apiKey, host, geoApiVersion);
    }

    @Bean
    public CityClient cityClient(ICityClientUriBuilderProvider uriBuilderProvider) {
        return new CityClient(uriBuilderProvider);
    }

    @Bean
    public IWeatherClientUriBuilderProvider weatherClientUriBuilderProvider(
            @Value("${api.key}") String apiKey,
            @Value("${api.host}") String host,
            @Value("${data.api.version}") double dataApiVersion){
        return new WeatherClientUriBuilderProvider(apiKey, host, dataApiVersion);
    }

    @Bean
    public WeatherClient weatherClient(IWeatherClientUriBuilderProvider uriBuilderProvider) {
        return new WeatherClient(uriBuilderProvider);
    }
}

