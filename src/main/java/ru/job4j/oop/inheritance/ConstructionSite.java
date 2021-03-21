package ru.job4j.oop.inheritance;

public class ConstructionSite {
    public static void main(String[] args) {
        Professional perfectMaster = new Professional();
        Engineer ivanov = new Engineer();
        Programmer sierra = new Programmer("java", "brige stability software");
        sierra.setName("Ketty");
        sierra.setSurname("Sierra");
        Builder petrovich = new Builder();
        petrovich.setName("Petrovich");
        Task brigeAcrossTheSky = new Task("BrigeAcrossTheSky");
        petrovich.choiseMaterial(brigeAcrossTheSky);
        sierra.writeCode(brigeAcrossTheSky);
    }
}
