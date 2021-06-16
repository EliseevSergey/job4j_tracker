package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        int shortest = Math.min(o1.length(), o2.length());
        for (int index = 0; index < shortest; index++) {
            int decision = Character.compare(o1.charAt(index), o2.charAt(index));
            if (decision != 0) {
                rsl = decision;
                break;
            }
            if (decision == 0) {
                        rsl = Integer.compare(o1.length(), o2.length());
                    }
                }
    return rsl;
    }
}
