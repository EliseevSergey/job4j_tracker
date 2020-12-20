package ru.job4j.oop.inheritance;

import java.security.PrivateKey;

public class Programmer  extends Engineer {
    private String language;
    private String experiance;

    public Programmer() {
    }

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
}