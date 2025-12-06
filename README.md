# API Languages

A simple Spring Boot REST API for managing programming languages stored in MongoDB. The service exposes endpoints to list existing languages, fetch a single language, create new entries, and update rankings.

## Prerequisites
- Java 11+
- Gradle (Gradle Wrapper included)
- Access to a MongoDB database

> The default connection string is defined in `src/main/resources/application.yml`. Override it with the `SPRING_DATA_MONGODB_URI` environment variable for local development.

## Running the application
1. Install dependencies and run the application:
   ```bash
   ./gradlew bootRun
   ```
2. By default the API starts on port `8011`. You can change the port by setting `SERVER_PORT` or editing `src/main/resources/application.yml`.

## API overview
All endpoints return or accept `Language` documents shaped like:
```json
{
  "id": "<string>",
  "title": "<name>",
  "image": "<url>",
  "ranking": <number>
}
```

### Endpoints
| Method | Path | Description |
| --- | --- | --- |
| `GET` | `/languages` | List all languages |
| `GET` | `/language/{id}` | Retrieve a language by its ID |
| `POST` | `/language` | Create a new language document |
| `PATCH` | `/language/{id}/{ranking}` | Update the ranking for an existing language |

### Sample requests
- List all languages
  ```bash
  curl http://localhost:8011/languages
  ```

- Create a language
  ```bash
  curl -X POST http://localhost:8011/language \
    -H "Content-Type: application/json" \
    -d '{"title": "Java", "image": "https://example.com/java.png", "ranking": 1}'
  ```

- Update a ranking
  ```bash
  curl -X PATCH http://localhost:8011/language/<id>/2
  ```

## Running tests
Execute the test suite with:
```bash
./gradlew test
```
