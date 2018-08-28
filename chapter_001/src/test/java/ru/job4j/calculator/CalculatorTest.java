package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubstractTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        calc.substract(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultiplyTwoByFourThenEight() {
        Calculator calc = new Calculator();
        calc.multiply(2D, 4D);
        double result = calc.getResult();
        double expected = 8D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivideNineByThreeThenThree() {
        Calculator calc = new Calculator();
        calc.divide(9D, 3D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultiplicationDoubles() {
        Calculator calc = new Calculator();
        calc.multiply(1.1, 2.2);
        double result = calc.getResult();
        double expected = 2.42;
        assertThat(result, is(expected));
    }
}