package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()  + " on railroad");

    }

    @Override
    public void slowdown() {
        System.out.println(getClass().getSimpleName()  + " with emergency handle");
    }
}
