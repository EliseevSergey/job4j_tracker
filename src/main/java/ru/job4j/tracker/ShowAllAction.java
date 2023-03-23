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
    public boolean execute(Input input, Store tracker) {
        for (Item item : tracker.findAll()) {
            out.println(item);
        }
        return true;
    }
}
