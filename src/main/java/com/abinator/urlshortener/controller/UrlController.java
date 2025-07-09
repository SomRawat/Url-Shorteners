package com.abinator.urlshortener.controller;

import com.abinator.urlshortener.constants.AppConstants;
import com.abinator.urlshortener.entry.Url;
import com.abinator.urlshortener.services.manager.UrlManager;
import com.abinator.urlshortener.utils.ValidationUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * REST controller for URL shortening operations.
 * Provides endpoints for creating short URLs and redirecting to original URLs.
 */
@RestController
@RequestMapping(AppConstants.API_V1_BASE + AppConstants.URLS_PATH)
@Validated
@Slf4j
@RequiredArgsConstructor
@Tag(name = "URL Shortener", description = "URL shortening and redirection API")
public class UrlController {

    private final UrlManager urlManager;

    /**
     * Creates a shortened URL for the provided long URL.
     * 
     * @param url the original URL to be shortened
     * @return ResponseEntity containing the shortened URL details or error status
     */
    @PostMapping(AppConstants.SHORTEN_PATH)
    @Operation(summary = "Shorten a URL", description = "Creates a short URL for the given long URL")
    @ApiResponse(responseCode = "200", description = "URL shortened successfully")
    @ApiResponse(responseCode = "400", description = "Invalid URL format")
    public ResponseEntity<Url> shortenUrl(
            @Parameter(description = "URL to shorten", example = "https://example.com/very/long/url")
            @RequestParam @NotBlank String url) {
        
        final String sanitizedUrl = ValidationUtils.sanitizeUrl(url);
        if (!ValidationUtils.isValidUrl(sanitizedUrl)) {
            return ResponseEntity.badRequest().build();
        }
        
        try {
            final Url shortUrlEntry = urlManager.shortenUrl(sanitizedUrl);
            return ResponseEntity.ok(shortUrlEntry);
        } catch (Exception e) {
            log.error("Failed to shorten URL: {}", sanitizedUrl, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Redirects to the original URL using the short key.
     * Tracks access analytics and increments usage counter.
     * 
     * @param key the short URL key
     * @return ResponseEntity with redirect status or error status
     */
    @GetMapping("/{key}")
    @Operation(summary = "Redirect to original URL", description = "Redirects to the original URL using the short key")
    @ApiResponse(responseCode = "302", description = "Redirect to original URL")
    @ApiResponse(responseCode = "404", description = "Short URL not found")
    public ResponseEntity<Void> redirectUrl(
            @Parameter(description = "Short URL key", example = "abc123")
            @PathVariable String key) {
        
        if (!ValidationUtils.isValidKey(key)) {
            return ResponseEntity.badRequest().build();
        }
        
        try {
            final String sanitizedKey = ValidationUtils.sanitizeKey(key);
            final String originalUrl = urlManager.getUrlByKey(sanitizedKey);
            
            if (originalUrl != null) {
                return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(originalUrl))
                    .build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Failed to retrieve URL for key: {}", key, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
