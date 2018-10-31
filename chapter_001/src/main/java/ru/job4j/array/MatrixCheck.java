package ru.job4j.array;

/**
 * @author Dmitrii Mitin (mailto:ppdnk@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class MatrixCheck {
    /**
     * Проверка, что диагонали массива состоят из одинаковых элементов.
     * @param data Массив, в котором булет осуществляться проверка диагоналей.
     * @return Возвращает true, если диагонали массива состоят из одинаковых элементов и false в противном случае.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            } else if (data[0][data.length - 1] != data[i][data.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
