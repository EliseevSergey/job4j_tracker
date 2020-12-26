package ru.job4j.tracker;

import java.util.Arrays;

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
        Item[] noNull = new Item[size];
        int qty = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].getName() != null) {
                noNull[qty] = items[index];
                qty++;
            }
            noNull = Arrays.copyOf(noNull, qty);
        }
        return noNull;
    }

    public Item[] findByName(String name) {
        Item[] nameList = new Item[size];
        int qty = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].getName() == name) {
                nameList[qty] = items[index];
                qty++;
            }
            nameList = Arrays.copyOf(nameList, qty);
        }
        return nameList;
    }
}