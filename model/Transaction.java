
package model;

import java.time.LocalDateTime;

public class Transaction {

    private int transactionId;
    private String transactionType;
    private double amount;
    private LocalDateTime dateTime;
    private Account account;

    // Constructor
    public Transaction(int transactionId, String transactionType,
                       double amount, Account account) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.account = account;
        this.dateTime = LocalDateTime.now();
    }

    // Getters
    public int getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Account getAccount() {
        return account;
    }

    // Display transaction information
    public void recordTransaction() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Type: " + transactionType);
        System.out.println("Amount: P" + amount);
        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Date and Time: " + dateTime);
    }
}
