package com.noyex.news_app.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class NewsClient implements INewsClient{

    INewsClientUriBuilderProvider newsClientUriBuilderProvider;
    RestTemplate restTemplate;

    public NewsClient(INewsClientUriBuilderProvider newsClientUriBuilderProvider) {
        this.newsClientUriBuilderProvider = newsClientUriBuilderProvider;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public String fetchNews(String q, String sortBy) {
        String url = newsClientUriBuilderProvider.builder()
                .pathSegment("everything")
                .queryParam("q", q)
                .queryParam("sortBy", sortBy)
                .queryParam("pageSize", 10)
                .queryParam("page", 3)
                .queryParam("from", LocalDate.now().minusDays(7))
                .queryParam("to", LocalDate.now())
                .build()
                .toUriString();
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
