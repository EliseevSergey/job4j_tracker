package ru.job4j.oop;

public class Student {

    public void music() {
        System.out.println("Tra tra ta");
    }
    public void song() {
        System.out.println("I belive I Can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
}
