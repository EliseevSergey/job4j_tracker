package ru.job4j.tracker;

import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MockTrackerTest {
    private final Output output = new StubOutput();
    private final MemTracker tracker = new MemTracker();
    private final String ln = System.lineSeparator();

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction replaceAction = new ReplaceAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        replaceAction.execute(input, tracker);
        assertThat(output.toString(), is("Successfully Edited" + ln));
    }

    @Test
    public void whenItemWaReplacedFailure() {
        ReplaceAction replaceAction = new ReplaceAction(output);
        Input input = mock(Input.class);
        replaceAction.execute(input, tracker);
        assertThat(output.toString(), is("Edit was failed" + ln));
    }

    @Test
    public void whenItemWasDeletedSuccessfully() {
        Item item = tracker.add(new Item("ToBeDeleted item"));
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);
        assertThat(output.toString(), is("Successfully deleted" + ln));
    }

    @Test
    public void  whenItemWasFoundById() {
        Item item = tracker.add(new Item("ToBeFoundById item"));
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(4);
        when(input.askInt(any(String.class))).thenReturn(2);
        findByIdAction.execute(input, tracker);
        String string = item.toString();
        assertThat(output.toString(), is(string + ln));
    }

    @Test
    public void  whenItemWasFoundByName() {
        Item item = tracker.add(new Item("ToBeFound item"));
        tracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(5);
        when(input.askStr(any(String.class))).thenReturn("ToBeFound item");
        findByNameAction.execute(input, tracker);
        String string = item.toString();
        assertThat(output.toString(), is(string + ln + string + ln));
    }
}
