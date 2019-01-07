package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    // получаем ссылку на стандартный вывод в консоль.
    PrintStream stdout = System.out;
    // Создаем буфер для хранения вывода.
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasNoDeletedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Item item3 = tracker.add(new Item("test name3", "desc3"));
        //создаём StubInput с последовательностью действий(производим удалении заявки с position = 1)
        Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        // проверяем, что элемент массива в трекере с position = 1, это элемент, который ранее был с position = 2.
        assertThat(tracker.getAll()[1].getName(), is("test name3"));
    }

    @Test
    public void whenGetAllTwoItemsThenPrintedTwoItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню" + System.lineSeparator() + "0. AddItem" + System.lineSeparator() + "1. GetAll" + System.lineSeparator() + "2. ReplaceById" + System.lineSeparator() + "3. DeleteById" + System.lineSeparator() + "4. FindById" + System.lineSeparator() + "5. FindByName" + System.lineSeparator() + "6. Exit" + System.lineSeparator() + "------------ Все заявки --------------" + System.lineSeparator() + "")
                                .append(item.getId())
                                .append(" - ")
                                .append(item.getName())
                                .append(" - ")
                                .append(item.getDesc())
                                .append("" + System.lineSeparator() + "")
                                .append(item2.getId())
                                .append(" - ")
                                .append(item2.getName())
                                .append(" - ")
                                .append(item2.getDesc())
                                .append("" + System.lineSeparator() + "")
                                .append("" + System.lineSeparator() + "Меню" + System.lineSeparator() + "0. AddItem" + System.lineSeparator() + "1. GetAll" + System.lineSeparator() + "2. ReplaceById" + System.lineSeparator() + "3. DeleteById" + System.lineSeparator() + "4. FindById" + System.lineSeparator() + "5. FindByName" + System.lineSeparator() + "6. Exit")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}