import java.util.*;
class Vehicle {
    String ownerName;
    String vehicleType;
    static Double registrationFee;
    Vehicle(String ownerName, String vehicleType){
        this.ownerName=ownerName;
        this.vehicleType = vehicleType;
    }
    void display() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration Fee has been updated to: " + registrationFee);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the registration fee: ");
        registrationFee= scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter number of vehicles: ");
        int numVehicles = scanner.nextInt();
        scanner.nextLine();
        Vehicle[] vehicles = new Vehicle[numVehicles];
        System.out.println();
        for (int i = 0; i < numVehicles; i++) {
            System.out.print("Enter owner's name for vehicle " + (i + 1) + ": ");
            String ownerName = scanner.nextLine();
            System.out.print("Enter vehicle type for vehicle " + (i + 1) + ": ");
            String vehicleType = scanner.nextLine();
            vehicles[i] = new Vehicle(ownerName, vehicleType);
            System.out.println();
        }
        System.out.println("\nVehicle Details:");
        for (Vehicle vehicle : vehicles) {
            vehicle.display();
            System.out.println();
        }
        System.out.print("Enter new registration fee: ");
        double newFee = scanner.nextDouble();
        updateRegistrationFee(newFee);
        System.out.println("\nUpdated Vehicle Details:");
        for (Vehicle vehicle : vehicles) {
            vehicle.display();
            System.out.println();
        }
    }
}

