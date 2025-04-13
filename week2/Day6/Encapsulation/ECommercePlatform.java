import java.util.*;
abstract class Product {
    private String productId;
    private String name;
    private double price;
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public abstract double calculateDiscount();

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double calculateFinalPrice() {
        double discount = calculateDiscount();
        double priceAfterDiscount = price - discount;

        if (this instanceof Taxable) {
            Taxable taxableProduct = (Taxable) this;
            double tax = taxableProduct.calculateTax();
            return priceAfterDiscount + tax;
        }
        return priceAfterDiscount;
    }
}
class Electronics extends Product implements Taxable {
    private double discountRate;
    private double taxRate;
    public Electronics(String productId, String name, double price, double discountRate, double taxRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
        this.taxRate = taxRate / 100;
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }
    @Override
    public String getTaxDetails() {
        return "Tax on Electronics: " + calculateTax();
    }
}
class Clothing extends Product implements Taxable {
    private double discountRate;
    private double taxRate;
    public Clothing(String productId, String name, double price, double discountRate, double taxRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
        this.taxRate = taxRate / 100;
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }
    @Override
    public String getTaxDetails() {
        return "Tax on Clothing: " + calculateTax();
    }
}
class Groceries extends Product {
    private double discountRate;
    public Groceries(String productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }
}
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int numProducts = sc.nextInt();
        sc.nextLine();
        System.out.println();
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter details for product " + (i + 1));
            System.out.print("Enter product ID: ");
            String productId = sc.nextLine();
            System.out.print("Enter product name: ");
            String name = sc.nextLine();
            System.out.print("Enter product price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter product category (Electronics/Clothing/Groceries): ");
            String category = sc.nextLine();
            if (category.equalsIgnoreCase("Electronics")) {
                System.out.print("Enter discount rate for Electronics : ");
                double discountRate = sc.nextDouble() / 100;
                System.out.print("Enter tax rate for Electronics (%): ");
                double taxRate = sc.nextDouble();
                sc.nextLine();
                products.add(new Electronics(productId, name, price, discountRate, taxRate));
            } else if (category.equalsIgnoreCase("Clothing")) {
                System.out.print("Enter discount rate for Clothing : ");
                double discountRate = sc.nextDouble() / 100;
                System.out.print("Enter tax rate for Clothing (%)): ");
                double taxRate = sc.nextDouble();
                sc.nextLine();
                products.add(new Clothing(productId, name, price, discountRate, taxRate));
            } else if (category.equalsIgnoreCase("Groceries")) {
                System.out.print("Enter discount rate for Groceries : ");
                double discountRate = sc.nextDouble() / 100;
                sc.nextLine();
                products.add(new Groceries(productId, name, price, discountRate));
            } else {
                System.out.println("Invalid category, skipping product.");
            }
            System.out.println();
        }
        System.out.println("\nProduct Details:");
        for (Product product : products) {
            System.out.println("\nProduct Name: " + product.getName());
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Price: " + product.getPrice());
            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                System.out.println(taxableProduct.getTaxDetails());
            }
            System.out.println("Discount: " + product.calculateDiscount());
            System.out.println("Final Price: " + product.calculateFinalPrice());
        }
        sc.close();
    }
}
