import java.util.*;
public class Circle {
    private double radius;
    public Circle() {
        this(1.0);
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public void display() {
        System.out.println("Radius: " + radius);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle c1 = new Circle();
        System.out.println("Default constructor");
        c1.display();
        System.out.println();
        System.out.print("Enter circle radius:");
        double radius = sc.nextDouble();
        Circle c2 = new Circle(radius);
        c2.display();
    }
}