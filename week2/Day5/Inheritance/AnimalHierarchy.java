import java.util.Scanner;
class Animal {
    String name;
    int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void makeSound() {
        System.out.println(name + " says Woof!");
    }
}
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " says Woof!");
    }
}
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " says Meow!");
    }
}
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " says Chirp!");
    }
}
public class AnimalHierarchy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal[] animals = new Animal[3];
        System.out.println("Enter Dog details:");
        System.out.print("Name: ");
        String dogName = scanner.nextLine();
        System.out.print("Age: ");
        int dogAge = scanner.nextInt();
        scanner.nextLine();
        animals[0] = new Dog(dogName, dogAge);
        System.out.println();
        System.out.println("Enter Cat details:");
        System.out.print("Name: ");
        String catName = scanner.nextLine();
        System.out.print("Age: ");
        int catAge = scanner.nextInt();
        scanner.nextLine();
        animals[1] = new Cat(catName, catAge);
        System.out.println();
        System.out.println("Enter Bird details:");
        System.out.print("Name: ");
        String birdName = scanner.nextLine();
        System.out.print("Age: ");
        int birdAge = scanner.nextInt();
        scanner.nextLine();
        animals[2] = new Bird(birdName, birdAge);
        System.out.println();
        System.out.println("Animal Information:");
        for (Animal animal : animals) {
            animal.makeSound();
        }
        scanner.close();
    }
}
