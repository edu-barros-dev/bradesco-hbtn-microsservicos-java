package src.test.java.com.example.calculator.model;

import org.testng.annotations.Test;
import src.main.java.com.example.calculator.model.Calculator;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void sumTest() {
        Double result = calculator.sum(10.0, 5.0);
        assertEquals(15.0, result);
    }

    @Test
    public void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> calculator.sum(null, 10.0));
        assertThrows(NullPointerException.class, () -> calculator.sum(10.0, null));
        assertThrows(NullPointerException.class, () -> calculator.sum(null, null));
    }

    @Test
    void subTest() {
        Double result = calculator.sub(10.0, 4.0);
        assertEquals(6.0, result);
    }

    @Test
    void divideTest() {
        Double result = calculator.divide(20.0, 4.0);
        assertEquals(5.0, result);
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10.0, 0.0));
    }

    @Test
    void factorialTest() {
        Integer result = calculator.factorial(5);
        assertEquals(Integer.valueOf(120), result);
    }

    @Test
    void integerToBinaryTest() {
        Integer result = calculator.integerToBinary(5);
        assertEquals(Integer.valueOf(101), result);
    }

    @Test
    void integerToHexadecimalTest() {
        String result = calculator.integerToHexadecimal(170);
        assertEquals("AA", result);
    }
}

