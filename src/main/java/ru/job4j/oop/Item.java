package ru.job4j.oop;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public Item(int id) {
    }

    public Item(int id, String name) {
    }

    public static void main(String[] args) {
        Item Empty = new Item();
        Item Idishnick = new Item(7);
        Item IdandName = new Item(777, "Petrovich");
    }
}

