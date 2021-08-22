package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class JobTest {
    @Test
    public void whenPriorityUp() {
        List<Job> sueta = Arrays.asList(
                new Job("Cooking", 3),
                new Job("Sport", 1),
                new Job("CleanUp", 2),
                new Job("Sleep", 4));
        Collections.sort(sueta, new SortPriorityUp());
        Iterator<Job> it = sueta.iterator();
        assertThat(it.next(), is(new Job("Sleep", 4)));
        assertThat(it.next(), is(new Job("Cooking", 3)));
        assertThat(it.next(), is(new Job("CleanUp", 2)));
        assertThat(it.next(), is(new Job("Sport", 1)));
        System.out.println(sueta);
    }

    @Test
    public void whenPriorityDown() {
        List<Job> sueta = Arrays.asList(
                new Job("Cooking", 3),
                new Job("Sport", 1),
                new Job("CleanUp", 2),
                new Job("Sleep", 4));
        Collections.sort(sueta, new SortPriorityDown());
        Iterator<Job> it = sueta.iterator();
        assertThat(it.next(), is(new Job("Sport", 1)));
        assertThat(it.next(), is(new Job("CleanUp", 2)));
        assertThat(it.next(), is(new Job("Cooking", 3)));
        assertThat(it.next(), is(new Job("Sleep", 4)));
    }

    @Test
    public void whenNameAlphabetReverse() {
        List<Job> sueta = Arrays.asList(
                new Job("Cooking", 3),
                new Job("Sport", 1),
                new Job("CleanUp", 2),
                new Job("Sleep", 4));
        Collections.sort(sueta, new SortNameAlphabetReverse());
        Iterator<Job> it = sueta.iterator();
        assertThat(it.next(), is(new Job("Sport", 1)));
        assertThat(it.next(), is(new Job("Sleep", 4)));
        assertThat(it.next(), is(new Job("Cooking", 3)));
        assertThat(it.next(), is(new Job("CleanUp", 2)));
    }

    @Test
    public void whenNameAlphabet() {
        List<Job> sueta = Arrays.asList(
                new Job("Cooking", 3),
                new Job("Sport", 1),
                new Job("CleanUp", 2),
                new Job("Sleep", 4));
        Collections.sort(sueta, new SortNameAlphabet());
        Iterator<Job> it = sueta.iterator();
        assertThat(it.next(), is(new Job("CleanUp", 2)));
        assertThat(it.next(), is(new Job("Cooking", 3)));
        assertThat(it.next(), is(new Job("Sleep", 4)));
        assertThat(it.next(), is(new Job("Sport", 1)));
    }

    @Test
    public void whenComparatorNameUpandPriorityUp() {
        Comparator<Job> cmpNameAlphabetPriorityUp =
                new SortNameAlphabet().thenComparing(new SortPriorityUp());
        int rsl = cmpNameAlphabetPriorityUp.compare(
                new Job("A", 666),
                new Job("A", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorPriorityDownNameAlphabet() {
        Comparator<Job> cmpPriorityNameAlphabet =
                new SortPriorityDown().thenComparing(new SortNameAlphabet());
        List<Job> sueta = Arrays.asList(
                new Job("Z", 1),
                new Job("Y", 2),
                new Job("Y", 3),
                new Job("X", 1));
        Collections.sort(sueta, cmpPriorityNameAlphabet);
        Iterator<Job> it = sueta.iterator();
        assertThat(it.next(), is(new Job("X", 1)));
        assertThat(it.next(), is(new Job("Z", 1)));
        assertThat(it.next(), is(new Job("Y", 2)));
        assertThat(it.next(), is(new Job("Y", 3)));
    }
}