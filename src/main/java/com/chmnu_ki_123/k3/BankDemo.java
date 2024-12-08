package com.chmnu_ki_123.k3;

public class BankDemo {

    public static void main(String[] args) {
        CheckingAccount c = new CheckingAccount(101);
        System.out.println("Depositing $500...");
        c.deposit(500.00);

        System.out.println("\nWithdrawing $100...");
        c.withdraw(100.00);
        System.out.println("Current balance: $" + c.getBalance());

        System.out.println("\nWithdrawing $600...");
        try {
            c.withdraw(600.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Attempted to withdraw $600 but only had $" + c.getBalance());
            System.out.println("Need $" + e.getAmount() + " more.");
        }

    }
}

class BankAccount {
    private double balance;
    private int number;

    public BankAccount(int number) {
        this.number = number;
        this.balance = 0; // Ensure balance starts at 0 or another value if needed
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            double needs = amount - balance;
            throw new InsufficientFundsException(needs);
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }
}

class CheckingAccount extends BankAccount {

    public CheckingAccount(int number) {
        super(number);
    }

}

class InsufficientFundsException extends RuntimeException {
    private double amount;

    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
