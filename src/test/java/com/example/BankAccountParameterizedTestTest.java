package com.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
//import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {
    // parameterize tests with differents value for the parameters. 
    @ParameterizedTest
    @ValueSource(ints = {100, 400, 800, 1000})
    @DisplayName("test Success of Deposit")
    /* only possible with JUnit5 : don't need to create an instance of BankAccount, we can put it in parameter 
    amount <=> Values from ints */

    public void testDeposit(int amount, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
    public void testDayOfWeek(DayOfWeek day){
        assertTrue(day.toString().startsWith("T"));
    }

    //@CsvSource({"100, Mary", "200, Rachid", "150, Ted"})
    @ParameterizedTest
    @CsvFileSource(resources = "/details.csv") 
    public void depositAndNameTest(double amount, String name, BankAccount bankAccount){
        bankAccount.deposit(amount);
        bankAccount.setBankHolderName(name);
        assertEquals(amount, bankAccount.getBalance());
        assertEquals(name, bankAccount.getBankHolderName());
    }
}
