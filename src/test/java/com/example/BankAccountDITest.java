package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/* DI = dependency injection : 

Dependency injection avoids duplicate code and makes the tests more loosely coupled.
  */
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDITest {
    @Test
    @DisplayName("test Success of Deposit 450")
    /*
     * only possible with JUnit5 : don't need to create an instance of BankAccount,
     * we can put it in parameter
     */
    public void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(450);
        assertEquals(450, bankAccount.getBalance());
    }

}
