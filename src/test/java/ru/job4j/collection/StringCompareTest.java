package ru.job4j.collection;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class StringCompareTest {
    @Test
    public void whenStringEqualsThenZero() {
        StringCompare sorter = new StringCompare();
        int rsl = sorter.compare("Ivanov", "Ivanov");
        assertThat(rsl, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova");
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenRightLessThanLeftResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Sidorova",
                "Sidorov");
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova");
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov");
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov");
        assertThat(rst, lessThan(0));
    }
}