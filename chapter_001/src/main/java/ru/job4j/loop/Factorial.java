package ru.job4j.loop;

/**
 * @author Dmitrii Mitin (mailto:ppdnk@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Вычисление факториала.
     * @param n Число, для которого вычисляется факториал.
     * @return Факториал.
     */
    public int calc(int n) {
        int result = 1;
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                result = result * i;
            }
        }
        return result;
    }
}
