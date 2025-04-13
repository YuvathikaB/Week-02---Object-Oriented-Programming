import java.util.Scanner;
interface Refuelable {
    void refuel();
}
class Vehicle1 {
    protected String model;
    protected int maxSpeed;
    public Vehicle1(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
    public void displayType() {
        System.out.println("General Vehicle");
    }
}
class ElectricVehicle extends Vehicle1 {
    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }
    @Override
    public void displayType() {
        System.out.println("Vehicle Type: Electric Vehicle");
    }
    public void charge() {
        System.out.println("Charging: Plugged in and charging.");
    }
}
class PetrolVehicle extends Vehicle1 implements Refuelable {
    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }
    @Override
    public void displayType() {
        System.out.println("Vehicle Type: Petrol Vehicle");
    }
    @Override
    public void refuel() {
        System.out.println("Refueling: Filled up with petrol.");
    }
}
public class VehicleManagementHybrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Electric Vehicle Model: ");
        String eModel = scanner.nextLine();
        System.out.print("Enter Electric Vehicle Max Speed: ");
        int eSpeed = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Petrol Vehicle Model: ");
        String pModel = scanner.nextLine();
        System.out.print("Enter Petrol Vehicle Max Speed: ");
        int pSpeed = scanner.nextInt();
        ElectricVehicle ev = new ElectricVehicle(eModel, eSpeed);
        PetrolVehicle pv = new PetrolVehicle(pModel, pSpeed);
        System.out.println("\nVehicle Details");
        System.out.println();
        ev.displayType();
        ev.displayInfo();
        ev.charge();
        System.out.println();
        pv.displayType();
        pv.displayInfo();
        pv.refuel();
        System.out.println();
    }
}
