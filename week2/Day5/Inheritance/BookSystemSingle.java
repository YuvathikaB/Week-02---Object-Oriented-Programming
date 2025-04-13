import java.util.Scanner;
class Book {
    String title;
    int publicationYear;
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}
class Author extends Book {
    String name;
    String bio;
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}
public class BookSystemSingle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the author's name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter the author's bio: ");
        String authorBio = scanner.nextLine();
        Author author = new Author(title, publicationYear, authorName, authorBio);
        System.out.println();
        author.displayInfo();
        scanner.close();
    }
}
