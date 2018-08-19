package ru.job4j.converter;

/**
 * Конвертер валюты.
 */
public class Converter {
    /**
     * Метод для ковертации рублей в евро.
     * @param value - сколько есть рублей.
     * @return - сколько получится евро.
     */
    public int rubleToEuro(int value) {
        return (value / 70);
    }

    /**
     * Метод для конвертации рублей в доллары.
     * @param value - сколько есть рублей.
     * @return - сколько получится долларов.
     */
    public int rubleToDollar(int value) {
        return (value / 60);
    }

    /**
     * Метод для конвертации евро в рубли.
     * @param value - сколько есть евро.
     * @return - сколько получится рублей.
     */
    public int euroToRuble(int value) {
        return (value * 70);
    }

    /**
     * Метод для конвертации долларов в рубли.
     * @param value - сколько есть долларов.
     * @return - сколько получится рублей.
     */
    public int dollarToRuble(int value) {
        return (value * 60);
    }
}
