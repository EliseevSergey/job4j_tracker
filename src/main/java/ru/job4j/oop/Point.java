package ru.job4j.oop;

import java.sql.SQLOutput;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point second) {
        return Math.sqrt(Math.pow((this.x - second.x), 2) + Math.pow((this.y - second.y), 2));
    }

    public double distance3d(Point second) {
        return Math.sqrt(Math.pow((this.x - second.x), 2) + Math.pow((this.y - second.y), 2)
                + Math.pow((this.z - second.z), 2));
    }
}
