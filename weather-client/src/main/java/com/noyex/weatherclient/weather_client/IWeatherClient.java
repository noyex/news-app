package com.noyex.weatherclient.weather_client;

import org.springframework.stereotype.Component;

@Component
public interface IWeatherClient {
    String fetchWeather(double lat, double lon);
}
