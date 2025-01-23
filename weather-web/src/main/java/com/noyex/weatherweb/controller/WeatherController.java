package com.noyex.weatherweb.controller;


import com.noyex.weatherservice.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/weather")
public class WeatherController {

    private ICityService cityService;

    @Autowired
    public WeatherController(ICityService cityService) {
        this.cityService = cityService;
    }


}
