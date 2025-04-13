import java.util.Scanner;
class Order {
    String orderId;
    String orderDate;
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    public String getOrderStatus() {
        return "Order Placed.\nOrder ID: " + orderId + ", Order Date: " + orderDate;
    }
}
class ShippedOrder extends Order {
    String trackingNumber;
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    @Override
    public String getOrderStatus() {
        return super.getOrderStatus() + "\nShipped.\nTracking Number: " + trackingNumber;
    }
}
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    @Override
    public String getOrderStatus() {
        return super.getOrderStatus() + "\nDelivered.\nDelivery Date: " + deliveryDate;
    }
}
public class OrderManagementSystemMultilevel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Order ID: ");
        String orderId = scanner.nextLine();
        System.out.print("Enter Order Date: ");
        String orderDate = scanner.nextLine();
        System.out.print("Enter Tracking Number: ");
        String trackingNumber = scanner.nextLine();
        System.out.print("Enter Delivery Date: ");
        String deliveryDate = scanner.nextLine();
        DeliveredOrder deliveredOrder = new DeliveredOrder(orderId, orderDate, trackingNumber, deliveryDate);
        System.out.println();
        System.out.println(deliveredOrder.getOrderStatus());
        scanner.close();
    }
}
