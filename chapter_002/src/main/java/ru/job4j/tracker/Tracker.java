package ru.job4j.tracker;

import java.util.Random;
import java.util.Arrays;

public class Tracker {
    /**
     * Хранилище заявок
     */
    private Item[] items = new Item[100];
    /**
     * Счетчик заполненных жлементов, указывает куда записывать новый элемент
     */
    private int position = 0;
    /**
     * Генератор случайных чисел
     */
    private static final Random RN = new Random();
    /**
     * Метод реализует добавление новой заявки в хранилище.
     * @param item данные новой заявки.
     * @return возвращает новую заявку.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }
    /**
     * Метод реализует генерацию случайного ID
     */
    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Метод реализует поиск и вывод на экран существующей заявки по ее ID
     * @param id  - id заявки, которую нужно найти
     * @return возвращает найденную заявку
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }
    /**
     * Метод реализует вывод всех существующих заявок
     * @return возвращает все существующие заявки
     */
    public Item[] getAll() {
        return Arrays.copyOf(this.items, this.position);
    }
    /**
     * Метод реализует редактирование существующей заявки по ее ID
     * @param id  - id заявки, которую нужно заменить
     * @param update - новые данные заявки
     */
    public boolean replaceById(String id, Item update) {
        public boolean done = false;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                update.setId(id);
                items[i] = update;
                done = true;
                break;
            }
            return done;
        }


    }
    /**
     * Метод реализует удаление существующей заявки по ее ID
     * @param id  - id заявки, которую нужно удалить
     */
    public void deleteById(String id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, position - i);
                position--;
                break;
            }
        }
    }
    /**
     * Метод реализует поиск и вывод на экран существующих заявок по имени (name)
     * @param name  - имя заявки, которую нужно найти
     * @return массив найденных заявок
     */
    public Item[] findByName(String name) {
        int j = 0;
        Item[] result = new Item[position];
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getName().contains(name)) {
                result[j] = items[i];
                j++;
            }
        }
        return Arrays.copyOf(result, j);
    }
}