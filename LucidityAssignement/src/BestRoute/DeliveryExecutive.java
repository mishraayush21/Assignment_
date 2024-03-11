package BestRoute;


// Class to represent Delivery Executive, inheriting from User
class DeliveryExecutive extends User {
    public DeliveryExecutive(String userId, GeoLocation location) {
        super(userId, location, UserType.DELIVERY_EXECUTIVE);
    }
}
