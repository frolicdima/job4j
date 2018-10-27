package ru.job4j.array;

/**
 * @author Dmitrii Mitin (mailto:ppdnk@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * Проверка, что массив состоит из одинаковых элементов типа boolean.
     * @param data входной массив.
     * @return Возвращает true, если массив состоит из одинаковых элементов, в противном случае false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0] != data[i]) {
                result = false;
                break;
            }

        }
        return result;
    }
}