import java.util.*;
public class Book {
    private static String libraryName;
    private String title;
    private String author;
    private final String isbn;
    public Book(String title,String author,String isbn){
        this.title=title;
        this.author=author;
        this.isbn =isbn;
    }
    public static void  displayLibraryName(){
        System.out.println("Library name : "+ libraryName);
    }
    public void display() {
        if (this instanceof Book) {
            System.out.println("Title: "+title);
            System.out.println("Author : "+author);
            System.out.println("ISBN :  " + isbn);
        }
    }
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter library name: ");
        libraryName = scanner.nextLine();
        System.out.print("Enter number of books to add: ");
        int numbooks = scanner.nextInt();
        scanner.nextLine();
        Book[] books = new Book[numbooks];
        for (int i = 0; i < numbooks; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");
            System.out.print("Enter book Name: ");
            String title = scanner.nextLine();
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            System.out.print("Enter ISBN: ");
            String isbn = scanner.next();
            scanner.nextLine();
            books[i] = new Book(title, author,isbn);
            System.out.println();
        }
        for (Book bk : books) {
            Book.displayLibraryName();
            bk.display();
            System.out.println();
        }
    }
}
