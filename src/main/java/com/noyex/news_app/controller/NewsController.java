package com.noyex.news_app.controller;

import com.noyex.news_app.service.INewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewsController {
    private final INewsService newsService;

    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }
}
