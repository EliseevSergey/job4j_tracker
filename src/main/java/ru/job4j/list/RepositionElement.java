package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class RepositionElement {
    public static List<String> changePosition(List<String> list, int index) {
        if (index >= list.size() - 1) {
            list.remove(list.size() - 1);
            return list;
        } else {
            String last = list.remove(list.size() - 1);
            list.set(index, last);
            return list;
        }
    }

    public static void main(String[] args) {
        List<String> check = new ArrayList<>();
        check.add("A");
        check.add("B");
        check.add("C");
        check.add("D");
        for (String element : check) {
            System.out.println(element + " old");
        }
        RepositionElement.changePosition(check, 2);
        for (String element : check) {
            System.out.println(element + " new in range");
        }
        RepositionElement.changePosition(check, 666);
        for (String element : check) {
            System.out.println(element + " new out of range");
        }
    }
}
