import java.util.*;
// Abstract class Employee
abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;
    // Constructor
    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    // Abstract method for calculating salary
    public abstract double calculateSalary();
    // Concrete method for displaying employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Total Salary: " + calculateSalary());
    }
    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
// FullTimeEmployee class extends Employee
class FullTimeEmployee extends Employee {
    private double fixedSalary;

    public FullTimeEmployee(String employeeId, String name, double baseSalary, double fixedSalary) {
        super(employeeId, name, baseSalary);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedSalary;
    }
}
// PartTimeEmployee class extends Employee
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    public PartTimeEmployee(String employeeId, String name, double baseSalary, double hourlyRate, int hoursWorked) {
        super(employeeId, name, baseSalary);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hourlyRate * hoursWorked);
    }
}
// Department interface
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}
// Concrete class that implements Department interface
class ITDepartment implements Department {
    private String departmentName;
    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }
    @Override
    public String getDepartmentDetails() {
        return "Department: " + departmentName;
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int numEmployees = sc.nextInt();
        sc.nextLine();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Enter Employee ID: ");
            String employeeId = sc.nextLine();
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Base Salary: ");
            double baseSalary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Full-Time Employee or Part-Time Employee? (Enter 'full' or 'part'): ");
            String employeeType = sc.nextLine();
            if (employeeType.equalsIgnoreCase("full")) {
                System.out.print("Enter Fixed Salary for Full-Time Employee: ");
                double fixedSalary = sc.nextDouble();
                sc.nextLine();
                FullTimeEmployee fullTimeEmp = new FullTimeEmployee(employeeId, name, baseSalary, fixedSalary);
                employees.add(fullTimeEmp);
            } else if (employeeType.equalsIgnoreCase("part")) {
                System.out.print("Enter Hourly Rate for Part-Time Employee: ");
                double hourlyRate = sc.nextDouble();
                System.out.print("Enter Hours Worked for Part-Time Employee: ");
                int hoursWorked = sc.nextInt();
                sc.nextLine();
                PartTimeEmployee partTimeEmp = new PartTimeEmployee(employeeId, name, baseSalary, hourlyRate, hoursWorked);
                employees.add(partTimeEmp);
            } else {
                System.out.println("Invalid input for employee type. Skipping this employee.");
                continue;
            }
        }
        ITDepartment itDept = new ITDepartment();
        for (Employee emp : employees) {
            System.out.print("\nAssign a department for " + emp.getName() + ": ");
            String departmentName = sc.nextLine();
            itDept.assignDepartment(departmentName);
            System.out.println(emp.getName() + " works in the " + itDept.getDepartmentDetails());
        }
        System.out.println("\nEmployee Details:");
        System.out.println();
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
        sc.close();
    }
}

