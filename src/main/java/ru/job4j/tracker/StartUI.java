package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.println("Create item name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
                System.out.println("Item has been created");
            }
            else if (select == 1) {
                System.out.println("Show all items by names");
                for (int index = 0; index < tracker.findAll().length; index++) {
                    System.out.println(tracker.findAll()[index].getName());
                }
                System.out.println("=The end of list=");
            }
            else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.println("Input id of item which to be edited");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Input name of item which to be inputted in chosen id");
                String name = scanner.nextLine();
                Item newInput = new Item();
                newInput.setName(name);
                tracker.replace(id, newInput);
                if (tracker.replace(id, newInput)) {
                    System.out.println("Successfully Edited");
                } else {
                    System.out.println("Edit was failed");
                }
            }
            else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.println("Input id of item which to be deleted");
                int id = Integer.valueOf(scanner.nextLine());
                tracker.delete(id);
                if (tracker.delete(id)) {
                    System.out.println("Successfully deleted");
                } else {
                    System.out.println("Deletion was failed");
                }
            }

            else if (select == 6) {
                System.out.println("bye bye");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
