import java.util.*;
public class Employee {
    String name;
    int id;
    double salary;
    Employee(String name, int id,double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    void display(){
        System.out.println("Name : "+name);
        System.out.println("ID : "+id);
        System.out.println("Salary : "+salary);

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of the employee : ");
        String name=sc.nextLine();
        System.out.print("Enter ID of the employee : ");
        int id=sc.nextInt();
        System.out.print("Enter salary of the employee : ");
        double salary=sc.nextDouble();
        Employee emp=new Employee(name,id,salary);
        emp.display();
    }
}


