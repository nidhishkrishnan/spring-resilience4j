# Resilience4j Circuit breaker implementation using Spring Boot 2

This is a Spring Boot2 example to demonstrate how we can use Resilience4j in Spring Boot2 Rest Service

## Running the app

### 1- Start the docker compose file
```
docker-compose up
```

### 2- Verify the mock rest service

Once the `docker-compose up` is executed successfully, hit the below url to see if the mock rest service is available

**Syntax:** `http://localhost:5050/{some-message}`

**Request:** http://localhost:5050/something

**Response:** `/ - Hello something! Host:b745bed59ddf/172.27.0.2`

### 3- Run the app

```
./gradlew bootRun
```

### 4- Access Swagger UI

Open browser and execute the below url

http://localhost:8080/swagger-ui.html

You can see the swagger ui like as shown below

## License

See [LICENSE](LICENSE) file.

