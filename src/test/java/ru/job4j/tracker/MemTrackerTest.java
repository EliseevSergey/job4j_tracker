package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MemTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item("Bug");
        bugWithDesc.setName("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }

    @Test
    public void sortDown() {
        Item a = new Item("A");
        a.setId(1);
        Item b = new Item("B");
        b.setId(2);
        Item c = new Item("C");
        c.setId(3);
        Item d = new Item("D");
        d.setId(4);
        List<Item> before = Arrays.asList(c, a, b, d);
        Collections.sort(before, new SortDown());
        List<Item> expect = Arrays.asList(d, c, b, a);
        assertThat(expect, is(before));
    }

    @Test
    public void sortUp() {
        Item a = new Item("A");
        a.setId(1);
        Item b = new Item("B");
        b.setId(2);
        Item c = new Item("C");
        c.setId(3);
        Item d = new Item("D");
        d.setId(4);
        List<Item> before = Arrays.asList(b, c, a, d);
        Collections.sort(before, new SortUp());
        List<Item> expect = Arrays.asList(a, b, c, d);
        assertThat(expect, is(before));
    }
}

