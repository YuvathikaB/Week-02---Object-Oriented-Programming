import java.util.Scanner;
public class BankingSystem {
    abstract static class BankAccount {
        private String accountNumber;
        private String holderName;
        private double balance;
        public BankAccount(String accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        }
        public String getAccountNumber() {
            return accountNumber;
        }
        public String getHolderName() {
            return holderName;
        }
        public double getBalance() {
            return balance;
        }
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Invalid withdraw amount.");
            }
        }
        public abstract double calculateInterest();

        public void displayInfo() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Holder Name: " + holderName);
            System.out.println("Balance: " + balance);
        }
    }
    interface Loanable {
        void applyForLoan(double amount);
        boolean calculateLoanEligibility();
    }
    static class SavingsAccount extends BankAccount implements Loanable {
        private final double interestRate = 0.05;
        public SavingsAccount(String accountNumber, String holderName, double balance) {
            super(accountNumber, holderName, balance);
        }
        @Override
        public double calculateInterest() {
            return getBalance() * interestRate;
        }
        @Override
        public void applyForLoan(double amount) {
            System.out.println("SavingsAccount loan applied for: $" + amount);
        }
        @Override
        public boolean calculateLoanEligibility() {
            return getBalance() >= 1000;
        }
    }
    static class CurrentAccount extends BankAccount implements Loanable {
        private final double interestRate = 0.03;
        public CurrentAccount(String accountNumber, String holderName, double balance) {
            super(accountNumber, holderName, balance);
        }
        @Override
        public double calculateInterest() {
            return getBalance() * interestRate;
        }
        @Override
        public void applyForLoan(double amount) {
            System.out.println("CurrentAccount loan applied for: " + amount);
        }
        @Override
        public boolean calculateLoanEligibility() {
            return getBalance() >= 5000;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Type (Savings/Current): ");
        String type = scanner.nextLine().trim();
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Holder Name: ");
        String holderName = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        BankAccount account = null;
        if (type.equalsIgnoreCase("Savings")) {
            account = new SavingsAccount(accountNumber, holderName, balance);
        } else if (type.equalsIgnoreCase("Current")) {
            account = new CurrentAccount(accountNumber, holderName, balance);
        } else {
            System.out.println("Invalid account type.");
            System.exit(0);
        }
        System.out.println("\nAccount Created ");
        account.displayInfo();
        System.out.print("\nEnter deposit amount: ");
        double deposit = scanner.nextDouble();
        account.deposit(deposit);
        System.out.print("\nEnter withdraw amount: ");
        double withdraw = scanner.nextDouble();
        account.withdraw(withdraw);
        double interest = account.calculateInterest();
        System.out.println("\nCalculated Interest: " + interest);
        if (account instanceof Loanable) {
            System.out.print("\nEnter loan amount to apply: ");
            double loanAmount = scanner.nextDouble();
            Loanable loanable = (Loanable) account;
            loanable.applyForLoan(loanAmount);
            System.out.println("Loan Eligibility: " + (loanable.calculateLoanEligibility() ? "Eligible" : "Not Eligible"));
        }
        scanner.close();
    }
}
