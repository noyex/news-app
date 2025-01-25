package com.noyex.news_app.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.noyex.news_app.client.INewsClient;
import com.noyex.translator_app.service.TranslationService;
import org.springframework.stereotype.Component;

@Component
public class NewsService implements INewsService {
    private final TranslationService translationService;
    private final INewsClient newsClient;
    private final ObjectMapper objectMapper;

    public NewsService(TranslationService translationService, INewsClient newsClient, ObjectMapper objectMapper) {
        this.translationService = translationService;
        this.newsClient = newsClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public String fetchTranslatedNews(String q, String sortBy, String targetLanguage) {
        String jsonResponse = newsClient.fetchNews(q, sortBy);

        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode articlesNode = rootNode.path("articles");

            for (JsonNode article : articlesNode) {
                String translatedTitle = translationService.translateText(
                        article.path("title").asText(), targetLanguage
                );
                ((ObjectNode) article).put("title", translatedTitle);

                String translatedDescription = translationService.translateText(
                        article.path("description").asText(), targetLanguage
                );
                ((ObjectNode) article).put("description", translatedDescription);
            }

            return objectMapper.writeValueAsString(rootNode);
        } catch (Exception e) {
            throw new RuntimeException("Error processing JSON", e);
        }
    }
}
