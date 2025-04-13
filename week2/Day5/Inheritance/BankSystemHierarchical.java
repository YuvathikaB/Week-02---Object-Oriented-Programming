import java.util.Scanner;
class BankAccount {
    protected String accountNumber;
    protected double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    public void displayAccountType() {
        System.out.println("General Bank Account");
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    @Override
    public void displayAccountType() {
        System.out.println("Savings Account");
    }
    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    @Override
    public void displayAccountType() {
        System.out.println("Checking Account");
    }
    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount {
    public FixedDepositAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }
}
public class BankSystemHierarchical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Enter Interest Rate for Savings Account (%): ");
        double interestRate = scanner.nextDouble();
        System.out.print("Enter Withdrawal Limit for Checking Account: ");
        double withdrawalLimit = scanner.nextDouble();
        BankAccount savings = new SavingsAccount(accountNumber, balance, interestRate);
        BankAccount checking = new CheckingAccount(accountNumber, balance, withdrawalLimit);
        BankAccount fixedDeposit = new FixedDepositAccount(accountNumber, balance);
        System.out.println("\nAccount Details:");
        System.out.println();
        BankAccount[] accounts = {savings, checking, fixedDeposit};
        for (BankAccount acc : accounts) {
            acc.displayAccountType();
            acc.displayAccountInfo();
            System.out.println();
        }
    }
}
