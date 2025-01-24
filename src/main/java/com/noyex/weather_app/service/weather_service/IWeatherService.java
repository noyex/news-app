package com.noyex.weather_app.service.weather_service;

import com.noyex.weather_app.client.weather_client.contract.WeatherDto;

public interface IWeatherService {
    WeatherDto getWeatherByCoordinates(double lat, double lon);
}
