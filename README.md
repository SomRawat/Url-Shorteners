# URL Shortener Microservice

A Redis-powered microservice built with Spring Boot 3.1.5 and Java 21 to generate short URLs with TTL, collision detection, redirect analytics, and link tracking.

## Architecture Overview

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Client App    │───▶│  URL Shortener  │───▶│     Redis       │
│                 │    │   Microservice  │    │    Database     │
└─────────────────┘    └─────────────────┘    └─────────────────┘
                              │
                              ▼
                       ┌─────────────────┐
                       │   Analytics     │
                       │   & Tracking    │
                       └─────────────────┘
```

## Features

- **URL Shortening**: Generate short URLs using Murmur3 hash algorithm
- **TTL Support**: Configurable Time-To-Live for shortened URLs (default: 1 hour)
- **Collision Detection**: Automatic key regeneration on hash collisions
- **Analytics Tracking**: Track access count and usage statistics
- **URL Validation**: Input validation with proper error handling
- **Production Security**: Spring Security with admin endpoint protection
- **Health Monitoring**: Spring Actuator with Prometheus metrics
- **API Documentation**: Interactive Swagger UI
- **Graceful Shutdown**: Proper application lifecycle management

## Technology Stack

- **Java 21** - Latest LTS version with modern features
- **Spring Boot 3.1.5** - Production-ready framework
- **Redis** - High-performance in-memory database
- **Swagger/OpenAPI 3** - API documentation
- **Docker** - Containerization
- **Prometheus** - Metrics and monitoring
- **Lombok** - Boilerplate code reduction

## API Endpoints

### URL Shortening
```bash
POST /api/v1/urls/shorten?url=https://example.com/very/long/url
```

**Response:**
```json
{
  "key": "abc123",
  "url": "https://example.com/very/long/url",
  "created_at": "2024-01-01T12:00:00",
  "access_count": 0,
  "ttl_seconds": 3600
}
```

### URL Redirection
```bash
GET /api/v1/urls/{key}
```
Returns HTTP 302 redirect to original URL.

### Analytics
```bash
GET /api/v1/analytics/{key}
```

**Response:**
```json
{
  "key": "abc123",
  "accessCount": 42,
  "analyticsKey": "analytics:abc123"
}
```

### Health & Monitoring
- `GET /actuator/health` - Health check
- `GET /actuator/info` - Application info
- `GET /actuator/metrics` - Application metrics (Admin)
- `GET /actuator/prometheus` - Prometheus metrics (Admin)

### API Documentation
- `GET /swagger-ui.html` - Interactive API documentation
- `GET /v3/api-docs` - OpenAPI specification

## Quick Start

### Using Docker Compose (Recommended)
```bash
git clone <repository>
cd url-shortener
docker-compose up --build
```

### Local Development
```bash
# Start Redis
docker run -d -p 6379:6379 redis:7-alpine

# Run application
./gradlew bootRun
```

## Usage Examples

### 1. Shorten a URL
```bash
curl -X POST "http://localhost:8080/api/v1/urls/shorten?url=https://github.com/spring-projects/spring-boot" \
  -H "Content-Type: application/json"
```

**Response:**
```json
{
  "key": "f8a3b2c1",
  "url": "https://github.com/spring-projects/spring-boot",
  "created_at": "2024-01-01T12:00:00",
  "access_count": 0,
  "ttl_seconds": 3600
}
```

### 2. Access Short URL (Redirect)
```bash
curl -L "http://localhost:8080/api/v1/urls/f8a3b2c1"
```
This will redirect (HTTP 302) to the original URL and increment the access counter.

### 3. Get Analytics
```bash
curl "http://localhost:8080/api/v1/analytics/f8a3b2c1"
```

**Response:**
```json
{
  "key": "f8a3b2c1",
  "accessCount": 5,
  "analyticsKey": "analytics:f8a3b2c1"
}
```

### 4. Health Check
```bash
curl "http://localhost:8080/actuator/health"
```

### 5. View API Documentation
Open browser: `http://localhost:8080/swagger-ui.html`

## Data Flow Diagram

```
┌─────────────┐
│   Request   │
│ POST /shorten│
└──────┬──────┘
       │
       ▼
┌─────────────┐    ┌─────────────┐
│ Validation  │───▶│ Hash Gen    │
│ URL Format  │    │ Murmur3     │
└─────────────┘    └──────┬──────┘
                          │
                          ▼
                   ┌─────────────┐
                   │ Collision   │
                   │ Detection   │
                   └──────┬──────┘
                          │
                          ▼
                   ┌─────────────┐    ┌─────────────┐
                   │ Store Redis │───▶│ Return Key  │
                   │ with TTL    │    │ & Metadata  │
                   └─────────────┘    └─────────────┘

┌─────────────┐
│   Request   │
│ GET /{key}  │
└──────┬──────┘
       │
       ▼
┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│ Fetch Redis │───▶│ Track       │───▶│ HTTP 302    │
│ by Key      │    │ Analytics   │    │ Redirect    │
└─────────────┘    └─────────────┘    └─────────────┘
```

## Configuration

### Environment Variables
- `REDIS_HOST` - Redis hostname (default: localhost)
- `REDIS_PORT` - Redis port (default: 6379)
- `REDIS_PASSWORD` - Redis password (optional)
- `ADMIN_USER` - Admin username (default: admin)
- `ADMIN_PASSWORD` - Admin password (default: changeme)
- `PORT` - Application port (default: 8080)

### Production Deployment
```bash
docker build -t urlshortener:prod .
docker run -d -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e REDIS_HOST=redis-server \
  -e ADMIN_PASSWORD=secure_password \
  urlshortener:prod
```

## Key Features Explained

### 1. TTL (Time-To-Live)
- Default: 1 hour (3600 seconds)
- Automatically expires URLs in Redis
- Configurable per URL

### 2. Collision Detection
- Uses Murmur3 hash algorithm
- Detects hash collisions
- Automatically generates new keys with timestamp

### 3. Analytics Tracking
- Tracks access count per URL
- Stores analytics data separately
- 30-day retention for analytics

### 4. Validation
- URL format validation (http/https)
- Input size limits
- Proper error responses

## Monitoring & Observability

- **Health Checks**: Built-in health endpoints
- **Metrics**: Prometheus-compatible metrics
- **Logging**: Structured logging with correlation IDs
- **Swagger UI**: Interactive API documentation

## Security

- **Input Validation**: Comprehensive request validation
- **Admin Protection**: Basic auth for admin endpoints
- **CSRF Protection**: Disabled for API usage
- **Container Security**: Non-root user in Docker

## Development

### Code Structure
```
src/main/java/com/abinator/urlshortener/
├── config/          # Configuration classes
├── controller/      # REST controllers
├── entry/          # Data entities
├── exception/      # Exception handlers
└── services/       # Business logic
```

### Key Design Patterns
- **Dependency Injection**: Using `@RequiredArgsConstructor`
- **Builder Pattern**: For entity creation
- **Repository Pattern**: For data access
- **Global Exception Handling**: Centralized error handling