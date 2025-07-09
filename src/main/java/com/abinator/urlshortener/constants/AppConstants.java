package com.abinator.urlshortener.constants;

import java.util.concurrent.TimeUnit;

/**
 * Application-wide constants.
 * Contains all configuration values, validation rules, and default settings.
 */
public final class AppConstants {
    
    private AppConstants() {
        throw new UnsupportedOperationException("Constants class cannot be instantiated");
    }
    
    // Redis Configuration
    /** Prefix for analytics keys in Redis */
    public static final String ANALYTICS_PREFIX = "analytics:";
    
    // TTL Configuration
    /** Default TTL for shortened URLs in seconds (1 hour) */
    public static final Long DEFAULT_TTL_SECONDS = 3600L;
    /** TTL for analytics data in days */
    public static final Long ANALYTICS_TTL_DAYS = 30L;
    /** Time unit for URL TTL */
    public static final TimeUnit TTL_TIME_UNIT = TimeUnit.SECONDS;
    /** Time unit for analytics TTL */
    public static final TimeUnit ANALYTICS_TIME_UNIT = TimeUnit.DAYS;
    
    // Validation Rules
    /** Regex pattern for URL validation */
    public static final String URL_REGEX = "^(https?://)([\\w\\.-]+)(:[0-9]+)?(/.*)?$";
    /** Maximum allowed URL length */
    public static final int MAX_URL_LENGTH = 2048;
    /** Maximum allowed key length */
    public static final int MAX_KEY_LENGTH = 10;
    /** Minimum required key length */
    public static final int MIN_KEY_LENGTH = 1;
    
    // API Endpoints
    /** Base path for API version 1 */
    public static final String API_V1_BASE = "/api/v1";
    /** URLs endpoint path */
    public static final String URLS_PATH = "/urls";
    /** Analytics endpoint path */
    public static final String ANALYTICS_PATH = "/analytics";
    /** Shorten endpoint path */
    public static final String SHORTEN_PATH = "/shorten";
    
    // Default Values
    /** Default access count for new URLs */
    public static final Long DEFAULT_ACCESS_COUNT = 0L;
}