package com.noyex.weather_app.client.weather_client;

public interface IWeatherClient {
    String fetchCurrentWeather(double lat, double lon);
}
