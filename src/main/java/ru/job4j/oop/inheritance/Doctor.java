package ru.job4j.oop.inheritance;

public class Doctor extends Professional {
    String experience;
    String type;

    public Doctor(){
    }

    public Doctor(String experience, String type) {
        this.experience = experience;
        this.type = type;
    }

    public void issueRecipe(Diagnosis diagnosis) {
        System.out.println(this.getName() + " выдаёт рецепты от " + diagnosis.getDiagnosis());
    }
}
