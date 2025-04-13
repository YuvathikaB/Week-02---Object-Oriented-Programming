import java.util.*;
abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    public abstract double calculateFare(double distance);
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId +
                "\nDriver Name: " + driverName +
                "\nRate per Km: $" + ratePerKm;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public String getDriverName() {
        return driverName;
    }
    public double getRatePerKm() {
        return ratePerKm;
    }
}
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
class RideCar extends RideVehicle implements GPS {
    private String currentLocation;
    public RideCar(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Garage";
    }
    @Override
    public double calculateFare(double distance) {
        double baseFare = 20;
        return baseFare + (distance * getRatePerKm());
    }
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}
class RideBike extends RideVehicle implements GPS {
    private String currentLocation;
    public RideBike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Parking Lot";
    }
    @Override
    public double calculateFare(double distance) {
        return 10 + (distance * getRatePerKm());
    }
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}
class Auto extends RideVehicle implements GPS {
    private String currentLocation;
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Stand";
    }
    @Override
    public double calculateFare(double distance) {
        return 15 + (distance * getRatePerKm());
    }
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}
public class RideHailingApp {
    public static void processRide(RideVehicle vehicle, double distance) {
        System.out.println("\nRide Summary : ");
        System.out.println();
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: " + vehicle.calculateFare(distance));
        if (vehicle instanceof GPS) {
            GPS gps = (GPS) vehicle;
            System.out.println("Current Location: " + gps.getCurrentLocation());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vehicle type (Car/Bike/Auto): ");
        String type = scanner.nextLine();
        System.out.print("Enter Vehicle ID: ");
        String vehicleId = scanner.nextLine();
        System.out.print("Enter Driver Name: ");
        String driverName = scanner.nextLine();
        System.out.print("Enter Rate per Km: ");
        double rate = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Distance of Ride (km): ");
        double distance = Double.parseDouble(scanner.nextLine());
        RideVehicle vehicle = null;
        switch (type.toLowerCase()) {
            case "car":
                vehicle = new RideCar(vehicleId, driverName, rate);
                break;
            case "bike":
                vehicle = new RideBike(vehicleId, driverName, rate);
                break;
            case "auto":
                vehicle = new Auto(vehicleId, driverName, rate);
                break;
            default:
                System.out.println("Invalid vehicle type.");
        }
        if (vehicle != null) {
            processRide(vehicle, distance);
            if (vehicle instanceof GPS) {
                GPS gps = (GPS) vehicle;
                gps.updateLocation("Customer Drop-off Point");
                System.out.println("Location Updated: " + gps.getCurrentLocation());
            }
        }
        scanner.close();
    }
}

