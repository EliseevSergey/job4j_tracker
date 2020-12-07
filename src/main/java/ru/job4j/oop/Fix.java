package ru.job4j.oop;

public class Fix {
    private String desc;

    public Fix(String anything) {
        desc = anything;
    }

    public static void main(String[] args) {
        String kicker = "GO";
        Fix newborn = new Fix(kicker);
    }
}
