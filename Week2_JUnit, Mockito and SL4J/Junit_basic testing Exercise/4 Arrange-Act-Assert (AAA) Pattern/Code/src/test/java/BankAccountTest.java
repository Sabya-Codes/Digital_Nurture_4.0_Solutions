import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;

/**
 * Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and Teardown Methods
 * This test class demonstrates:
 * 1. AAA pattern in test organization
 * 2. Test fixtures using @Before and @After
 * 3. Class-level setup using @BeforeClass and @AfterClass
 */
public class BankAccountTest {
    
    // Test fixtures - objects used across multiple tests
    private BankAccount account;
    private BankAccount secondAccount;
    private static int testCounter;
    
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("=== Starting BankAccount Test Suite ===");
        testCounter = 0;
    }
    
    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("=== Completed BankAccount Test Suite ===");
        System.out.println("Total tests executed: " + testCounter);
    }
    
    @Before
    public void setUp() {
        // Arrange - Set up test fixtures before each test
        account = new BankAccount("ACC001", "John Doe", 1000.0);
        secondAccount = new BankAccount("ACC002", "Jane Smith", 500.0);
        testCounter++;
        System.out.println("Test #" + testCounter + " - Setting up test fixtures");
    }
    
    @After
    public void tearDown() {
        // Clean up after each test
        System.out.println("Test #" + testCounter + " - Cleaning up test fixtures");
        account = null;
        secondAccount = null;
    }
    
    // Test 1: Constructor validation using AAA pattern
    @Test
    public void testBankAccountCreation() {
        // Arrange
        String accountNumber = "ACC123";
        String accountHolder = "Alice Johnson";
        double initialBalance = 2500.0;
        
        // Act
        BankAccount newAccount = new BankAccount(accountNumber, accountHolder, initialBalance);
        
        // Assert
        assertEquals("Account number should match", accountNumber, newAccount.getAccountNumber());
        assertEquals("Account holder should match", accountHolder, newAccount.getAccountHolder());
        assertEquals("Initial balance should match", initialBalance, newAccount.getBalance(), 0.01);
        assertTrue("New account should be active", newAccount.isActive());
    }
    
    // Test 2: Deposit functionality using AAA pattern
    @Test
    public void testDeposit() {
        // Arrange
        double initialBalance = account.getBalance();
        double depositAmount = 250.0;
        double expectedBalance = initialBalance + depositAmount;
        
        // Act
        account.deposit(depositAmount);
        
        // Assert
        assertEquals("Balance should increase by deposit amount", 
                    expectedBalance, account.getBalance(), 0.01);
    }
    
    // Test 3: Withdrawal functionality using AAA pattern
    @Test
    public void testWithdraw() {
        // Arrange
        double initialBalance = account.getBalance();
        double withdrawAmount = 300.0;
        double expectedBalance = initialBalance - withdrawAmount;
        
        // Act
        account.withdraw(withdrawAmount);
        
        // Assert
        assertEquals("Balance should decrease by withdrawal amount", 
                    expectedBalance, account.getBalance(), 0.01);
    }
    
    // Test 4: Transfer functionality using AAA pattern
    @Test
    public void testTransfer() {
        // Arrange
        double initialBalanceSource = account.getBalance();
        double initialBalanceTarget = secondAccount.getBalance();
        double transferAmount = 200.0;
        double expectedSourceBalance = initialBalanceSource - transferAmount;
        double expectedTargetBalance = initialBalanceTarget + transferAmount;
        
        // Act
        account.transfer(secondAccount, transferAmount);
        
        // Assert
        assertEquals("Source account balance should decrease", 
                    expectedSourceBalance, account.getBalance(), 0.01);
        assertEquals("Target account balance should increase", 
                    expectedTargetBalance, secondAccount.getBalance(), 0.01);
    }
    
    // Test 5: Interest application using AAA pattern
    @Test
    public void testApplyInterest() {
        // Arrange
        double initialBalance = account.getBalance();
        double interestRate = 5.0; // 5%
        double expectedBalance = initialBalance + (initialBalance * 0.05);
        
        // Act
        account.applyInterest(interestRate);
        
        // Assert
        assertEquals("Balance should increase by interest amount", 
                    expectedBalance, account.getBalance(), 0.01);
    }
    
    // Test 6: Account closure using AAA pattern
    @Test
    public void testCloseAccount() {
        // Arrange
        // First withdraw all money to make balance zero
        double currentBalance = account.getBalance();
        account.withdraw(currentBalance);
        
        // Act
        account.closeAccount();
        
        // Assert
        assertFalse("Account should be inactive after closure", account.isActive());
        assertEquals("Balance should remain zero", 0.0, account.getBalance(), 0.01);
    }
    
    // Test 7: Exception testing with AAA pattern - Invalid deposit
    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        // Arrange
        double invalidAmount = -100.0;
        
        // Act
        account.deposit(invalidAmount);
        
        // Assert - Exception should be thrown (handled by @Test annotation)
    }
    
    // Test 8: Exception testing with AAA pattern - Insufficient funds
    @Test(expected = IllegalStateException.class)
    public void testWithdrawInsufficientFunds() {
        // Arrange
        double currentBalance = account.getBalance();
        double excessiveAmount = currentBalance + 100.0;
        
        // Act
        account.withdraw(excessiveAmount);
        
        // Assert - Exception should be thrown
    }
    
    // Test 9: Exception testing with AAA pattern - Invalid constructor
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAccountCreation() {
        // Arrange
        String invalidAccountNumber = null;
        String validAccountHolder = "Test User";
        double validBalance = 100.0;
        
        // Act
        new BankAccount(invalidAccountNumber, validAccountHolder, validBalance);
        
        // Assert - Exception should be thrown
    }
    
    // Test 10: Complex scenario using AAA pattern
    @Test
    public void testComplexBankingScenario() {
        // Arrange
        double initialBalance1 = account.getBalance();
        double initialBalance2 = secondAccount.getBalance();
        double depositAmount = 500.0;
        double transferAmount = 300.0;
        double interestRate = 2.0;
        
        // Act - Perform multiple operations
        account.deposit(depositAmount);
        account.transfer(secondAccount, transferAmount);
        account.applyInterest(interestRate);
        
        // Assert - Verify final state
        double expectedFinalBalance = (initialBalance1 + depositAmount - transferAmount) * 1.02;
        assertEquals("Final balance should reflect all operations", 
                    expectedFinalBalance, account.getBalance(), 0.01);
        
        double expectedSecondBalance = initialBalance2 + transferAmount;
        assertEquals("Second account should have received transfer", 
                    expectedSecondBalance, secondAccount.getBalance(), 0.01);
    }
    
    // Test 11: State verification using AAA pattern
    @Test
    public void testAccountStateAfterOperations() {
        // Arrange
        assertTrue("Account should start as active", account.isActive());
        
        // Act
        account.deposit(100.0);
        account.withdraw(50.0);
        
        // Assert
        assertTrue("Account should remain active after normal operations", account.isActive());
        assertTrue("Balance should be positive", account.getBalance() > 0);
    }
    
    // Test 12: Boundary testing using AAA pattern
    @Test
    public void testZeroBalanceOperations() {
        // Arrange
        double currentBalance = account.getBalance();
        account.withdraw(currentBalance); // Make balance zero
        
        // Act & Assert for deposit
        account.deposit(0.01); // Minimum positive deposit
        assertEquals("Should accept minimum positive deposit", 0.01, account.getBalance(), 0.001);
        
        // Act & Assert for withdrawal
        account.withdraw(0.01); // Withdraw all
        assertEquals("Balance should be zero after withdrawing all", 0.0, account.getBalance(), 0.001);
    }
}
