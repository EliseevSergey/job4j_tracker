package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;

public class TriangleTest extends TestCase {

    public void testArea() {
        Point a = new Point(0,0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle Bermudos = new Triangle(a, b, c);
        double rsl = Bermudos.area(a, b, c);
        Assert.assertEquals(8, rsl, 0.001);
    }

    public void testArea2() {
        Point a = new Point(0,0);
        Point b = new Point(0, 5);
        Point c = new Point(5, 0);
        Triangle Bermudos = new Triangle(a, b, c);
        double rsl = Bermudos.area(a, b, c);
        Assert.assertEquals(12.5, rsl, 0.001);
    }

    public void testNotExist() {
        Point a = new Point(0,0);
        Point b = new Point(0, 5);
        Point c = new Point(0, 3);
        Triangle Bermudos = new Triangle(a, b, c);
        double rsl = Bermudos.area(a, b, c);
        Assert.assertEquals(-1, rsl, 0.001);
    }

    public void testHalf() {
        Point a = new Point(0,0);
        Point b = new Point(0, 4);
        Point c = new Point(4, 0);
        Triangle Treugol = new Triangle(a, b, c);
        double rsl = Treugol.half(a, b, c);
        Assert.assertEquals(6.83, rsl, 0.01);

    }



}