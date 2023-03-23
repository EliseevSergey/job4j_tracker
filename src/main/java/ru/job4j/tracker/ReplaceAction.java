package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Input id of item which to be edited");
        String name = input.askStr("Input name of item which to be inputted in chosen id");
        Item newInput = new Item(name);
        if (tracker.replace(id, newInput)) {
            out.println("Successfully Edited");
        } else {
            out.println("Edit was failed");
        }
        return true;
    }
}
