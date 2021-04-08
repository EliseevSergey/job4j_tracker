package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {
    @Test
    public void whenOk() {
       assertThat(Fact.calc(9), is(362880));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenException() {
        Fact.calc(-9);
    }
}