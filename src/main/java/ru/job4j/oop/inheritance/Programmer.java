package ru.job4j.oop.inheritance;

public class Programmer  extends Engineer {
    private String language;
    private String experiance;

    public Programmer(String language, String experiance) {
        this.language = language;
        this.experiance = experiance;
    }

    public String getLanguage() {
    return language;
    }

    public String getExperiance() {
        return experiance;
    }

    public void writeCode(Task task) {
        System.out.println(this.getName() + " writes code for " + task.getContent());
    }
}