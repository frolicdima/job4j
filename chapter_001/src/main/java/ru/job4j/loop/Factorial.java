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
        if (n < 0) {
            System.out.println("unsupported value");
        }
        if (n == 0) {
            return 1;
        } else {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
            return result;
        }
    }
}
