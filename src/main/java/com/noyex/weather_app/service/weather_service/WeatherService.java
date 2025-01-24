package com.noyex.weather_app.service.weather_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noyex.weather_app.client.weather_client.IWeatherClient;
import com.noyex.weather_app.client.weather_client.contract.WeatherDto;
import org.springframework.stereotype.Component;

@Component
public class WeatherService implements IWeatherService{
    private final IWeatherClient weatherClient;
    private final ObjectMapper objectMapper;

    public WeatherService(IWeatherClient weatherClient, ObjectMapper objectMapper) {
        this.weatherClient = weatherClient;
        this.objectMapper = objectMapper;
    }


    @Override
    public WeatherDto getWeatherByCoordinates(double lat, double lon) {
        String jsonWeather = weatherClient.fetchCurrentWeather(lat, lon);
        try {
            return objectMapper.readValue(jsonWeather, WeatherDto.class);
        } catch (JsonProcessingException e){
            throw new RuntimeException("Error parsing weather data ", e);
        }
    }
}
