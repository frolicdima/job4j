package ru.job4j.array;

/**
 * @author Dmitrii Mitin (mailto:ppdnk@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
    /**
     * Вычисление факториала.
     * @param data Массив, в котором булет осуществляться поиск.
     * @param el Значение для поиска в массиве.
     * @return Возвращает индекс элемента, если есть совпадение или -1 в противном случае.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
