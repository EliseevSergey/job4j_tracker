package ru.job4j.oop;

import java.sql.SQLOutput;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point second) {
        return Math.sqrt(Math.pow((this.x - second.x), 2) + Math.pow((this.y - second.y),2));
    }

    public static void main(String[] args) {
        Point first = new Point(0, 0);
        Point second = new Point(4, 0);
        Point third = new Point(0, 4);
        System.out.println(first.distance(second));
    }
}
