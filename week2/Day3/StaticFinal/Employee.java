import java.util.*;
public class Employee {
    private static String companyName;
    private static int totalEmployees =0;
    private String name;
    private String designation;
    private final int id;
    public Employee(String name,int id,String designation){
        this.name =name;
        this.id=id;
        this.designation=designation;
        totalEmployees++;
    }
    public static void displayTotalEmployee(){
        System.out.println("Total employees: " + totalEmployees);
    }
    public void display() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee Name: " + name);
            System.out.println("Employee ID: " + id);
            System.out.println("Designation: " + designation);
        }
    }
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter company name: ");
        companyName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine();
        Employee[] emps = new Employee[numEmployees];
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEnter details for employee " + (i + 1) + ":");
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter designation: ");
            String designation = scanner.nextLine();
            emps[i] = new Employee(name,id,designation);
            System.out.println();
        }
        for (Employee emp : emps) {
            emp.display();
            System.out.println();
        }
        Employee.displayTotalEmployee();
    }
}
