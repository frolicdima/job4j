package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testName", "testDescription", 123L, {"testComment"});
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenGetAll3ItemsThenTrackerHasAll3Items() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("id0", "name0", "desc0", 0L);
        Item item1 = new Item("id1", "name1", "desc1", 1L);
        Item item2 = new Item("id2", "name2", "desc2", 2L);
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        Item[] expected = new Item[]{item0, item1, item2};
        assertThat(tracker.getAll(), is(expected));
    }

}