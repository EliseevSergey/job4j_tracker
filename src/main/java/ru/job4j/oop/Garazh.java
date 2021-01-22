package ru.job4j.oop;

public class Garazh {
    public static void main(String[] args) {
        Vehicle tu =  new Plane();
        Vehicle an = new Plane();
        Vehicle elektro = new Train();
        Vehicle tovar = new Train();
        Vehicle ikarus = new Bus();
        Vehicle pazik = new Bus();

        Vehicle[] garazh = new Vehicle[]{tu, an, elektro, tovar, ikarus, pazik};
        for (Vehicle a : garazh) {
            a.move();
            a.slowdown();
        }
    }
}

