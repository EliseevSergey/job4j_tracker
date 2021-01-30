package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Items name ====";
    }
    @Override
    public boolean execute (Input input, Tracker tracker) {
        String name = input.askStr("Input name of item which to be found");
        Item[] target = tracker.findByName(name);
        if (target.length == 0) {
            System.out.println("not found with name: " + name);
        } else {
            for (int index = 0; index < target.length; index++) {
                System.out.println(target[index]);
            }
        }
        return true;
    }
}
