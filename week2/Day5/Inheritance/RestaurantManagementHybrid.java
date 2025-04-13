import java.util.Scanner;
interface Worker {
    void performDuties();
}
class Person1 {
    protected String name;
    protected int id;
    public Person1(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
    public void displayRole() {
        System.out.println("General Person");
    }
}
class Chef extends Person1 implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }
    @Override
    public void displayRole() {
        System.out.println("Role: Chef");
    }
    @Override
    public void performDuties() {
        System.out.println("Duties: Preparing meals");
    }
}
class Waiter extends Person1 implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }
    @Override public void displayRole() {
        System.out.println("Role: Waiter");
    }
    @Override public void performDuties() {
        System.out.println("Duties: Serving food to customers");
    }
}
public class RestaurantManagementHybrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Chef's Name: ");
        String chefName = scanner.nextLine();
        System.out.print("Enter Chef's ID: ");
        int chefId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Waiter's Name: ");
        String waiterName = scanner.nextLine();
        System.out.print("Enter Waiter's ID: ");
        int waiterId = scanner.nextInt();
        Chef chef = new Chef(chefName, chefId);
        Waiter waiter = new Waiter(waiterName, waiterId);
        System.out.println("\nRestaurant Workers:");
        System.out.println();
        chef.displayRole();
        chef.displayInfo();
        chef.performDuties();
        System.out.println();
        waiter.displayRole();
        waiter.displayInfo();
        waiter.performDuties();
        System.out.println();
    }
}
