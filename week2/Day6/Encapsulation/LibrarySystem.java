import java.util.Scanner;
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    public abstract int getLoanDuration();
    public String getItemDetails() {
        return "Item ID: " + itemId + "\nTitle: " + title + "\nAuthor: " + author;
    }
    public String getItemId() {
        return itemId;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
}
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}
class Book extends LibraryItem implements Reservable {
    private boolean available = true;
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    @Override
    public int getLoanDuration() {
        return 14;
    }
    @Override
    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }
    @Override
    public boolean checkAvailability() {
        return available;
    }
}
class Magazine extends LibraryItem implements Reservable {
    private boolean available = true;
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    @Override
    public int getLoanDuration() {
        return 7;
    }
    @Override
    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }
    @Override
    public boolean checkAvailability() {
        return available;
    }
}
class DVD extends LibraryItem implements Reservable {
    private boolean available = true;
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    @Override
    public int getLoanDuration() {
        return 5;
    }
    @Override
    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }
}
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item type (Book/Magazine/DVD): ");
        String itemType = scanner.nextLine();
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        LibraryItem item = null;
        if (itemType.equalsIgnoreCase("Book")) {
            item = new Book(itemId, title, author);
        } else if (itemType.equalsIgnoreCase("Magazine")) {
            item = new Magazine(itemId, title, author);
        } else if (itemType.equalsIgnoreCase("DVD")) {
            item = new DVD(itemId, title, author);
        } else {
            System.out.println("Invalid item type.");
        }
        if (item != null) {
            System.out.println("\nItem Details : ");
            System.out.println();
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("\nChecking availability...");
                if (reservableItem.checkAvailability()) {
                    System.out.println("Item is available. Reserving now...");
                    reservableItem.reserveItem();
                } else {
                    System.out.println("Item is not available for reservation.");
                }
            }
        }
        scanner.close();
    }
}
