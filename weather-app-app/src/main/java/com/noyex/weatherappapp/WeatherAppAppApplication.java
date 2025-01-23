package com.noyex.weatherappapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class WeatherAppAppApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(WeatherAppAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
