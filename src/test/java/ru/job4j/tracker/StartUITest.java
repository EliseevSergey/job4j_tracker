package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Diamond","1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out), new ExitAction(out)
        };
    new StartUI(out).init(in, tracker, actions);
    assertThat(tracker.findAll()[0].getName(), is ("Diamond"));
    }

        @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item ("FindMeByName"));
        Input in = new StubInput(new String[] {"0","FindMeByName","1"});
        UserAction[] actions = {
                new FindByNameAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." +  System.lineSeparator() +
                "0. === Find Items name ===" + System.lineSeparator() +
                "1. === Exit ===" + System.lineSeparator() +
                "Item{id=1, name='FindMeByName'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. === Find Items name ===" + System.lineSeparator() +
                "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item ("FindItembyId"));
        Input in = new StubInput(new String[] {"0",String.valueOf(item.getId()),"1"});
        UserAction[] actions = {
                new FindByIdAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." +  System.lineSeparator() +
                "0. === Find Item by id ===" + System.lineSeparator() +
                "1. === Exit ===" + System.lineSeparator() +
                "Item{id=1, name='FindItembyId'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. === Find Item by id ===" + System.lineSeparator() +
                "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenFindIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item ("FindMeById"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {
                new FindByIdAction(out), new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getId(), is(1));
    }

    @Test
    public void whenReplaceAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item ("Replaced item"));
        String replaceName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), replaceName, "1"});
        UserAction[] actions = {
                new ReplaceAction(out), new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replaceName));
    }

    @Test
    public void whenDeletedAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item ("Must die"));
        Input in = new StubInput(new String[] {"0", String.valueOf(tracker.findByName("Must die")[0].getId()), "1"});
        UserAction[] actions = {
                new DeleteAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExitAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenShowAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        Item third = tracker.add(new Item("Third"));
        Input in = new StubInput(new String[]{"0", "1"});
        UserAction[] actions = {
                new ShowAllAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. === Show all items by names ===" + System.lineSeparator() +
                "1. === Exit ===" + System.lineSeparator() +
                "Item{id=1, name='First'}" + System.lineSeparator() +
                "Item{id=2, name='Second'}" + System.lineSeparator() +
                "Item{id=3, name='Third'}" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. === Show all items by names ===" + System.lineSeparator() +
                "1. === Exit ===" + System.lineSeparator()));
    }
}


