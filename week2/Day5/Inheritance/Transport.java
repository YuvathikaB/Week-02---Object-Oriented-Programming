import java.util.Scanner;
class Vehicle {
    int maxSpeed;
    String fuelType;
    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }
    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}
class Car extends Vehicle {
    int seatCapacity;
    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}
class Truck extends Vehicle {
    double loadCapacity;
    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity);
    }
}
class Motorcycle extends Vehicle {
    boolean hasSidecar;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar) {
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}
public class Transport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[3];
        System.out.println("Enter Car details:");
        System.out.print("Max Speed: ");
        int carSpeed = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fuel Type: ");
        String carFuel = scanner.nextLine();
        System.out.print("Seat Capacity: ");
        int carSeats = scanner.nextInt();
        vehicles[0] = new Car(carSpeed, carFuel, carSeats);
        System.out.println("\nEnter Truck details:");
        System.out.print("Max Speed: ");
        int truckSpeed = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fuel Type: ");
        String truckFuel = scanner.nextLine();
        System.out.print("Load Capacity : ");
        double truckLoad = scanner.nextDouble();
        vehicles[1] = new Truck(truckSpeed, truckFuel, truckLoad);
        System.out.println("\nEnter Motorcycle details:");
        System.out.print("Max Speed: ");
        int motorcycleSpeed = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fuel Type: ");
        String motorcycleFuel = scanner.nextLine();
        System.out.print("Has Sidecar (true/false): ");
        boolean hasSidecar = scanner.nextBoolean();
        vehicles[2] = new Motorcycle(motorcycleSpeed, motorcycleFuel, hasSidecar);
        System.out.println("\nVehicle Information:");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println();
        }
        scanner.close();
    }
}
