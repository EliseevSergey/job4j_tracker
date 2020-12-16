package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest{

    @Test
    public void testDistance3d() {
        Point start = new Point(0, 0, 0);
        Point end = new Point(1, 1, 1);
        Assert.assertEquals(1.732, start.distance3d(end), 0.001);
    }
}