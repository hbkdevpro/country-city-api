# Country & City API

Simple Spring Boot API to list countries and cities with pagination.

## Setup

You need Java 21 and Maven installed.

mvn clean install
mvn spring-boot:run

API runs on http://localhost:8081

## Endpoints

- GET /api/countries - Get all countries
- GET /api/countries/{countryId}/cities?page=0&size=10 - Get cities by country
- GET /api/cities/{cityId} - Get a specific city

## Swagger

Check http://localhost:8081/swagger-ui.html

## Testing

Import the Postman collection and test everything.

## Data

Countries: Spain, India, Luxembourg
Cities: Madrid, Barcelona, New Delhi, Mumbai, Luxembourg City, Esch-sur-Alzette

All in-memory, resets on restart.

## Code

- Controllers → endpoints
- Services → logic
- DTOs → responses
- Mappers → conversions