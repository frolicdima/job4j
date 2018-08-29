package ru.job4j.calculator;

import java.math.BigDecimal;

import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 * Calculator
 *
 * @author Dmitrii Mitin (mailto:ppdnk@mail.ru)
 */
public class Calculator {
    /**result**/
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
     * subtract.
     * @param first - first arg,
     * @param second - second arg.
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * multiplу.
     * @param first - first arg,
     * @param second - second arg.
     */
    public void multiply(double first, double second) {
        BigDecimal bdFirst = new BigDecimal(Double.toString(first));
        BigDecimal bdSecond = new BigDecimal(Double.toString(second));
        BigDecimal bdResult = bdFirst.multiply(bdSecond);
        this.result = bdResult.doubleValue();
    }

    /**
     * divide.
     * @param first - first arg,
     * @param second - second arg.
     */
    public void divide(double first, double second) {
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