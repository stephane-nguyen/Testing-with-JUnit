package com.example;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTestTest {
    
    @RepeatedTest(5)
    @DisplayName("test Success of Deposit 450")
    /* only possible with JUnit5 : don't need to create an instance of BankAccount, we can put it in parameter */
    public void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(450);
        assertEquals(450, bankAccount.getBalance());
    }

    @RepeatedTest(5)
    @DisplayName("test Success of Deposit 450")
    /* only possible with JUnit5 : don't need to create an instance of BankAccount, we can put it in parameter */
    public void testDepositRepetitionInfo(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
        bankAccount.deposit(450);
        assertEquals(450, bankAccount.getBalance());
        System.out.println("Nr : " + repetitionInfo.getCurrentRepetition());
    }
}
