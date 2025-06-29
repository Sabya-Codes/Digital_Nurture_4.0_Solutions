/**
 * BankAccount class for Exercise 4: AAA Pattern and Test Fixtures
 * This class represents a bank account with various operations
 * Perfect for demonstrating the Arrange-Act-Assert pattern
 */
public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private boolean isActive;
    
    /**
     * Constructor for BankAccount
     * @param accountNumber the account number
     * @param accountHolder the account holder name
     * @param initialBalance the initial balance
     */
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder cannot be null or empty");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.isActive = true;
    }
    
    /**
     * Deposits money into the account
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if amount is negative or zero
     * @throws IllegalStateException if account is not active
     */
    public void deposit(double amount) {
        if (!isActive) {
            throw new IllegalStateException("Cannot deposit to inactive account");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }
    
    /**
     * Withdraws money from the account
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if amount is negative or zero
     * @throws IllegalStateException if account is not active or insufficient funds
     */
    public void withdraw(double amount) {
        if (!isActive) {
            throw new IllegalStateException("Cannot withdraw from inactive account");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }
    
    /**
     * Transfers money to another account
     * @param targetAccount the target account
     * @param amount the amount to transfer
     * @throws IllegalArgumentException if target account is null or amount is invalid
     * @throws IllegalStateException if either account is inactive or insufficient funds
     */
    public void transfer(BankAccount targetAccount, double amount) {
        if (targetAccount == null) {
            throw new IllegalArgumentException("Target account cannot be null");
        }
        if (targetAccount == this) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }
        
        // This will validate amount and account status
        this.withdraw(amount);
        targetAccount.deposit(amount);
    }
    
    /**
     * Closes the account
     * @throws IllegalStateException if account has a positive balance
     */
    public void closeAccount() {
        if (balance > 0) {
            throw new IllegalStateException("Cannot close account with positive balance");
        }
        isActive = false;
    }
    
    /**
     * Applies interest to the account
     * @param interestRate the interest rate (as a percentage, e.g., 5.0 for 5%)
     * @throws IllegalArgumentException if interest rate is negative
     * @throws IllegalStateException if account is not active
     */
    public void applyInterest(double interestRate) {
        if (!isActive) {
            throw new IllegalStateException("Cannot apply interest to inactive account");
        }
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        balance += balance * (interestRate / 100.0);
    }
    
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    @Override
    public String toString() {
        return String.format("BankAccount{accountNumber='%s', accountHolder='%s', balance=%.2f, isActive=%s}",
                accountNumber, accountHolder, balance, isActive);
    }
}
