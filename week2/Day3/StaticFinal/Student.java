import java.util.*;
public class Student {
    private static String universityName;
    private static int totalStudents =0;
    private String name;
    private String grade;
    private final int rollNumber;
    public Student(String name,int rollNumber,String grade){
        this.name =name;
        this.rollNumber =rollNumber;
        this.grade=grade;
        totalStudents++;
    }
    public static void displayTotalStudents(){
        System.out.println("Total students: " + totalStudents);
    }
    public void display() {
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Student Name: " + name);
            System.out.println("Roll number: " + rollNumber);
            System.out.println("Grade: " + grade);
        }
    }
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter university name: ");
        universityName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        Student[] students = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter roll number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter grade: ");
            String grade = scanner.next();
            scanner.nextLine();
            students[i] = new Student(name,rollNumber,grade);
            System.out.println();
        }
        for (Student student : students) {
            student.display();
            System.out.println();
        }
        Student.displayTotalStudents();
    }
}

