package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(8, calculator.add(5, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));
    }

    @Test
    void testIsPrimeTrue() {
        assertTrue(calculator.isPrime(17));
    }

    @Test
    void testIsPrimeFalse() {
        assertFalse(calculator.isPrime(18));
    }

    @Test
    void testIsPrimeEdgeCases() {
        assertFalse(calculator.isPrime(0));
        assertFalse(calculator.isPrime(1));
        assertTrue(calculator.isPrime(2));
    }
}
