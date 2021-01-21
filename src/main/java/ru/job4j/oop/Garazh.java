package ru.job4j.oop;

public class Garazh {
    public static void main(String[] args) {
        Vehicle Tu =  new Plane();
        Vehicle An = new Plane();
        Vehicle Elektro = new Train();
        Vehicle Tovar = new Train();
        Vehicle Ikar = new Bus();
        Vehicle Paz = new Bus();

        Vehicle[] garazh = new Vehicle[]{Tu, An, Elektro, Tovar, Ikar, Paz};
        for (Vehicle a : garazh) {
            a.move();
            a.slowdown();
        }
    }
}

