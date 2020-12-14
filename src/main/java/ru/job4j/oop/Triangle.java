package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point first, Point second, Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public double half(Point first, Point second, Point third) {
        double ab = first.distance(second);
        double bc = second.distance(third);
        double ca = third.distance(first);
        return (ab + bc + ca) / 2;
    }

    public boolean exist(Point first, Point second, Point third) {
        double ab = first.distance(second);
        double bc = second.distance(third);
        double ca = third.distance(first);
        return (ab + bc) > ca && (bc + ca) > ab && (ca + ab) > bc;
    }

    public double area(Point first, Point second, Point third) {
        double rsl = 0;
        double ab = first.distance(second);
        double bc = second.distance(third);
        double ca = third.distance(first);
        double p = (ab + bc + ca) / 2;
        return rsl  = this.exist(first, second, third)? Math.sqrt(p * (p - ab) * (p - bc) * (p - ca)) : -1;
    }
}
