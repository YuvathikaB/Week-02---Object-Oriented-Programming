import java.util.ArrayList;
import java.util.Scanner;
public class LibraryBooks {
    static class Book {
        private String title;
        private String author;
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
        public String toString() {
            return "Book :\nTitle = " + title + "\nAuthor = " + author;
        }
    }
    static class Library {
        private String name;
        private ArrayList<Book> books;
        public Library(String name) {
            this.name = name;
            this.books = new ArrayList<>();
        }
        public void addBook(Book book) {
            books.add(book);
        }
        public void displayBooks() {
            System.out.println("Books in " + name + ":");
            for (Book book : books) {
                System.out.println(book);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Library 1 name: ");
        String library1Name = scanner.nextLine();
        Library library1 = new Library(library1Name);
        System.out.print("Enter Library 2 name: ");
        String library2Name = scanner.nextLine();
        Library library2 = new Library(library2Name);
        System.out.println();
        System.out.print("Enter Book 1 title: ");
        String title1 = scanner.nextLine();
        System.out.print("Enter Book 1 author: ");
        String author1 = scanner.nextLine();
        Book book1 = new Book(title1, author1);
        System.out.println();
        System.out.print("Enter Book 2 title: ");
        String title2 = scanner.nextLine();
        System.out.print("Enter Book 2 author: ");
        String author2 = scanner.nextLine();
        Book book2 = new Book(title2, author2);
        System.out.println();
        System.out.print("Enter Book 3 title: ");
        String title3 = scanner.nextLine();
        System.out.print("Enter Book 3 author: ");
        String author3 = scanner.nextLine();
        Book book3 = new Book(title3, author3);
        System.out.println();
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book2);
        library2.addBook(book3);
        library1.displayBooks();
        System.out.println();
        library2.displayBooks();
    }
}
