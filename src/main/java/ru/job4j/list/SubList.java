package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        List<String> rsl = new ArrayList<String>();
        if (list.indexOf(el) == -1) {
            return rsl;
        } else if (list.indexOf(el) == list.lastIndexOf(el)) {
            return rsl;
        } else {
            rsl = list.subList(list.indexOf(el), list.lastIndexOf(el));
        }
        return rsl;
    }
}
