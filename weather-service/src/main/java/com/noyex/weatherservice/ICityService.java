package com.noyex.weatherservice;


import com.noyex.weathercore.contracts.CityDetailsDto;

public interface ICityService {
    CityDetailsDto getCity(String city);
    double getCityLat(CityDetailsDto city);
    double getCityLon(CityDetailsDto city);
}
