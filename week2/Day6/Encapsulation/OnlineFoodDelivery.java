import java.util.*;
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public abstract double calculateTotalPrice();
    public String getItemDetails() {
        return "Item: " + itemName + "\nPrice: " + price + "\nQuantity: " + quantity;
    }
    public String getItemName() {
        return itemName;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}
interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}
class VegItem extends FoodItem implements Discountable {
    private double totalPrice;
    private double discountApplied;
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.totalPrice = calculateTotalPrice();
    }
    @Override
    public double calculateTotalPrice() {
        totalPrice = getPrice() * getQuantity();
        return totalPrice;
    }
    @Override
    public void applyDiscount(double percent) {
        discountApplied = (percent / 100.0) * totalPrice;
        totalPrice -= discountApplied;
    }
    @Override
    public String getDiscountDetails() {
        return "Discount on Veg Item: " + String.format("%.2f", discountApplied);
    }
    public double getFinalPrice() {
        return totalPrice;
    }
}
class NonVegItem extends FoodItem implements Discountable {
    private double totalPrice;
    private double discountApplied;
    private final double nonVegCharge = 1.5;
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.totalPrice = calculateTotalPrice();
    }
    @Override
    public double calculateTotalPrice() {
        totalPrice = (getPrice() + nonVegCharge) * getQuantity();
        return totalPrice;
    }
    @Override
    public void applyDiscount(double percent) {
        discountApplied = (percent / 100.0) * totalPrice;
        totalPrice -= discountApplied;
    }
    @Override
    public String getDiscountDetails() {
        return "Discount on Non-Veg Item: " + String.format("%.2f", discountApplied);
    }
    public double getFinalPrice() {
        return totalPrice;
    }
}
public class OnlineFoodDelivery {
    public static void processOrder(FoodItem item, double discountPercent) {
        System.out.println("\n--- Order Summary ---");
        System.out.println();
        System.out.println(item.getItemDetails());
        System.out.println("Original Total: " + item.calculateTotalPrice());
        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            d.applyDiscount(discountPercent);
            System.out.println(d.getDiscountDetails());
            if (item instanceof VegItem) {
                System.out.println("Final Price: " + ((VegItem) item).getFinalPrice());
            } else if (item instanceof NonVegItem) {
                System.out.println("Final Price: " + ((NonVegItem) item).getFinalPrice());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item type (Veg/NonVeg): ");
        String type = scanner.nextLine();

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter discount percentage: ");
        double discount = scanner.nextDouble();

        FoodItem item = null;

        if (type.equalsIgnoreCase("Veg")) {
            item = new VegItem(name, price, quantity);
        } else if (type.equalsIgnoreCase("NonVeg")) {
            item = new NonVegItem(name, price, quantity);
        } else {
            System.out.println("Invalid item type.");
        }

        if (item != null) {
            processOrder(item, discount);
        }

        scanner.close();
    }
}
