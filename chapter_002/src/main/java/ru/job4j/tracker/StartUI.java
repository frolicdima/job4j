package ru.job4j.tracker;

public class StartUI {

    public static final String ADD = "0";
    public static final String SHOWALLITEMS = "1";
    public static final String EDITITEM = "2";
    public static final String DELETEITEM = "3";
    public static final String FINDITEMBYID = "4";
    public static final String FINDITEMBYNAME = "5";
    public static final String EXIT = "6";

    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String id;
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Long created = null;
        String[] comments;
        Item item = new Item(id, name, desc, created, comments);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

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

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            }
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
        }
    }