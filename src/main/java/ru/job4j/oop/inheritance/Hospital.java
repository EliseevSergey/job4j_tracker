package ru.job4j.oop.inheritance;

public class Hospital {
    public static void main(String[] args) {
        Professional perfectPro = new Professional();
        Doctor chaos = new Doctor();
        chaos.setName("Chaos");
        Diagnosis toothAche = new Diagnosis("toothAche");
        chaos.issueRecipe(toothAche);
        Pacient pugovkin = new Pacient(true);
        pugovkin.setName("Pugovkin");
        pugovkin.setAge(33);
        pugovkin.setEducation("Bomber");
        pugovkin.complain(toothAche);
        Dantist dantist = new Dantist();
        dantist.setName("Zlo");
        dantist.drilltooth(pugovkin);
    }
}