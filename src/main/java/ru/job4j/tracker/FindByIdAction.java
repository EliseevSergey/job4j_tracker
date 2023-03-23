package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Item by id ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Input id of item which to be found");
        Item target = tracker.findById(id);
        if (target != null) {
            out.println(target);
        } else {
            out.println("not found with id: " + id);
        }
       return true;
    }
}
