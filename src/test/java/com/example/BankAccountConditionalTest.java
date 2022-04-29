package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

//annotations for checking for system and environment variables exist
//Often these conditional tests are not a good pratice but sometimes you don't have the choice
public class BankAccountConditionalTest {

    // test ignored if not the case
    @Test
    @EnabledOnOs({ OS.MAC })
    public void testMac() {

    }

    @Test
    @EnabledOnOs({ OS.WINDOWS })
    public void testWindows() {

    }

    @Test
    @EnabledOnJre({ JRE.JAVA_16 })
    public void testJre() {

    }

    @Test
    @DisabledOnJre({ JRE.JAVA_16 })
    public void testNoJre() {

    }
}
