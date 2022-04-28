package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



//assertions decide whether the tests fail or not 


@DisplayName("test BankAccount class")
public class BankAccountAssertTest {
    
    @Test
    @DisplayName("test withdraw 300 successfully") // name of the test
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount(500, 100);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("test Success of Deposit 450")
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount(500, 100);
        bankAccount.deposit(450);
        assertEquals(950, bankAccount.getBalance());
    }

    @Test
    @DisplayName("test : amount will become negative because of the withdraw")
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("test activation account after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("test set bank holder name")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.setBankHolderName("Cédric");
        assertNotNull(bankAccount.getBankHolderName());
    }

    @Test
    @DisplayName("test we can't withdraw below minimum")
    public void testNoWithdrawBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName("test we can't withdraw below minimum")
    public void testWithdrawAndDepositWithoutExceptions(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertAll(() -> bankAccount.deposit(500), () -> bankAccount.withdraw(200));
    }
    
    @Test
    @DisplayName("test speed deposit")
    public void testDepositTimeout(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(33));
        //customized msg
        assertEquals(0, 1/3, "oops not the same");
        //automatically fail the test
        //fail(); 
    }
}
