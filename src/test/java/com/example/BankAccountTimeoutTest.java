package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

//for all tests in class 
//    @Timeout(value=500, unit = TimeUnit.MILLISECONDS)

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS) // timeout the full method
    public void testDepositTimeoutAssertion(BankAccount bankAccount) {
        try {
            Thread.sleep(200); // for 1000, error since our test will expire
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(300);
        assertEquals(300, bankAccount.getBalance());
    }

    @Test
    public void testDepositTimeoutAnnotation(BankAccount bankAccount) {
        try {
            Thread.sleep(1000); // for 1000, error since our test will expire
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(300);
        // timeout the execution of the assertion
        assertTimeout(Duration.ofMillis(500), () -> {
            // Thread.sleep(501); //test failed
            Thread.sleep(10); // test passed
        });
    }
}
