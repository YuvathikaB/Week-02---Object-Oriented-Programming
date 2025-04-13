import java.util.*;
public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    private double dailyRate;
    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }
    public double totalCost() {
        return rentalDays * dailyRate;
    }
    public void displayRentalDetails() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + totalCost());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter car model: ");
        String carModel = scanner.nextLine();
        System.out.print("Enter rental days: ");
        int rentalDays = scanner.nextInt();
        System.out.print("Enter daily rental rate: ");
        double dailyRate = scanner.nextDouble();
        CarRental rental = new CarRental(customerName, carModel, rentalDays, dailyRate);
        System.out.println();
        rental.displayRentalDetails();
    }
}
