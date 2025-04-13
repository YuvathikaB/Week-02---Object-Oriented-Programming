import java.util.*;
public class Book1 {
    public String ISBN;
    protected String title;
    private String author;
    public Book1(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void display() {
        System.out.println("\nBook Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
    }
}
class EBook extends Book1 {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }
    public void display() {
        System.out.println("\nEBook Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
    }
}
class BookSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();
        Book1 book = new Book1(ISBN, title, author);
        book.display();
        EBook eBook = new EBook(ISBN, title, author);
        eBook.display();
        scanner.close();
    }
}
