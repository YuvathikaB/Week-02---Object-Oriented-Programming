import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EcommercePlatform {
    static class Product {
        private String name;
        private double price;
        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
        public String getName() {
            return name;
        }
        public double getPrice() {
            return price;
        }
    }
    static class Order {
        private int orderId;
        private List<Product> products;
        public Order(int orderId) {
            this.orderId = orderId;
            this.products = new ArrayList<>();
        }
        public void addProduct(Product product) {
            products.add(product);
        }
        public void showOrderDetails() {
            System.out.println("Order ID: " + orderId);
            double totalPrice = 0;
            for (Product product : products) {
                System.out.println("Product: " + product.getName() + " | Price: " + product.getPrice());
                totalPrice += product.getPrice();
            }
            System.out.println("Total Price: " + totalPrice);
        }
    }
    static class Customer {
        private String name;
        private List<Order> orders;
        public Customer(String name) {
            this.name = name;
            this.orders = new ArrayList<>();
        }
        public String getName() {
            return name;
        }
        public void placeOrder(Order order) {
            orders.add(order);
        }
        public void showCustomerOrders() {
            System.out.println("Orders placed by " + name + ":");
            for (Order order : orders) {
                order.showOrderDetails();
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);
        System.out.print("Enter number of products: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine();
        List<Product> productList = new ArrayList<>();
        System.out.println();
        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter Product " + (i + 1) + " name: ");
            String productName = scanner.nextLine();
            System.out.print("Enter Product " + (i + 1) + " price: ");
            double productPrice = scanner.nextDouble();
            scanner.nextLine();
            productList.add(new Product(productName, productPrice));
            System.out.println();
        }
        System.out.println();
        System.out.print("Enter number of orders for " + customerName + ": ");
        int numOrders = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numOrders; i++) {
            System.out.print("Enter Order " + (i + 1) + " ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine();
            Order order = new Order(orderId);
            System.out.print("Enter number of products in this order: ");
            int numOrderProducts = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            for (int j = 0; j < numOrderProducts; j++) {
                System.out.print("Enter Product name for order " + (i + 1) + ": ");
                String orderProductName = scanner.nextLine();
                for (Product product : productList) {
                    if (product.getName().equals(orderProductName)) {
                        order.addProduct(product);
                    }
                }
            }
            customer.placeOrder(order);
            System.out.println();
        }
        System.out.println();
        customer.showCustomerOrders();
    }
}
