package com.noyex;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean("hourlyCacheManager")
    @Primary
    public CacheManager hourlyCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.HOURS)
                .maximumSize(100));
        return cacheManager;
    }

    @Bean("dailyCacheManager")
    public CacheManager dailyCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.DAYS)
                .maximumSize(1000));
        return cacheManager;
    }
}