

package model;

public class SavingsAccount extends Account implements InterestBearing {

    private static final double INTEREST_RATE = 0.0005;

    // Constructor
    public SavingsAccount(String accountNumber, double balance, String branch) {
        super(accountNumber, balance, branch);
    }

    // Calculate monthly interest (0.05%)
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    // Apply monthly interest
    @Override
    public void applyInterest() {
        double interest = calculateInterest();
        double roundedInterest = Math.round(interest * 100.0) / 100.0;

        if (roundedInterest > 0) {
            setBalance(getBalance() + roundedInterest);
            recordInterest(roundedInterest);
        }
    }
}
