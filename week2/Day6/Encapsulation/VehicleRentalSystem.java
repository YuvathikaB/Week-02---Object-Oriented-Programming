
import java.util.*;
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    public abstract double calculateRentalCost(int days);
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getRentalRate() {
        return rentalRate;
    }
    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Rental Rate: " + String.format("%.2f", rentalRate));
    }
}
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    @Override
    public double calculateInsurance() {
        return 0.05 * getRentalRate();
    }
    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + insurancePolicyNumber;
    }
}
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    @Override
    public double calculateInsurance() {
        return 0.03 * getRentalRate();
    }
    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + insurancePolicyNumber;
    }
}
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    @Override
    public double calculateInsurance() {
        return 0.1 * getRentalRate();
    }
    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + insurancePolicyNumber;
    }
}
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vehicles: ");
        int numVehicles = sc.nextInt();
        sc.nextLine();
        System.out.println();
        for (int i = 0; i < numVehicles; i++) {
            System.out.println("Enter details for vehicle " + (i + 1));
            System.out.print("Enter vehicle number: ");
            String vehicleNumber = sc.nextLine();
            System.out.print("Enter rental rate: ");
            double rentalRate = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter vehicle type (Car/Bike/Truck): ");
            String type = sc.nextLine();
            System.out.print("Enter insurance policy number: ");
            String insurancePolicyNumber = sc.nextLine();
            if (type.equalsIgnoreCase("Car")) {
                vehicles.add(new Car(vehicleNumber, rentalRate, insurancePolicyNumber));
            } else if (type.equalsIgnoreCase("Bike")) {
                vehicles.add(new Bike(vehicleNumber, rentalRate, insurancePolicyNumber));
            } else if (type.equalsIgnoreCase("Truck")) {
                vehicles.add(new Truck(vehicleNumber, rentalRate, insurancePolicyNumber));
            } else {
                System.out.println("Invalid vehicle type.");
                continue;
            }
            System.out.println();
        }
        System.out.println("\nVehicle Details and Costs:");
        System.out.println();
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            System.out.print("Enter rental days: ");
            int days = sc.nextInt();
            sc.nextLine();
            double rentalCost = vehicle.calculateRentalCost(days);
            System.out.println("Rental Cost: " + String.format("%.2f", rentalCost));
            if (vehicle instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) vehicle;
                System.out.println(insurableVehicle.getInsuranceDetails());
                double insuranceCost = insurableVehicle.calculateInsurance();
                System.out.println("Insurance Cost: " + String.format("%.2f", insuranceCost));
            }
            System.out.println();
        }
        sc.close();
    }
}

