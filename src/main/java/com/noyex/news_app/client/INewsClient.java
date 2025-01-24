package com.noyex.news_app.client;

import java.time.LocalDate;

public interface INewsClient {
    String fetchNews(LocalDate from, String sortBy);
}
