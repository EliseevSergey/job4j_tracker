package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest extends TestCase {

    public void testDistance3d() {
        Point start = new Point(0, 0, 0);
        Point end = new Point(1, 1, 1);
        Assert.assertEquals(1.732, start.distance3d(end), 0.001);
    }
}