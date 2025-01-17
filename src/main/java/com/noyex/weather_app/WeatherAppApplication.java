package com.noyex.weather_app;

import com.noyex.weather_app.client.IWeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherAppApplication implements CommandLineRunner {

	private final IWeatherClient weatherClient;

    public WeatherAppApplication(IWeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }


    public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		weatherClient.getWeather("London");
	}

}
