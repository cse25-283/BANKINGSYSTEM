
import Controller.BankController;
import model.Customer;
import model.SavingsAccount;
import model.InvestmentAccount;
import model.Account;
import model.Transaction;

public class Main {

    public static void main(String[] args) {

        // Create bank controller
        BankController bank = new BankController();

        // Register a customer
        Customer customer = new Customer(
                1001,
                "Logan",
                "Obonye",
                "Gaborone"
        );

        bank.registerCustomer(customer);

        // Create accounts
        SavingsAccount savings = new SavingsAccount(
                "SAV001", 1000.00, "Gaborone"
        );

        InvestmentAccount investment = new InvestmentAccount(
                "INV001", 2000.00, "Gaborone"
        );

        bank.createAccount(1001, savings);
        bank.createAccount(1001, investment);

        // Perform transactions
        bank.depositMoney("SAV001", 500.00);
        bank.withdrawMoney("SAV001", 200.00);

        // Apply monthly interest
        System.out.println("\n--- MONTHLY INTEREST ---");
        bank.applyMonthlyInterest();

        // Display account balances
        System.out.println("\n--- ACCOUNT BALANCES ---");

        System.out.println(
                "Savings Balance: P" + savings.getBalance()
        );

        System.out.println(
                "Investment Balance: P" + investment.getBalance()
        );

        // Display transaction history
        System.out.println("\n--- SAVINGS TRANSACTIONS ---");

        for (Transaction transaction :
                bank.getTransactionHistory("SAV001")) {
            transaction.recordTransaction();
        }

        System.out.println("\n--- INVESTMENT TRANSACTIONS ---");

        for (Transaction transaction :
                bank.getTransactionHistory("INV001")) {
            transaction.recordTransaction();
        }
    }
}

