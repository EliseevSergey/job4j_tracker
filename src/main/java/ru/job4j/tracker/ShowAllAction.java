package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    private final Output out;
    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items by names ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] pool = tracker.findAll();
        for (int index = 0; index < pool.length; index++) {
            out.println(pool[index]);
        }
        return true;
    }
}
