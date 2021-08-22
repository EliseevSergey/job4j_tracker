package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()  + " on road");
    }

    @Override
    public void slowdown() {
        System.out.println(getClass().getSimpleName()  + " with breaks");
    }
}
