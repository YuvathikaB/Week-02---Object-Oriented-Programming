import java.util.*;
public class Book {
    String title, author;
    double price;
    Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book b1 = new Book();
        System.out.print("Default constructors:\n");
        b1.display();
        System.out.println();
        System.out.print("Enter book title:");
        String title = sc.nextLine();
        System.out.print("Enter book author:");
        String author = sc.nextLine();
        System.out.print("Enter book price:");
        double price = sc.nextDouble();
        Book b2 = new Book(title, author, price);
        System.out.println();
        b2.display();
    }
}