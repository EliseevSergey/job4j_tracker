package ru.job4j.collection;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DepDescCompTest {
@Test
    public void compare() {
    int rsl = new DepDescComp().compare("K2/SK1/SSK2", "K2/SK1/SSK1");
    assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
    int rsl = new DepDescComp().compare("K2", "K2/SK1");
    assertThat(rsl, lessThan(0));
    }

    @Test
    public void sortAsc() {
        List<String> input = Arrays.asList("K2/SK2/SSK2", "K2", "K1/SK1", "K1/SK1/SSK1","K2/SK1", "K1", "K2/SK2");
        List<String> expect = Arrays.asList("K1", "K1/SK1", "K1/SK1/SSK1", "K2", "K2/SK1", "K2/SK2", "K2/SK2/SSK2");
        Collections.sort(input);
        MatcherAssert.assertThat(input, is(expect));
    }

    @Test
    public void sortDecs() {
        List<String> input = Arrays.asList("K2/SK2/SSK2", "K2", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2",  "K1", "K2/SK2", "K2/SK1", "K1/SK2", "K2/SK1/SSK2", "K2/SK1/SSK1");
        List<String> expect = Arrays.asList("K2", "K2/SK1","K2/SK1/SSK1", "K2/SK1/SSK2", "K2/SK2", "K2/SK2/SSK2", "K1", "K1/SK1", "K1/SK1/SSK1","K1/SK1/SSK2", "K1/SK2");
        Collections.sort(input, new DepDescComp());
        MatcherAssert.assertThat(input, is(expect));
    }
}
