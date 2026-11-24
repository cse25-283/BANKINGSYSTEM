


package model;

public class ChequeAccount extends Account {

    private double overdraftLimit;

    // Constructor
    public ChequeAccount(String accountNumber, double balance,
                         String branch, double overdraftLimit) {
        super(accountNumber, balance, branch);
        this.overdraftLimit = overdraftLimit;
    }

    // Get overdraft limit
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    // Withdraw money with overdraft support
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > getBalance() + overdraftLimit) {
            return false;
        }

        setBalance(getBalance() - amount);
        recordTransaction("Withdrawal", amount);
        return true;
    }
}
