package ru.job4j.oop.inheritance;

public class Pacient extends Doctor {
    private boolean lifeOrNot;

    public Pacient() {
    }

    public Pacient(boolean lifeOrNot) {
        this.lifeOrNot = lifeOrNot;
    }

    public void complain(Diagnosis diagnosis) {
        System.out.println(this.getName() + " жалуется " + diagnosis.getDiagnosis());
    }
}
