package com.noyex.news_app.client.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record NewsDto(
        @JsonProperty("status") String status,
        @JsonProperty("totalResults") int totalResults,
        @JsonProperty("articles") List<ArticleData> articles) {

    public record ArticleData(
            @JsonProperty("source") Source source,
            @JsonProperty("author") String author,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("url") String url,
            @JsonProperty("urlToImage") String urlToImage,
            @JsonProperty("publishedAt") String publishedAt,
            @JsonProperty("content") String content) {

        public record Source(
                @JsonProperty("id") String id,
                @JsonProperty("name") String name) { }
    }
}