package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class GeomProgressionTest {
    @Test
    public void testGenerateAndSum() {
        int rsl = GeomProgression.generateAndSum(2, 2, 6);
        assertThat(rsl, is (126));
    }
}