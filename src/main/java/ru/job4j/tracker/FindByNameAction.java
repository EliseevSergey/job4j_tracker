package ru.job4j.tracker;

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
    public boolean execute (Input input, Tracker tracker) {
        String name = input.askStr("Input name of item which to be found");
        Item[] target = tracker.findByName(name);
        if (target.length == 0) {
            out.println("not found with name: " + name);
        } else {
            for (int index = 0; index < target.length; index++) {
                out.println(target[index]);
            }
        }
        return true;
    }
}
