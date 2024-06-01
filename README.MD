## Order Service with Template Pattern

This repository demonstrates the Template Method design pattern for handling restaurant orders based on a DomainType enum received in the request header ("X-Restaurant-Type").

### Project Structure
``` shell
order-service/
├── pom.xml (if using Maven)
├── src/main/java/
│   ├── com/example/orderservice/
│   │   ├── CreateOrderServiceRequest.java
│   │   ├── CreateOrderServiceResponse.java
│   │   ├── DomainType.java
│   │   ├── RestaurantService.java
│   │   ├── ChineseRestaurant.java
│   │   └── TurkishRestaurant.java
├── src/main/resources/application.properties (optional for configuration)
└── src/test/java/ (for unit tests)
````

### Design Pattern: Template Method
The DomainType enum acts as a template, defining a skeleton for the order process. Each enum variant (CHINESE_RESTAURANT, TURKISH_RESTAURANT) overrides the execute() method to provide specific logic for retrieving the appropriate RestaurantService implementation (e.g., ChineseRestaurant, TurkishRestaurant).

### API Endpoint
* /order (POST): Accepts an order request body and a DomainType in the "X-Restaurant-Type" header.
* Returns a ResponseEntity<CreateOrderServiceResponse> containing order status and message.

### Code Breakdown:
### 1. DomainType.java
``` JAVA
public enum DomainType {
CHINESE_RESTAURANT (
        @Override
        public RestaurantService execute() {
            return AppContextHolder.getBean(ChineseRestaurant.class);
        }
    ),
    TURKISH_RESTAURANT (
        @Override
        public RestaurantService execute() {
            return AppContextHolder.getBean(TurkishRestaurant.class);
        }
    );
};
    public abstract RestaurantService execute();
}
```
* Defines an enum with variants representing restaurant types.
* Each variant overrides execute() to retrieve the corresponding RestaurantService using Spring's AppContextHolder.

### 2. RestaurantService.java

``` Java
public abstract class RestaurantService {
    public abstract CreateOrderServiceResponse order(CreateOrderServiceRequest request);
}
```
* Abstract base class for ChineseRestaurant and TurkishRestaurant.
* Declares the abstract order method, defining the contract for handling orders.

### 3. ChineseRestaurant.java

``` JAVA
@Slf4j
@Service
public class ChineseRestaurant extends RestaurantService {
    @Override
    public CreateOrderServiceResponse order(CreateOrderServiceRequest request) {
        log.info("Ordering Chinese food");
        return CreateOrderServiceResponse.builder()
        .success(true)
        .message("Ordering Chinese food")
        .build();
    }
}
````
* Concrete implementation for Chinese restaurants.
* Overrides order to handle Chinese order logic (replace with your actual implementation).

### 4. TurkishRestaurant.java
``` JAVA
@Slf4j
@Service
public class TurkishRestaurant extends RestaurantService {
    @Override
    public CreateOrderServiceResponse order(CreateOrderServiceResponse request) {
        log.info("Ordering Turkish food");
        return CreateOrderServiceResponse.builder()
        .success(true)
        .message("Ordering Turkish food")
        .build();
    }
}
````
* Concrete implementation for Turkish restaurants.
* Overrides order to handle Turkish order logic (replace with your actual implementation).

### 5. CreateOrderServiceRequest.java and CreateOrderServiceResponse.java

* These classes (not shown) define the request and response data structures for your order service.

### Running the Application
(Specific instructions will depend on your development environment.)
1. Build the project using Maven or your preferred build tool.
2. Deploy the service to your application server.
3. Send a POST request to /order with the desired DomainType in the "X-Restaurant-Type" header and a valid request body.

### Example Request:

``` shell
POST /order HTTP/1.1
Content-Type: application/json
X-Restaurant-Type: CHINESE_RESTAURANT 
````
``` json
{
"customerId": 123,
"items": [...]
}
````
### Example Response:
``` json
{
"success": true,
"message": "Ordering Chinese food"
}
````
## Benefits of Template Method
### Extensibility

New restaurant types can be easily added by creating new enum variants and corresponding RestaurantService implementations.
Loose Coupling: The DomainType enum acts as an intermediary, decoupling the controller from the specific restaurant implementations.
Considerations:

### Complexity

The Template Method pattern can introduce some complexity compared to simpler approaches.
Overkill: For simple scenarios, a direct implementation might be more straightforward.
Conclusion

The Template Method pattern provides a flexible and extensible approach for handling diverse order types in a centralized manner. It promotes code reuse, reduces coupling, and facilitates future enhancements.

### Next Steps

Implement the actual order logic in ChineseRestaurant and TurkishRestaurant classes.
Add unit tests to ensure the correctness of the code.
Consider using dependency injection frameworks like Spring to manage RestaurantService instances.
Explore advanced techniques like strategy pattern or chain of responsibility for more complex scenarios.