import java.util.Scanner;
class Person {
    protected String name;
    protected int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    public void displayRole() {
        System.out.println("General Person");
    }
}
class Teacher extends Person {
    private String subject;
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }
}
class Student extends Person {
    private String grade;
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Grade: " + grade);
    }
}
class Staff extends Person {
    public Staff(String name, int age) {
        super(name, age);
    }
    @Override
    public void displayRole() {
        System.out.println("Role: Staff");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}
public class SchoolSystemHierarchical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Teacher's Name: ");
        String teacherName = scanner.nextLine();
        System.out.print("Enter Teacher's Age: ");
        int teacherAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Teacher's Subject: ");
        String subject = scanner.nextLine();
        System.out.print("Enter Student's Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter Student's Age: ");
        int studentAge = scanner.nextInt();
        System.out.print("Enter Student's Grade: ");
        String grade = scanner.next();
        scanner.nextLine();
        System.out.print("Enter Staff's Name: ");
        String staffName = scanner.nextLine();
        System.out.print("Enter Staff's Age: ");
        int staffAge = scanner.nextInt();
        Person teacher = new Teacher(teacherName, teacherAge, subject);
        Person student = new Student(studentName, studentAge, grade);
        Person staff = new Staff(staffName, staffAge);
        System.out.println("\nSchool Roles:");
        System.out.println();
        Person[] people = {teacher, student, staff};
        for (Person p : people) {
            p.displayRole();
            p.displayInfo();
            System.out.println();
        }
    }
}
