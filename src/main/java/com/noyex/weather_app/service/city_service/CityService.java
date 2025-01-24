package com.noyex.weather_app.service.city_service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noyex.weather_app.client.city_client.ICityClient;
import com.noyex.weather_app.client.city_client.contract.CityDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {
    private final ICityClient weatherClient;
    private final ObjectMapper objectMapper;

    public CityService(ICityClient weatherClient, ObjectMapper objectMapper) {
        this.weatherClient = weatherClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public CityDto getCity(String city) {
        String jsonWeather = weatherClient.fetchCity(city);
        try{
            List<CityDto> cityDtos = objectMapper.readValue(jsonWeather, new TypeReference<List<CityDto>>() {});
            return cityDtos.getFirst();
        }
        catch (JsonProcessingException e){
            throw new RuntimeException("Error parsing weather data ", e);
        }
    }

    @Override
    public double getCityLat(CityDto city) {
        return city.latitude();
    }

    @Override
    public double getCityLon(CityDto city) {
        return city.longitude();
    }

}
