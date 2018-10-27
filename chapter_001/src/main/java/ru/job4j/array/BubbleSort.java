package ru.job4j.array;

/**
 * @author Dmitrii Mitin (mailto:ppdnk@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * Сортировка массива методом пузырька.
     * @param array Входной массив для сортировки.
     * @return Возвращает отсортированный массив.
     */
    public int[] sort(int[] array) {
        int temp;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
