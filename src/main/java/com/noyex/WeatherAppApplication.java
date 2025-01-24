package com.noyex;

import com.noyex.weather_app.client.city_client.ICityClient;
import com.noyex.weather_app.client.weather_client.IWeatherClient;
import com.noyex.weather_app.service.city_service.ICityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherAppApplication implements CommandLineRunner {

	private final ICityClient cityClient;
	private final ICityService cityService;
	private final IWeatherClient weatherClient;

    public WeatherAppApplication(ICityClient cityClient, ICityService cityService,IWeatherClient weatherClient) {
        this.cityClient = cityClient;
        this.cityService = cityService;
		this.weatherClient = weatherClient;
    }


    public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
