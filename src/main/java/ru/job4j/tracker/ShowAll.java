package ru.job4j.tracker;

public class ShowAll implements UserAction {
    @Override
    public String name() {
        return "=== Show all items by names ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] pool = tracker.findAll();
        for (int index = 0; index < pool.length; index++) {
            System.out.println(pool[index]);

        }
        return true;
    }
}
