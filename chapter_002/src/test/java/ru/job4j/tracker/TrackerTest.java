package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testName", "testDescription", 123L, new String[]{"testComment"});
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenGetAllFor3ItemsThenTrackerHas3Items() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("id0", "name0", "desc0", 0L, new String[]{"testComment0"});
        Item item1 = new Item("id1", "name1", "desc1", 1L, new String[]{"testComment1"});
        Item item2 = new Item("id2", "name2", "desc2", 2L, new String[]{"testComment2"});
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        Item[] expected = new Item[]{item0, item1, item2};
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenFoundIdFirstThenReturnFirstItem() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("id0", "name0", "desc0", 0L, new String[]{"testComment0"});
        Item item1 = new Item("id1", "name1", "desc1", 1L, new String[]{"testComment1"});
        Item item2 = new Item("id2", "name2", "desc2", 2L, new String[]{"testComment2"});
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }

    @Test
    public void whenReplaceByIdFirstThenReturnUpdatedItemInsteadOfFirst() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("id0", "name0", "desc0", 0L, new String[]{"testComment0"});
        Item item1 = new Item("id1", "name1", "desc1", 1L, new String[]{"testComment1"});
        Item item2 = new Item("id2", "name2", "desc2", 2L, new String[]{"testComment2"});
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        Item updated = new Item("upd", "upd", "upd", 100500L, new String[]{"upd"});
        tracker.replaceById(item0.getId(), updated);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }

    @Test
    public void whenDeleteByIdFirstThenTrackerHasNoDeletedItem() {
        Tracker tracker = new Tracker();
        Item item0 = new Item("id0", "name0", "desc0", 0L, new String[]{"testComment0"});
        Item item1 = new Item("id1", "name1", "desc1", 1L, new String[]{"testComment1"});
        Item item2 = new Item("id2", "name2", "desc2", 2L, new String[]{"testComment2"});
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        Item[] expected = new Item[]{item0, item2};
        tracker.deleteById(item1.getId());
        assertThat(tracker, is(expected));
    }

}