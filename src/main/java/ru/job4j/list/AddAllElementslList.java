package ru.job4j.list;

import java.util.List;

public class AddAllElementslList {
    public static int combiner(List<String> left, List<String> right, String str) {
        if (left.contains(str) && right.contains(str)) {
            left.remove(str);
            left.addAll(right);
        }
        int rsl = left.indexOf(str);
        return rsl;
    }
}
