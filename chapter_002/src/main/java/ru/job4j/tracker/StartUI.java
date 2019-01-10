package ru.job4j.tracker;

import java.util.*;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки
     */
    public static final String ADD = "0";
    public static final String SHOWALLITEMS = "1";
    public static final String EDITITEM = "2";
    public static final String DELETEITEM = "3";
    public static final String FINDITEMBYID = "4";
    public static final String FINDITEMBYNAME = "5";
    public static final String EXIT = "6";
    /**
     * Получение данных от пользователя
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструтор, инициализирующий поля
     * @param input ввод данных
     * @param tracker хранилище заявок
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    /*private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }*/
    /**
     * Метод реализует вывод всех существующих заявок
     */
    private void showItems() {
        System.out.println("------------ Все заявки --------------");
        for (Item item : tracker.getAll()) {
            System.out.println(item.getId() + " - " + item.getName() + " - " + item.getDesc());
        }
        System.out.println();
    }
    /**
     * Метод реализует редактирование существующей заявки по ее ID
     */
    private void editItem() {
        String oldId = this.input.ask("Введите ID заявки, которую нужно обновить :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item updated = new Item(name, desc);
        this.tracker.replaceById(oldId, updated);
    }
    /**
     * Метод реализует удаление существующей заявки по ее ID
     */
    private void deleteItem() {
        String oldId = this.input.ask("Введите ID заявки, которую нужно удалить :");
        this.tracker.deleteById(oldId);
    }
    /**
     * Метод реализует поиск и вывод на экран существующей заявки по ее ID
     */
    private void findItemById() {
        String oldId = this.input.ask("Введите ID заявки, которую нужно найти :");
        Item result = this.tracker.findById(oldId);
        System.out.println("Найдена заявка:");
        System.out.println(result.getId() + " - " + result.getName() + " - " + result.getDesc());
    }
    /**
     * Метод реализует поиск и вывод на экран существующих заявок по имени (name)
     */
    private void findItemByName() {
        String search = this.input.ask("Введите имя или часть имени заявки для поиска :");
        Item[] result = tracker.findByName(search);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getId() + " - " + result[i].getName() + " - " + result[i].getDesc());
        }
    }
    /**
     * Метод реализует отображение пунктов меню
     */
    private void showMenu() {
        System.out.println("Меню");
        System.out.println("0. AddItem");
        System.out.println("1. GetAll");
        System.out.println("2. ReplaceById");
        System.out.println("3. DeleteById");
        System.out.println("4. FindById");
        System.out.println("5. FindByName");
        System.out.println("6. Exit");
    }
    /**
     * Основой цикл программы
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(this.input.ask("select:", range));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
        }
    }