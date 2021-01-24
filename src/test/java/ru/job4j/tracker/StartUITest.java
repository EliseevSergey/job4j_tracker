package ru.job4j.tracker;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Checker"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Checker");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), "replaced item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleted() {
        Tracker tracker = new Tracker();
        Item item = new Item("to be deleted");
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId())};
        StartUI.delete(new StubInput(answer), tracker);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}