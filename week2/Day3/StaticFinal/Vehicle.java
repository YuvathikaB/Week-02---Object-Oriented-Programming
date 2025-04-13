import java.util.*;
public class Vehicle {
    private static double registrationFee;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Updated Registration Fee: " + registrationFee);
    }
    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vehicles to register: ");
        int numVehicles = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the registration fee: ");
        registrationFee = scanner.nextInt();
        scanner.nextLine();
        Vehicle[] vehicles = new Vehicle[numVehicles];
        for (int i = 0; i < numVehicles; i++) {
            System.out.println("\nEnter details for Vehicle " + (i + 1) + ":");
            System.out.print("Enter Owner Name: ");
            String ownerName = scanner.nextLine();
            System.out.print("Enter Vehicle Type (Car/Bike/Truck..): ");
            String vehicleType = scanner.nextLine();
            System.out.print("Enter Registration Number: ");
            String registrationNumber = scanner.nextLine();
            vehicles[i] = new Vehicle(ownerName, vehicleType, registrationNumber);
        }
        System.out.print("\nDo you want to update the registration fee? (yes/no): ");
        String choice = scanner.next();
        System.out.println();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new registration fee: ");
            double newFee = scanner.nextDouble();
            updateRegistrationFee(newFee);
            System.out.println();
        }
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleDetails();
            System.out.println();
        }
    }
}
