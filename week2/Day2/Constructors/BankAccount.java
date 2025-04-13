import java.util.*;
class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void display() {
        System.out.println("\nBank Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    public void display() {
        System.out.println("\nSavings Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
    }
}
class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(accountNumber, accountHolder, balance);
        bankAccount.display();
        System.out.print("\nEnter new Balance to set: ");
        double newBalance = scanner.nextDouble();
        bankAccount.setBalance(newBalance);
        bankAccount.display();
        SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountHolder, balance);
        savingsAccount.display();
    }
}
