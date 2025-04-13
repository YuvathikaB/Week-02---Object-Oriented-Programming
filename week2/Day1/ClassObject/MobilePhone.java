import java.util.*;
public class MobilePhone {
    String brand;
    String model;
    double price;
    MobilePhone(String brand, String model,double price){
        this.brand=brand;
        this.model=model;
        this.price=price;
    }
    void display(){
        System.out.println("Brand : "+brand);
        System.out.println("Model : "+model);
        System.out.println("Price : "+price);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the brand of the mobile : ");
        String title=sc.nextLine();
        System.out.print("Enter the model of the phone : ");
        String author=sc.nextLine();
        System.out.print("Enter the price of the phone : ");
        double price=sc.nextDouble();
        MobilePhone ph=new MobilePhone(title,author,price);
        ph.display();
    }
}
