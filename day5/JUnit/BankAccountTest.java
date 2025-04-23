
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import JUnit.BankAccount;


public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void setup() {
        bankAccount = new BankAccount();
    }

   
    @Test
    public void testDeposit() {
        bankAccount.deposit(100.0);
        assertEquals(100.0, bankAccount.getBalance(), "Balance should be 100 after depositing 100.");
        
        bankAccount.deposit(50.0);
        assertEquals(150.0, bankAccount.getBalance(), "Balance should be 150 after depositing 50.");
    }

    
    @Test
    public void testWithdraw() {
        bankAccount.deposit(200.0);
        assertTrue(bankAccount.withdraw(50.0), "Withdrawal of 50 should be successful.");
        assertEquals(150.0, bankAccount.getBalance(), "Balance should be 150 after withdrawing 50.");
    }

    
    @Test
    public void testWithdrawInsufficientFunds() {
        bankAccount.deposit(100.0);
        assertFalse(bankAccount.withdraw(150.0), "Withdrawal of 150 should fail due to insufficient funds.");
        assertEquals(100.0, bankAccount.getBalance(), "Balance should remain 100 after a failed withdrawal.");
    }

    
    @Test
    public void testDepositNegativeAmount() {
        double initialBalance = bankAccount.getBalance();
        bankAccount.deposit(-50.0);
        assertEquals(initialBalance, bankAccount.getBalance(), "Balance should not change when depositing a negative amount.");
    }
}
