package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker first = null;
    private Store tracker = new MemTracker();

    private SingleTracker() {
    }

    public static SingleTracker getFirst() {
        if (first == null) {
            first = new SingleTracker();
        }
        return first;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item finfById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findAll() {
        return tracker.findAll(); }

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
