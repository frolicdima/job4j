package ru.job4j.tracker;

import java.util.*;

public class StartUI {
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

    boolean work = true;

    public void exit() {
        work = false;
    }

    /**
     * Альтернативный основной цикл программы
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);//почему в скобках "this"?
        while(work) {
            menu.show();

        }
    }

    /**
     * Основой цикл программы
     */
    /*
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>(); //создали список range
        menu.fillActions(); //заполняет список actions объектами внутренних классов, например, AddItem, которые созданы на основе интерфейса UserAction.
        //actions является полем объекта menu
        for (int i = 0; i < menu.getActionsLentgh(); i++) { //наполняю список range пустыми элементами по количеству элементов в списке actions
            range.add(i);
        }
        do {
            menu.show(); //выводит на экран поле info для каждого элемента в списке actions (печатает меню)
            menu.select(Integer.valueOf(this.input.ask("select:")));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }
*/
    /**
     * Запускт программы
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
        }
    }