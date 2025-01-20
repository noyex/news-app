package com.noyex.weather_app.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noyex.weather_app.client.IWeatherClient;
import com.noyex.weather_app.client.contract.WeatherDto;
import org.springframework.stereotype.Service;

@Service
public class WeatherService implements IWeatherService {
    private final IWeatherClient weatherClient;
    private final ObjectMapper objectMapper;

    public WeatherService(IWeatherClient weatherClient, ObjectMapper objectMapper) {
        this.weatherClient = weatherClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public WeatherDto getWeatherForCity(String city) {
        String jsonWeather = weatherClient.fetchWeatherForCity(city);
        try{
            return objectMapper.readValue(jsonWeather, WeatherDto.class);
        }
        catch (JsonProcessingException e){
            throw new RuntimeException("Error parsing weather data ", e);
        }
    }
}
