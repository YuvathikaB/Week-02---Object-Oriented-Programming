import java.util.*;
public class Book {
    String title;
    String author;
    double price;
    Book(String title, String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    void display(){
        System.out.println("Title : "+title);
        System.out.println("Author : "+author);
        System.out.println("Price : "+price);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the name of the book : ");
        String title=sc.nextLine();
        System.out.print("Enter the author of the book : ");
        String author=sc.nextLine();
        System.out.print("Enter the price of the book : ");
        double price=sc.nextDouble();
        Book book=new Book(title,author,price);
        book.display();
    }
}
