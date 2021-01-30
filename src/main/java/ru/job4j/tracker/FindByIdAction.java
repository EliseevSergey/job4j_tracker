package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name(){
        return "=== Find Item by id ====";
    }
    @Override
    public boolean execute (Input input, Tracker tracker) {
        int id = input.askInt("Input id of item which to be found");
        Item target = tracker.findById(id);
        if (target != null) {
            System.out.println(target);
        } else {
            System.out.println("not found with id: " + id);
        }
       return true;
    }
}
