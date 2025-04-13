import java.util.Scanner;
class Employee {
    String name;
    int id;
    double salary;
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}
class Manager extends Employee {
    int teamSize;
    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}
class Developer extends Employee {
    String programmingLanguage;
    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}
class Intern extends Employee {
    int durationMonths;
    public Intern(String name, int id, double salary, int durationMonths) {
        super(name, id, salary);
        this.durationMonths = durationMonths;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Duration: " + durationMonths + " months");
    }
}
public class EmployeeHierarchy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Manager details:");
        System.out.print("Name: ");
        String managerName = scanner.nextLine();
        System.out.print("ID: ");
        int managerId = scanner.nextInt();
        System.out.print("Salary: ");
        double managerSalary = scanner.nextDouble();
        System.out.print("Team Size: ");
        int teamSize = scanner.nextInt();
        scanner.nextLine();
        Manager manager = new Manager(managerName, managerId, managerSalary, teamSize);
        System.out.println("\nEnter Developer details:");
        System.out.print("Name: ");
        String developerName = scanner.nextLine();
        System.out.print("ID: ");
        int developerId = scanner.nextInt();
        System.out.print("Salary: ");
        double developerSalary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Programming Language: ");
        String programmingLanguage = scanner.nextLine();
        Developer developer = new Developer(developerName, developerId, developerSalary, programmingLanguage);
        System.out.println("\nEnter Intern details:");
        System.out.print("Name: ");
        String internName = scanner.nextLine();
        System.out.print("ID: ");
        int internId = scanner.nextInt();
        System.out.print("Salary: ");
        double internSalary = scanner.nextDouble();
        System.out.print("Internship Duration (in months): ");
        int durationMonths = scanner.nextInt();
        Intern intern = new Intern(internName, internId, internSalary, durationMonths);
        System.out.println("\nManager Details:");
        manager.displayDetails();
        System.out.println("\nDeveloper Details:");
        developer.displayDetails();
        System.out.println("\nIntern Details:");
        intern.displayDetails();
        scanner.close();
    }
}
