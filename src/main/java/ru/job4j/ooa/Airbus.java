package ru.job4j.ooa;

public class Airbus {
    private String name;
    private Aircraft aircraft = new Aircraft();

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        if (this.getName().equals("A380")) {
            System.out.println("Количество двигателей равно: " + (aircraft.getCOUNT_ENGINE() + 2));
        } else {
        System.out.println("Количество двигателей равно: " + aircraft.getCOUNT_ENGINE());
        }
    }

    @Override
    public String toString() {
        return "Airbus{" +
                "name='" + name + '\'' +
                '}';
    }
}
