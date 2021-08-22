package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()  + " in air");
    }

    @Override
    public void slowdown() {
        System.out.println(getClass().getSimpleName()  + " with wings");
    }
}
