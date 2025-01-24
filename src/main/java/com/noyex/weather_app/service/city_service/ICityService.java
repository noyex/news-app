package com.noyex.weather_app.service.city_service;

import com.noyex.weather_app.client.city_client.contract.CityDto;

public interface ICityService {
    CityDto getCity(String city);
    double getCityLat(CityDto city);
    double getCityLon(CityDto city);
}
