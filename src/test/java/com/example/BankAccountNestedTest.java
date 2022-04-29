package com.example;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BankAccountNestedTest {
    @Test
    @DisplayName("test withdraw 300 successfully") // name of the test
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount(500, 100);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("test Deposit 450 successfully")
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount(500, 100);
        bankAccount.deposit(450);
        assertEquals(950, bankAccount.getBalance());
    }

    @Nested // to test the children class( <=> sub test) in addition. Nested tests are used for grouping unit tests 
    class WhenBalanceEqualsZero{
        @Test
        public void testWithdrawMinimumBalanceIs0(){
            BankAccount bankAccount = new BankAccount(500, 0);
            assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));
        }
        @Test
        public void testWithdrawMinimumBalanceNegative1000(){
            BankAccount bankAccount = new BankAccount(500, -1000);
            bankAccount.withdraw(500);
            assertEquals(0, bankAccount.getBalance());
        }
    }
}
