package com.noyex.news_app.client;

import java.time.LocalDate;

public interface INewsClient {
    String fetchNews(String q, String sortBy, int page);
}
