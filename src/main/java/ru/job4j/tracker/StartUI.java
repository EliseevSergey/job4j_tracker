package ru.job4j.tracker;

import ru.job4j.poly.Transport;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new Consoleinput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(), new ShowAll(), new ReplaceAction(), new DeleteAction(), new FindByIdAction(), new FindByNameAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
