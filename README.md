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

<img width="600" alt="Screenshot 2020-07-27 at 23 42 03" src="https://user-images.githubusercontent.com/6831336/88595237-e5438000-d062-11ea-950c-02b09231c762.png">

## License

See [LICENSE](LICENSE) file.

