package com.noyex.weather_app.controller;

import com.noyex.weather_app.client.city_client.contract.CityDto;
import com.noyex.weather_app.client.weather_client.contract.WeatherDto;
import com.noyex.weather_app.service.city_service.ICityService;
import com.noyex.weather_app.service.weather_service.IWeatherService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/weather")
public class WeatherController {

    private final ICityService cityService;
    private final IWeatherService weatherService;

    public WeatherController(ICityService cityService, IWeatherService weatherService) {
        this.cityService = cityService;
        this.weatherService = weatherService;
    }



    @GetMapping("/{city}")
    @Cacheable("weather")
    public ResponseEntity<WeatherDto> getWeatherForCity(@PathVariable String city){
        CityDto cityDto = cityService.getCity(city);
        double lat = cityService.getCityLat(cityDto);
        double lon = cityService.getCityLon(cityDto);
        WeatherDto weatherDto = weatherService.getWeatherByCoordinates(lat, lon);
        return ResponseEntity.ok(weatherDto);
    }

}
