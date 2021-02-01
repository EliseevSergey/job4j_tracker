package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;
    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute (Input input, Tracker tracker) {
        out.println("=== Delete item ====");
        int id = input.askInt("Input id of item which to be deleted");
        if (tracker.delete(id)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Deletion was failed");
        }
        return true;
    }
}
