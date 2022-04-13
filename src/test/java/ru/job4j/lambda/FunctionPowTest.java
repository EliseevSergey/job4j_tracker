package ru.job4j.lambda;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FunctionPowTest {
    @Test
    public void testCalculate() {
        Assert.assertThat(FunctionPow.calculate(3.00), is(9.0));
        assertEquals(4, FunctionPow.calculate(2), 0.01);
    }
}