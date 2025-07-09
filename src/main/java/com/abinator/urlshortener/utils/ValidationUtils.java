package com.abinator.urlshortener.utils;

import com.abinator.urlshortener.constants.AppConstants;

import java.util.regex.Pattern;

/**
 * Utility class for input validation and sanitization.
 * Provides methods to validate URLs and keys according to application constraints.
 */
public final class ValidationUtils {
    
    private static final Pattern URL_PATTERN = Pattern.compile(AppConstants.URL_REGEX);
    
    private ValidationUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    /**
     * Validates if the provided URL meets application requirements.
     * 
     * @param url the URL to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidUrl(final String url) {
        return url != null 
            && !url.trim().isEmpty() 
            && url.length() <= AppConstants.MAX_URL_LENGTH 
            && URL_PATTERN.matcher(url).matches();
    }
    
    /**
     * Validates if the provided key meets application requirements.
     * 
     * @param key the key to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidKey(final String key) {
        if (key == null || key.trim().isEmpty()) {
            return false;
        }
        
        final int keyLength = key.length();
        return keyLength >= AppConstants.MIN_KEY_LENGTH 
            && keyLength <= AppConstants.MAX_KEY_LENGTH;
    }
    
    /**
     * Sanitizes URL input by trimming whitespace.
     * 
     * @param url the URL to sanitize
     * @return sanitized URL or null if input is null
     */
    public static String sanitizeUrl(final String url) {
        return url != null ? url.trim() : null;
    }
    
    /**
     * Sanitizes key input by trimming whitespace and converting to lowercase.
     * 
     * @param key the key to sanitize
     * @return sanitized key or null if input is null
     */
    public static String sanitizeKey(final String key) {
        return key != null ? key.trim().toLowerCase() : null;
    }
}