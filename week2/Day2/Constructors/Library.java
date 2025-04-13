import java.util.Scanner;
class Library {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;
//    public Library() {
//        this.title = "Unknown";
//        this.author = "Unknown";
//        this.price = 0.0;
//        this.isAvailable = true;
//    }
    public Library(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }
    public Library(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }
    public Library(Library other) {
        this.title = other.title;
        this.author = other.author;
        this.price = other.price;
        this.isAvailable = other.isAvailable;
    }
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have borrowed the book: " + title);
        } else {
            System.out.println("Sorry, the book is currently unavailable.");
        }
    }
    public void returnBook() {
        isAvailable = true;
        System.out.println("Thank you for returning: " + title);
    }
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book price: ");
        double price = scanner.nextDouble();
        Library book1 = new Library(title, author, price);
        System.out.println("\nBook details (before borrowing):");
        book1.display();
        System.out.print("\nDo you want to borrow the book? (yes/no): ");
        scanner.nextLine();
        String borrowResponse = scanner.nextLine();
        if (borrowResponse.equalsIgnoreCase("yes")) {
            book1.borrowBook();
        }
        System.out.println("\nBook details (after borrowing):");
        book1.display();
        System.out.print("\nDo you want to return the book? (yes/no): ");
        String returnResponse = scanner.nextLine();
        if (returnResponse.equalsIgnoreCase("yes")) {
            book1.returnBook();
        }
        System.out.println("\nBook details (after returning):");
        book1.display();
        scanner.close();
    }
}
