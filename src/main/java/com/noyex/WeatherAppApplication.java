package com.noyex;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.noyex.news_app.client.INewsClient;
import com.noyex.news_app.service.INewsService;
import com.noyex.weather_app.client.city_client.ICityClient;
import com.noyex.weather_app.client.weather_client.IWeatherClient;
import com.noyex.weather_app.service.city_service.ICityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherAppApplication implements CommandLineRunner {

	private final INewsClient newsClient;
	private final INewsService newsService;

    public WeatherAppApplication(INewsClient newsClient, INewsService newsService) {
        this.newsClient = newsClient;
        this.newsService = newsService;
    }


    public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(newsClient.fetchNews("bitcoin", "publishedAt"));
	}

}
