package ru.job4j.list;

import java.util.List;

public class CheckerAndGetter {
    public static String getElement(List<String> list) {
        if (list.isEmpty()) {
            return "";
        } else {
            return list.get(0);
        }
    }
}
