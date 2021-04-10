package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> auto = new HashSet<>();
        auto.add("BMW");
        auto.add("Lada");
        auto.add("Volvo");
        auto.add("Toyota");
        for (String car : auto) {
            System.out.println(car);
        }
    }
}
