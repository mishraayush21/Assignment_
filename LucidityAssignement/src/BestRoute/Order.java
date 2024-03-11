package BestRoute;

// Class to represent Order
class Order {
    private String orderId;
    private GeoLocation restaurant;
    private GeoLocation consumer;

    public Order(String orderId, GeoLocation restaurant, GeoLocation consumer) {
        this.orderId = orderId;
        this.restaurant = restaurant;
        this.consumer = consumer;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public GeoLocation getRestaurant() {
        return restaurant;
    }

    public GeoLocation getConsumer() {
        return consumer;
    }
}
