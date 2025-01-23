package com.noyex.weatherclient;

import com.noyex.weatherclient.city_client.CityClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherClientApplication implements CommandLineRunner {

    private final CityClient cityClient;

    public WeatherClientApplication(CityClient cityClient) {
        this.cityClient = cityClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(cityClient.fetchCity("Warsaw"));
    }
}
