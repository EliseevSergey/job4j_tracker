package ru.job4j.tracker;

import java.util.Comparator;

public class SortDown implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        if (item1.getId() > item2.getId()) {
            return -1;
        }
        if (item1.getId() < item2.getId()) {
            return 1;
        }
        return 0;
    }
}

