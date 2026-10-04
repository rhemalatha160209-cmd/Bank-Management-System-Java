// 1. Interface for Transactions
interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
}

// 2. Parent Class with Encapsulation
abstract class BankAccount implements Transaction {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Abstract method to display account details
    public abstract void displayAccountType();
}

// 3. Child Class implementing Inheritance & Polymorphism
class SavingsAccount extends BankAccount {
    private double interestRate = 0.04; // 4% Interest

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Successfully deposited: $" + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

// 4. Main Class to run the Project
class Main {
    public static void main(String[] args) {
        SavingsAccount myAcc = new SavingsAccount("SAV12345", 1000.0);

        System.out.println("--- BANK ACCOUNT DETAILS ---");
        myAcc.displayAccountType();
        System.out.println("Account No: " + myAcc.getAccountNumber());
        System.out.println("Initial Balance: $" + myAcc.getBalance());

        System.out.println("\n--- TRANSACTIONS ---");
        myAcc.deposit(500.0);
        myAcc.withdraw(200.0);

        System.out.println("\nFinal Balance: $" + myAcc.getBalance());
    }
}
