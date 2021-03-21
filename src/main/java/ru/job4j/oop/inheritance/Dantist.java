package ru.job4j.oop.inheritance;

public class Dantist extends Doctor {
    private String language;
    private String equipment;

    public Dantist() {
    }

    public Dantist(String language, String equipment) {
        this.language = language;
        this.equipment = equipment;
    }

    public void drilltooth(Pacient pacient) {
        System.out.println(this.getName() + " сверлит зуб " + pacient.getName());
    }
}
