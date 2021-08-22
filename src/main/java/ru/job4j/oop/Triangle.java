package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double half(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double bc, double ca) {
        return (ab + bc) > ca && (bc + ca) > ab && (ca + ab) > bc;
    }

    public double area(Point first, Point second, Point third) {
        double rsl = 0;
        double ab = first.distance(second);
        double bc = second.distance(third);
        double ca = third.distance(first);
        double p = this.half(ab, bc, ca);
        rsl = this.exist(ab, bc, ca) ? Math.sqrt(p * (p - ab) * (p - bc) * (p - ca)) : -1;
        return rsl;
    }
}
