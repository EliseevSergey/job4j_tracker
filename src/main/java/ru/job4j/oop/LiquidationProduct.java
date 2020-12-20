package ru.job4j.oop;

public final class LiquidationProduct {
    private Product good;

    public LiquidationProduct(String name, int price) {
        Product good = new Product(name, price);
    }

    public String label() {
        return good.label();
    }
}
