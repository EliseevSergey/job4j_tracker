package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = items[index];
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String name) {
        Item[] nameList = new Item[size];
        int qty = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].getName().equals(name)) {
                nameList[qty] = items[index];
                qty++;
            }
        }
        return Arrays.copyOf(nameList, qty);
    }
}