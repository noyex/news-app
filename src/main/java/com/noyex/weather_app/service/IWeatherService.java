package com.noyex.weather_app.service;

import com.noyex.weather_app.client.contract.WeatherDto;

public interface IWeatherService {
    WeatherDto getWeatherForCity(String city);
}
