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


# How to use Resilience4j in Spring Boot Application

## Define @CircuitBreaker for the service call function:

```java
@Slf4j
@Service
@RequiredArgsConstructor
public class HelloWorldGateway {

    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "hello-world", fallbackMethod = "fallbackForHelloWorld")
    public String getHelloWorld() {
        log.info("calling getHelloWorld()");
        return restTemplate.getForObject("/world", String.class);
    }

    public String fallbackForHelloWorld(Throwable t) {
        log.error("Inside fallbackForGetSeller, cause - {}", t.toString());
        return "Sorry ... Service not available!!!";
    }
}

```

## Define the resilience4j properties for "hello-world" in application.yml

```yaml
resilience4j.circuitbreaker:
  instances:
    hello-world:
      registerHealthIndicator: true
      ringBufferSizeInClosedState: 7
      ringBufferSizeInHalfOpenState: 5
      waitDurationInOpenState: 30s
      failureRateThreshold: 60
      
```

## Call the defined @CircuitBreaker function in HelloWorld Service
Call the HelloWorld Service (`getHelloWorld`) from the `HelloWorldGateway`

```java
@Service
@RequiredArgsConstructor
public class HelloWorldService {

    private final HelloWorldGateway helloWorldGateway;

    public String getHelloWorld() {
        return helloWorldGateway.getHelloWorld();
    }
}
```

## License

See [LICENSE](LICENSE) file.

