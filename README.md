# Lucidity_Assignment # Best Route Delivery System



# Approach and Assumptions
- The GeoLocation class represents a geographic location with a name, latitude, and longitude coordinates.
- Users are categorized into two types: DELIVERY_EXECUTIVE and CONSUMER.
- Each user has a unique user ID, and their location is represented using the GeoLocation class.
- Orders consist of a pair of locations: the restaurant from which the order originates and the consumer's location.
- The DeliveryExecutive and Consumer classes are subclasses of the User class.
- The DistanceCalculatorStrategy interface defines a method to calculate the distance between two GeoLocation objects.
- The HaversineDistanceCalculator class implements the DistanceCalculatorStrategy interface using the Haversine formula for distance calculation.
- The BestRouteDriver class orchestrates the delivery process, finding the best route for the delivery executive to follow based on the provided orders and their locations.
- The BestRouteDriver class now accepts a DistanceCalculatorStrategy implementation through its constructor, allowing for flexibility in the distance calculation algorithm.



## UML Diagram

```plantuml

class GeoLocation {
    - String name
    - double latitude
    - double longitude
    + GeoLocation(String name, double latitude, double longitude)
    + getName(): String
    + getLatitude(): double
    + getLongitude(): double
}

enum UserType {
    DELIVERY_EXECUTIVE
    CONSUMER
}

class User {
    - String userId
    - GeoLocation location
    - UserType userType
    + User(String userId, GeoLocation location, UserType userType)
    + getUserId(): String
    + setUserId(String userId): void
    + getLocation(): GeoLocation
    + setLocation(GeoLocation location): void
    + getUserType(): UserType
    + setUserType(UserType userType): void
}

class DeliveryExecutive {
    + DeliveryExecutive(String userId, GeoLocation location)
}

class Consumer {
    + Consumer(String userId, GeoLocation location)
}

class Order {
    - String orderId
    - GeoLocation restaurant
    - GeoLocation consumer
    + Order(String orderId, GeoLocation restaurant, GeoLocation consumer)
    + getOrderId(): String
    + getRestaurant(): GeoLocation
    + getConsumer(): GeoLocation
}

interface DistanceCalculatorStrategy {
    + calculateDistance(GeoLocation location1, GeoLocation location2): double
}

class HaversineDistanceCalculator {
    + calculateDistance(GeoLocation location1, GeoLocation location2): double
}

class BestRouteDriver {
    - static DistanceCalculatorStrategy distanceCalculator
    + BestRouteDriver(DistanceCalculatorStrategy distanceCalculator)
    + findBestRoute(DeliveryExecutive deliveryExecutive, List<Order> orders): List<GeoLocation>
    + main(String[] args): void
}

DeliveryExecutive --|> User
Consumer --|> User
Order "1" *-- "1" GeoLocation
DistanceCalculatorStrategy <|.. HaversineDistanceCalculator
BestRouteDriver *-- DistanceCalculatorStrategy
