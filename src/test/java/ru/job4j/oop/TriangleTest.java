package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {
    @Test
    public void testArea() {
        Point a = new Point(0,0, 666);
        Point b = new Point(4, 0, 666);
        Point c = new Point(0, 4, 666);
        Triangle Bermudos = new Triangle(a, b, c);
        double rsl = Bermudos.area(a, b, c);
        Assert.assertEquals(8, rsl, 0.001);
    }

    @Test
    public void testArea2() {
        Point a = new Point(0,0, 666);
        Point b = new Point(0, 5, 666);
        Point c = new Point(5, 0, 666);
        Triangle Bermudos = new Triangle(a, b, c);
        double rsl = Bermudos.area(a, b, c);
        Assert.assertEquals(12.5, rsl, 0.001);
    }

    @Test
    public void testNotExist() {
        Point a = new Point(0,0, 666);
        Point b = new Point(0, 5, 666);
        Point c = new Point(0, 3, 666);
        Triangle Bermudos = new Triangle(a, b, c);
        double rsl = Bermudos.area(a, b, c);
        Assert.assertEquals(-1, rsl, 0.001);
    }
}