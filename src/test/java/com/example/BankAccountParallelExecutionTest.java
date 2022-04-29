package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT) //faster with it 
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

    @Test
    @DisplayName("test Success of Deposit 450")
    /*
     * only possible with JUnit5 : don't need to create an instance of BankAccount,
     * we can put it in parameter
     */
    public void testDeposit(BankAccount bankAccount) {
        try{
            Thread.sleep(200); // for 1000, error since our test will expire
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(450);
        assertEquals(450, bankAccount.getBalance());
    }

    @Test
    @DisplayName("test Success of Deposit 450")
    public void testDeposit1(BankAccount bankAccount) {
        try {
            Thread.sleep(500); // for 1000, error since our test will expire
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(450);
        assertEquals(450, bankAccount.getBalance());
    }

    @Test
    @DisplayName("test Success of Deposit 450")
    public void testDeposit2(BankAccount bankAccount) {
        try {
            Thread.sleep(800); // for 1000, error since our test will expire
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(450);
        assertEquals(450, bankAccount.getBalance());
    }
}
