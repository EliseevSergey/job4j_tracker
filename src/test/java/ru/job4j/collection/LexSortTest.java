package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
    String[] input = {
            "10. Task.",
            "1. Task.",
            "2. Task.",
            "6. Task"
    };
    String[] out = {
            "1. Task.",
            "2. Task.",
            "6. Task",
            "10. Task.",

    };
    Arrays.sort(input, new LexSort());
    Assert.assertThat(input, is(out));
    }
}