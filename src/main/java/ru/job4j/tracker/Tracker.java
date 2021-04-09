package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

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

    public Item[] findAll() {
        Item[] result = new Item[items.size()];
        result = items.toArray(result);
        return result;
    }

    public Item[] findByName(String name) {
        Item[] nameList = new Item[items.size()];
        int qty = 0;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getName().equals(name)) {
                nameList[qty] = items.get(index);
                qty++;
            }
        }
        return Arrays.copyOf(nameList, qty);
    }

    public boolean replace(int id, Item item) {
      int index = indexOf(id);
      boolean rsl = index != -1;
      if (rsl) {
        items.add(index, item);
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
}