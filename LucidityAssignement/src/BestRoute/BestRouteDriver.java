package BestRoute;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Main class to orchestrate the delivery process
public class BestRouteDriver {

    private static DistanceCalculatorStrategy distanceCalculator = new HaversineDistanceCalculator();

    public BestRouteDriver(DistanceCalculatorStrategy distanceCalculator) {
        BestRouteDriver.distanceCalculator = distanceCalculator;
    }

    public static List<GeoLocation> findBestRoute(DeliveryExecutive deliveryExecutive, List<Order> orders) {
        List<GeoLocation> route = new ArrayList<>();
        GeoLocation currentLocation = deliveryExecutive.getLocation();

        // Lists to hold restaurants and consumers
        List<GeoLocation> restaurants = new ArrayList<>();
        List<GeoLocation> consumers = new ArrayList<>();

        // Populate restaurant and consumer lists
        for (Order order : orders) {
            restaurants.add(order.getRestaurant());
            consumers.add(order.getConsumer());
        }

        // Sort restaurants and consumers based on distance from current location
        restaurants.sort(Comparator.comparingDouble(loc -> distanceCalculator.calculateDistance(currentLocation, loc)));
        consumers.sort(Comparator.comparingDouble(loc -> distanceCalculator.calculateDistance(currentLocation, loc)));

        // Add restaurants first, then corresponding consumers
        for (int i = 0; i < orders.size(); i++) {
            route.add(restaurants.get(i));
            route.add(consumers.get(i));
        }

        return route;
    }


    public static void main(String[] args) {

        DeliveryExecutive aman = new DeliveryExecutive("DE1", new GeoLocation("Koramangala", 12.9279, 77.6271));
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", new GeoLocation("R1", 12.9298, 77.6245), new GeoLocation("C1", 12.9255, 77.6219)));
        orders.add(new Order("2", new GeoLocation("R2", 12.9285, 77.6336), new GeoLocation("C2", 12.9204, 77.6251)));
        System.out.println("Order 1");
        List<GeoLocation> route = findBestRoute(aman, orders);
        for (GeoLocation location : route) {
            System.out.print(location.getName()+"\t");
        }
        System.out.println("\n------------------");

        DeliveryExecutive aman2 = new DeliveryExecutive("DE1", new GeoLocation("Koramangala", 12.9279, 77.6271));
        List<Order> orders2 = new ArrayList<>();
        orders2.add(new Order("1", new GeoLocation("R1", 12.9298, 77.6245), new GeoLocation("C1", 12.9255, 77.6219)));
        orders2.add(new Order("2", new GeoLocation("R3", 12.9312, 77.6200), new GeoLocation("C3", 12.9325, 77.6298)));
        orders2.add(new Order("3", new GeoLocation("R2", 12.9285, 77.6336), new GeoLocation("C2", 12.9204, 77.6251)));
        System.out.println("Order 2");
        List<GeoLocation> route2 = findBestRoute(aman2, orders2);
        for (GeoLocation location : route2) {
            System.out.print(location.getName()+"\t");
        }
        System.out.println("\n------------------");
    }
}

