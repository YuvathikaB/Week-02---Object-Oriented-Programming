import java.util.Scanner;
class Person {
    private String name;
    private int age;
//    public Person() {
//        this("Unknown", 0);
//    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter person name: ");
        String name = sc.nextLine();
        System.out.print("Enter person age: ");
        int age = sc.nextInt();
        Person p1 = new Person(name, age);
        Person p2 = new Person(p1);
        p1.display();
        System.out.println();
        System.out.print("Copy constructor\n");
        p2.display();
    }
}

