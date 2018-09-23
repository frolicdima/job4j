package ru.job4j.max;

/**
 * @author Dmitrii Mitin (mailto:ppdnk@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Метод для поиска максимального числа.
     * @param first - первое число,
     * @param second - второе число.
     * @return - максимальное число.
     */
    public int max(int first, int second) {
        return (first >= second ? first : second);
    }

    public int max(int first, int second, int third) {
        //int temp = max(first, second);
        //temp = max(temp, third);
        //return temp;
        return max(max(first, second), third);
    }
}
