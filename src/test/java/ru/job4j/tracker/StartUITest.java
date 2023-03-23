package ru.job4j.tracker;

import org.junit.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Diamond", "1"});
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Diamond"));
    }

        @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("FindMeByName"));
        Input in = new StubInput(new String[] {"0", "FindMeByName", "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(String.format("Menu." +  System.lineSeparator()
                + "0. === Find Items name ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator()
                + "id: 1, name: FindMeByName, created: %s" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. === Find Items name ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator(),
                FORMATTER.format(LocalDateTime.now()))));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("FindItembyId"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);

        assertThat(out.toString(), is(String.format("Menu." +  System.lineSeparator()
                + "0. === Find Item by id ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator()
                + "id: 1, name: FindItembyId, created: %s" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. === Find Item by id ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator(),
                FORMATTER.format(LocalDateTime.now()))));
    }

    @Test
    public void whenFindIdAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("FindMeById"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getId(), is(1));
    }

    @Test
    public void whenReplaceAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        String replaceName = "New item name";
        Input in =
                new StubInput(new String[] {"0", String.valueOf(item.getId()), replaceName, "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replaceName));
    }

    @Test
    public void whenDeletedAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Must die"));
        Input in = new StubInput(new String[] {"0",
                        String.valueOf(memTracker.findByName("Must die").get(0).getId()), "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExitAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(),
                is("Menu." + System.lineSeparator() + "0. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenShowAllAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item first = memTracker.add(new Item("First"));
        Item second = memTracker.add(new Item("Second"));
        Item third = memTracker.add(new Item("Third"));
        Input in = new StubInput(new String[]{"0", "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(String.format("Menu." + System.lineSeparator()
                + "0. === Show all items by names ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator()
                + "id: 1, name: First, created: %s" + System.lineSeparator()
                + "id: 2, name: Second, created: %s" + System.lineSeparator()
                + "id: 3, name: Third, created: %s" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. === Show all items by names ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator(),
                        FORMATTER.format(LocalDateTime.now()),
                        FORMATTER.format(LocalDateTime.now()),
                        FORMATTER.format(LocalDateTime.now())))
                );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Input in = new StubInput(new String[]{"666", "0"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. === Exit ===" + System.lineSeparator()
                + "Wrong input, you can select: 0 .. 0"
                + System.lineSeparator() + "Menu." + System.lineSeparator()
                + "0. === Exit ===" + System.lineSeparator()));
    }
}


