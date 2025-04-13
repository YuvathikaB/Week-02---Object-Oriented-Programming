import java.util.Scanner;
public class CartItem {
    String itemName;
    double price;
    int quantity;
    static double totalCost = 0;
    static CartItem[] cartItems = new CartItem[5];
    private static int itemCount = 0;
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public static void addItem(String itemName, double price, int quantity) {
        if (itemCount < cartItems.length) {
            CartItem newItem = new CartItem(itemName, price, quantity);
            cartItems[itemCount] = newItem;
            itemCount++;
            totalCost += newItem.getTotalCost();
            System.out.println(itemName + " added to cart.");
        } else {
            System.out.println("Cart is full! Cannot add more items.");
        }
    }
    public static void removeItem(String itemName) {
        boolean itemFound = false;
        for (int i = 0; i < itemCount; i++) {
            if (cartItems[i].itemName.equals(itemName)) {
                totalCost -= cartItems[i].getTotalCost();
                System.out.println(itemName + " has been removed from the cart.");
                for (int j = i; j < itemCount - 1; j++) {
                    cartItems[j] = cartItems[j + 1];
                }
                cartItems[itemCount - 1] = null;
                itemCount--;
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            System.out.println(itemName + " was not found in the cart.");
        }
    }
    public static void displayTotalCost() {
        System.out.println("Total cost of items in cart: " + totalCost);
    }
    public double getTotalCost() {
        return price * quantity;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add item to cart");
            System.out.println("2. Remove item from cart");
            System.out.println("3. Display total cost");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter item name:");
                    String itemName = scanner.nextLine();
                    System.out.println("Enter price of " + itemName + ":");
                    double price = scanner.nextDouble();
                    System.out.println("Enter quantity of " + itemName + ":");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    addItem(itemName, price, quantity);
                    break;
                case 2:
                    System.out.println("Enter item name to remove:");
                    String removeItemName = scanner.nextLine();
                    removeItem(removeItemName);
                    break;
                case 3:
                    displayTotalCost();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
