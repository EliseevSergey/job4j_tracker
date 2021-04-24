package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Items name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Input name of item which to be found");
        List<Item> target = tracker.findByName(name);
        if (target.isEmpty()) {
            out.println("not found with name: " + name);
        } else {
            for (Item item : target) {
                out.println(item);
            }
        }
        return true;
    }
}
