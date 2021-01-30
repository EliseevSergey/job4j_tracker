package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Input id of item which to be edited");
        String name = input.askStr("Input name of item which to be inputted in chosen id");
        Item newInput = new Item(name);
        if (tracker.replace(id, newInput)) {
            System.out.println("Successfully Edited");
        } else {
            System.out.println("Edit was failed");
        }
        return true;
    }
}
