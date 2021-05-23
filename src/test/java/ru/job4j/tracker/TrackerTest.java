package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item("Bug");
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test

    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void SortDown() {
        Item a = new Item("A");
        a.setId(1);
        Item b = new Item("B");
        b.setId(2);
        Item c = new Item("C");
        c.setId(3);
        Item d = new Item("D");
        d.setId(4);
        List<Item> expect = Arrays.asList(d, c, b, a);
        Tracker tracker = new Tracker();
        tracker.getItems().add(a);
        tracker.getItems().add(b);
        tracker.getItems().add(c);
        tracker.getItems().add(d);
        Collections.sort(tracker.getItems(), new SortDown());
        assertThat(expect, is(tracker.getItems()));
    }

    @Test
    public void SortUp() {
        Item a = new Item("A");
        a.setId(1);
        Item b = new Item("B");
        b.setId(2);
        Item c = new Item("C");
        c.setId(3);
        Item d = new Item("D");
        d.setId(4);
        List<Item> expect = Arrays.asList(a, b, c, d);
        Tracker tracker = new Tracker();
        tracker.getItems().add(d);
        tracker.getItems().add(c);
        tracker.getItems().add(b);
        tracker.getItems().add(a);
        Collections.sort(tracker.getItems(), new SortUp());
        assertThat(expect, is(tracker.getItems()));
    }
}

