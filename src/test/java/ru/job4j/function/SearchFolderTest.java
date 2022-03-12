package ru.job4j.function;

import static org.hamcrest.Matchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolderTest {
    @Test
    public void whenFilterSize() {
        List<Folder> list = List.of(
                new Folder("fix", 100),
                new Folder("bug", 75),
                new Folder("bug", 190));
        List<Folder> expected = List.of(new Folder("bug", 75));
        SearchFolder sizeSearch = new SearchFolder();
        Predicate<Folder> pred = f -> f.getSize() < 100;
        List<Folder> rsl = sizeSearch.filter(pred, list);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenFilterName() {
        List<Folder> list = List.of(
                new Folder("fix", 100),
                new Folder("bug", 75),
                new Folder("bug", 190));
        List<Folder> expected = List.of(
                new Folder("bug", 75),
                new Folder("bug", 190));
        Predicate<Folder> pred = p -> p.getName().contains("bug");
        SearchFolder nameSearch = new SearchFolder();
        List<Folder> rsl = nameSearch.filter(pred, list);
        assertThat(rsl, is(expected));
    }
}