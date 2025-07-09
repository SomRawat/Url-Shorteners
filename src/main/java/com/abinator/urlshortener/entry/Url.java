package com.abinator.urlshortener.entry;

import com.abinator.urlshortener.constants.AppConstants;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Entity representing a shortened URL with metadata.
 * Contains the short key, original URL, creation timestamp, access count, and TTL.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "URL entity for shortening service")
public class Url {

    /** The shortened URL key */
    @NotBlank(message = "Key cannot be blank")
    @Size(min = AppConstants.MIN_KEY_LENGTH, max = AppConstants.MAX_KEY_LENGTH, 
          message = "Key must be between " + AppConstants.MIN_KEY_LENGTH + " and " + AppConstants.MAX_KEY_LENGTH + " characters")
    @Schema(description = "Short URL key", example = "abc123")
    private String key;

    /** The original long URL */
    @NotBlank(message = "URL cannot be blank")
    @Pattern(regexp = "^https?://.*", message = "URL must start with http:// or https://")
    @Size(max = AppConstants.MAX_URL_LENGTH, message = "URL cannot exceed " + AppConstants.MAX_URL_LENGTH + " characters")
    @Schema(description = "Original URL", example = "https://example.com/very/long/url")
    private String url;

    /** Timestamp when the URL was created */
    @Schema(description = "Creation timestamp")
    private LocalDateTime createdAt;

    /** Number of times the URL has been accessed */
    @Builder.Default
    @Schema(description = "Number of times URL was accessed", example = "0")
    private Long accessCount = AppConstants.DEFAULT_ACCESS_COUNT;

    /** Time-to-live in seconds */
    @Builder.Default
    @Schema(description = "TTL in seconds", example = "3600")
    private Long ttlSeconds = AppConstants.DEFAULT_TTL_SECONDS;
}
