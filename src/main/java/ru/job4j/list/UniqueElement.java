package ru.job4j.list;

import java.util.List;

public class UniqueElement {
    public static boolean checkList(List<String> list, String str) {
        if (list.indexOf(str) == -1) {
            return false;
        } else if (list.indexOf(str) == list.lastIndexOf(str)) {
            return true;
        } else {
            return false;
        }
    }
}
