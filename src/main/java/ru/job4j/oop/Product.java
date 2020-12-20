package ru.job4j.oop;

public final class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String label() {
        return name + "  " + price;
    }
}
