


package Controller;

import model.Customer;
import model.Account;
import model.Transaction;
import model.InterestBearing;

import java.util.ArrayList;
import java.util.List;

public class BankController {

    private List<Customer> customers = new ArrayList<>();

    // Register a new customer
    public void registerCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer registered successfully.");
    }

    // Search for a customer using their ID
    public Customer searchCustomer(int customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null;
    }

    // Retrieve all registered customers
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    // Create an account for an existing customer
    public void createAccount(int customerID, Account account) {
        Customer customer = searchCustomer(customerID);

        if (customer != null) {
            customer.addAccount(account);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    // Search for an account using its account number
    public Account searchAccount(String accountNumber) {
        for (Customer customer : customers) {
            for (Account account : customer.getAccounts()) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    return account;
                }
            }
        }
        return null;
    }

    // Deposit money into an account
    public void depositMoney(String accountNumber, double amount) {
        Account account = searchAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        } else if (account.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money from an account
    public void withdrawMoney(String accountNumber, double amount) {
        Account account = searchAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        } else if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
        }
    }

    // Retrieve transaction history for an account
    public List<Transaction> getTransactionHistory(String accountNumber) {
        Account account = searchAccount(accountNumber);

        if (account != null) {
            return account.getTransactionHistory();
        }

        return new ArrayList<>();
    }

    // Apply monthly interest to eligible accounts
    public void applyMonthlyInterest() {
        for (Customer customer : customers) {
            for (Account account : customer.getAccounts()) {

                if (account instanceof InterestBearing) {
                    InterestBearing interestAccount =
                            (InterestBearing) account;

                    interestAccount.applyInterest();

                    System.out.println(
                            "Monthly interest applied to account: "
                            + account.getAccountNumber()
                    );
                }
            }
        }

        System.out.println("Monthly interest process completed.");
    }
}
