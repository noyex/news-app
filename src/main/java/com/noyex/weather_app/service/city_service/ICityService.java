package com.noyex.weather_app.service.city_service;

import com.noyex.weather_app.client.city_client.contract.WeatherDto;

public interface ICityService {
    WeatherDto getCity(String city);
    double getCityLat(WeatherDto city);
    double getCityLon(WeatherDto city);
}
