package ru.job4j.fit;

/**
 * Программа расчета идеального веса.
 */
public class Fit {

    /**
     * Идеальный вес мужчины.
     * @param height - рост.
     * @return - идеальный вес.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес женщины.
     * @param height - рост.
     * @return - идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
