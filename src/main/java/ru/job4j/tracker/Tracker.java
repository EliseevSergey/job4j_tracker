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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : Item.Antinull;
    }

    public Item[] findAll() { return Arrays.copyOf(items, size);
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

    public boolean replace(int id, Item item) { // override
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = item;
            items[index].setId(id);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int dltd = indexOf(id);
        boolean rsl = dltd != -1;
        if (dltd != -1) {
            System.arraycopy(items, dltd + 1, items, dltd, size - dltd);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
}