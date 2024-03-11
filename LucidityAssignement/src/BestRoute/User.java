package BestRoute;


// Class to represent a User
class User {
    private String userId;
    private GeoLocation location;
    private UserType userType;

    public User(String userId, GeoLocation location, UserType userType) {
        this.userId = userId;
        this.location = location;
        this.userType = userType;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
