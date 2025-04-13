import java.util.Scanner;
public class BankCustomer {
    static class Customer {
        private String name;
        private double balance;
        public Customer(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }
        public String getName() {
            return name;
        }
        public void viewBalance() {
            System.out.println("Customer: " + name +"\nBalance: " + balance);
        }
    }
    static class Bank {
        private String name;
        public Bank(String name) {
            this.name = name;
        }
        public void openAccount(Customer customer) {
            System.out.println("Opening account for " + customer.getName() + " at " + name + " Bank.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Bank name: ");
        String bankName = scanner.nextLine();
        Bank bank = new Bank(bankName);
        System.out.println();
        System.out.print("Enter Customer 1 name: ");
        String customer1Name = scanner.nextLine();
        System.out.print("Enter Customer 1 initial balance: ");
        double customer1Balance = scanner.nextDouble();
        scanner.nextLine();
        Customer customer1 = new Customer(customer1Name, customer1Balance);
        System.out.println();
        System.out.print("Enter Customer 2 name: ");
        String customer2Name = scanner.nextLine();
        System.out.print("Enter Customer 2 initial balance: ");
        double customer2Balance = scanner.nextDouble();
        scanner.nextLine();
        Customer customer2 = new Customer(customer2Name, customer2Balance);
        System.out.println();
        bank.openAccount(customer1);
        customer1.viewBalance();
        System.out.println();
        bank.openAccount(customer2);
        customer2.viewBalance();
    }
}
