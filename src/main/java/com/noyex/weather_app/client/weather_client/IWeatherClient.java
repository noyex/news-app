package com.noyex.weather_app.client.weather_client;

public interface IWeatherClient {
    String fetchWeather(double lat, double lon);
}
