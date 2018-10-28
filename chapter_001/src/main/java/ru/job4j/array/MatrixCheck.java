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
        boolean diagOne = data[0][0]; //стартовое значение главное диагонали;
        boolean diagTwo = data[0][data.length - 1]; //стартовое значение побочной диагонали;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (i == j) {
                    if (data[i][j] != diagOne) {
                        result = false;
                        break;
                    }
                } else if (i == j + data.length - 1) {
                    if (data[i][data.length - 1 - i] != diagTwo) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
