package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("\\.", 2);
        int firstNum = Integer.parseInt(first[0]);
        String[] second = o2.split("\\.", 2);
        int secondNum = Integer.parseInt(second[0]);
        return Integer.compare(firstNum, secondNum);
    }
}
