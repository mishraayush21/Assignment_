package BestRoute;

// Class to represent Consumer, inheriting from User
class Consumer extends User {
    public Consumer(String userId, GeoLocation location) {
        super(userId, location, UserType.CONSUMER);
    }
}
