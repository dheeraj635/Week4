
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccount {

    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

   
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

   
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true; 
        }
        return false; 
    }

   
    public double getBalance() {
        return balance;
    }
}
