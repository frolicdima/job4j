package ru.job4j.tracker;

import java.util.*;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Константы меню, они же по факту ключи
     */
    public static final String ADD = "0";
    public static final String SHOWALLITEMS = "1";
    public static final String EDITITEM = "2";
    public static final String DELETEITEM = "3";
    public static final String FINDITEMBYID = "4";
    public static final String FINDITEMBYNAME = "5";
    public static final String EXIT = "6";

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    public class AddItem implements UserAction {

        private int key;
        private String info;

        public AddItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return Integer.valueOf(ADD);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }

        @Override
        public String info() {
            return (ADD + ". AddItem");
        }
    }

    /**
     * Метод реализует вывод всех существующих заявок
     */
    public class ShowItems implements UserAction {

        private int key;
        private String info;

        public ShowItems(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return Integer.valueOf(SHOWALLITEMS);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки --------------");
            for (Item item : tracker.getAll()) {
                System.out.println(item.getId() + " - " + item.getName() + " - " + item.getDesc());
            }
            System.out.println();
        }

        @Override
        public String info() {
            return (SHOWALLITEMS + ". GetAll");
        }
    }

    /**
     * Метод реализует редактирование существующей заявки по ее ID
     */
    public class EditItem implements UserAction {

        private int key;
        private String info;

        public EditItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return Integer.valueOf(EDITITEM);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String oldId = input.ask("Введите ID заявки, которую нужно обновить :");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item updated = new Item(name, desc);
            tracker.replaceById(oldId, updated);
            System.out.println((done == false)? "Элемент с указанным ID не найден" : "Элемент с указанным ID отредактирован");
        }

        @Override
        public String info() {
            return (EDITITEM + ". ReplaceById");
        }
    }

    /**
     * Метод реализует удаление существующей заявки по ее ID
     */
    public class DeleteItem implements UserAction {

        private int key;
        private String info;

        public DeleteItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return Integer.valueOf(DELETEITEM);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String oldId = input.ask("Введите ID заявки, которую нужно удалить :");
            tracker.deleteById(oldId);
        }

        @Override
        public String info() {
            return (DELETEITEM + ". DeleteById");
        }
    }

    /**
     * Метод реализует поиск и вывод на экран существующей заявки по ее ID
     */
    public class FindItemById implements UserAction {

        private int key;
        private String info;

        public FindItemById(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return Integer.valueOf(FINDITEMBYID);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String oldId = input.ask("Введите ID заявки, которую нужно найти :");
            Item result = tracker.findById(oldId);
            System.out.println("Найдена заявка:");
            System.out.println(result.getId() + " - " + result.getName() + " - " + result.getDesc());
        }

        @Override
        public String info() {
            return (FINDITEMBYID + ". FindById");
        }
    }

    /**
     * Метод реализует поиск и вывод на экран существующих заявок по имени (name)
     */
    public class FindItemByName implements UserAction {

        private int key;
        private String info;

        public FindItemByName(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return Integer.valueOf(FINDITEMBYNAME);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String search = input.ask("Введите имя или часть имени заявки для поиска :");
            Item[] result = tracker.findByName(search);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i].getId() + " - " + result[i].getName() + " - " + result[i].getDesc());
            }
        }

        @Override
        public String info() {
            return (FINDITEMBYNAME + ". FindByName");
        }
    }

    /**
     * Метод реализует возможность выхода из программы не выполняя другие пугкты меню
     */
    public class Exit implements UserAction {

        private int key;
        private String info;

        public Exit(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return Integer.valueOf(EXIT);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return (EXIT + ". Exit");
        }
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new EditItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemByName(5, "Find items by name"));
        this.actions.add(new Exit(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}