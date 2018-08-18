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
    public void whenSubstractionTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        calc.substraction(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultiplicationTwoByFourThenEight() {
        Calculator calc = new Calculator();
        calc.multiplication(2D, 4D);
        double result = calc.getResult();
        double expected = 8D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivisionNineByThreeThenThree() {
        Calculator calc = new Calculator();
        calc.division(9D, 3D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }
}