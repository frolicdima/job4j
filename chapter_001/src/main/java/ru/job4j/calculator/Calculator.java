package ru.job4j.calculator;

/**
 * Calculator
 *
 * @author Dmitrii Mitin (mailto:ppdnk@mail.ru)
 */
public class Calculator {
    private double result;

    public void add(double first, double second) {
        /**
         * add.
         * @param first - first arg,
         * @param second - second arg.
         */
        this.result = first + second;
    }

    public void substraction(double first, double second) {
        /**
         * subtraction.
         * @param first - first arg,
         * @param second - second arg.
         */
        this.result = first - second;
    }

    public void multiplication(double first, double second) {
        /**
         * multiplication.
         * @param first - first arg,
         * @param second - second arg.
         */
        this.result = first * second;
    }

    public void division(double first, double second) {
        /**
         * division.
         * @param first - first arg,
         * @param second - second arg.
         */
        this.result = first / second;
    }

    public double getResult() {
        /**
         * getResult.
         * @return result.
         */
        return this.result;
    }
}