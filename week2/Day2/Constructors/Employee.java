import java.util.*;
class Employee {
    public int employeeID;
    protected String department;
    private double salary;
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void display() {
        System.out.println("\nEmployee Details:");
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}
class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }
    public void display() {
        System.out.println("\nManager Details:");
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}
class EmployeeDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        Employee employee = new Employee(employeeID, department, salary);
        employee.display();
        System.out.print("\nEnter new Salary to set: ");
        double newSalary = scanner.nextDouble();
        employee.setSalary(newSalary);
        employee.display();
        Manager manager = new Manager(employeeID, department, salary);
        manager.display();
    }
}
