package ru.job4j.collection;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
@Test
    public void testConvert() {
    ConvertList converter = new ConvertList();
    List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    int[] first = {1, 2};
    int[] second = {3, 4, 5, 6};
    int[] third = {7, 8, 9};
    List<int[]> masterList = List.of(first, second, third);
    assertThat(converter.convert(masterList), is(expected));
    }
}