import java.util.*;
public class Circle {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double area() {
        return Math.PI * radius * radius;
    }
    public double circumference() {
        return 2 * Math.PI * radius;
    }
    public void display(){
        System.out.println("Radius: " + radius);
        System.out.println("Area : " + String.format("%.2f",area()));
        System.out.println("Circumference : " + String.format("%.2f",circumference()));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of circle : ");
        double radius = sc.nextDouble();
        Circle circle = new Circle(radius);
        circle.display();
    }
}
