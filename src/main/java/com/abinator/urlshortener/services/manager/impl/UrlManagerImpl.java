package com.abinator.urlshortener.services.manager.impl;

import com.abinator.urlshortener.constants.AppConstants;
import com.abinator.urlshortener.entry.Url;
import com.abinator.urlshortener.services.manager.UrlManager;
import com.google.common.hash.Hashing;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotBlank;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * Implementation of URL management service.
 * Handles URL shortening, retrieval, and analytics tracking using Redis as storage.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UrlManagerImpl implements UrlManager {
    
    private final RedisTemplate<String, Url> redisTemplate;

    /**
     * Retrieves the original URL by its short key and tracks access analytics.
     * 
     * @param key the short URL key
     * @return the original URL or null if not found
     */
    @Override
    public String getUrlByKey(@NotBlank final String key) {
        final Url urlEntry = redisTemplate.opsForValue().get(key);
        
        if (urlEntry != null) {
            trackAccess(key);
            updateAccessCount(key, urlEntry);
            return urlEntry.getUrl();
        }
        
        return null;
    }

    /**
     * Creates a shortened URL with collision detection and TTL.
     * 
     * @param url the original URL to shorten
     * @return the created URL entry with short key
     */
    @Override
    public Url shortenUrl(@NotBlank final String url) {
        final String key = generateUniqueKey(url);
        
        final Url shortUrlEntry = Url.builder()
            .key(key)
            .url(url)
            .createdAt(LocalDateTime.now())
            .accessCount(AppConstants.DEFAULT_ACCESS_COUNT)
            .ttlSeconds(AppConstants.DEFAULT_TTL_SECONDS)
            .build();

        redisTemplate.opsForValue().set(key, shortUrlEntry, 
            shortUrlEntry.getTtlSeconds(), AppConstants.TTL_TIME_UNIT);
        
        return shortUrlEntry;
    }

    /**
     * Generates a unique key with collision detection.
     * 
     * @param url the URL to generate key for
     * @return a unique key
     */
    private String generateUniqueKey(final String url) {
        String key = generateKey(url);
        
        // Handle collision by appending timestamp
        while (Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
            key = generateKey(url + System.nanoTime());
            log.warn("Key collision detected, generated new key");
        }
        
        return key;
    }

    /**
     * Generates a hash-based key for the given URL.
     * 
     * @param url the URL to hash
     * @return the generated key
     */
    private String generateKey(final String url) {
        return Hashing.murmur3_32()
            .hashString(url, StandardCharsets.UTF_8)
            .toString();
    }

    /**
     * Updates the access count for a URL entry.
     * 
     * @param key the URL key
     * @param urlEntry the URL entry to update
     */
    private void updateAccessCount(final String key, final Url urlEntry) {
        urlEntry.setAccessCount(urlEntry.getAccessCount() + 1);
        redisTemplate.opsForValue().set(key, urlEntry, 
            urlEntry.getTtlSeconds(), AppConstants.TTL_TIME_UNIT);
    }

    /**
     * Tracks access analytics in Redis with TTL.
     * 
     * @param key the URL key to track
     */
    private void trackAccess(final String key) {
        final String analyticsKey = AppConstants.ANALYTICS_PREFIX + key;
        redisTemplate.opsForValue().increment(analyticsKey);
        redisTemplate.expire(analyticsKey, 
            AppConstants.ANALYTICS_TTL_DAYS, AppConstants.ANALYTICS_TIME_UNIT);
    }
}
