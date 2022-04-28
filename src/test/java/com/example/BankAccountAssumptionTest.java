package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


//assumption fails -> test will be aborted 

public class BankAccountAssumptionTest {
    @Test
    @DisplayName("test activation account after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assumeTrue(bankAccount != null, "Account is not null");
        assertTrue(bankAccount.isActive());
        //<=> assertTrue and assumeTrue, even though the assumption is not met, the test is not aborted and passes
        assumingThat(bankAccount == null, () -> assertTrue(bankAccount.isActive()));
    }
}//before JUnit 5, parameters from method & constructors not allowed