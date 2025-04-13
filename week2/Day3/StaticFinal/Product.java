import java.util.*;
public class Product {
    private static int discount;
    private final int productID;
    private String productName;
    private double price;
    private int quantity;
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    public static void updateDiscount(int newDiscount) {
        discount = newDiscount;
        System.out.println("Updated Discount: " + discount + "%");
    }
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            double discountedPrice = price - (price * discount / 100);
            System.out.println("Price After Discount: " + discountedPrice);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of products to add: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine();
        Product[] products = new Product[numProducts];
        for (int i = 0; i < numProducts; i++) {
            System.out.println("\nEnter details for Product " + (i + 1) + ":");
            System.out.print("Enter Product ID: ");
            int productID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Product Name: ");
            String productName = scanner.nextLine();
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter discount: ");
            discount = scanner.nextInt();
            products[i] = new Product(productID, productName, price, discount);
        }
        System.out.print("\nEnter new discount percentage: ");
        int newDiscount = scanner.nextInt();
        updateDiscount(newDiscount);
        System.out.println();
        for (Product product : products) {
            product.displayProductDetails();
            System.out.println();
        }
    }
}
