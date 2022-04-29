package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // allows us to remove static from BeforeAll/AfterAll
public class BankAccountBeforeAndAfterTest {
    static BankAccount bankAccount;

    @BeforeAll // has to be static
    public void prepTest() {
        bankAccount = new BankAccount(500, 0);
    }

    // @BeforeEach // no static, before each test
    // public void prepTest1() {
    //     bankAccount = new BankAccount(500, 0);
    // }

    @Test
    public void testWithdraw() {
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(500);
        assertEquals(700, bankAccount.getBalance());
    }

    @AfterAll
    public void endTest() {
        System.out.println("End of the Test");
    }

    // @AfterEach
    // public void endTest1() {
    //     System.out.println("End of the Test");
    // }
}
