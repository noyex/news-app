package com.noyex.news_app.service;

import com.noyex.news_app.client.contract.NewsDto;

import java.util.List;

public interface INewsService {
    String fetchTranslatedNews(String q, String sortBy, int page);
}
