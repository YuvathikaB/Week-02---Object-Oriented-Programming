import java.util.Scanner;
public class Item {
    int itemCode;
    String itemName;
    double price;
    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    public double totalCost(double quantity) {
        return quantity * price;
    }
    void display(double quantity) {
        System.out.println("Item code : " + itemCode);
        System.out.println("Item name : " + itemName);
        System.out.println("Unit price : " + price);
        System.out.println("Quantity: "+quantity);
        System.out.print("Total cost : " + totalCost(quantity));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the item : ");
        String itemName = sc.nextLine();
        System.out.print("Enter the item code : ");
        int itemCode = sc.nextInt();
        System.out.print("Enter the unit price of the item : ");
        double price = sc.nextDouble();
        System.out.print("Enter quantity: ");
        double quantity = sc.nextDouble();
        Item item = new Item(itemCode, itemName, price);
        item.display(quantity);
    }
}