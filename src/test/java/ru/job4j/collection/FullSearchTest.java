package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.*;

public class FullSearchTest {
    @Test
    public void fullSearch() {
        List<Task> input = Arrays.asList(
                new Task("1", "come"),
                new Task("2", "see"),
                new Task("3", "delay"),
                new Task("3", "win"));
        Set<String> expected = new HashSet<String>(Arrays.asList("1", "2", "3"));
        FullSearch cezar = new FullSearch();
        assertThat(cezar.extractNumber(input), is(expected));
    }
}