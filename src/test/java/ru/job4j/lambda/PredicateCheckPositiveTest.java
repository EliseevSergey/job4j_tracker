package ru.job4j.lambda;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class PredicateCheckPositiveTest {
@Test
    public void testCheck() {
        Assert.assertTrue(PredicateCheckPositive.check(5));
        Assert.assertFalse(PredicateCheckPositive.check(-6));
    }
}