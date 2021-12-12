package ru.job4j.collection;

import org.junit.Test;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
    List<String> input = Arrays.asList("K1/SK1/SSK1", "K2/SK2/SSK2");
    List<String> expect = Arrays.asList("K1", "K1/SK1", "K1/SK1/SSK1", "K2", "K2/SK2","K2/SK2/SSK2");
    List<String> result = Departments.fillGaps(input);
    assertThat(result, is(expect));
    }

    @Test
    public void whenNonChanged() {
        List<String> input = Arrays.asList("K1", "K1/SK1");
        List<String> expect = Arrays.asList("K1", "K1/SK1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }
}