package com.abinator.urlshortener.services.manager;

import com.abinator.urlshortener.entry.Url;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;

/**
 * Service interface for URL management operations.
 * Provides methods for URL shortening and retrieval with validation.
 */
@Validated
public interface UrlManager {
    
    /**
     * Retrieves the original URL by its short key.
     * 
     * @param key the short URL key (must not be blank)
     * @return the original URL or null if not found
     */
    String getUrlByKey(@NotBlank String key);
    
    /**
     * Creates a shortened URL for the given original URL.
     * 
     * @param url the original URL to shorten (must not be blank)
     * @return the created URL entity with short key and metadata
     */
    Url shortenUrl(@NotBlank String url);
}
