package ru.job4j.list;

import java.util.List;

public class RemoveIf {
    public static List<String> listSorter(List<String> list) {
       list.removeIf(elm -> (elm.length() < 5));
       return list;
    }
}
