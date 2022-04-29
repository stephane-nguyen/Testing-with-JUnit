package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


/* 
    minimize dependencies, when we do need externals objects
    test library to help stubbing and mocking objects (mocking = create an isolated version of the object to test it without touching the real one)
     to create mock objects for testing and write loosely coupled tests that are really only testing the unit of code and not hidden dependencies of that piece of code

Mockito enables us to create mocks and specify how they should behave in certain situations. 
*/
@ExtendWith(MockitoExtension.class)
public class CalculteMethodsMockitoTest {
    @Mock
    CalculateMethods calculateMethods;

    @BeforeEach
    public void setupMocks(){
        Mockito.when(calculateMethods.divide(6,3)).thenReturn(2.0);
    }

    @Test
    public void testDivide(){
        assertEquals(2.0, calculateMethods.divide(6,3));
    }
}
