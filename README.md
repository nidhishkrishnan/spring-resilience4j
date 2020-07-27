# Resilience4j Circuit breaker implementation using Spring Boot 2

This is a Spring Boot2 example to demonstrate how we can use Resilience4j in Spring Boot2 Rest Service

## Running the app

### 1- Start the docker compose file
```
docker-compose up -d
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

and when you hit the `/hello-world` GET service you will a hello world message like as shown

<img width="600" alt="Screenshot 2020-07-27 at 23 58 34" src="https://user-images.githubusercontent.com/6831336/88596345-2dfc3880-d065-11ea-903d-6f4e65fafc12.png">

### 5- Stop the docker compose
```
docker-compose down
```

### 6- Hit the /hello-world GET service in Swagger

Now if you hit the `/hello-world` GET service in Swagger after stopping the docker compose you will get a message like as shown

<img width="600" alt="Screenshot 2020-07-28 at 00 05 12" src="https://user-images.githubusercontent.com/6831336/88596726-12456200-d066-11ea-8d1a-08b6f053f829.png">

### 7- Hit the /hello-world more than 6 times
If you hit the `/hello-world` service more than 7 times then Circuit Breaker will be open and further service hitting will be blocked for next `30 seconds`. One Sample logs is shown below

```
2020-07-28 00:07:26.329 ERROR 77427 --- [nio-8080-exec-7] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - org.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://localhost:5050/world": Connection refused (Connection refused); nested exception is java.net.ConnectException: Connection refused (Connection refused)
2020-07-28 00:07:26.705  INFO 77427 --- [nio-8080-exec-8] c.s.r.service.HelloWorldGateway          : calling getHelloWorld()
2020-07-28 00:07:26.707 ERROR 77427 --- [nio-8080-exec-8] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - org.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://localhost:5050/world": Connection refused (Connection refused); nested exception is java.net.ConnectException: Connection refused (Connection refused)
2020-07-28 00:07:27.213  INFO 77427 --- [nio-8080-exec-9] c.s.r.service.HelloWorldGateway          : calling getHelloWorld()
2020-07-28 00:07:27.215 ERROR 77427 --- [nio-8080-exec-9] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - org.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://localhost:5050/world": Connection refused (Connection refused); nested exception is java.net.ConnectException: Connection refused (Connection refused)
2020-07-28 00:07:27.770  INFO 77427 --- [io-8080-exec-10] c.s.r.service.HelloWorldGateway          : calling getHelloWorld()
2020-07-28 00:07:27.773 ERROR 77427 --- [io-8080-exec-10] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - org.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://localhost:5050/world": Connection refused (Connection refused); nested exception is java.net.ConnectException: Connection refused (Connection refused)
2020-07-28 00:07:28.142  INFO 77427 --- [nio-8080-exec-1] c.s.r.service.HelloWorldGateway          : calling getHelloWorld()
2020-07-28 00:07:28.145 ERROR 77427 --- [nio-8080-exec-1] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - org.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://localhost:5050/world": Connection refused (Connection refused); nested exception is java.net.ConnectException: Connection refused (Connection refused)
2020-07-28 00:07:28.379  INFO 77427 --- [nio-8080-exec-2] c.s.r.service.HelloWorldGateway          : calling getHelloWorld()
2020-07-28 00:07:28.381 ERROR 77427 --- [nio-8080-exec-2] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - org.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://localhost:5050/world": Connection refused (Connection refused); nested exception is java.net.ConnectException: Connection refused (Connection refused)
2020-07-28 00:07:28.657  INFO 77427 --- [nio-8080-exec-3] c.s.r.service.HelloWorldGateway          : calling getHelloWorld()
2020-07-28 00:07:28.669 ERROR 77427 --- [nio-8080-exec-3] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - org.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://localhost:5050/world": Connection refused (Connection refused); nested exception is java.net.ConnectException: Connection refused (Connection refused)
2020-07-28 00:07:28.885 ERROR 77427 --- [nio-8080-exec-5] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - io.github.resilience4j.circuitbreaker.CallNotPermittedException: CircuitBreaker 'hello-world' is OPEN and does not permit further calls
2020-07-28 00:07:29.080 ERROR 77427 --- [nio-8080-exec-4] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - io.github.resilience4j.circuitbreaker.CallNotPermittedException: CircuitBreaker 'hello-world' is OPEN and does not permit further calls
2020-07-28 00:07:29.298 ERROR 77427 --- [nio-8080-exec-6] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - io.github.resilience4j.circuitbreaker.CallNotPermittedException: CircuitBreaker 'hello-world' is OPEN and does not permit further calls
2020-07-28 00:07:29.539 ERROR 77427 --- [nio-8080-exec-7] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - io.github.resilience4j.circuitbreaker.CallNotPermittedException: CircuitBreaker 'hello-world' is OPEN and does not permit further calls
2020-07-28 00:07:29.727 ERROR 77427 --- [nio-8080-exec-8] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - io.github.resilience4j.circuitbreaker.CallNotPermittedException: CircuitBreaker 'hello-world' is OPEN and does not permit further calls
2020-07-28 00:07:29.943 ERROR 77427 --- [nio-8080-exec-9] c.s.r.service.HelloWorldGateway          : Inside fallbackForGetSeller, cause - io.github.resilience4j.circuitbreaker.CallNotPermittedException: CircuitBreaker 'hello-world' is OPEN and does not permit further calls

```

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
      ringBufferSizeInClosedState: 7 # after 7 hits circuit will be opened
      ringBufferSizeInHalfOpenState: 5
      waitDurationInOpenState: 30s # 30 seconds is the lockin period once the circuit is open
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

