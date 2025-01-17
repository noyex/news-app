package com.noyex.weather_app.controller;

import com.noyex.weather_app.client.contract.WeatherDto;
import com.noyex.weather_app.service.IWeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/weather")
public class WeatherController {

    private final IWeatherService weatherService;

    public WeatherController(IWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherDto> getWeatherForCity(@PathVariable String city){
        return ResponseEntity.ok(weatherService.getWeatherForCity(city));
    }


}
