
package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int customerID;
    private String firstName;
    private String surname;
    private String address;

    private List<Account> accounts = new ArrayList<>();

    // Constructor
    public Customer(int customerID, String firstName,
                    String surname, String address) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
    }

    // Getters
    public int getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    // Add account
    public void addAccount(Account account) {
        accounts.add(account);
    }
}
