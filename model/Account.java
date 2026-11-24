



package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private static int nextTransactionId = 1;

    private String accountNumber;
    private double balance;
    private String branch;

    private List<Transaction> transactionHistory = new ArrayList<>();

    // Constructor
    public Account(String accountNumber, double balance, String branch) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.branch = branch;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getBranch() {
        return branch;
    }

    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    // Deposit money
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        recordTransaction("Deposit", amount);
        return true;
    }

    // Withdraw money
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        recordTransaction("Withdrawal", amount);
        return true;
    }

    // Record transaction
    protected void recordTransaction(String type, double amount) {
        Transaction transaction = new Transaction(
                nextTransactionId++,
                type,
                amount,
                this
        );

        transactionHistory.add(transaction);
    }

    // Record interest payment
    public void recordInterest(double amount) {
        if (amount > 0) {
            recordTransaction("Interest", amount);
        }
    }

    // Update balance
    protected void setBalance(double balance) {
        this.balance = balance;
    }
}
