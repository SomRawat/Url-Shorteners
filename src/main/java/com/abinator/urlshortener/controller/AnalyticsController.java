package com.abinator.urlshortener.controller;

import com.abinator.urlshortener.constants.AppConstants;
import com.abinator.urlshortener.utils.ValidationUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * REST controller for URL analytics operations.
 * Provides endpoints for retrieving access statistics for shortened URLs.
 */
@RestController
@RequestMapping(AppConstants.API_V1_BASE + AppConstants.ANALYTICS_PATH)
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Analytics", description = "URL access analytics and tracking")
public class AnalyticsController {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * Retrieves analytics data for a shortened URL.
     * 
     * @param key the short URL key
     * @return ResponseEntity containing analytics data or error status
     */
    @GetMapping("/{key}")
    @Operation(summary = "Get URL analytics", description = "Retrieve access count for a shortened URL")
    @ApiResponse(responseCode = "200", description = "Analytics retrieved successfully")
    @ApiResponse(responseCode = "400", description = "Invalid key format")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Map<String, Object>> getAnalytics(
            @Parameter(description = "Short URL key", example = "abc123")
            @PathVariable String key) {
        
        if (!ValidationUtils.isValidKey(key)) {
            return ResponseEntity.badRequest().build();
        }
        
        try {
            final String sanitizedKey = ValidationUtils.sanitizeKey(key);
            final String analyticsKey = AppConstants.ANALYTICS_PREFIX + sanitizedKey;
            final Object count = redisTemplate.opsForValue().get(analyticsKey);
            
            final Map<String, Object> analytics = Map.of(
                "key", sanitizedKey,
                "accessCount", count != null ? count : AppConstants.DEFAULT_ACCESS_COUNT,
                "analyticsKey", analyticsKey
            );
            
            return ResponseEntity.ok(analytics);
        } catch (Exception e) {
            log.error("Failed to retrieve analytics for key: {}", key, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}