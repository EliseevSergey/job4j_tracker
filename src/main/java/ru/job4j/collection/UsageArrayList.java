package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> opg = new ArrayList<String>();
        opg.add("Petr");
        opg.add("Ivan");
        opg.add("Stepan");
        opg.remove("Stepan");
        opg.add("Ninja");
        for (String name : opg) {
            System.out.println(name);
        }
    }
}
