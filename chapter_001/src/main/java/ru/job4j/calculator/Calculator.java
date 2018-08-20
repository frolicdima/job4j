package ru.job4j.calculator;

/**
 * Calculator
 *
 * @author Dmitrii Mitin (mailto:ppdnk@mail.ru)
 */
public class Calculator {
    private double result;

    /**
     * add.
     * @param first - first arg,
     * @param second - second arg.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * subtraction.
     * @param first - first arg,
     * @param second - second arg.
     */
    public void substraction(double first, double second) {
        this.result = first - second;
    }

    /**
     * multiplication.
     * @param first - first arg,
     * @param second - second arg.
     */
    public void multiplication(double first, double second) {
        this.result = first * second;
    }

    /**
     * division.
     * @param first - first arg,
     * @param second - second arg.
     */
    public void division(double first, double second) {
        this.result = first / second;
    }

    /**
     * getResult.
     * @return result.
     */
    public double getResult() {
        return this.result;
    }
}