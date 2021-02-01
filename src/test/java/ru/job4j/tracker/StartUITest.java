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
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0","1"});
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item ("First"));
        Item second = tracker.add(new Item ("Second"));
        Item third = tracker.add(new Item ("Third"));
        Item[] expect = {first, second, third};
        UserAction[] actions = {
                new ShowAll(out),new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll(), is(expect));
    }
        @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item ("FindMeByName"));
        Input in = new StubInput(new String[] {"0", "FindMeByName", "1"});
        UserAction[] actions = {
                new FindByNameAction(out), new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("FindMeByName"));
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
        Input in = new StubInput(new String[] {"0", String.valueOf(tracker.findByName("Must die")[0].getId()),"1"});
        UserAction[] actions = {
                new DeleteAction(out), new ExitAction(out)
        };
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
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. === Exit ===" + System.lineSeparator() + "Bye , Bye" + System.lineSeparator()));
    }
}


