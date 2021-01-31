package ru.job4j.tracker;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "Diamond","1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(), new ExitAction()
        };
    new StartUI().init(in, tracker, actions);
    assertThat(tracker.findAll()[0].getName(), is ("Diamond"));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item ("Replaced item"));
        String replaceName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), replaceName, "1"});
        UserAction[] actions = {
                new ReplaceAction(), new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replaceName));
    }

    @Test
    public void whenDeleted() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item ("Must die"));
        Input in = new StubInput(new String[] {"0", String.valueOf(tracker.findByName("Must die")[0].getId()),"1"});
        UserAction[] actions = {
                new DeleteAction(), new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}

