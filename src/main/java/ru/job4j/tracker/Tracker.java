package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public List<Item> getItems() {
        return items;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String name) {
        List<Item> nameList = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                nameList.add(item);
            }
        }
        return nameList;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.set(index, item);
            items.get(index).setId(id);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int dltd = indexOf(id);
        boolean rsl = dltd != -1;
        if (dltd != -1) {
            items.remove(dltd);
        }
        return rsl;
    }

    public void main(String[] args) {
        Collections.sort(items, new SortUp());
        Collections.sort(items, new SortDown());
    }
}