package ru.job4j.loop;

/**
 * @author Dmitrii Mitin (mailto:ppdnk@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Сумма четных чисел из заданного промежутка.
     * @param start Начало промежутка,
     * @param finish Конец промежутка.
     * @return Сумма четных чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
