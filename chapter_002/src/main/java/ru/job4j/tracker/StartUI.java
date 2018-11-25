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
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showItems() {
        System.out.println("------------ Все заявки --------------");
        for (Item item : tracker.getAll()) {
            System.out.println(item.getId() + " - " + item.getName() + " - " + item.getDesc());
        }
        System.out.println();
    }

    private void editItem() {
        String oldId = this.input.ask("Введите ID заявки, которую нужно обновить :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item updated = new Item(name, desc);
        this.tracker.replaceById(oldId, updated);
    }

    private void deleteItem() {
        String oldId = this.input.ask("Введите ID заявки, которую нужно удалить :");
        this.tracker.deleteById(oldId);
    }

    private void findItemById() {
        String oldId = this.input.ask("Введите ID заявки, которую нужно найти :");
        Item result = this.tracker.findById(oldId);
        System.out.println("Найдена заявка:");
        System.out.println(result.getId() + " - " + result.getName() + " - " + result.getDesc());
    }

    private void findItemByName() {
        String search = this.input.ask("Введите ID заявки, которую нужно найти :");
        /*for (Item item : tracker.findByName(search)) {
            System.out.println(item.getId() + " - " + item.getName() + " - " + item.getDesc());
        }*/
        Item[] result = tracker.findByName(search);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getId() + " - " + result[i].getName() + " - " + result[i].getDesc());
        }
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
            } else if (SHOWALLITEMS.equals(answer)) {
                this.showItems();
            } else if (EDITITEM.equals(answer)) {
                this.editItem();
            } else if (DELETEITEM.equals(answer)) {
                this.deleteItem();
            } else if (FINDITEMBYID.equals(answer)) {
                this.findItemById();
            } else if (FINDITEMBYNAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
        }
    }