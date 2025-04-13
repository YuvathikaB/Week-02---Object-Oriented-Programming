import java.util.*;
public class Student {
    public int rollNumber;
    protected String name;
    private Double CGPA;
    Student(int rollNumber,String name,Double CGPA){
        this.rollNumber=rollNumber;
        this.name=name;
        this.CGPA=CGPA;
    }
    public double getCGPA() {
        return CGPA;
    }
    public void setCGPA(double newCGPA) {
        this.CGPA = newCGPA;
    }
    public void display() {
        System.out.println("\nStudent Details:");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
    }
}
class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }
    public void display() {
        System.out.println("\nPostgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
    }
}
class University {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student CGPA: ");
        double CGPA = scanner.nextDouble();
        Student student1 = new Student(rollNumber, name, CGPA);
        student1.display();
        System.out.print("\nEnter new CGPA for Student: ");
        double newCGPA = scanner.nextDouble();
        student1.setCGPA(newCGPA);
        student1.display();
        System.out.println("\nCreating a Postgraduate Student : ");
        scanner.nextLine();
        System.out.print("Enter Postgraduate Roll Number: ");
        int pgRollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Postgraduate Name: ");
        String pgName = scanner.nextLine();
        System.out.print("Enter Postgraduate CGPA: ");
        double pgCGPA = scanner.nextDouble();
        PostgraduateStudent pgStudent = new PostgraduateStudent(pgRollNumber, pgName, pgCGPA);
        pgStudent.display();
    }
}