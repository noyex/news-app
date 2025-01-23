package com.noyex.weather_app.controller;

import com.noyex.weather_app.client.city_client.contract.WeatherDto;
import com.noyex.weather_app.service.city_service.ICityService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/weather")
public class WeatherController {

    private final ICityService weatherService;

    public WeatherController(ICityService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherDto> getWeatherForCity(@PathVariable("city") String cityName){
        var city = weatherService.getCity(cityName);
        if (city == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(city);
    }

}
