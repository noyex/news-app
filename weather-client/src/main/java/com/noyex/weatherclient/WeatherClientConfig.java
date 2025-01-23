package com.noyex.weatherclient;

import com.noyex.weatherclient.city_client.CityClient;
import com.noyex.weatherclient.city_client.CityClientUriBuilderProvider;
import com.noyex.weatherclient.city_client.ICityClient;
import com.noyex.weatherclient.city_client.ICityClientUriBuilderProvider;
import com.noyex.weatherclient.weather_client.IWeatherClient;
import com.noyex.weatherclient.weather_client.IWeatherClientUriBuilderProvider;
import com.noyex.weatherclient.weather_client.WeatherClient;
import com.noyex.weatherclient.weather_client.WeatherClientUriBuilderProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
    @Scope("prototype")
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
    @Scope("prototype")
    public WeatherClient weatherClient(IWeatherClientUriBuilderProvider uriBuilderProvider) {
        return new WeatherClient(uriBuilderProvider);
    }
}

