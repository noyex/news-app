package com.noyex.translator_app.service;

import com.noyex.translator_app.client.TranslationClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Value("${google.api.key}")
    private String apiKey;

    @Bean
    public TranslationClient translationClient() {
        return new TranslationClient(apiKey);
    }

    @Bean
    public TranslationService translationService(TranslationClient translationClient) {
        return new TranslationService(translationClient);
    }
}