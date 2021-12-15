package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> unique = new LinkedHashSet<>();
        for (String line : deps) {
            String start = "";
            for (String el : line.split("/")) {
                start += "".equals(start) ? el : "/" + el;
                unique.add(start);
                }
            }
        return new ArrayList<>(unique);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}