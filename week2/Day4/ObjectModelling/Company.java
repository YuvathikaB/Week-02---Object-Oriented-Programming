import java.util.*;
public class Company {
    private String companyName;
    private List<Department> departments;
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
        System.out.println("Company " + this.companyName + " created");
        System.out.println();
    }
    public class Department {
        String deptName;
        List<Employee> employees;
        public Department(String name) {
            this.deptName = name;
            this.employees = new ArrayList<>();
            System.out.println("Department '" + this.deptName + "' created within Company '" + Company.this.companyName + "'.");
            System.out.println();
        }
        public String getDeptName() {
            return deptName;
        }
        public void addEmployee(Employee emp) {
            this.employees.add(emp);
            System.out.println("Employee " + emp.getEmpName() + " added to dept " + deptName);
            System.out.println();
        }
        public List<Employee> getEmployees() {
            return employees;
        }
        public class Employee {
            private String name;
            private int id;
            Employee(String name, int id) {
                this.name = name;
                this.id = id;
                System.out.println("Employee name: " + name + " id: " + id);
            }
            public String getEmpName() {
                return name;
            }
            public int getEmpID() {
                return id;
            }
            @Override
            public String toString() {
                return "Employee{name='" + name + "' , id=" + id + '}';
            }
        }
    }
    public void addDept(Department department) {
        this.departments.add(department);
    }
    public List<Department> getDept() {
        return departments;
    }
    public void deleteCompany() {
        System.out.println("Deleting company: " + this.companyName + " started.");
        System.out.println();
        if (this.departments != null) {
            for (Department dept : this.departments) {
                System.out.println("Deleting dept " + dept.getDeptName());
                if (dept.employees != null) {
                    for (Department.Employee emp : dept.employees) {
                        System.out.println("Deleting emp " + emp.getEmpName());
                    }
                    dept.employees.clear();
                    dept.employees = null;
                    System.out.println();
                }
            }
            this.departments.clear();
            this.departments = null;
        }
        System.out.println("Company " + this.companyName + " and its components deleted.");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the company name: ");
        String companyName = scanner.nextLine();
        Company myCompany = new Company(companyName);
        System.out.print("Enter the number of departments: ");
        int numDepts = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numDepts; i++) {
            System.out.print("Enter the name of department " + (i+1) + ": ");
            String deptName = scanner.nextLine();
            Company.Department dept = myCompany.new Department(deptName);
            myCompany.addDept(dept);
            System.out.print("Enter the number of employees in " + deptName + ": ");
            int numEmployees = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < numEmployees; j++) {
                System.out.print("Enter the name of employee " + (j+1) + ": ");
                String empName = scanner.nextLine();
                System.out.print("Enter the ID of employee " + (j+1) + ": ");
                int empId = scanner.nextInt();
                scanner.nextLine();
                Company.Department.Employee emp = dept.new Employee(empName, empId);
                dept.addEmployee(emp);
            }
        }
        System.out.println("Company Details");
        System.out.println("Company name: " + myCompany.companyName);
        for (Department dept : myCompany.departments) {
            System.out.println("Department name: " + dept.getDeptName());
            for (Company.Department.Employee emp : dept.getEmployees()) {
                System.out.println(emp);
            }
            System.out.println();
        }
        System.out.println("Deleting company...");
        myCompany.deleteCompany();
        scanner.close();
    }
}
