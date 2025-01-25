package com.noyex.news_app.controller;

import com.noyex.news_app.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/news")
@CacheConfig(cacheManager = "dailyCacheManager")
public class NewsController {

    private final INewsService newsService;

    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }



    @GetMapping
    @Cacheable("news")
    public ResponseEntity<String> getNews(
            @RequestParam(defaultValue = "technology") String q,
            @RequestParam(defaultValue = "popularity") String sortBy,
            @RequestParam(defaultValue = "1") int page) {
        return ResponseEntity.ok(newsService.fetchTranslatedNews(q, sortBy, page));
    }
}

